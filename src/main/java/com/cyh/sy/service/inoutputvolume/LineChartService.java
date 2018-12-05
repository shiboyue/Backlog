package com.cyh.sy.service.inoutputvolume;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.cyh.core.util.ExcelUtil.ExcelLogs;
import com.cyh.core.util.ExcelUtil.ExcelUtil;
import com.cyh.sy.consts.AreaEnum;
import com.cyh.sy.consts.TypeEnum;
import com.cyh.sy.entity.InstalltionVolume;
import com.cyh.sy.entity.WeekNumber;
import com.cyh.sy.service.ChartPieService;
import com.cyh.sy.service.ILineChartService;

public abstract class LineChartService implements ILineChartService {
	
	private static final Logger LOG = Logger.getLogger(ChartPieService.class);

	private static String catalinabase = System.getProperty("catalina.base");
	static
	{
		catalinabase = new File(catalinabase).getParent();
	}
	
	private boolean isRatio(String sheetName)
	{
		return sheetName.contains("对比");
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<InstalltionVolume> readInstalltionBackLog(String fileName, String sheetName) {
		boolean isRatio = isRatio(sheetName);
		InputStream inputStream = null;
		try {
			LOG.info(catalinabase);
			File f = new File(fileName);
			inputStream = new FileInputStream(f);

		} catch (Exception e) {
			LOG.error(e, e);
		}

		ExcelLogs logs = new ExcelLogs();
		Collection<Map> inputDataMap = ExcelUtil.importExcel(Map.class, inputStream, "yyyy/MM/dd HH:mm:ss", logs, sheetName, 0);
		List<InstalltionVolume> installationVolumeList = new ArrayList<>();
		for (Map<String, String> m : inputDataMap) {
			String week = m.get("Week");
			if ("合计".equalsIgnoreCase(week)) {
				continue;
			}
			for (Entry<String, String> entry : m.entrySet()) {
				String titleName = entry.getKey();
				String number = entry.getValue();
				if (isRightType(titleName) && StringUtils.isNotBlank(number)) {
					InstalltionVolume installtionVolume = new InstalltionVolume();
					installtionVolume.setArea(AreaEnum.getAreaEnum(sheetName));
					installtionVolume.setType(TypeEnum.getTypeEnum(titleName));

					if (installationVolumeList.contains(installtionVolume)) {
						int index = installationVolumeList.indexOf(installtionVolume);
						InstalltionVolume installationVolumeIndex = installationVolumeList.get(index);
						WeekNumber weekNumber = generateWeekNumber(week, entry, isRatio);
						installationVolumeIndex.getWeekList().add(weekNumber);
					} else {
						WeekNumber weekNumber = generateWeekNumber(week, entry, isRatio);
						List<WeekNumber> weekNumberList = new ArrayList<>();
						weekNumberList.add(weekNumber);
						installtionVolume.setWeekList(weekNumberList);
						installationVolumeList.add(installtionVolume);
					}
				}
			}
		}

		return installationVolumeList;
	}

	private WeekNumber generateWeekNumber(String week, Entry<String, String> entry, boolean isRatio) {
		WeekNumber weekNumber = new WeekNumber();
		weekNumber.setWeek(week);
		if(isRatio)
		{
			BigDecimal bg = new BigDecimal(entry.getValue());
			double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			weekNumber.setRation(f1);
		}else
		{
			weekNumber.setNumber(Integer.valueOf(entry.getValue()));
		}
		return weekNumber;
	}

	abstract boolean isRightType(String type);
}
