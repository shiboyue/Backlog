package com.cyh.sy.service;

import java.util.List;

import com.cyh.sy.entity.InstalltionVolume;

public interface ILineChartService {
	 List<InstalltionVolume> readInstalltionBackLog(String fileName, String sheetName);


}
