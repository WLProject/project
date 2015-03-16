<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/../commons/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GanttChart</title>
</head>
<body>

<div id="chartdiv" align="center" style="top: 30px;"></div>
 <div id="fcexpDiv" align="center"></div>
	<script type="text/javascript">
	$(document).ready(function(){
	 	$.loadChart();
	});	
	
	$.loadChart = function(){
		$.post ("${ctx}/chart/chart.do?method=getGanttChart",
				function(data){
			$.parseAjaxReturnInfo(data, $.success, $.failed);
				}
				,"json");
	}
	
	$.success = function (Message, data) {
		$.setChartDiv(data.xml)
	}
	$.setChartDiv = function(xml){

		 var  myChart = new FusionCharts("${ctx}/commons/charts/MSColumn3D.swf","viewAllChartId", "90%", "330", "0", "1");
		  //myChart.setDataURL("../commons/charts/Data/MSColumn2D.xml");
		  myChart.setDataXML(xml);
		  myChart.render("chartdiv");
		  
		  var myExportComponent = new FusionChartsExportObject("fcExporter1", "${ctx}/commons/charts/FCExporter.swf");
		  myExportComponent.Render("fcexpDiv");
	}
</script>
</body>
</html>