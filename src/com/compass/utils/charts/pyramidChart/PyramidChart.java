package com.compass.utils.charts.pyramidChart;

import com.compass.utils.charts.AbstractChartObj;

/**
 * @author wangLong
 *
 */
public class PyramidChart extends AbstractChartObj{

	public PyramidChart(String name, boolean hasChild) {
		  super("chart", true);
	}

	@Override
	protected void initAttributeDefinations() {
		// TODO Auto-generated method stub
		    addAcceptedAttr("animation", Boolean.class);
		    addAcceptedAttr("defaultAnimation", Integer.class);
		    addAcceptedAttr("clickURL", String.class);
		    addAcceptedAttr("palette", Boolean.class);
		    addAcceptedAttr("paletteThemeColor", String.class);
		    addAcceptedAttr("annRenderDelay", String.class);
		    addAcceptedAttr("showPrintMenuItem", Boolean.class);
		    addAcceptedAttr("showAboutMenuItem", String.class);
	}

	@Override
	protected void initAcceptedChildTypes() {
		// TODO Auto-generated method stub
		  addAcceptedChildTypes(Set.class);
	}

}
