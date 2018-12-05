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

import com.cyh.sy.entity.InstalltionVolume;
import com.cyh.sy.service.ILineChartService;

@Controller
public class InstallOutputVolumeController extends AbstractInstallIncreaseVolumeController{

	protected Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource
	private ILineChartService installoutputVolumeservice;
	/**
	 * 返回Chart页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/com/installoutputvolume")
	public String chart(HttpServletRequest request, Model model) {
		return "installoutputchartjs";
	}

	@RequestMapping(value = { "/com/getSouthInstallOutputChartPie.do" })
	@ResponseBody
	public List<InstalltionVolume> getSouthInstallData() {
		String sheetName = "安装出量-南区";
		return installoutputVolumeservice.readInstalltionBackLog(installVolumePath, sheetName);
	}

	@RequestMapping(value = { "/com/getNorthInstallOutputChartPie.do" })
	@ResponseBody
	public List<InstalltionVolume> getNorthInstallData() {
		String sheetName = "安装出量-北区";
		return installoutputVolumeservice.readInstalltionBackLog(installVolumePath, sheetName);
	}

	@RequestMapping(value = { "/com/getNationInstallOutputChartPie.do" })
	@ResponseBody
	public List<InstalltionVolume> getNationInstallData() {
		String sheetName = "安装出量-全国";
		return installoutputVolumeservice.readInstalltionBackLog(installVolumePath, sheetName);
	}

	@RequestMapping(value = { "/com/getEastInstallOutputChartPie.do" })
	@ResponseBody
	public List<InstalltionVolume> getNumber() {
		String sheetName = "安装出量-东区";
		return installoutputVolumeservice.readInstalltionBackLog(installVolumePath, sheetName);
	}
}
