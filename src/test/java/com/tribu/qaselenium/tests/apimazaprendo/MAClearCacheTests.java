package com.tribu.qaselenium.tests.apimazaprendo;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tribu.qaselenium.pages.mazaprendo.MAConfigurationP;
import com.tribu.qaselenium.pages.mazaprendo.MAHomeP;
import com.tribu.qaselenium.pages.mazaprendo.MALandingP;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;

@Listeners(TestsListenerManager.class)
public class MAClearCacheTests extends TestBase {

	@SuppressWarnings("unchecked")
	@Test(groups = { "smoke" })
	public void clearCacheDrupal(Method method, ITestContext testContext) {
		SoftAssert softAssert = new SoftAssert();
		
		// page variables
		MALandingP maLandingP;
		MAHomeP maHomeP;
		MAConfigurationP maConfigurationP;

		/* login */
		maLandingP = openUrl(MALandingP::new, 3000).get();
		maHomeP = maLandingP.login(readCredentials("admin"),softAssert);

		// remove from api drupal
		maConfigurationP = maHomeP.getMenuConfigurationButton().click(MAConfigurationP::new).get();
		maConfigurationP.getPerformance().click()
//						.getClearCache().click()
//						.getEmptyCacheAlert(e->e.getText().contains("vaciadas")).assess(softAssert::assertTrue)
						.exec(softAssert::assertAll);

		String downloadPath = System.getProperty("user.home") + File.separator + "Downloads";
		String homePath = System.getProperty("user.home");
		String workPath = System.getProperty("user.home") + File.separator + "work";
		String unoPath = System.getProperty("user.home") + File.separator + "work" + File.separator + "1";
		String sPath = System.getProperty("user.home") + File.separator + "work" + File.separator + "1"+ File.separator + "s";
		log.info("downloadPath : "  + System.getProperty("user.dir"));
		log.info("homePath : "  + System.getProperty("user.home"));
		
		File dir = new File(workPath);
		File[] dir_contents = dir.listFiles();
		for (int i = 0; i < dir_contents.length; i++) {
			log.info("resources path : "  + dir_contents[i].getName());
//			if (dir_contents[i].getName().contains(fileName))
//				return flag = true;
		}
		
		File dir1 = new File(unoPath);
		File[] dir_contents1 = dir.listFiles();
		for (int i = 0; i < dir_contents.length; i++) {
			log.info("resources path : "  + dir_contents[i].getName());
//			if (dir_contents[i].getName().contains(fileName))
//				return flag = true;
		}
		
		File dir2 = new File(sPath);
		File[] dir_contents2 = dir.listFiles();
		for (int i = 0; i < dir_contents.length; i++) {
			log.info("resources path : "  + dir_contents[i].getName());
//			if (dir_contents[i].getName().contains(fileName))
//				return flag = true;
		}
	}
}
