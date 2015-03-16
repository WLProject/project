package com.compass.utils.charts.msline;

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
    addAcceptedAttr("valuePosition", String.class);
    addAcceptedAttr("alpha", Integer.class);
    addAcceptedAttr("anchorSides", Integer.class);
    addAcceptedAttr("anchorRadius", Integer.class);
    addAcceptedAttr("anchorBorderColor", String.class);
    addAcceptedAttr("anchorBorderThickness", Integer.class);
    addAcceptedAttr("anchorBgColor", String.class);
    addAcceptedAttr("anchorAlpha", Integer.class);
    addAcceptedAttr("anchorBgAlpha", Integer.class);
    addAcceptedAttr("dashed ", Boolean.class);
  }

  @Override
  protected void initAcceptedChildTypes() {
    //Do nothing
  }
}
