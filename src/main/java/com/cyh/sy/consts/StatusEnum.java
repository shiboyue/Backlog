package com.cyh.sy.consts;

public enum StatusEnum {

	NOTSHEEPED("未发货"), WAITCUSTOMER("等客户"), INSTALLATION("在安装"), ARRANGED("已安排"), WAITFILES("等文件"), TOBEARRANGED("待安排"),
	UNKNOW("Unknow"), EXECUTING("在执行");

	private String status;

	private StatusEnum(String status) {
		this.setStatus(status);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static StatusEnum getStatusEnum(String status)
	{
		for (StatusEnum eachStatus: StatusEnum.values()) {
			if(status.equalsIgnoreCase(eachStatus.getStatus()))
			{
				return eachStatus;
			}
		}
		return StatusEnum.UNKNOW;
	}
}
