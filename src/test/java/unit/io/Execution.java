package unit.io;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Execution extends BaseClass {
	@BeforeClass
	public static void tc0()
	{
		Launcher("https://adactinhotelapp.com/");
	}
	@Before
	public void tc1()
	{
		//verfication point
		String title = driver.getTitle();
		boolean contains = title.contains("Adactin");
		Assert.assertTrue(contains);
		System.out.println("Title is verfied");
		System.out.println("login module");
		System.out.println("test1 data is entered");
		System.out.println("test1 data is verified");
	}
	@Test
	public void tc2() throws IOException
	{
		AsactinHomePage Homepage=new AsactinHomePage();
		WebElement username = Homepage.getUsername();
		String dataFromExcel = dataFromExcel(0, 0);
		enterText(username, dataFromExcel);
		WebElement password = Homepage.getPassword();
		String dataFromExcel2 = dataFromExcel(0, 1);
		enterText(password, dataFromExcel2);
		Homepage.getLogin().click();
		
	}
	@After
	public void tc3()
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("C:\\Users\\Dell\\Desktop\\Java driver files\\ScreenShort"));
	}
}
