package com.cyh.sy.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyh.sy.entity.InstallationBacklog;
import com.cyh.sy.service.IChartService;

@Controller
public class PMBackLogController {

	protected Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource
	private IChartService pmbacklogservice;
	/**
	 * 返回Chart页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/com/pmchart")
	public String chart(HttpServletRequest request, Model model) {
		return "pmchartjs";
	}
	
	@RequestMapping(value = { "/com/getPMEastChartPie.do" })
	@ResponseBody
	public List<InstallationBacklog> getNumber() {
		//PMBacklogService BarChartService = new PMBacklogService();
		String sheetName = "PM存量-东区";
		return pmbacklogservice.readInstalltionBackLog(sheetName);
	}

	@RequestMapping(value = { "/com/getPMSouthChartPie.do" })
	@ResponseBody
	public List<InstallationBacklog> getSouthInstallData() {
		//PMBacklogService BarChartService = new PMBacklogService();
		String sheetName = "PM存量-南区";
		return pmbacklogservice.readInstalltionBackLog(sheetName);
	}

	@RequestMapping(value = { "/com/getPMNorthChartPie.do" })
	@ResponseBody
	public List<InstallationBacklog> getNorthInstallData() {
		//PMBacklogService BarChartService = new PMBacklogService();
		String sheetName = "PM存量-北区";
		return pmbacklogservice.readInstalltionBackLog(sheetName);
	}

	@RequestMapping(value = { "/com/getPMNationChartPie.do" })
	@ResponseBody
	public List<InstallationBacklog> getNationInstallData() {
		//PMBacklogService BarChartService = new PMBacklogService();
		String sheetName = "PM存量-全国";
		return pmbacklogservice.readInstalltionBackLog(sheetName);
	}
}
