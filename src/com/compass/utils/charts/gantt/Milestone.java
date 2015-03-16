package com.compass.utils.charts.gantt;

import com.compass.utils.charts.AbstractChartObj;

/**
 * Milestone ±Í«©
 */
public class Milestone extends AbstractChartObj {
  /**
   * ≥ı ºªØChart Object
   */
  public Milestone() {
    super("milestone", false);
  }

  @Override
  protected void initAttributeDefinations() {
    addAcceptedAttr("date", String.class);
    addAcceptedAttr("taskId", String.class);
    addAcceptedAttr("shape", String.class);
    addAcceptedAttr("toolText", String.class);
    addAcceptedAttr("color", String.class);
  }

  @Override
  protected void initAcceptedChildTypes() {
    //Do nothing.
  }
}
