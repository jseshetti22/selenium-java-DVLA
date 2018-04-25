package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class declares the page objects of "vehicle information query flow"
 *
 */

public class VehicleInformationPage {

	private WebDriver driver;
	private WebDriverWait wait;

	//@FindBy(css = ".button")
	@FindBy(xpath="html/body/div[5]/div[2]/main/div/div[1]/div/section[1]/p/a")
	public WebElement START_BUTTON;

	//@FindBy(css = "#Vrm")
	@FindBy(xpath="html/body/main/form/div/div/div[2]/fieldset/div/input")
	public WebElement QUERY_TEXTAREA;

	@FindBy(css = "button[name='Continue']")
	public WebElement QUERY_SUBMIT_BUTTON;

	@FindBy(css = ".heading-large")
	public WebElement VERIFICATION_QUESTION;

	@FindBy(xpath = "//*[@id=\"pr3\"]//li[2]//strong")
	public WebElement VEHICLE_MAKE;

	@FindBy(xpath = "//*[@id=\"pr3\"]//li[3]//strong")
	public WebElement VEHICLE_COLOUR;


	public VehicleInformationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}

	public void clickOnStartButton() {
		wait.until(ExpectedConditions.visibilityOf(START_BUTTON));
		START_BUTTON.click();
	}


	public void enterRegistrationNumber(String registrationNumber) {
		wait.until(ExpectedConditions.visibilityOf(QUERY_TEXTAREA));
		QUERY_TEXTAREA.sendKeys(registrationNumber);
	}

	public void submitRegistrationNumber() {
		wait.until(ExpectedConditions.visibilityOf(QUERY_SUBMIT_BUTTON));
		QUERY_SUBMIT_BUTTON.click();
	}


}
