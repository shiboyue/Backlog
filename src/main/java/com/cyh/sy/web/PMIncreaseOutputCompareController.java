package com.cyh.sy.web;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyh.sy.entity.InstalltionVolume;
import com.cyh.sy.service.ILineChartService;

@Controller
public class PMIncreaseOutputCompareController extends AbstractPMIncreaseOutputCompareController{

	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private ILineChartService pmVolumeservice;

	@RequestMapping(value = { "/com/getSouthPMincreaseoutputcompareChartPie.do" })
	@ResponseBody
	public List<InstalltionVolume> getSouthInstallData() {
		String sheetName = "PM进出量对比-南区";
		return pmVolumeservice.readInstalltionBackLog(pmVolumePath, sheetName);
	}

	@RequestMapping(value = { "/com/getNorthPMincreaseoutputcompareChartPie.do" })
	@ResponseBody
	public List<InstalltionVolume> getNorthInstallData() {
		String sheetName = "PM进出量对比-北区";
		return pmVolumeservice.readInstalltionBackLog(pmVolumePath, sheetName);
	}

	@RequestMapping(value = { "/com/getNationPMincreaseoutputcompareChartPie.do" })
	@ResponseBody
	public List<InstalltionVolume> getNationInstallData() {
		String sheetName = "PM进出量对比-全国";
		return pmVolumeservice.readInstalltionBackLog(pmVolumePath, sheetName);
	}

	@RequestMapping(value = { "/com/getEastPMincreaseoutputcompareChartPie.do" })
	@ResponseBody
	public List<InstalltionVolume> getEastInstallData() {
		String sheetName = "PM进出量对比-东区";
		return pmVolumeservice.readInstalltionBackLog(pmVolumePath, sheetName);
	}
}
