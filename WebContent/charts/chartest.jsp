<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/../commons/taglibs.jsp" %>
<%

String xml = "<chart>"+
   "<datatable headerVAlign='bottom'>"+
      "<datacolumn headerText='Who does?' headerFontSize='18' headerVAlign='bottom' headerAlign='right' align='left' fontSize='12' >"+
        "<text label='John' />"+
        "<text label='David' />"+
         "<text label='Mary' />"+
         "<text label='Andrew' />"+
         "<text label='Tiger' />"+
         "<text label='Sharon' />"+
         "<text label='Neil' />"+
         "<text label='Harry' />"+
         "<text label='Chris' />"+
         "<text label='Richard' />"+
      "</datacolumn>"+
   "</datatable>"+
"</chart>";



%>
<html>
<head>
<body>
	<div id="chartdiv" align="center"></div>
	 <div id="fcexpDiv" align="center">FusionCharts Export Handler Component</div>
	<script type="text/javascript">
	  var  xml = "<%=xml%>";
	  var  myChart = new FusionCharts("${ctx}/commons/charts/MSColumn3D.swf","viewAllChartId", "90%", "330", "0", "1");
	 // myChart.setDataURL("${ctx}/commons/charts/Data/MSColumn2D.xml");
	  
	  myChart.setDataXML(xml);
	  myChart.render("chartdiv");
	  
	  var myExportComponent = new FusionChartsExportObject("fcExporter1", "${ctx}/commons/charts/FCExporter.swf");
	  


	   //Border properties
	   myExportComponent.componentAttributes.borderThickness = '1';
	   myExportComponent.componentAttributes.borderColor = '0372AB';

	   //Font properties
	   myExportComponent.componentAttributes.fontFace = 'Arial';
	   myExportComponent.componentAttributes.fontColor = '0372AB';
	   myExportComponent.componentAttributes.fontSize = '12';

	   //Button visual configuration
	   myExportComponent.componentAttributes.btnWidth = '100';
	   myExportComponent.componentAttributes.btnHeight= '25';
	   myExportComponent.componentAttributes.btnColor = 'E1f5ff';
	   myExportComponent.componentAttributes.btnBorderColor = '0372AB';

	   //Button font properties
	   myExportComponent.componentAttributes.btnFontFace = 'Verdana';
	   myExportComponent.componentAttributes.btnFontColor = '0372AB';
	   myExportComponent.componentAttributes.btnFontSize = '15';

	   //Title of button
	   myExportComponent.componentAttributes.btnsavetitle = '保存'
	   myExportComponent.componentAttributes.btndisabledtitle = '等待导出'; 
	   
	  myExportComponent.Render("fcexpDiv");
	</script>

</head>
</body>
</html>
