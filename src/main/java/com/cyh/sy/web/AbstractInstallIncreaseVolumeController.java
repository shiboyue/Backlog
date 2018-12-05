package com.cyh.sy.web;

import org.springframework.beans.factory.annotation.Value;

public class AbstractInstallIncreaseVolumeController {
	
	@Value("#{configProperties['installVolumePath']}")
	protected String installVolumePath;
}
