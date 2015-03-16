package com.compass.utils.charts.gantt;

import com.compass.utils.charts.AbstractChartObj;

/**
 * text节点
 */
public class Text extends AbstractChartObj {
  /**
   * 初始化Chart Object
   */
  public Text() {
    super("text", false);
  }

  @Override
  protected void initAttributeDefinations() {
    addAcceptedAttr("label", String.class);
    addAcceptedAttr("link", String.class);
    addAcceptedAttr("bgColor", String.class);
    addAcceptedAttr("bgAlpha", Integer.class);
    addAcceptedAttr("font", String.class);
    addAcceptedAttr("fontColor", String.class);
    addAcceptedAttr("fontSize", Integer.class);
    addAcceptedAttr("isBold", Boolean.class);
    addAcceptedAttr("isItalic", Boolean.class);
    addAcceptedAttr("isUnderline", Boolean.class);
    addAcceptedAttr("align", String.class);
    addAcceptedAttr("vAlign", String.class);
  }

  @Override
  protected void initAcceptedChildTypes() {
    //Do nothing.
  }
}
