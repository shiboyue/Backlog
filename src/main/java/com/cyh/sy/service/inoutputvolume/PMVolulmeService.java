package com.cyh.sy.service.inoutputvolume;

public class PMVolulmeService extends LineChartService {

	protected boolean isRightType(String type) {
		return "LC".equalsIgnoreCase(type) || "MS".equalsIgnoreCase(type) || "Others".equalsIgnoreCase(type)
				|| "TOF".equalsIgnoreCase(type);
	}

}
