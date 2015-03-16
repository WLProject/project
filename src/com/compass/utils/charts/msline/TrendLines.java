package com.compass.utils.charts.msline;

import com.compass.utils.charts.AbstractChartObj;

/**
 * TrendLines
 */
public class TrendLines extends AbstractChartObj {
  /**
   * ≥ı ºªØChart Object
   */
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
