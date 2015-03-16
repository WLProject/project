package com.compass.utils.charts.gantt;

import com.compass.utils.charts.AbstractChartObj;

/**
 * Task ±Í«©
 */
public class Task extends AbstractChartObj {
  /**
   * ≥ı ºªØChart Object
   */
  public Task() {
    super("task", false);
  }

  @Override
  protected void initAttributeDefinations() {
    addAcceptedAttr("start", String.class);
    addAcceptedAttr("end", String.class);
    addAcceptedAttr("id", String.class);
    addAcceptedAttr("processId", String.class);
    addAcceptedAttr("label", String.class);
    addAcceptedAttr("link", String.class);
    addAcceptedAttr("percentComplete", Integer.class);
    addAcceptedAttr("showAsGroup", Boolean.class);
    addAcceptedAttr("animation", Boolean.class);
    addAcceptedAttr("font", String.class);
    addAcceptedAttr("fontColor", String.class);
    addAcceptedAttr("fontSize", Integer.class);
    addAcceptedAttr("color", String.class);
    addAcceptedAttr("alpha", Integer.class);
    addAcceptedAttr("showBorder", Boolean.class);
    addAcceptedAttr("borderColor", String.class);
    addAcceptedAttr("borderThickness", Integer.class);
    addAcceptedAttr("borderAlpha", Integer.class);
    addAcceptedAttr("height", String.class);
    addAcceptedAttr("topPadding", String.class);
    addAcceptedAttr("showLabel", Boolean.class);
    addAcceptedAttr("showPercentLabel", Boolean.class);
    addAcceptedAttr("showStartDate", Boolean.class);
    addAcceptedAttr("showEndDate", Boolean.class);
    addAcceptedAttr("toolText", String.class);

  }

  @Override
  protected void initAcceptedChildTypes() {
    //Do nothing
  }
}
