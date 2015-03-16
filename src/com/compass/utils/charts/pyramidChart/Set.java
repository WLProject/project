package com.compass.utils.charts.pyramidChart;

import com.compass.utils.charts.AbstractChartObj;

/**
 * @author wangLong
 *
 */
public class Set extends AbstractChartObj{

	public Set(String name, boolean hasChild) {
		super(name, hasChild);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initAttributeDefinations() {
		// TODO Auto-generated method stub
		 addAcceptedAttr("label", String.class);
		    addAcceptedAttr("value", Integer.class);
		    addAcceptedAttr("toolText", String.class);
		    addAcceptedAttr("link", String.class);
	}

	@Override
	protected void initAcceptedChildTypes() {
		// TODO Auto-generated method stub
		
	}

}
