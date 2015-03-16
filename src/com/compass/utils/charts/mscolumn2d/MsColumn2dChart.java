package com.compass.utils.charts.mscolumn2d;

import com.compass.utils.charts.AbstractChartObj;

/**
 * MsColumn2dChart
 */
public class MsColumn2dChart extends AbstractChartObj {
  /**
   * ≥ı ºªØChart Object
   */
  public MsColumn2dChart() {
    super("chart", true);
  }

  @Override
  protected void initAttributeDefinations() {
    //Functional Attributes
    addAcceptedAttr("animation", Boolean.class);
    addAcceptedAttr("palette", Integer.class);
    addAcceptedAttr("paletteColors", String.class);
    addAcceptedAttr("showAboutMenuItem", Boolean.class);
    addAcceptedAttr("aboutMenuItemLabel", String.class);
    addAcceptedAttr("aboutMenuItemLink", String.class);
    addAcceptedAttr("showLabels", Boolean.class);
    addAcceptedAttr("labelDisplay", String.class);
    addAcceptedAttr("useEllipsesWhenOverflow", Boolean.class);
    addAcceptedAttr("rotateLabels", Boolean.class);
    addAcceptedAttr("slantLabels", Boolean.class);
    addAcceptedAttr("labelStep", Integer.class);
    addAcceptedAttr("staggerLines", Integer.class);
    addAcceptedAttr("showValues", Boolean.class);
    addAcceptedAttr("rotateValues", Boolean.class);
    addAcceptedAttr("placeValuesInside", Boolean.class);
    addAcceptedAttr("showYAxisValues", Boolean.class);
    addAcceptedAttr("showLimits", Boolean.class);
    addAcceptedAttr("showDivLineValues", Boolean.class);
    addAcceptedAttr("yAxisValuesStep", Integer.class);
    addAcceptedAttr("showShadow", Boolean.class);
    addAcceptedAttr("adjustDiv", Boolean.class);
    addAcceptedAttr("rotateYAxisName", Boolean.class);
    addAcceptedAttr("yAxisNameWidth", Integer.class);
    addAcceptedAttr("clickURL", String.class);
    addAcceptedAttr("defaultAnimation", Boolean.class);
    addAcceptedAttr("yAxisMinValue", Integer.class);
    addAcceptedAttr("yAxisMaxValue", Integer.class);
    addAcceptedAttr("setAdaptiveYMin", Boolean.class);

    // Chart Titles and Axis Names
    addAcceptedAttr("caption", String.class);
    addAcceptedAttr("subCaption", String.class);
    addAcceptedAttr("xAxisName", String.class);
    addAcceptedAttr("yAxisName", String.class);

    // Chart Cosmetics
    addAcceptedAttr("showBorder", Boolean.class);
    addAcceptedAttr("borderColor", String.class);
    addAcceptedAttr("borderThickness", Integer.class);
    addAcceptedAttr("borderAlpha", Integer.class);
    addAcceptedAttr("bgColor", String.class);
    addAcceptedAttr("bgAlpha", Integer.class);
    addAcceptedAttr("bgRatio", Integer.class);
    addAcceptedAttr("bgAngle", Integer.class);
    addAcceptedAttr("bgSWF", String.class);
    addAcceptedAttr("bgSWFAlpha", Integer.class);
    addAcceptedAttr("canvasBgColor", String.class);
    addAcceptedAttr("canvasBgAlpha", Integer.class);
    addAcceptedAttr("canvasBgRatio", Integer.class);
    addAcceptedAttr("canvasBgAngle", Integer.class);
    addAcceptedAttr("canvasBorderColor", String.class);
    addAcceptedAttr("canvasBorderThickness", Integer.class);
    addAcceptedAttr("canvasBorderAlpha", Integer.class);
    addAcceptedAttr("showVLineLabelBorder", Boolean.class);
    addAcceptedAttr("logoURL", String.class);
    addAcceptedAttr("logoPosition", String.class);
    addAcceptedAttr("logoAlpha", Integer.class);
    addAcceptedAttr("logoScale", Integer.class);
    addAcceptedAttr("logoLink", String.class);

    //Data Plot Cosmetics
    addAcceptedAttr("useRoundEdges", Boolean.class);
    addAcceptedAttr("showPlotBorder", Boolean.class);
    addAcceptedAttr("plotBorderColor", String.class);
    addAcceptedAttr("plotBorderThickness", Integer.class);
    addAcceptedAttr("plotBorderAlpha", Integer.class);
    addAcceptedAttr("plotBorderDashed", Boolean.class);
    addAcceptedAttr("plotBorderDashLen", Integer.class);
    addAcceptedAttr("plotBorderDashGap", Integer.class);
    addAcceptedAttr("plotFillAngle", Integer.class);
    addAcceptedAttr("plotFillRatio", Integer.class);
    addAcceptedAttr("plotFillAlpha", Integer.class);
    addAcceptedAttr("plotGradientColor", String.class);

    //Divisional Lines & Grids
    addAcceptedAttr("numDivLines", Integer.class);
    addAcceptedAttr("divLineColor", String.class);
    addAcceptedAttr("divLineThickness", Integer.class);
    addAcceptedAttr("divLineAlpha", Integer.class);
    addAcceptedAttr("divLineIsDashed", Boolean.class);
    addAcceptedAttr("divLineDashLen", Integer.class);
    addAcceptedAttr("divLineDashGap", Integer.class);
    addAcceptedAttr("zeroPlaneColor", String.class);
    addAcceptedAttr("zeroPlaneThickness", Integer.class);
    addAcceptedAttr("zeroPlaneAlpha", Integer.class);
    addAcceptedAttr("showAlternateHGridColor", Boolean.class);
    addAcceptedAttr("alternateHGridColor", String.class);
    addAcceptedAttr("alternateHGridAlpha", Integer.class);

    //Legend Properties
    addAcceptedAttr("showLegend", Boolean.class);
    addAcceptedAttr("legendCaption", String.class);
    addAcceptedAttr("legendIconScale", Integer.class);
    addAcceptedAttr("legendPosition", String.class);
    addAcceptedAttr("legendBgColor", String.class);
    addAcceptedAttr("legendBgAlpha", Integer.class);
    addAcceptedAttr("legendBorderColor", String.class);
    addAcceptedAttr("legendBorderThickness", Integer.class);
    addAcceptedAttr("legendBorderAlpha", Integer.class);
    addAcceptedAttr("legendShadow", Boolean.class);
    addAcceptedAttr("legendAllowDrag", Boolean.class);
    addAcceptedAttr("legendScrollBgColor", String.class);
    addAcceptedAttr("legendScrollBarColor", String.class);
    addAcceptedAttr("legendScrollBtnColor", String.class);
    addAcceptedAttr("reverseLegend", Boolean.class);
    addAcceptedAttr("interactiveLegend", Boolean.class);
    addAcceptedAttr("legendNumColumns", Integer.class);
    addAcceptedAttr("minimiseWrappingInLegend", Boolean.class);

    //Number Formatting
    addAcceptedAttr("formatNumber", Boolean.class);
    addAcceptedAttr("formatNumberScale", Boolean.class);
    addAcceptedAttr("defaultNumberScale", String.class);
    addAcceptedAttr("numberScaleUnit", String.class);
    addAcceptedAttr("numberScaleValue", String.class);
    addAcceptedAttr("numberPrefix", String.class);
    addAcceptedAttr("numberSuffix", String.class);
    addAcceptedAttr("decimalSeparator", String.class);
    addAcceptedAttr("thousandSeparator", String.class);
    addAcceptedAttr("inDecimalSeparator", String.class);
    addAcceptedAttr("inThousandSeparator", String.class);
    addAcceptedAttr("decimals", Integer.class);
    addAcceptedAttr("forceDecimals", Boolean.class);
    addAcceptedAttr("forceYAxisValueDecimals", Boolean.class);
    addAcceptedAttr("yAxisValueDecimals", Integer.class);

    //Font Properties
    addAcceptedAttr("baseFont", String.class);
    addAcceptedAttr("baseFontSize", Integer.class);
    addAcceptedAttr("baseFontColor", String.class);
    addAcceptedAttr("outCnvBaseFont", String.class);
    addAcceptedAttr("outCnvBaseFontSize", Integer.class);
    addAcceptedAttr("outCnvBaseFontColor", String.class);

    //Tool-tip
    addAcceptedAttr("showToolTip", Boolean.class);
    addAcceptedAttr("toolTipBgColor", String.class);
    addAcceptedAttr("toolTipBorderColor", String.class);
    addAcceptedAttr("toolTipSepChar", String.class);
    addAcceptedAttr("seriesNameInToolTip", Boolean.class);
    addAcceptedAttr("showToolTipShadow", Boolean.class);

    //Chart Padding & Margins
    addAcceptedAttr("captionPadding", Integer.class);
    addAcceptedAttr("xAxisNamePadding", Integer.class);
    addAcceptedAttr("yAxisNamePadding", Integer.class);
    addAcceptedAttr("yAxisValuesPadding", Integer.class);
    addAcceptedAttr("labelPadding", Integer.class);
    addAcceptedAttr("valuePadding", Integer.class);
    addAcceptedAttr("plotSpacePercent", Integer.class);
    addAcceptedAttr("chartLeftMargin", Integer.class);
    addAcceptedAttr("chartRightMargin", Integer.class);
    addAcceptedAttr("chartTopMargin", Integer.class);
    addAcceptedAttr("chartBottomMargin", Integer.class);
    addAcceptedAttr("legendPadding", Integer.class);
    addAcceptedAttr("canvasLeftMargin", Integer.class);
    addAcceptedAttr("canvasRightMargin", Integer.class);
    addAcceptedAttr("canvasTopMargin", Integer.class);
    addAcceptedAttr("canvasBottomMargin", Integer.class);
  }

  @Override
  protected void initAcceptedChildTypes() {
    addAcceptedChildTypes(Categories.class);
    addAcceptedChildTypes(TrendLines.class);
    addAcceptedChildTypes(DataSet.class);
  }
}
