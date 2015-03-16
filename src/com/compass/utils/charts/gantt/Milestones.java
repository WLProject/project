package com.compass.utils.charts.gantt;

import com.compass.utils.charts.AbstractChartObj;

/**
 * Milestones±Í«©
 */
public class Milestones extends AbstractChartObj {
  /**
   * ≥ı ºªØChart Object
   */
  public Milestones() {
    super("milestones", true);
  }

  @Override
  protected void initAttributeDefinations() {
    //Do nothing.
  }

  @Override
  protected void initAcceptedChildTypes() {
    addAcceptedChildTypes(Milestone.class);
  }
}
