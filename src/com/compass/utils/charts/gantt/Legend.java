package com.compass.utils.charts.gantt;

import com.compass.utils.charts.AbstractChartObj;

/**
 * Legend �ڵ�
 */
public class Legend extends AbstractChartObj {
  /**
   * ��ʼ��Chart Object
   */
  public Legend() {
    super("legend", true);
  }

  @Override
  protected void initAttributeDefinations() {
    //Do nothing
  }

  @Override
  protected void initAcceptedChildTypes() {
    addAcceptedChildTypes(Item.class);
  }
}
