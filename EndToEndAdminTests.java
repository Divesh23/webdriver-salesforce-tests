import java.time.Duration;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;

public class EndToEndAdminTests {
	
	//Xpaths for specific elements
	String xpathForNewRecord = "/html/body/div[4]/div[1]/section/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/ul/li[1]/a/div";
	String xpathForStartingDistance = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_distance_tracker__c___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section/div/div/div/slot/records-record-layout-row[3]/slot/records-record-layout-item[1]/div/span/slot/lightning-input/div/input";
	String xpathForEndingDistance = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_distance_tracker__c___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section/div/div/div/slot/records-record-layout-row[4]/slot/records-record-layout-item[1]/div/span/slot/lightning-input/div/input";
	String xpathForPlayerDetails = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_distance_tracker__c___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section/div/div/div/slot/records-record-layout-row[5]/slot/records-record-layout-item[1]/div/span/slot/records-record-layout-lookup/lightning-lookup/lightning-lookup-desktop/lightning-grouped-combobox/div/div/lightning-base-combobox/div/div[1]/input";
	String xpathForSaveRecord = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/records-form-footer/div/div/div/runtime_platform_actions-actions-ribbon/ul/li[3]/runtime_platform_actions-action-renderer/runtime_platform_actions-executor-lwc-headless/slot[1]/slot/lightning-button/button";
	String xpathForAssertRecord = "/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___flexipage__default_rec_-l___-distance_-tracker__c___-v-i-e-w/forcegenerated-flexipage_default_rec_l_distance_tracker__c__view_js/record_flexipage-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-template-desktop2/div/div[1]/slot/flexipage-component2/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_distance_tracker__c___012000000000000aaa___compact___view___recordlayout2/records-highlights2/div[1]/div/div[1]/div[2]/h1/slot/lightning-formatted-text";
	String xpathForPlayer = "/html/body/div[4]/div[1]/section/div[1]/div[1]/one-appnav/div/one-app-nav-bar/nav/div/one-app-nav-bar-item-root[2]";
	String xpathForNewPlayer = "/html/body/div[4]/div[1]/section/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/ul/li[1]/a/div";
	String xpathForNewPlayerDetails = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_player__c___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section/div/div/div/slot/records-record-layout-row/slot/records-record-layout-item[1]/div/span/slot/records-record-layout-base-input/lightning-input/div[1]/input";
	String xpathForSaveNewPlayer = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/records-form-footer/div/div/div/runtime_platform_actions-actions-ribbon/ul/li[3]/runtime_platform_actions-action-renderer/runtime_platform_actions-executor-lwc-headless/slot[1]/slot/lightning-button/button";
	String xpathForAssertPlayer = "/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___flexipage__default_rec_-l___-player__c___-v-i-e-w/forcegenerated-flexipage_default_rec_l_player__c__view_js/record_flexipage-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-template-desktop2/div/div[1]/slot/flexipage-component2/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_player__c___012000000000000aaa___compact___view___recordlayout2/records-highlights2/div[1]/div/div[1]/div[2]/h1/slot/lightning-formatted-text";
	String xpathForAssertDistance = "/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___flexipage__default_rec_-l___-distance_-tracker__c___-v-i-e-w/forcegenerated-flexipage_default_rec_l_distance_tracker__c__view_js/record_flexipage-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-template-desktop2/div/div[2]/div[1]/slot/flexipage-component2/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/flexipage-tab2[2]/slot/flexipage-component2/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_distance_tracker__c___012000000000000aaa___full___view___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/div/div/slot/records-record-layout-row[5]/slot/records-record-layout-item[1]/div/div/div[2]/span/slot[1]/records-formula-output/slot/lightning-formatted-number";
	String xpathForAppName = "/html/body/div[4]/div[1]/section/div[1]/div[1]/one-appnav/div/div/div/span/span"; 
	
	//Login information
	String email = "divesh.david+1@gmail.com";
	
	//Distance calculations and player information 
	String startingDistance = "100";
	String endingDistance = "120";
	String distanceCovered = String.valueOf(Integer.parseInt(endingDistance) - Integer.parseInt(startingDistance))+".0";
	String player = "Saliba";
	
	//Webdriver instantiation 
	WebDriver driver;
	
