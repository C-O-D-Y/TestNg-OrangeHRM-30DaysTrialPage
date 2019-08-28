package com.atmecs.testscripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.TestNGException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.atmecs.orangehrm.getdatafrompropertyfile.ReadFile;
import com.atmecs.testbase.ChooseWebDriver;


public class HomePageTesting extends ChooseWebDriver {

	ReadFile read = new ReadFile();

	@BeforeSuite
	public void setUp() throws IOException {
		System.out.println("Test Started");
	}

	@AfterSuite
	public void tearDown() {
		driver.close();
		System.out.println("Test End");
	}

	@Test(dataProvider = "data-provider", dataProviderClass = DataProvider1.class)
	public void testHome(String inputData, String inputData1, String inputData2, String inputData3, String inputData4,
			String inputData5) throws IOException {
		try {
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.findElement(By.id("cta_button_3749854_7956a89e-6f16-4650-8d49-9f825d5cc7d6")).click();
			driver.findElement(By.id(read.getLocater("first_name"))).click();
			driver.findElement(By.id(read.getLocater("first_name"))).sendKeys(inputData.toString());
			driver.findElement(By.id(read.getLocater("last_name"))).sendKeys(inputData1.toString());
			driver.findElement(By.id(read.getLocater("Bussiness_email"))).sendKeys(inputData2.toString());
			driver.findElement(By.id(read.getLocater("job_title"))).sendKeys(inputData3.toString());
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//a[@class='optanon-allow-all accept-cookies-button']")).click();
			driver.findElement(By.id(read.getLocater("no_of_employees"))).click();
			{
				WebElement dropdown = driver.findElement(By.id(read.getLocater("no_of_employees")));
				dropdown.findElement(By.xpath("//option[. = '401 - 450']")).click();
			}
			driver.findElement(By.id(read.getLocater("no_of_employees"))).click();
			driver.findElement(By.id(read.getLocater("company_name"))).click();
			driver.findElement(By.id(read.getLocater("company_name"))).sendKeys(inputData4.toString());
			driver.findElement(By.id(read.getLocater("industry"))).click();
			{
				WebElement dropdown = driver.findElement(By.id(read.getLocater("industry")));
				dropdown.findElement(By.xpath("//option[. = 'Computer / Technology - Services / Consultancy']"))
						.click();
			}
			driver.findElement(By.id(read.getLocater("industry"))).click();
			driver.findElement(By.id(read.getLocater("phone_no"))).click();
			driver.findElement(By.id(read.getLocater("phone_no"))).sendKeys(inputData5.toString());
			driver.findElement(By.id(read.getLocater("country"))).click();
			{
				WebElement dropdown = driver.findElement(By.id(read.getLocater("country")));
				dropdown.findElement(By.xpath("//option[. = 'India']")).click();
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				System.out.println("Time out");
				e.printStackTrace();
			}
			driver.findElement(By.id(read.getLocater("state"))).click();
			{
				WebElement dropdown = driver.findElement(By.id(read.getLocater("state")));
				dropdown.findElement(By.xpath("//option[. = 'Madhya Pradesh']")).click();
			}
			driver.findElement(By.id(read.getLocater("url"))).sendKeys("cody9897");
			driver.findElement(By.id(read.getLocater("submit"))).click();
			System.out.println("Test run");
			driver.quit();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("Time Out");
			}
		} catch (TestNGException Exception)

		{
			System.out.println("Exception handled");
		}
	}
}
