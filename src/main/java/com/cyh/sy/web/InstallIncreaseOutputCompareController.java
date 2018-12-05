package com.cyh.sy.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyh.sy.entity.InstalltionVolume;
import com.cyh.sy.service.ILineChartService;

@Controller
public class InstallIncreaseOutputCompareController {

	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Value("#{configProperties['installVolumePath']}")
	private String installVolumePath;
	
	@Resource
	private ILineChartService installoutputVolumeservice;
	/**
	 * 返回Chart页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/com/installincreaseoutputcomparevolume")
	public String chart(HttpServletRequest request, Model model) {
		return "installincreaseoutputcomparechartjs";
	}

	@RequestMapping(value = { "/com/getSouthInstallincreaseoutputcompareChartPie.do" })
	@ResponseBody
	public List<InstalltionVolume> getSouthInstallData() {
		String sheetName = "安装进出量对比-南区";
		return installoutputVolumeservice.readInstalltionBackLog(installVolumePath, sheetName);
	}

	@RequestMapping(value = { "/com/getNorthInstallincreaseoutputcompareChartPie.do" })
	@ResponseBody
	public List<InstalltionVolume> getNorthInstallData() {
		String sheetName = "安装进出量对比-北区";
		return installoutputVolumeservice.readInstalltionBackLog(installVolumePath, sheetName);
	}

	@RequestMapping(value = { "/com/getNationInstallincreaseoutputcompareChartPie.do" })
	@ResponseBody
	public List<InstalltionVolume> getNationInstallData() {
		String sheetName = "安装进出量对比-全国";
		return installoutputVolumeservice.readInstalltionBackLog(installVolumePath, sheetName);
	}

	@RequestMapping(value = { "/com/getEastInstallincreaseoutputcompareChartPie.do" })
	@ResponseBody
	public List<InstalltionVolume> getEastInstallData() {
		String sheetName = "安装进出量对比-东区";
		return installoutputVolumeservice.readInstalltionBackLog(installVolumePath, sheetName);
	}
}
