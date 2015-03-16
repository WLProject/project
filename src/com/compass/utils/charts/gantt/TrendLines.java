package com.compass.utils.charts.gantt;

import com.compass.utils.charts.AbstractChartObj;

/**
 * TrendLines 节点
 */
public class TrendLines extends AbstractChartObj {
  /**
   * 初始化Chart Object
   */
  public TrendLines() {
    super("trendlines", true);
  }

  @Override
  protected void initAttributeDefinations() {
    //Do nothing
  }

  @Override
  protected void initAcceptedChildTypes() {
    addAcceptedChildTypes(Line.class);
  }
}
