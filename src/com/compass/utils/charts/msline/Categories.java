package com.compass.utils.charts.msline;

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
    addAcceptedAttr("font", String.class);
    addAcceptedAttr("fontSize", Integer.class);
    addAcceptedAttr("fontColor", String.class);
  }

  @Override
  protected void initAcceptedChildTypes() {
    addAcceptedChildTypes(Category.class);
    addAcceptedChildTypes(VLine.class);
  }
}
