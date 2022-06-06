package bo.tic.www;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CheckOutPageTest {

	private RemoteWebDriver driver;
	E2EPages searchExperienceTodayPage;
	//ExperienceListPage experienceListPage;
	
	@Before
	public void setUp() throws Exception {
		
		searchExperienceTodayPage = new E2EPages(driver);
		driver = searchExperienceTodayPage.firefoxDriverConnection();
		searchExperienceTodayPage.get("https://www.viator.com/");
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void verifyCreditCardMandatoryCheckOutInputFields() throws InterruptedException {
		searchExperienceTodayPage.searchExperience("Barcelona");		
		searchExperienceTodayPage.chooseExperience();
		searchExperienceTodayPage.verifyCreditCardMandatoryCheckOutInputFields();
		assertTrue(true);
	}

}
