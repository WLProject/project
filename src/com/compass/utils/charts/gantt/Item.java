package com.compass.utils.charts.gantt;

import com.compass.utils.charts.AbstractChartObj;

/**
 * Item �ڵ�
 */
public class Item extends AbstractChartObj {
  /**
   * ��ʼ��Chart Object
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
