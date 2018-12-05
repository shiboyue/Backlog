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
public class PMIncreaseVolumeController extends AbstractPMIncreaseOutputCompareController{

	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private ILineChartService pmVolumeservice;

	@RequestMapping(value = { "/com/getSouthPMincreaseChartPie.do" })
	@ResponseBody
	public List<InstalltionVolume> getSouthInstallData() {
		String sheetName = "PM增量-南区";
		return pmVolumeservice.readInstalltionBackLog(pmVolumePath, sheetName);
	}

	@RequestMapping(value = { "/com/getNorthPMincreaseChartPie.do" })
	@ResponseBody
	public List<InstalltionVolume> getNorthInstallData() {
		String sheetName = "PM增量-北区";
		return pmVolumeservice.readInstalltionBackLog(pmVolumePath, sheetName);
	}

	@RequestMapping(value = { "/com/getNationPMincreaseChartPie.do" })
	@ResponseBody
	public List<InstalltionVolume> getNationInstallData() {
		String sheetName = "PM增量-全国";
		return pmVolumeservice.readInstalltionBackLog(pmVolumePath, sheetName);
	}

	@RequestMapping(value = { "/com/getEastPMincreaseChartPie.do" })
	@ResponseBody
	public List<InstalltionVolume> getNumber() {
		String sheetName = "PM增量-东区";
		return pmVolumeservice.readInstalltionBackLog(pmVolumePath, sheetName);
	}
}
