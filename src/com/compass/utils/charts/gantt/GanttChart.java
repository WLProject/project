package com.compass.utils.charts.gantt;

import com.compass.utils.charts.AbstractChartObj;

/**
 * Gantt GanttChart
 */
public class GanttChart extends AbstractChartObj {
  /**
   * ≥ı ºªØChart Object
   */
  public GanttChart() {
    super("chart", true);
  }

  @Override
  protected void initAttributeDefinations() {
    //base element
    addAcceptedAttr("dataFormat", String.class);
    addAcceptedAttr("outputDataFormat", String.class);
    addAcceptedAttr("ganttPaneDuration", Integer.class);
    addAcceptedAttr("ganttPaneDurationUnit", String.class);
    addAcceptedAttr("showFullDataTable", Boolean.class);
    addAcceptedAttr("ganttWidthPercent", Integer.class);
    addAcceptedAttr("caption", String.class);
    addAcceptedAttr("subCaption", String.class);
    addAcceptedAttr("showTaskStartDate", Boolean.class);
    addAcceptedAttr("showTaskEndDate", Boolean.class);
    addAcceptedAttr("showTaskLabels", Boolean.class);
    addAcceptedAttr("showPercentLabel", Boolean.class);
    addAcceptedAttr("showSlackAsFill", Boolean.class);
    addAcceptedAttr("slackFillColor", String.class);
    addAcceptedAttr("animation", Boolean.class);
    addAcceptedAttr("defaultAnimation", Boolean.class);
    addAcceptedAttr("clickURL", String.class);
    addAcceptedAttr("annRenderDelay", Integer.class);
    addAcceptedAttr("extendCategoryBg", Boolean.class);
    addAcceptedAttr("showPrintMenuItem", Boolean.class);
    addAcceptedAttr("showAboutMenuItem", Boolean.class);
    addAcceptedAttr("aboutMenuItemLabel", String.class);
    addAcceptedAttr("aboutMenuItemLink", String.class);

    //Cosmetic properties
    addAcceptedAttr("palette", Integer.class);
    addAcceptedAttr("paletteThemeColor", String.class);
    addAcceptedAttr("bgColor", String.class);
    addAcceptedAttr("bgAlpha", Integer.class);
    addAcceptedAttr("bgRatio", String.class);
    addAcceptedAttr("bgAngle", Integer.class);
    addAcceptedAttr("showBorder", Boolean.class);
    addAcceptedAttr("borderColor", String.class);
    addAcceptedAttr("borderThickness", Integer.class);
    addAcceptedAttr("borderAlpha", Integer.class);
    addAcceptedAttr("bgSWF", String.class);
    addAcceptedAttr("bgSWFAlpha", Integer.class);
    addAcceptedAttr("canvasBgColor", String.class);
    addAcceptedAttr("canvasBgAlpha", Integer.class);
    addAcceptedAttr("canvasBgRatio", String.class);
    addAcceptedAttr("canvasBgAngle", Integer.class);
    addAcceptedAttr("canvasBorderColor", String.class);
    addAcceptedAttr("canvasBorderThickness", Integer.class);
    addAcceptedAttr("canvasBorderAlpha", Integer.class);
    addAcceptedAttr("ganttLineColor", String.class);
    addAcceptedAttr("ganttLineAlpha", Integer.class);
    addAcceptedAttr("gridBorderColor", String.class);
    addAcceptedAttr("gridBorderAlpha", Integer.class);
    addAcceptedAttr("gridResizeBarColor", String.class);
    addAcceptedAttr("gridResizeBarThickness", Integer.class);
    addAcceptedAttr("gridResizeBarAlpha", Integer.class);
    addAcceptedAttr("taskBarRoundRadius", Integer.class);
    addAcceptedAttr("taskBarFillMix", String.class);
    addAcceptedAttr("taskBarFillRatio", String.class);
    addAcceptedAttr("baseFont", String.class);
    addAcceptedAttr("baseFontSize", Integer.class);
    addAcceptedAttr("baseFontColor", String.class);
    addAcceptedAttr("showShadow", Boolean.class);
    addAcceptedAttr("logoURL", String.class);
    addAcceptedAttr("logoPosition", String.class);
    addAcceptedAttr("logoAlpha", Integer.class);
    addAcceptedAttr("logoScale", Integer.class);
    addAcceptedAttr("logoLink", String.class);

    //Tool tip properties
    addAcceptedAttr("showToolTip", Boolean.class);
    addAcceptedAttr("toolTipBgColor", String.class);
    addAcceptedAttr("toolTipBorderColor", String.class);
    addAcceptedAttr("dateInToolTip", Boolean.class);
    addAcceptedAttr("showToolTipShadow", Boolean.class);

    //Legend properties
    addAcceptedAttr("showLegend", Boolean.class);
    addAcceptedAttr("legendCaption", String.class);
    addAcceptedAttr("legendBorderColor", String.class);
    addAcceptedAttr("legendBorderThickness", Integer.class);
    addAcceptedAttr("legendBorderAlpha", Integer.class);
    addAcceptedAttr("legendBgColor", String.class);
    addAcceptedAttr("legendBgAlpha", Integer.class);
    addAcceptedAttr("legendShadow", Boolean.class);
    addAcceptedAttr("legendAllowDrag", Boolean.class);
    addAcceptedAttr("legendScrollBgColor", String.class);
    addAcceptedAttr("legendScrollBarColor", String.class);
    addAcceptedAttr("legendScrollBtnColor", String.class);
    addAcceptedAttr("reverseLegend", Boolean.class);

    //Scrool bar properties
    addAcceptedAttr("scrollColor", String.class);
    addAcceptedAttr("scrollPadding", Integer.class);
    addAcceptedAttr("scrollHeight", Integer.class);
    addAcceptedAttr("scrollBtnWidth", Integer.class);
    addAcceptedAttr("scrollBtnPadding", Integer.class);

    //Chart Margin & Padding
    addAcceptedAttr("chartLeftMargin", Integer.class);
    addAcceptedAttr("chartRightMargin", Integer.class);
    addAcceptedAttr("chartTopMargin", Integer.class);
    addAcceptedAttr("chartBottomMargin", Integer.class);
    addAcceptedAttr("taskDatePadding", Integer.class);
    addAcceptedAttr("captionPadding", Integer.class);
    addAcceptedAttr("legendPadding", Integer.class);
  }

  @Override
  protected void initAcceptedChildTypes() {
    addAcceptedChildTypes(Categories.class);
    addAcceptedChildTypes(Processes.class);
    addAcceptedChildTypes(Tasks.class);
    addAcceptedChildTypes(Legend.class);
    addAcceptedChildTypes(TrendLines.class);
    addAcceptedChildTypes(DataTable.class);
    addAcceptedChildTypes(Milestones.class);
  }
}
