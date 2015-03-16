package com.compass.utils.charts.mscolumn2d;

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
    addAcceptedAttr("label", String.class);
    addAcceptedAttr("showLabel", Boolean.class);
    addAcceptedAttr("toolText", String.class);
  }

  @Override
  protected void initAcceptedChildTypes() {
    //Do nothing
  }
}
