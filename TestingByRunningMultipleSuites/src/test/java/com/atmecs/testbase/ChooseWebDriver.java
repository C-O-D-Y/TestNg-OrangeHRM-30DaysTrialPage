package com.atmecs.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;

public class ChooseWebDriver {
	String browserName;
	String url;
	public static Properties prop;
	static public WebDriver driver;

	@BeforeMethod
	public void chooseWebDriver() {
		InputStream input = null;

		try {
			input = new FileInputStream("./src/test/java/com.atmecs.testdata/config.properties");
		} catch (FileNotFoundException e) {

			System.out.println("File not found");
		}

		prop = new Properties();

		// load a properties file
		try {
			prop.load(input);
		} catch (IOException e) {
			System.out.println("Property file not loaded");
		}
		browserName = prop.getProperty("browserName");

		switch (browserName) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "Firefox":
			System.setProperty("webdriver.gecko.driver", "./lib/geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		case "MicrosoftEdge":
			System.setProperty("webdriver.edge.driver", "./lib/msedgedriver.exe");
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("WebDriver not found");

		}

	}
}
