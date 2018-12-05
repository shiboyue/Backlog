package com.cyh.sy.service;

import java.util.List;

import com.cyh.sy.entity.InstallationBacklog;

public interface IChartService {

	 List<InstallationBacklog> readInstalltionBackLog(String sheetName);
}
