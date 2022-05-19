package com.tribu.qaselenium.tests.b22;

import java.lang.reflect.Method;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tribu.qaselenium.pages.b22.B22HomeP;
import com.tribu.qaselenium.pages.b22.B22LandingP;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;
import com.tribu.qaselenium.tests.data.InitiativesDAO;
import com.tribu.qaselenium.tests.data.PlanInitiativesDAO;
import com.tribu.qaselenium.tests.data.UploadInitiativesDAO;
import com.tribu.qaselenium.tests.data.UploadsDAO;




@Listeners(TestsListenerManager.class)
public class B22PreconditionTests extends TestBase {

	@Test(groups = { "smoke", "deleteContent" })
	public void preconditions(Method method) {
	
		UploadInitiativesDAO uploadInitiativesDao = new UploadInitiativesDAO();
		uploadInitiativesDao.remove();
		PlanInitiativesDAO planInitiativesDao = new PlanInitiativesDAO();
		planInitiativesDao.remove();
		InitiativesDAO initiativesDao = new InitiativesDAO();
		initiativesDao.remove();
		UploadsDAO uploadsDao = new UploadsDAO();
		uploadsDao.remove();
		
		log.info("initiatives were removed");
	}
}
