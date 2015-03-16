package com.compass.utils.charts.gantt;

import com.compass.utils.charts.AbstractChartObj;

/**
 * Legend 节点
 */
public class Legend extends AbstractChartObj {
  /**
   * 初始化Chart Object
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
