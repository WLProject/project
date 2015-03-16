package com.compass.utils.charts.gantt;

import com.compass.utils.charts.AbstractChartObj;

/**
 * TrendLines �ڵ�
 */
public class TrendLines extends AbstractChartObj {
  /**
   * ��ʼ��Chart Object
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
