package com.tribu.qaselenium.tests.apimazaprendo;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Objects;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tribu.qaselenium.pages.mazaprendo.MAContentListP;
import com.tribu.qaselenium.pages.mazaprendo.MAHomeP;
import com.tribu.qaselenium.pages.mazaprendo.MALandingP;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;
import com.tribu.qaselenium.tests.mazaprendo.data.TeacherCourseAssign;
import com.tribu.qaselenium.tests.mazaprendo.data.TeacherCourseAssignDAO;
import com.tribu.qaselenium.tests.mazaprendo.data.UserCourseAssign;
import com.tribu.qaselenium.tests.mazaprendo.data.UserCourseAssignDAO;
import com.tribu.qaselenium.tests.mazaprendo.data.UserLessonAssign;
import com.tribu.qaselenium.tests.mazaprendo.data.UserLessonAssignDAO;

@Listeners(TestsListenerManager.class)
public class MAPreconditionTests extends TestBase {

	@SuppressWarnings("unchecked")
	@Test(groups = { "smoke", "deleteContent" })
	public void preconditions(Method method) {
		SoftAssert softAssert = new SoftAssert();
		// page variables
		MALandingP maLandingP;
		MAHomeP maHomeP;
		MAContentListP maContentListP;
		
		String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "uploadFiles" + File.separator + "upload.xlsx";

		/* login */
		maLandingP = openUrl(MALandingP::new).get();
		maHomeP = maLandingP.login(readCredentials("admin"),softAssert);

		maContentListP = maHomeP.getMenuContentButton().click(MAContentListP::new).get();
		
		/* remove past courses in api drupal */
		maContentListP.getTitlefilterField().type(this.getCurrentYear())
					.getActionSelect().click()
					.getActionDeleteItem().click()
					.getActionSelect().click()
					.getFilterButton().click()
					.getEmptyMessage()
					.ifFoundOrElse(()->log.info("Not found elements to remove"),()->maContentListP.removeContent(softAssert))
					.exec(softAssert::assertAll);
					
		/* remove past courses assigned to the user */
		
		//teacher precondition
		TeacherCourseAssignDAO teacherCourseAssignDao = new TeacherCourseAssignDAO();
		TeacherCourseAssign teacherCourseCheckAssign = new TeacherCourseAssign("100000002");
		teacherCourseAssignDao.remove(teacherCourseCheckAssign);
		log.info("assigned courses to teacher 100000002 were removed");
		
		//users precondition
		UserCourseAssignDAO userCourseAssignDao = new UserCourseAssignDAO();
		UserLessonAssignDAO userLessonAssignDao = new UserLessonAssignDAO();
		
		try {
			xlsxReader(path).forEachRemaining((map) -> {
				if (map.get("sharp") != null) {
					UserCourseAssign userCourseCheckAssign = new UserCourseAssign(map.get("sharp"));
					userCourseAssignDao.remove(userCourseCheckAssign);
					log.info("User " + map.get("sharp") + " assigned courses were removed");

					UserLessonAssign userLessonCheckAssign = new UserLessonAssign(map.get("sharp"));
					userLessonAssignDao.remove(userLessonCheckAssign);
					log.info("User " + map.get("sharp") + " assigned lessons  were removed");
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		softAssert.assertAll();
	}
}
