package com.compass.charts.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.compass.utils.charts.AbstractChartObj;
import com.compass.utils.charts.gantt.Categories;
import com.compass.utils.charts.gantt.Category;
import com.compass.utils.charts.gantt.DataTable;
import com.compass.utils.charts.gantt.GanttChart;
import com.compass.utils.charts.gantt.Processes;
import com.compass.utils.charts.gantt.Task;
import com.compass.utils.charts.gantt.Tasks;
import com.compass.utils.mvc.AjaxReturnInfo;

@Controller
@RequestMapping("/chart/chart.do")
public class ChartsController {
	private static final long serialVersionUID = 1L;
	
	
@RequestMapping(params ="method=getChart")
@ResponseBody	
public void getChart(HttpServletResponse response){
		String percentum="";
//      随机数对象
        Random r = new Random();
//      产生2为随机数
        StringBuffer sb = new StringBuffer();
        int random = 0;
        for (int i = 0; i < 2; i++) {
            random = r.nextInt(10);
            sb.append(random);
        }
        percentum=sb.toString();
        response.setContentType("text/html");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println("&value="+percentum+"&");
			out.flush();
			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
@RequestMapping(params ="method=getLineChart")
@ResponseBody
public void getLineChart(HttpServletResponse response){
		String percentum="";
//      随机数对象
        Random r = new Random();
//      产生2为随机数
        StringBuffer sb = new StringBuffer();
        int random = 0;
        for (int i = 0; i < 2; i++) {
            random = r.nextInt(10);
            sb.append(random);
        }
        percentum=sb.toString();
        response.setContentType("text/html");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println("&value="+percentum+"&");
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("&FormDia="+percentum+"&");
		
		
	}
@RequestMapping(params ="method=getGanttChart")
@ResponseBody
public AjaxReturnInfo getGanttChart() {
		String xml = createGanttXm();
		xml ="<chart caption='Business Results 2005 v 2006' xAxisName='Month' yAxisName='Revenue' numberPrefix='$'  exportEnabled='1' exportAtClient='1' exportHandler='fcExporter1' exportFormats='PDF=Export PDF|PNG=Export PNG' >"+
		"<categories>"
		+"<category label='Jan' />"
		+"<category label='Feb' />"
		+"<category label='Mar' />"
		+"<category label='Apr' />"
		+"<category label='May' />"
		+"<category label='Jun' />"
		+"<category label='Jul' />"
		+"<category label='Aug' />"
		+"<category label='Sep' />"
		+"<category label='Oct' />"
		+"<category label='Nov' />"
		+"<category label='Dec' />"
		+"</categories>"

		   +"<dataset seriesName='2006'>"
		   +" <set value='27400' />"
		   +"<set value='29800'/>"
		   +"<set value='25800' />"
		   +"<set value='26800' />"
		   +"<set value='29600' />"
		   +"<set value='32600' />"
		   +"<set value='31800' />"
		   +" <set value='36700' />"
		   +"<set value='29700' />"
		   +"<set value='31900' />"
		   +"<set value='34800' />"
		   +"<set value='24800' />"
		      +"</dataset>"

		   +"<dataset seriesName='2005'>"
		   +"<set value='10000'/>"
		   +"<set value='11500'/>"
		   +"<set value='12500'/>"
		   +"<set value='15000'/>"
		   +"<set value='11000' />"
		   +"<set value='9800' />"
		   +"<set value='11800' />"
		      +"<set value='19700' />"
		      +" <set value='21700' />"
		      +"<set value='21900' />"
		      +"<set value='22900' />"
		      +"<set value='20800' />"
		      +"</dataset>"

		   +"<trendlines>"
		   +"<line startValue='26000' color='91C728' displayValue='Target' showOnTop='1'/>"
		      +"</trendlines>"

		   +"<styles>"

		   +"<definition>"
		      +"<style name='CanvasAnim' type='animation' param='_xScale' start='0' duration='1' />"
		         +"</definition>"

		      +"<application>"
		      +"<apply toObject='Canvas' styles='CanvasAnim' />"
		         +" </application>   "

		      +"</styles>"

		+"</chart>";
		AjaxReturnInfo ajaxReturnInfo = AjaxReturnInfo.success("");
		ajaxReturnInfo.add("xml", xml);
		return ajaxReturnInfo;
	}

	private String createGanttXm() {
		GanttChart gantt = new GanttChart();
		gantt.setAttribute("dataFormat", "mm/dd/yyyy");
		gantt.setAttribute("outputDataFormat", "hh:mn");
		gantt.setAttribute("ganttPaneDuration", 6);
		gantt.setAttribute("ganttPaneDurationUnit", "h");
		gantt.setAttribute("ganttWidthPercent", 80);
		gantt.setAttribute("animation", false);
		gantt.setAttribute("dateInToolTip", false);
		gantt.setAttribute("showFullDataTable", true);
		gantt.setAttribute("scrollPadding", 0);

		gantt.setAttribute("chartLeftMargin", 0);
		gantt.setAttribute("chartRightMargin", 0);
		gantt.setAttribute("chartTopMargin", 0);
		gantt.setAttribute("chartLeftMargin", 0);
		gantt.setAttribute("borderColor", "blue");
		gantt.setAttribute("showBorder", false);
		gantt.setAttribute("borderThickness", 0);

		// 创建子节点
		gantt.addChildren(createCategories());
		gantt.addChild(createProcesses());
		gantt.addChild(createTasks());
		gantt.addChild(createLegend());
		gantt.addChild(createDatatable());
		return gantt.getXml();
	}

	private List<Categories> createCategories() {
		List<Categories> catList = new ArrayList<Categories>();
		Categories timeCate = new Categories();
		timeCate.setAttribute("align", "center");
		Category category = new Category();

		category.setAttribute("start", "2012-05-21");
		category.setAttribute("end", "2012-05-26");
		category.setAttribute("label", "Gantt");
		timeCate.addChild(category);
		catList.add(timeCate);
		return catList;
	}

	private AbstractChartObj createDatatable() {
		//创建前面栏位
		 DataTable dataTable = new DataTable();
		 dataTable.setAttribute("headerVAlign", "bottom");
		 dataTable.setAttribute("align", "left");
		return null;
	}

	private AbstractChartObj createLegend() {
		//添加图例
		return null;
	}

	private AbstractChartObj createTasks() {
		Tasks tasks = new Tasks();
	    
	    Task task = new Task();
	    task.setAttribute("start", "2012-05-11");
	    task.setAttribute("end","2012-05-12");
	    task.setAttribute("height", "7");
	    task.setAttribute("toppadding", "70%");
	    task.setAttribute("processId", "10");
        task.setAttribute("topPadding","30");
        task.setAttribute("height", "20");
        tasks.addChild(task);
		return tasks;
	}

	private AbstractChartObj createProcesses() {
		Processes processes = new Processes();
		processes.setAttribute("headertext", "Eqp Group");
		processes.setAttribute("align", "left");
		processes.setAttribute("headerVAlign", "bottom");
		com.compass.utils.charts.gantt.Process process = new com.compass.utils.charts.gantt.Process();
		process.setAttribute("label", "10");
		process.setAttribute("id", "11");
		process.setAttribute("font", "Arial");
		process.setAttribute("fontSize", "12");
		process.setAttribute("isUnderline", true);
		process.setAttribute("isBold", true);
		// process.setAttribute("link", "JavaScript:myJSFunction(\"" +
		// list.get(i) + "\");");
		processes.addChild(process);
		return processes;
	}
}
