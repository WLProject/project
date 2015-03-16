package com.compass.utils.charts.column2d;

import com.compass.utils.charts.AbstractChartObj;

public class TrendLines extends AbstractChartObj {
  /**
   * @author wangLong
   * ≥ı ºªØChart Object
   */
  public TrendLines() {
    super("trendLines", true);
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
