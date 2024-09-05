package com.blankfactor.tech.pages;

import com.blankfactor.tech.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;
import java.util.logging.Logger;

public class NewsletterPage extends BasePage {

    public NewsletterPage(WebDriver driver) {
        super(driver);
    }

    public static final Logger log = Logger.getLogger(HomePage.class.getName());

    @FindBy(xpath = "//ul[@id='menu-header-1']//a[normalize-space()='Newsletter']")
    protected WebElement newsletterTab;

    @FindBy(xpath = "//iframe[@class='perfmatters-lazy entered pmloaded']")
    protected WebElement iFrame;

    @FindBy(xpath = "//input[@class=\"pencraft _emailInput_11q5m_23\"=\"example\"]")
    protected WebElement emailField;

    @FindBy(xpath = "//button[@class=\"button rightButton primary subscribe-btn _button_11q5m_76\"=\"example\"]")
    protected WebElement subscribeBtn;

    @FindBy(xpath = "//div[@class=\"email-confirmation-screen\"=\"example\"]")
    protected WebElement confirmMsg;

    @FindBy(xpath = "//button[contains(text(), \"Promete una suscripción\")]")
    protected WebElement promiseSubBtn;

    Actions actions = new Actions(driver);

    public void waitUntilElementIsClickable(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
        } catch (TimeoutException e) {
            log.warning("Element not clickable after 10 seconds: " + webElement);
        }
    }

    public void waitUntilFrameToBeAvailableAndSwitchToIt(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(webElement));
        } catch (TimeoutException e) {
            log.warning("Element not clickable after 10 seconds: " + webElement);
        }
    }

    public void waitUntilAlertIsPresent(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.alertIsPresent());
        } catch (TimeoutException e) {
            log.warning("Element not clickable after 10 seconds: " );
        }
    }

    public void waitUntilVisibilityOf(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(webElement));
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (TimeoutException e) {
            log.warning("Element not clickable after 10 seconds: " + webElement);
        }
    }

    public void switchToIframe (){
        log.info("\nSwitch to iFrame\n");
        waitUntilFrameToBeAvailableAndSwitchToIt(iFrame);
        String email=randomEmailGenerator();
        enterEmail(email);
        clickSubscribeBtn();
        log.info("\nExiting the iFrame\n");
        driver.switchTo().defaultContent();
    }

    public void enterEmail(String email){
        waitUntilElementIsClickable(emailField);
        emailField.sendKeys(email);
    }

    public void clickSubscribeBtn(){
        waitUntilElementIsClickable(subscribeBtn);
    }

    public void clickNewsletterTab(){
        waitUntilElementIsClickable(newsletterTab);
    }

    public String randomEmailGenerator() {
        String[] emailProviders = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com"};
        Random random = new Random();
        StringBuilder randomString = new StringBuilder("testauto");
        for (int i = 0; i < 4; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            randomString.append(c);
        }
        return randomString + "@" + emailProviders[random.nextInt(emailProviders.length)];
    }

    public void scrollDown() {
        log.info("\nScrolling down\n");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    public boolean isAlertPresent() {
        try {
            waitUntilAlertIsPresent();
            log.info("\nThe alert is present\n");
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void handleAlert() {
        if (isAlertPresent()) {
            log.info("\nSwitch to alert\n");
            Alert alert = driver.switchTo().alert();
            log.info("\nClosing the alert\n");
            alert.accept();
            switchToNewWindow();
        }else {
            log.info("\nThe alert is not present\n");
            switchToNewWindow();
        }
    }

    public void switchToNewWindow() {
        log.info("\nSwitch to new window\n");
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }

    public String confirm() {
        try {
            Thread.sleep(2000);
            clickSubscribeBtn();

            if (isAlertPresent()) {
                handleAlert();
                getConfirmSubscribeMsg();
            }else {
                getConfirmSubscribeMsg();
            }

        } catch (NoSuchElementException e) {
            System.err.println("Element not found: " + e.getMessage());
        } catch (TimeoutException | InterruptedException e) {
            System.err.println("The confirmation element wait has expired: " + e.getMessage());
        }

        return getConfirmSubscribeMsg();
    }

    public String getConfirmSubscribeMsg(){
        log.info("\nConfirm\n");
        String confirmText = "";
        String promiseText = "";

        waitUntilVisibilityOf(confirmMsg);

        if (confirmMsg.isDisplayed()){
            confirmText = confirmMsg.getText();
        }else {
            waitUntilVisibilityOf(promiseSubBtn);
            promiseText = promiseSubBtn.getText();
            confirmText = promiseText;
        }
        return confirmText;
    }

}
