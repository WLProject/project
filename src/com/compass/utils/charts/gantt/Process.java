package com.compass.utils.charts.gantt;

import com.compass.utils.charts.AbstractChartObj;

/**
 * Process节点
 */
public class Process extends AbstractChartObj {
  /**
   * 初始化Chart Object
   */
  public Process() {
    super("process", false);
  }

  @Override
  protected void initAttributeDefinations() {
    addAcceptedAttr("label", String.class);
    addAcceptedAttr("link", String.class);
    addAcceptedAttr("id", String.class);
    addAcceptedAttr("font", String.class);
    addAcceptedAttr("fontColor", String.class);
    addAcceptedAttr("fontSize", String.class);
    addAcceptedAttr("isBold", Boolean.class);
    addAcceptedAttr("isItalic", Boolean.class);
    addAcceptedAttr("isUnderline", Boolean.class);
    addAcceptedAttr("align", String.class);
    addAcceptedAttr("vAlign", String.class);
    addAcceptedAttr("bgColor", String.class);
    addAcceptedAttr("bgAlpha", Integer.class);
  }

  @Override
  protected void initAcceptedChildTypes() {
    //Do nothing.
  }
}
