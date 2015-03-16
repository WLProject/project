package com.compass.utils.charts.msline;

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
    addAcceptedAttr("includeInLegend", Boolean.class);
    addAcceptedAttr("seriesName", String.class);
    addAcceptedAttr("color", String.class);
    addAcceptedAttr("alpha", String.class);
    addAcceptedAttr("showValues", Boolean.class);
    addAcceptedAttr("valuePosition", String.class);
    addAcceptedAttr("dashed", Boolean.class);
    addAcceptedAttr("drawAnchors", Boolean.class);
    addAcceptedAttr("anchorSides", Integer.class);
    addAcceptedAttr("anchorRadius", Integer.class);
    addAcceptedAttr("anchorBorderColor", String.class);
    addAcceptedAttr("anchorBorderThickness", Integer.class);
    addAcceptedAttr("anchorBgColor", String.class);
    addAcceptedAttr("anchorAlpha", Integer.class);
    addAcceptedAttr("anchorBgAlpha", Integer.class);
    addAcceptedAttr("lineThickness", Integer.class);
    addAcceptedAttr("lineDashLen", Integer.class);
    addAcceptedAttr("lineDashGap", Integer.class);
  }

  @Override
  protected void initAcceptedChildTypes() {
    addAcceptedChildTypes(Set.class);
  }
}
