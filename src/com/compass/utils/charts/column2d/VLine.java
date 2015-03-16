package com.compass.utils.charts.column2d;

import com.compass.utils.charts.AbstractChartObj;

public class VLine extends AbstractChartObj {
  /**
   * @author wangLong
   * ≥ı ºªØChart Object
   */
  public VLine() {
    super("vLine", false);
  }

  @Override
  protected void initAttributeDefinations() {
    addAcceptedAttr("color", String.class);
    addAcceptedAttr("thickness", Integer.class);
    addAcceptedAttr("alpha", Integer.class);
    addAcceptedAttr("dashed", Boolean.class);
    addAcceptedAttr("dashLen", Integer.class);
    addAcceptedAttr("dashGap", Integer.class);
    addAcceptedAttr("label", String.class);
    addAcceptedAttr("showLabelBorder", Boolean.class);
    addAcceptedAttr("linePosition", Integer.class);
    addAcceptedAttr("labelPosition", Integer.class);
    addAcceptedAttr("labelHAlign", String.class);
    addAcceptedAttr("labelVAlign", String.class);
  }

  @Override
  protected void initAcceptedChildTypes() {
    //Do nothing
  }
}
