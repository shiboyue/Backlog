package com.cyh.sy.service.backlog;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.cyh.core.util.ExcelUtil.ExcelLogs;
import com.cyh.core.util.ExcelUtil.ExcelUtil;
import com.cyh.sy.consts.AreaEnum;
import com.cyh.sy.consts.StatusEnum;
import com.cyh.sy.consts.TypeEnum;
import com.cyh.sy.entity.InstallationBacklog;
import com.cyh.sy.entity.StatusNumber;
import com.cyh.sy.service.IChartService;

public abstract class BarChartService implements IChartService {
	private static final Logger LOG = Logger.getLogger(BarChartService.class);

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<InstallationBacklog> readInstalltionBackLog(String sheetName) {
		InputStream inputStream = null;
		try {
			File f = new File("D:\\DataSets\\存量统计.xlsx");
			inputStream = new FileInputStream(f);

		} catch (Exception e) {
			LOG.error(e, e);
		}

		ExcelLogs logs = new ExcelLogs();
		Collection<Map> inputDataMap = ExcelUtil.importExcel(Map.class, inputStream, "yyyy/MM/dd HH:mm:ss", logs, sheetName, 0);
		List<InstallationBacklog> installationBacklogList = new ArrayList<>();
		for (Map<String, String> m : inputDataMap) {
			String status = m.get("Status");
			if ("总计".equalsIgnoreCase(status)) {
				continue;
			}
			StatusEnum statusEnum = StatusEnum.getStatusEnum(status);
			for (Entry<String, String> entry : m.entrySet()) {
				String titleName = entry.getKey();
				if (isRightType(titleName)) {
					InstallationBacklog installationBacklog = new InstallationBacklog();
					installationBacklog.setArea(AreaEnum.getAreaEnum(sheetName));
					installationBacklog.setType(TypeEnum.getTypeEnum(titleName));

					if (installationBacklogList.contains(installationBacklog)) {
						int index = installationBacklogList.indexOf(installationBacklog);
						InstallationBacklog installationBacklog2 = installationBacklogList.get(index);
						StatusNumber statusNumber = generateStatusNumber(statusEnum, entry);
						installationBacklog2.getStatusList().add(statusNumber);
					} else {
						StatusNumber statusNumber = generateStatusNumber(statusEnum, entry);
						List<StatusNumber> statusNumberList = new ArrayList<>();
						statusNumberList.add(statusNumber);
						installationBacklog.setStatusList(statusNumberList);
						installationBacklogList.add(installationBacklog);
					}
				}
			}
		}

		return installationBacklogList;
	}

	private StatusNumber generateStatusNumber(StatusEnum statusEnum, Entry<String, String> entry) {
		StatusNumber statusNumber = new StatusNumber();
		statusNumber.setStatus(statusEnum);
		statusNumber.setNumber(Integer.valueOf(entry.getValue()));
		return statusNumber;
	}

	abstract boolean isRightType(String type);
}
