package com.compass.utils.charts.gantt;

import com.compass.utils.charts.AbstractChartObj;

/**
 * Processes节点
 */
public class Processes extends AbstractChartObj {
  /**
   * 初始化Chart Object
   */
  public Processes() {
    super("processes", true);
  }

  @Override
  protected void initAttributeDefinations() {
    addAcceptedAttr("positionInGrid", String.class);
    addAcceptedAttr("width", String.class);

    addAcceptedAttr("headerText", String.class);
    addAcceptedAttr("headerFont", String.class);
    addAcceptedAttr("headerFontSize", Integer.class);
    addAcceptedAttr("headerFontColor", String.class);
    addAcceptedAttr("headerIsBold", Boolean.class);
    addAcceptedAttr("headerIsItalic", Boolean.class);
    addAcceptedAttr("headerIsUnderline", Boolean.class);
    addAcceptedAttr("headerAlign", String.class);
    addAcceptedAttr("headerVAlign", String.class);
    addAcceptedAttr("headerBgColor", String.class);
    addAcceptedAttr("headerBgAlpha", Integer.class);

    addAcceptedAttr("bgColor", String.class);
    addAcceptedAttr("bgAlpha", Integer.class);
    addAcceptedAttr("font", String.class);
    addAcceptedAttr("fontSize", Integer.class);
    addAcceptedAttr("fontColor", String.class);
    addAcceptedAttr("isBold", Boolean.class);
    addAcceptedAttr("isItalic", Boolean.class);
    addAcceptedAttr("isUnderline", Boolean.class);
    addAcceptedAttr("align", String.class);
    addAcceptedAttr("vAlign", String.class);
  }

  @Override
  protected void initAcceptedChildTypes() {
    addAcceptedChildTypes(Process.class);
  }
}
