package com.cyh.sy.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
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
import com.cyh.sy.entity.ChartPie;
import com.cyh.sy.entity.InstallationBacklog;
import com.cyh.sy.entity.StatusNumber;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class ChartPieService {

	private static final Logger LOG = Logger.getLogger(ChartPieService.class);

	private static final String[] TITLE_NAMES = new String[] { "xx", "yy", "zz" };

	private boolean isRightType(String type) {
		return "LC".equalsIgnoreCase(type) || "MS".equalsIgnoreCase(type) || "Others".equalsIgnoreCase(type)
				|| "TOF".equalsIgnoreCase(type) || "网络版".equalsIgnoreCase(type);
	}

	public List<InstallationBacklog> importXls(String sheetName) {
		InputStream inputStream = null;
		try {
			File f = new File("D:\\workspace\\SSM-Demo\\resources\\存量统计-2018.xlsx");
			inputStream = new FileInputStream(f);

		} catch (Exception e) {
			LOG.error(e, e);
		}

		ExcelLogs logs = new ExcelLogs();
		Collection<Map> importExcel = ExcelUtil.importExcel(Map.class, inputStream, "yyyy/MM/dd HH:mm:ss", logs,
				sheetName, 0);
		List<InstallationBacklog> installationBacklogList = new ArrayList<>();
		for (Map<String, String> m : importExcel) {
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

	public void getCsvFile(String ADDRESS_FILE) {
		try {
			CSVWriter writer = new CSVWriter(new FileWriter(ADDRESS_FILE));
			List<String[]> allElements = new ArrayList<String[]>();
			allElements.add(new String[] { "张三", "地址1", "邮箱1" });
			allElements.add(new String[] { "李四", "地址2", "邮箱2" });

			writer.writeAll(allElements);
			writer.close();
			System.out.println("\nGenerated CSV File:" + ADDRESS_FILE);

			CSVReader reader = new CSVReader(new FileReader(ADDRESS_FILE));
			String[] titles = reader.readNext();

			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) {
				System.out.println(
						"Name: [" + nextLine[0] + "]\nAddress: [" + nextLine[1] + "]\nEmail: [" + nextLine[2] + "]");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private int[] getColumnNuber(String[] file_titles, String[] TITLE_NAMES) {
		int[] titleIndexs = new int[TITLE_NAMES.length];
		int index = 0;
		for (int i = 0; i < TITLE_NAMES.length; i++) {
			for (int j = 0; j < file_titles.length; j++) {
				if (TITLE_NAMES[i].equalsIgnoreCase(file_titles[j])) {
					titleIndexs[index] = j;
					index++;
				} else {
					throw new RuntimeException("The title is not existed!");
				}
			}
		}

		return titleIndexs;
	}

	public List<ChartPie> getNumber() {
		List<ChartPie> list = new ArrayList<ChartPie>();
//	   List<ChartPie> hasMonths = iUserDao.selectHasMonth();
//	   if(hasMonths != null && hasMonths.size()>0){
//	      for(ChartPie c : hasMonths){
//	         ChartPie chartPie = new ChartPie(c.getMonth(), 20*iUserDao.getMonthTotalNumber(c.getMonth()));
//	         list.add(chartPie);
//	      }
//	   }
		ChartPie chartPie1 = new ChartPie("January", 100);
		ChartPie chartPie2 = new ChartPie("February", 200);
		ChartPie chartPie3 = new ChartPie("March", 300);
		ChartPie chartPie4 = new ChartPie("April", 400);
		ChartPie chartPie5 = new ChartPie("May", 500);
		list.add(chartPie1);
		list.add(chartPie2);
		list.add(chartPie3);
		list.add(chartPie4);
		list.add(chartPie5);

		return list;
	}
}
