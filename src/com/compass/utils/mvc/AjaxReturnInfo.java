package com.compass.utils.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

/**
 * @author wangLong
 * Ajax返回值封装类
 */
public class AjaxReturnInfo {
  private final String success;   //true or false
  private String message;         //返回信息
  private Exception exception;
  private Map<String, Object> datas = new HashMap<String, Object>();    //返回的数据
  private static Map<String, Object> json = new HashMap<String, Object>(); 
  private static List<Map<String, Object>>  treeJson = new ArrayList<Map<String,Object>>(); 
  

  /**
   * 取得成功状态的返回对象
   * @return success
   * @param message
   */
  public static AjaxReturnInfo success(String message) {
    AjaxReturnInfo ret =  new AjaxReturnInfo("true");
    ret.message = StringUtils.hasText(message) ? message : "success";
    return ret;
  }

  /**
   * 取得失败状态的返回对象
   * @return failed对象
   * @param message
   */
  public static AjaxReturnInfo failed(String message) {
    AjaxReturnInfo ret = new AjaxReturnInfo("false");
    ret.message = StringUtils.hasText(message) ? message : "failed";
    return ret;
  }

  
  /**
   * 返回easyUI datagrid 所需要的JSON格式数据
   * @param num
   * @param list
   * @return
  */
public static Map<String, Object>  setTable(Integer num,List<?> list){
	  json.put("total",num);// total键 存放总记录数，必须的
	  json.put("rows", list);// rows键 存放每页记录 list
	return json;
	  
  }
  

/**
* 返回easyUI Tree 所需要的JSON格式数据
* @param num
* @param list
* @return
*/
public static List<Map<String, Object>>  setTree(List<Map<String, Object>> list){
	treeJson = list;
	return treeJson;
	  
}

  /**
   * 私有的构造函数
   * @param result 'true' or 'false'
   */
  private AjaxReturnInfo(String result) {
    this.success = result;
  }

  /**
   * 取得成功标志
   * @return 'true' or 'false'
   */
  public String getSuccess() {
    return success;
  }

  /**
   * 添加数据
   * @param key Key值
   * @param obj 对象
   */
  public void add(String key, Object obj) {
    if(!StringUtils.hasText(key) || obj == null)
      return;
    this.datas.put(key, obj);
  }

  /**
   * 获得返回信息
   * @return 返回信息
   */
  public String getMessage() {
    return message;
  }

  /**
   * 取得所有数据
   * @return 数据集合
   */
  public Map<String, Object> getDatas() {
    return datas;
  }

  /**
   * 设置后台产生的异常
   * @param exp 异常
   */
  public void setException(Exception exp) {
    exception = exp;
  }

  /**
   * 获取后台产生的异常
   * @return 异常对象
   */
  public Exception getException() {
    return exception;
  }
}
