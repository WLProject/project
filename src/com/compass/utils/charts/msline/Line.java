package com.compass.utils.charts.msline;

import com.compass.utils.charts.AbstractChartObj;

/**
 * Line
 */
public class Line extends AbstractChartObj {
  /**
   * ��ʼ��Chart Object
   */
  public Line() {
    super("line", false);
  }

  @Override
  protected void initAttributeDefinations() {
    addAcceptedAttr("startValue", Integer.class);
    addAcceptedAttr("endValue", Integer.class);
    addAcceptedAttr("displayValue", String.class);
    addAcceptedAttr("color", String.class);
    addAcceptedAttr("isTrendZone", Boolean.class);
    addAcceptedAttr("showOnTop", Boolean.class);
    addAcceptedAttr("thickness", Integer.class);
    addAcceptedAttr("alpha", Integer.class);
    addAcceptedAttr("dashed", Boolean.class);
    addAcceptedAttr("dashLen", Integer.class);
    addAcceptedAttr("dashGap", Integer.class);
    addAcceptedAttr("valueOnRight", Boolean.class);
    addAcceptedAttr("toolText", String.class);
  }

  @Override
  protected void initAcceptedChildTypes() {
    //Do nothing.
  }
}
