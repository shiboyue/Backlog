package com.cyh.sy.service.inoutputvolume;

public class InstallVolulmeService extends LineChartService {

	protected boolean isRightType(String type) {
		return "LC".equalsIgnoreCase(type) || "MS".equalsIgnoreCase(type) || "Others".equalsIgnoreCase(type)
				|| "TOF".equalsIgnoreCase(type) || "网络版".equalsIgnoreCase(type);
	}

}
