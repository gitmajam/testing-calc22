package com.tribu.qaselenium.tests.negative;

import java.util.Map;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tribu.qaselenium.testframework.testbase.CsvDataProviders;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;

@Listeners(TestsListenerManager.class)
public class TestThreads extends TestBase {

	int variable1;
	int variable2;
	int variable3;

	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void test1(Map<String, String> testData) {
		SoftAssert softAssert = new SoftAssert();

		// Data
		String no = testData.get("no");
		String variable1 = testData.get("variable1");
		String variable2 = testData.get("variable2");
		String variable3 = testData.get("variable3");
	

		log.info("[" + this.hashCode() + "] variable 1 = " + variable1);
		log.info("[" + this.hashCode() + "] variable 2 = " + variable2);
		log.info("[" + this.hashCode() + "] variable 3 = " + variable3);

	}

}
