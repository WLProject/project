package com.compass.utils.charts.mscolumn2d;

import com.compass.utils.charts.AbstractChartObj;

/**
 * Set
 */
public class Set extends AbstractChartObj {
  /**
   * ≥ı ºªØChart Object
   */
  public Set() {
    super("set", false);
  }

  @Override
  protected void initAttributeDefinations() {
    addAcceptedAttr("value", Integer.class);
    addAcceptedAttr("displayValue", String.class);
    addAcceptedAttr("color", String.class);
    addAcceptedAttr("link", String.class);
    addAcceptedAttr("toolText", String.class);
    addAcceptedAttr("showValue", Boolean.class);
    addAcceptedAttr("dashed", Boolean.class);
    addAcceptedAttr("alpha", Integer.class);
  }

  @Override
  protected void initAcceptedChildTypes() {
    //Do nothing
  }
}
