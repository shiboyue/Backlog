package com.cyh.sy.consts;

public enum TypeEnum {

	LC("LC"), MS("MS"), OTHERS("Others"), TOF("TOF"), INTERNET("网络版");

	private String type;

	private TypeEnum(String type) {
		this.setType(type);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public static TypeEnum getTypeEnum(String status)
	{
		for (TypeEnum eachStatus: TypeEnum.values()) {
			if(status.equalsIgnoreCase(eachStatus.getType()))
			{
				return eachStatus;
			}
		}
		return TypeEnum.OTHERS;
	}
}
