package com.cyh.sy.service.backlog;

public class PMBacklogService extends BarChartService {

	public boolean isRightType(String type) {
		return "LC".equalsIgnoreCase(type) || "MS".equalsIgnoreCase(type) || "Others".equalsIgnoreCase(type)
				|| "TOF".equalsIgnoreCase(type);
	}
}
