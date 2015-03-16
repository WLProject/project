package com.compass.utils.charts.gantt;

import com.compass.utils.charts.AbstractChartObj;

/**
 * Tasks±Í«©
 */
public class Tasks extends AbstractChartObj {
  /**
   * ≥ı ºªØChart Object
   */
  public Tasks() {
    super("tasks", true);
  }

  @Override
  protected void initAttributeDefinations() {
    addAcceptedAttr("showlabels", Boolean.class);
    addAcceptedAttr("showpercentlabel", Boolean.class);
    addAcceptedAttr("showstartdate", Boolean.class);
    addAcceptedAttr("showenddate", Boolean.class);
    addAcceptedAttr("font", String.class);
    addAcceptedAttr("fontcolor", String.class);
    addAcceptedAttr("fontsize", Integer.class);
    addAcceptedAttr("color", String.class);
    addAcceptedAttr("alpha", Integer.class);
    addAcceptedAttr("showborder", Boolean.class);
    addAcceptedAttr("bordercolor", String.class);
    addAcceptedAttr("borderthickness", Integer.class);
    addAcceptedAttr("borderalpha", Integer.class);
  }

  @Override
  protected void initAcceptedChildTypes() {
    addAcceptedChildTypes(Task.class);
  }
}
