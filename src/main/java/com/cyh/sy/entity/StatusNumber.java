package com.cyh.sy.entity;

import com.cyh.sy.consts.StatusEnum;

public class StatusNumber {

	private StatusEnum status;

	private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}
}
