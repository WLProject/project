package com.compass.utils.charts;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangLong
 * FusionChart对象基类
 */
@SuppressWarnings("rawtypes")
public abstract class AbstractChartObj {
  private final String name;                //节点名称
  private final boolean hasChild;   //是否有子节点

  //存放每种类型子节点的Map：key为子节点类型,value是子节点列表
private Map<Class, Boolean> childTypes = new HashMap<Class, Boolean>();

  //子节点列表，按添加顺序
  private List<AbstractChartObj> children = new ArrayList<AbstractChartObj>();

  //属性名称的设置：key为属性名称，value为可接受的类型
  private Map<String, Class> attrDefinations = new HashMap<String, Class>();
  //属性值，key为属性名称，value为属性值
  private Map<String, Object> attrValues = new HashMap<String, Object>();

  /**
   * 添加一个合法属性
   * @param attrName 属性名称
   * @param attrClass 属性类型
   */
  protected final void addAcceptedAttr(String attrName, Class attrClass) {
    String name = attrName.trim().toLowerCase();

    this.attrDefinations.put(name, attrClass);
  }

  /**
   * 添加一个可接收的子节点类型
   *
   * @param clazz 子节点类型
   */
  protected final void addAcceptedChildTypes(Class clazz) {
    if (clazz == null) return;
    Boolean accept = childTypes.get(clazz);
    if (accept == null) {
      accept = true;
      childTypes.put(clazz, accept);
    }
  }

  /**
   * 初始化Chart Object
   *
   * @param name     对象名称
   * @param hasChild 是否允许添加子节点
   */
  public AbstractChartObj(String name, boolean hasChild) {
    this.name = name;
    this.hasChild = hasChild;
    initAttributeDefinations();
    initAcceptedChildTypes();
  }

  /**
   * 初始化属性定义文件
   */
  protected abstract void initAttributeDefinations();

  /**
   * 初始化可接受的子对象类型
   */
  protected abstract void initAcceptedChildTypes();

  /**
   * 设置属性值，如果该属性不合法忽略
   *
   * @param name  属性名称，不区分大小写
   * @param value 值，如果为null，将清除原有设定的值
   * @return 该属性原有值
   */
  public final Object setAttribute(String name, Object value) {
    if (!StringUtils.hasText(name)) return null;
    name = name.trim().toLowerCase();

    Class clazz = attrDefinations.get(name);
    if (clazz == null) throw new RuntimeException("There is no attribute named " + name);

    if (value == null) {
      return attrValues.remove(name);
    }

    if (!clazz.isInstance(value)) throw new RuntimeException("The attribute type is wrong.");

    return attrValues.put(name, value);
  }

  /**
   * 获取节点XML字符串
   *
   * @return XML字符串
   */
  public String getXml() {
    StringBuffer sb = new StringBuffer();
    if (hasChild) {
      sb.append("<").append(name).append(" ").append(getAttrsXml()).append(">").append("\n");
      sb.append(getChildrenXml());
      sb.append("</").append(name).append(">");
    } else {
      sb.append("<").append(name).append(" ").append(getAttrsXml()).append("/>");
    }
    sb.append("\n");
    return sb.toString();
  }

  protected final String getChildrenXml() {
    StringBuffer sb = new StringBuffer();

    for (AbstractChartObj obj : children) {
      sb.append(obj.getXml());
    }

    return sb.toString();
  }

  /**
   * 添加子节点
   */
  public void addChild(AbstractChartObj child) {
    if (!hasChild) throw new RuntimeException("This element is not accept child");

    if (child == null) return;
    Class clazz = child.getClass();

    Boolean accept = childTypes.get(clazz);
    if (accept == null) throw new RuntimeException("The child type is not acceptable");

    children.add(child);
  }

  /**
   * 批量添加子节点
   * @param children 子节点列表
   */
  public void addChildren(List<? extends AbstractChartObj> children) {
    if(CollectionUtils.isEmpty(children)) return;

    for(AbstractChartObj child : children) {
      addChild(child);
    }
  }

  /**
   * 获取所有子节点列表
   * @return 子节点列表
   */
  public List<AbstractChartObj> getChildren() {
    return children;
  }
    /**
     * 获取所有子节点列表
     * @return 子节点列表
     */
  public  Map<String, Object> getAttrValues() {
      return attrValues;
   }


  /**
   * 获得指定类型的子节点列表
   * @param clazz 类型
   * @return 该类型的子节点列表，如没有，返回空列表
   */
  @SuppressWarnings("unchecked")
public List<AbstractChartObj> getChildrenByType(Class clazz) {
    List<AbstractChartObj> ret = new ArrayList<AbstractChartObj>();

    for(AbstractChartObj obj : children) {
      if(clazz.isAssignableFrom(obj.getClass()))
        ret.add(obj);
    }

    return ret;
  }

  /**
   * 获取当前节点的所有属性设置字符串
   *
   * @return 属性设置字符串
   */
  protected final String getAttrsXml() {
    StringBuffer sb = new StringBuffer();

    for (String attr : attrValues.keySet()) {
      Object value = attrValues.get(attr);
      String valueStr = null;
      if (value instanceof Boolean) {
        if ((Boolean) value) valueStr = "1";
        else valueStr = "0";
      } else {
        valueStr = "" + value;
      }
      sb.append(" ").append(attr).append("='").append(valueStr).append("' ");
    }

    return sb.toString();
  }
}
