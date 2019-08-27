package com.atmecs.testscripts;

import com.atmecs.orangehrm.getdatafromexcelfile.ProvideData;

import org.testng.annotations.DataProvider;

public class DataProvider1 {
	@DataProvider(name = "data-provider")
	public Object[][] getData() {
		ProvideData provideData = new ProvideData();
		Object[][] getData = provideData.provideData();
		return getData;
	}
}
