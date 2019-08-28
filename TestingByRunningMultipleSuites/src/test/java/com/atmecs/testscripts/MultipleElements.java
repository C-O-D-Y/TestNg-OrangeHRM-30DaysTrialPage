package com.atmecs.testscripts;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.atmecs.testbase.ChooseWebDriver;

public class MultipleElements extends ChooseWebDriver {
	List<WebElement> webElements = new ArrayList<WebElement>();

	@Test
	public void getElements() throws FileNotFoundException {
		driver.get(prop.getProperty("url"));
		OutputStream out = new FileOutputStream("./src/test/java/com.atmecs.testdata/webelements.properties");
		Properties prop = new Properties();

		webElements = driver.findElements(By.xpath("//a"));
		try {
			for (int initial = 0; initial < webElements.size(); initial++) {
				String elements = webElements.get(initial).getText();
				String links = webElements.get(initial).getAttribute("href");
				Object ty = prop.setProperty(elements, links);
				try {
					prop.store(out, (String) ty);
				} catch (IOException e) {
					System.out.println("No links found");
				}
			}
		} catch (NullPointerException e) {
		}
	}
}
