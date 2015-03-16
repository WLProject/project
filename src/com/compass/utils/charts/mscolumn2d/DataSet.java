package com.compass.utils.charts.mscolumn2d;

import com.compass.utils.charts.AbstractChartObj;

/**
 * DataSet
 */
public class DataSet extends AbstractChartObj {
  /**
   * ≥ı ºªØChart Object
   */
  public DataSet() {
    super("dataset", true);
  }

  @Override
  protected void initAttributeDefinations() {
    addAcceptedAttr("seriesName", String.class);
    addAcceptedAttr("color", String.class);
    addAcceptedAttr("alpha", String.class);
    addAcceptedAttr("ratio", String.class);
    addAcceptedAttr("showValues", Boolean.class);
    addAcceptedAttr("dashed", Boolean.class);
    addAcceptedAttr("includeInLegend", Boolean.class);
  }

  @Override
  protected void initAcceptedChildTypes() {
    addAcceptedChildTypes(Set.class);
  }
}
