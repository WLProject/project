package com.compass.utils.charts.gantt;

import com.compass.utils.charts.AbstractChartObj;

/**
 * Category
 */
public class Category extends AbstractChartObj {
  /**
   * ≥ı ºªØChart Object
   */
  public Category() {
    super("category", false);
  }

  @Override
  protected void initAttributeDefinations() {
    //The same as Categories
    addAcceptedAttr("bgColor", String.class);
    addAcceptedAttr("bgAlpha", Integer.class);
    addAcceptedAttr("font", String.class);
    addAcceptedAttr("fontSize", Integer.class);
    addAcceptedAttr("fontColor", String.class);
    addAcceptedAttr("isBold", Boolean.class);
    addAcceptedAttr("isItalic", Boolean.class);
    addAcceptedAttr("isUnderline", Boolean.class);
    addAcceptedAttr("verticalPadding", Integer.class);
    addAcceptedAttr("align", String.class);
    addAcceptedAttr("vAlign", String.class);
    //The differents
    addAcceptedAttr("start", String.class);
    addAcceptedAttr("end", String.class);
    addAcceptedAttr("label", String.class);
    addAcceptedAttr("link", String.class);
  }

  @Override
  protected void initAcceptedChildTypes() {
    //Do nothing
  }
}
