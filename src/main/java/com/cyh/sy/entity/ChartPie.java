package com.cyh.sy.entity;

public class ChartPie {
	private String month;
	private Integer totalmoney;

	public ChartPie() {
		super();
	}

	public ChartPie(String month, Integer totalmoney) {
		this.month = month;
		this.totalmoney = totalmoney;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Integer getTotalmoney() {
		return totalmoney;
	}

	public void setTotalmoney(Integer totalmoney) {
		this.totalmoney = totalmoney;
	}

	@Override
	public String toString() {
		return "ChartPie{" + "month='" + month + '\'' + ", totalmoney='" + totalmoney + '\'' + '}';
	}
}
