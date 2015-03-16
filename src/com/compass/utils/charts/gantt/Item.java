package com.compass.utils.charts.gantt;

import com.compass.utils.charts.AbstractChartObj;

/**
 * Item 节点
 */
public class Item extends AbstractChartObj {
  /**
   * 初始化Chart Object
   */
  public Item() {
    super("item", false);
  }

  @Override
  protected void initAttributeDefinations() {
    addAcceptedAttr("label", String.class);
    addAcceptedAttr("color", String.class);
  }

  @Override
  protected void initAcceptedChildTypes() {
    //Do nothing
  }
}
