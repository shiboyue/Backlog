package com.cyh.sy.web;

import org.springframework.beans.factory.annotation.Value;

public class AbstractPMIncreaseOutputCompareController {
	@Value("#{configProperties['pmVolumePath']}")
	protected String pmVolumePath;
}
