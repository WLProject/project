package com.compass.utils.charts.line2d;

import com.compass.utils.charts.AbstractChartObj;

public class TrendLines extends AbstractChartObj {
  public TrendLines() {
    super("trendLines", true);
  }

  @Override
  protected void initAttributeDefinations() {
    //Do nothing.
  }

  @Override
  protected void initAcceptedChildTypes() {
    addAcceptedChildTypes(Line.class);
  }
}
