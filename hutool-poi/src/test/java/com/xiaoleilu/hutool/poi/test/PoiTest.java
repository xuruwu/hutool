package com.xiaoleilu.hutool.poi.test;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import com.xiaoleilu.hutool.io.FileUtil;
import com.xiaoleilu.hutool.lang.Console;
import com.xiaoleilu.hutool.poi.excel.ExcelReader;

public class PoiTest {
	
	@Test
	@Ignore
	public void excelReadTest() {
		ExcelReader reader = new ExcelReader(FileUtil.getInputStream("d:/dwdm.xls"), 0);
		reader.setTrimCellValue(true);
		List<List<Object>> readAll = reader.read();
		for (List<Object> list : readAll) {
			Console.log(list.get(4));
		}
	}
	
	@Test
	@Ignore
	public void excelReadToMapListTest() {
		ExcelReader reader = new ExcelReader(FileUtil.getInputStream("d:/dwdm.xls"), 0);
		reader.addHeaderAlias("BH", "编号");
		List<Map<String,Object>> all = reader.readAll();
		for (Map<String, Object> map : all) {
			Console.log(map);
		}
	}
	
	@Test
	public void excelReadToBeanListTest() {
		ExcelReader reader = new ExcelReader(FileUtil.getInputStream("d:/dwdm.xls"), 0);
		reader.addHeaderAlias("BH", "bh");
		reader.addHeaderAlias("ZDZ", "dwmc");
		
		List<Dw> all = reader.readAll(Dw.class);
		for (Dw dw : all) {
			Console.log(dw);
		}
	}
	
	public static class Dw{
		private String bh;
		private String dwmc;
		public String getBh() {
			return bh;
		}
		public void setBh(String bh) {
			this.bh = bh;
		}
		public String getDwMc() {
			return dwmc;
		}
		public void setDwmc(String dwmc) {
			this.dwmc = dwmc;
		}
		
		@Override
		public String toString() {
			return "Dw [bh=" + bh + ", dwmc=" + dwmc + "]";
		}
	}
}
