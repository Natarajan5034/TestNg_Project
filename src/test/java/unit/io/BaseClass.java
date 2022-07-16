package unit.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	static WebDriver driver;
	public static void Launcher(String Url)
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Url);
	}
	public static void enterText(WebElement element, String text)
	{
		element.sendKeys(text);
	}
	public static String dataFromExcel(int row, int cell) throws IOException
	{
		Workbook w=new XSSFWorkbook(new FileInputStream(new File("C:\\\\Users\\\\Dell\\\\eclipse-workspace\\\\Junit_7_7_22\\\\src\\\\test\\\\resources\\\\Test Data.xlsx")));
		return w.getSheet("Sheet2").getRow(row).getCell(cell).getStringCellValue();
	}
}