	//Explicit wait method
	public void waitForElement(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));	
	}
	
	//Test setup
	public void setUpTests() {
		System.setProperty("webdriver.chrome.driver", "/Users/Divesh/Documents/JAR/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://solufy-dev-ed.my.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	}
	
	//Login method
	public void login() throws InterruptedException {
		//For Demo
		Thread.sleep(4000);
		
		driver.findElement(By.name("username")).sendKeys(email);
		driver.findElement(By.name("pw")).sendKeys(password);
		driver.findElement(By.name("Login")).click();
		
		waitForElement(xpathForAppName);
	}
	
	//Getting the app name
	public String getAppName() {
		String appName = driver.findElement(By.xpath(xpathForAppName)).getText();
		
		if(appName.equals("Sprint Tracker")) {
			System.out.println("User has permissions to view this App");
		}
		else {
			System.out.println("User does not have permissions to view this App!");
		}
		return appName;
	}
	
	//Creating a new record
	public void createNewRecord() throws InterruptedException {
		//Clicking on the new record button
		driver.findElement(By.xpath(xpathForNewRecord)).click();
		
		//For Demo
		Thread.sleep(4000);

		//Entering starting distance information
		waitForElement(xpathForStartingDistance);
		driver.findElement(By.xpath(xpathForStartingDistance)).sendKeys(startingDistance);

		//Entering ending distance information
		waitForElement(xpathForEndingDistance);
		driver.findElement(By.xpath(xpathForEndingDistance)).sendKeys(endingDistance);
		
		//Adding the player
		waitForElement(xpathForPlayerDetails);
		driver.findElement(By.xpath(xpathForPlayerDetails)).sendKeys(player);
		Thread.sleep(4000);
		waitForElement(xpathForPlayerDetails);
		driver.findElement(By.xpath(xpathForPlayerDetails)).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath(xpathForPlayerDetails)).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(xpathForSaveRecord)).click();
		
		//Assertion for added record and auto generated ID
		waitForElement(xpathForAssertRecord);
		String actualId = driver.findElement(By.xpath(xpathForAssertRecord)).getText();
		Assert.isTrue(actualId.contains("D-"), "Auto-generated ID is invalid.");
		
		//Assertion for distance calculation
		String actualDistance = driver.findElement(By.xpath(xpathForAssertDistance)).getText();
		Assert.isTrue(actualDistance.equals(distanceCovered),"Distance Covered is calculated wrong.");
	}
	
	//Random name generating function
	public String generateRandomName() {
		String chars = "abcdefghijklmnopqrstuvwxyz";
				Random rnd = new Random();
				StringBuilder sb = new StringBuilder(10);
				int max = 10;
				int min = 4;
				int len = (int)Math.floor(Math.random()*(max-min+1)+min);
				for (int i = 0; i < len; i++)
					sb.append(chars.charAt(rnd.nextInt(chars.length())));
				return sb.toString();
	}
	
	//Creating a new player
	public void createPlayer() throws InterruptedException {
		//For Demo
		Thread.sleep(4000);
				
		//Generating name for the player
		String firstName = generateRandomName();
		firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
		String lastName = generateRandomName();
		lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1);
		
		//Clicking on player tab
		waitForElement(xpathForPlayer);
		driver.findElement(By.xpath(xpathForPlayer)).click();
		
		//For Demo
		Thread.sleep(4000);
		
		//Clicking on new player button
		waitForElement(xpathForNewPlayer);
		driver.findElement(By.xpath(xpathForNewPlayer)).click();
		
		//Adding player details
		waitForElement(xpathForNewPlayerDetails);
		driver.findElement(By.xpath(xpathForNewPlayerDetails)).sendKeys(firstName + ' ' +lastName);
		
		//Clicking on save
		waitForElement(xpathForSaveNewPlayer);
		driver.findElement(By.xpath(xpathForSaveNewPlayer)).click();
		
		//For Demo
		Thread.sleep(4000);
		
		//Assertion for name added
		waitForElement(xpathForAssertPlayer);
		String expectedName = driver.findElement(By.xpath(xpathForAssertPlayer)).getText();
		Assert.isTrue(expectedName.contains(firstName),"First name is not displayed correctly");
		Assert.isTrue(expectedName.contains(lastName),"Last name is not dispalyed correctly");
	}
	
	//Cleaning up the test
	public void cleanupTests() {
		System.out.println("Test completed successfully!");
		driver.close();
	}
	
	public static void main(String[] args) throws Exception {
		EndToEndAdminTests obj = new EndToEndAdminTests();
		obj.setUpTests();
		obj.login();
		if (obj.getAppName().equals("Sprint Tracker")) {
			obj.createNewRecord();
			obj.createPlayer();
		}
		obj.cleanupTests();
	}
}
