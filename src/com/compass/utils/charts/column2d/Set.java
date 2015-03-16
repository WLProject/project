package com.compass.utils.charts.column2d;

import com.compass.utils.charts.AbstractChartObj;

public class Set extends AbstractChartObj {
  /**
   * @author wangLong
   * ≥ı ºªØChart Object
   */
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
    addAcceptedAttr("toolText ", String.class);
    addAcceptedAttr("showLabel", Boolean.class);
    addAcceptedAttr("showValue", Boolean.class);
    addAcceptedAttr("dashed", Boolean.class);
    addAcceptedAttr("alpha", Integer.class);
  }

  @Override
  protected void initAcceptedChildTypes() {
    //Do nothing.
  }
}
