package com.cyh.sy.entity;

import java.util.List;

import com.cyh.sy.consts.AreaEnum;
import com.cyh.sy.consts.TypeEnum;

public class InstallationBacklog {

	private AreaEnum area;
	private TypeEnum type;
	
	private List<StatusNumber> statusList;

	public AreaEnum getArea() {
		return area;
	}

	public void setArea(AreaEnum area) {
		this.area = area;
	}

	public TypeEnum getType() {
		return type;
	}

	public void setType(TypeEnum type) {
		this.type = type;
	}

	public List<StatusNumber> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<StatusNumber> statusList) {
		this.statusList = statusList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InstallationBacklog other = (InstallationBacklog) obj;
		if (area != other.area)
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
}
