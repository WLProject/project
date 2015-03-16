package com.compass.utils.charts.gantt;

import com.compass.utils.charts.AbstractChartObj;

/**
 * Categories
 */
public class Categories extends AbstractChartObj {
  /**
   * ≥ı ºªØChart Object
   */
  public Categories() {
    super("categories", true);
  }

  @Override
  protected void initAttributeDefinations() {
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
    addAcceptedAttr(" vAlign", String.class);
  }

  @Override
  protected void initAcceptedChildTypes() {
    addAcceptedChildTypes(Category.class);
  }
}
