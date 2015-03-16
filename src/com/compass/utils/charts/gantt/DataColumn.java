package com.compass.utils.charts.gantt;

import com.compass.utils.charts.AbstractChartObj;

/**
 * datacolumn节点
 */
public class DataColumn extends AbstractChartObj {
  /**
   * 初始化Chart Object
   */
  public DataColumn() {
    super("datacolumn", true);
  }

  @Override
  protected void initAttributeDefinations() {
    addAcceptedAttr("headerText", String.class);
    addAcceptedAttr("headerLink", String.class);
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

    addAcceptedAttr("width", String.class);
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
    addAcceptedChildTypes(Text.class);
  }
}
