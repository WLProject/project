package com.compass.utils.charts.gantt;

import com.compass.utils.charts.AbstractChartObj;

/**
 * Line节点
 */
public class Line extends AbstractChartObj {
  /**
   * 初始化Chart Object
   */
  public Line() {
    super("line", false);
  }

  @Override
  protected void initAttributeDefinations() {
    addAcceptedAttr("start", String.class);
    addAcceptedAttr("end", String.class);
    addAcceptedAttr("color", String.class);
    addAcceptedAttr("displayValue", String.class);
    addAcceptedAttr("thickness", Integer.class);
    addAcceptedAttr("isTrendZone", Boolean.class);
    addAcceptedAttr("alpha", Integer.class);
    addAcceptedAttr("dashed", Boolean.class);
    addAcceptedAttr("dashLen", Integer.class);
    addAcceptedAttr("dashGap", Integer.class);
  }

  @Override
  protected void initAcceptedChildTypes() {
    //Do nothing
  }
}
