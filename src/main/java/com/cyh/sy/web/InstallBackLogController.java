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
public class InstallBackLogController {

	protected Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource
	private IChartService installbacklogservice;
	/**
	 * 返回Chart页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/com/chart")
	public String chart(HttpServletRequest request, Model model) {
		return "chartjs";
	}

	@RequestMapping(value = { "/com/getSouthChartPie.do" })
	@ResponseBody
	public List<InstallationBacklog> getSouthInstallData() {
		//InstallBacklogService BarChartService = new InstallBacklogService();
		String sheetName = "安装存量-南区";
		return installbacklogservice.readInstalltionBackLog(sheetName);
	}

	@RequestMapping(value = { "/com/getNorthChartPie.do" })
	@ResponseBody
	public List<InstallationBacklog> getNorthInstallData() {
		//InstallBacklogService BarChartService = new InstallBacklogService();
		String sheetName = "安装存量-北区";
		return installbacklogservice.readInstalltionBackLog(sheetName);
	}

	@RequestMapping(value = { "/com/getNationChartPie.do" })
	@ResponseBody
	public List<InstallationBacklog> getNationInstallData() {
		//InstallBacklogService BarChartService = new InstallBacklogService();
		String sheetName = "安装存量-全国";
		return installbacklogservice.readInstalltionBackLog(sheetName);
	}

	@RequestMapping(value = { "/com/getChartPie.do" })
	@ResponseBody
	public List<InstallationBacklog> getNumber() {
		//InstallBacklogService BarChartService = new InstallBacklogService();
		String sheetName = "安装存量-东区";
		return installbacklogservice.readInstalltionBackLog(sheetName);
	}
}
