package com.cyh.sy.consts;

public enum AreaEnum {

	NORTH("北区"), SOUTH("南区"), EAST("东区"), WEST("西区"), National("全国");

	private String area;

	private AreaEnum(String area) {
		this.area = area;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	public static AreaEnum getAreaEnum(String area)
	{
		for (AreaEnum eachArea: AreaEnum.values()) {
			if(area.contains(eachArea.getArea()))
			{
				return eachArea;
			}
		}
		return AreaEnum.NORTH;
	}
}
