package com.compass.utils.charts;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangLong
 * FusionChart�������
 */
@SuppressWarnings("rawtypes")
public abstract class AbstractChartObj {
  private final String name;                //�ڵ�����
  private final boolean hasChild;   //�Ƿ����ӽڵ�

  //���ÿ�������ӽڵ��Map��keyΪ�ӽڵ�����,value���ӽڵ��б�
private Map<Class, Boolean> childTypes = new HashMap<Class, Boolean>();

  //�ӽڵ��б������˳��
  private List<AbstractChartObj> children = new ArrayList<AbstractChartObj>();

  //�������Ƶ����ã�keyΪ�������ƣ�valueΪ�ɽ��ܵ�����
  private Map<String, Class> attrDefinations = new HashMap<String, Class>();
  //����ֵ��keyΪ�������ƣ�valueΪ����ֵ
  private Map<String, Object> attrValues = new HashMap<String, Object>();

  /**
   * ���һ���Ϸ�����
   * @param attrName ��������
   * @param attrClass ��������
   */
  protected final void addAcceptedAttr(String attrName, Class attrClass) {
    String name = attrName.trim().toLowerCase();

    this.attrDefinations.put(name, attrClass);
  }

  /**
   * ���һ���ɽ��յ��ӽڵ�����
   *
   * @param clazz �ӽڵ�����
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
   * ��ʼ��Chart Object
   *
   * @param name     ��������
   * @param hasChild �Ƿ���������ӽڵ�
   */
  public AbstractChartObj(String name, boolean hasChild) {
    this.name = name;
    this.hasChild = hasChild;
    initAttributeDefinations();
    initAcceptedChildTypes();
  }

  /**
   * ��ʼ�����Զ����ļ�
   */
  protected abstract void initAttributeDefinations();

  /**
   * ��ʼ���ɽ��ܵ��Ӷ�������
   */
  protected abstract void initAcceptedChildTypes();

  /**
   * ��������ֵ����������Բ��Ϸ�����
   *
   * @param name  �������ƣ������ִ�Сд
   * @param value ֵ�����Ϊnull�������ԭ���趨��ֵ
   * @return ������ԭ��ֵ
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
   * ��ȡ�ڵ�XML�ַ���
   *
   * @return XML�ַ���
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
   * ����ӽڵ�
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
   * ��������ӽڵ�
   * @param children �ӽڵ��б�
   */
  public void addChildren(List<? extends AbstractChartObj> children) {
    if(CollectionUtils.isEmpty(children)) return;

    for(AbstractChartObj child : children) {
      addChild(child);
    }
  }

  /**
   * ��ȡ�����ӽڵ��б�
   * @return �ӽڵ��б�
   */
  public List<AbstractChartObj> getChildren() {
    return children;
  }
    /**
     * ��ȡ�����ӽڵ��б�
     * @return �ӽڵ��б�
     */
  public  Map<String, Object> getAttrValues() {
      return attrValues;
   }


  /**
   * ���ָ�����͵��ӽڵ��б�
   * @param clazz ����
   * @return �����͵��ӽڵ��б���û�У����ؿ��б�
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
   * ��ȡ��ǰ�ڵ���������������ַ���
   *
   * @return ���������ַ���
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
