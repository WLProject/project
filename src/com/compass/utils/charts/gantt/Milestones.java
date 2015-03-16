package com.compass.utils.charts.gantt;

import com.compass.utils.charts.AbstractChartObj;

/**
 * Milestones��ǩ
 */
public class Milestones extends AbstractChartObj {
  /**
   * ��ʼ��Chart Object
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
