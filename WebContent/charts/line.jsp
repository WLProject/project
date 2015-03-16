<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp" %>
<%

String xml = "<chart manageResize='1' bgColor='000000' bgAlpha='100' canvasBorderThickness='1' canvasBorderColor='008040' canvasBgColor='000000' yAxisMaxValue='100'  decimals='0' numdivlines='9' numVDivLines='28' numDisplaySets='30' divLineColor='008040' vDivLineColor='008040' divLineAlpha='100' chartLeftMargin='10' baseFontColor='00dd00' showRealTimeValue='0'  numberSuffix='%' labelDisplay='rotate' slantLabels='1' toolTipBgColor='000000' toolTipBorderColor='008040' baseFontSize='11' showAlternateHGridColor='0' legendBgColor='000000' legendBorderColor='008040' legendPadding='35' showLabels='1' dataStreamURL='"+request.getContextPath()+"/chart/chart.do?method=getLineChart' refreshInterval='1' setAdaptiveYMin='1' xAxisName='Time' >"+
				"<categories>"+
					"<category label='6 mins ago' />"+
					"<category label='5 mins ago' />"+
					"<category label='4 mins ago' />"+
					"<category label='3 mins ago' />"+
					"<category label='2 mins ago' />"+
					"<category label='1 mins ago' />"+
				"</categories>"+
				"<dataset seriesName='RealDemo' showValues='0' color='00dd00'  showValues='0' alpha='100' anchorAlpha='0'>"+
					"<set value='32.34' />"+
					"<set value='34.35' />"+
					"<set value='31.25' />"+
					"<set value='33.23' />"+
					"<set value='31.34' />"+
					"<set value='33.76' />"+
				"</dataset>"+
				"<styles>"+
					"<definition>"+
						"<style type='font' name='captionFont' size='14' />"+
					"</definition>"+
					"<application>"+
						"<apply toObject='Caption' styles='captionFont' />"+
						"<apply toObject='Realtimevalue' styles='captionFont' />"+
					"</application>"+
				"</styles>"+
			"</chart>";
%>
<html>
<head>
<body>
<input id="yearmonth" name="yearmonth" class="Wdate"  type="text" SelectedDate="{x:Static sys:DateTime.Now}" style="width: 120px;" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
	<div id="chartdiv" align="center"></div>
	<script type="text/javascript">
	  var  xml = "<%=xml%>";
	  var  myChart = new FusionCharts("${ctx}/commons/charts/RealTimeLineDY.swf","viewAllChartId", "80%", "350", "0", "1");
	   //myChart.setDataURL("../commons/charts/Data/MSColumn2D.xml");
	  
	  myChart.setDataXML(xml);
	  myChart.render("chartdiv");
	
	</script>
</head>
</body>
</html>
