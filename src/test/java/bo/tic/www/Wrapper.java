package bo.tic.www;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.Keys;

public class Wrapper {	

	private RemoteWebDriver driver;	
		
	public Wrapper(RemoteWebDriver driver) {		
		this.driver 	=driver;
		
	}
	
	public RemoteWebDriver firefoxDriverConnection() throws IOException {
		
		Properties props = new Properties();
		props.load(Wrapper.class.getClassLoader().getResourceAsStream("project.properties"));
		String url = props.getProperty("selenium-grid-url");
		
		DesiredCapabilities dr = DesiredCapabilities.firefox(); 
		
		dr.setBrowserName("firefox");
		dr.setPlatform(Platform.WINDOWS);
		
		driver=new RemoteWebDriver(new URL(url), dr);
			
		return driver;
		
	}
	
	
	
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);			
	}
	
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();			
	}
	
	
	public void type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);		
	}
	
	public void sendEnter(By locator) {
		driver.findElement(locator).sendKeys(Keys.ENTER);		
	}
	
	public void sendTab(By locator) {
		driver.findElement(locator).sendKeys(Keys.TAB);		
	}
	
	public void click (By locator) {
		driver.findElement(locator).click();
	}

	public void get (String url) throws InterruptedException {
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(500);
	}
	
	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		}
		catch (org.openqa.selenium.NoAlertPresentException e) {
			return false;
		}		
	}
	
		
	public void chooseTab (Integer n) {
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	    //switch to new tab
		driver.switchTo().window(newTb.get(n));
	}
	
	public void nextActiveElemet (int n) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			driver.switchTo().activeElement().sendKeys(Keys.TAB);
			Thread.sleep(500);
			}	
			}
	
	public void ClickActiveElemet () {		
			driver.switchTo().activeElement().click();
	}
	
	public void switchToIframe (String string) {		
		driver.switchTo().frame(string); //switching the frame by ID
}
	

	
}
