package com.cyh.sy.service.backlog;

public class InstallBacklogService extends BarChartService {

	protected boolean isRightType(String type) {
		return "LC".equalsIgnoreCase(type) || "MS".equalsIgnoreCase(type) || "Others".equalsIgnoreCase(type)
				|| "TOF".equalsIgnoreCase(type) || "网络版".equalsIgnoreCase(type);
	}
}
