package com.compass.utils.charts.msline;

import com.compass.utils.charts.AbstractChartObj;

/**
 * Created by IntelliJ IDEA.
 * User: oob
 * Date: 11-9-16
 * Time: …œŒÁ12:25
 * To change this template use File | Settings | File Templates.
 */
public class Legend extends AbstractChartObj {

   /**
   * ≥ı ºªØChart Object
   */
  public Legend() {
    super("legend", true);
  }

  @Override
  protected void initAttributeDefinations() {
    addAcceptedAttr("showLegend",Boolean.class);
    addAcceptedAttr("legendCaption",String.class);
    addAcceptedAttr("legendIconScale",Integer.class);
    addAcceptedAttr("legendPosition",String.class);
    addAcceptedAttr("legendBgColor",String.class);
    addAcceptedAttr("legendBgAlpha",Integer.class);
    addAcceptedAttr("legendBorderColor",String.class);
    addAcceptedAttr("legendBorderThickness",Integer.class);
    addAcceptedAttr("legendBorderAlpha",Integer.class);
    addAcceptedAttr("legendShadow",Boolean.class);
    addAcceptedAttr("legendAllowDrag",String.class);
    addAcceptedAttr("legendScrollBgColor",String.class);
    addAcceptedAttr("legendScrollBarColor",String.class);
    addAcceptedAttr("legendScrollBtnColor",String.class);
    addAcceptedAttr("reverseLegend",Boolean.class);
    addAcceptedAttr("interactiveLegend",Boolean.class);
    addAcceptedAttr("legendNumColumns",Integer.class);
    addAcceptedAttr("minimiseWrappingInLegend",Boolean.class);
  }

  @Override
  protected void initAcceptedChildTypes() {
  }
}
