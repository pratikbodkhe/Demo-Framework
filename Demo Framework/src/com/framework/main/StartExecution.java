package com.framework.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.framework.commons.Constants;

public class StartExecution {
	// Instantiate Logger
	static Logger log = Logger.getLogger(StartExecution.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicConfigurator.configure();
		System.out.println(Constants.EXCEL_PATH);
		List<String> actions = new ArrayList<>();
		try {

			Workbook wb = new HSSFWorkbook(new FileInputStream(new File(
					Constants.EXCEL_PATH + "workbook.xls")));
			org.apache.poi.ss.usermodel.Sheet tcFlow = wb.getSheet("TcFlow");
			//int moduleCount = tcFlow.getLastRowNum();
			for (Row row : tcFlow) {
				actions.add(row.getCell(0).getStringCellValue());
			}
			wb.close();
		} catch (FileNotFoundException e) {
			log.error("TC Flow excel not found");
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.setProperty("webdriver.chrome.driver", "C:\\Impulse\\Data\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		for (String string : actions) {
			System.out.println(string);
			ProcessActions.execute(string,driver);
		}

	}

}
