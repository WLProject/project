package com.compass.utils.charts.line2d;

import com.compass.utils.charts.AbstractChartObj;

public class Set extends AbstractChartObj {
  public Set() {
    super("set", false);
  }

  @Override
  protected void initAttributeDefinations() {
    addAcceptedAttr("label", String.class);
    addAcceptedAttr("value", Integer.class);
    addAcceptedAttr("displayValue", String.class);
    addAcceptedAttr("color", String.class);
    addAcceptedAttr("link", String.class);
    addAcceptedAttr("toolText", String.class);
    addAcceptedAttr("showLabel", Boolean.class);
    addAcceptedAttr("showValue", Boolean.class);
    addAcceptedAttr("valuePosition", String.class);
    addAcceptedAttr("dashed", Boolean.class);
    addAcceptedAttr("alpha", Integer.class);
    addAcceptedAttr("anchorSides", Integer.class);
    addAcceptedAttr("anchorRadius", Integer.class);
    addAcceptedAttr("anchorBorderColor", String.class);
    addAcceptedAttr("anchorBorderThickness", Integer.class);
    addAcceptedAttr("anchorBgColor", String.class);
    addAcceptedAttr("anchorAlpha", Integer.class);
    addAcceptedAttr("anchorBgAlpha", Integer.class);
  }

  @Override
  protected void initAcceptedChildTypes() {
    //Do nothing.
  }
}
