package com.blankfactor.tech.pages;

import com.blankfactor.tech.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static final Logger log = Logger.getLogger(HomePage.class.getName());

    @FindBy (xpath = "//button[@id='search-toggle']")
    protected WebElement searchBtn;

    @FindBy (id ="search-form-2")
    protected WebElement searchField;

    @FindBy (id ="//main[@id='main']")

    protected List<WebElement> searchResult;

    Actions actions = new Actions(driver);

    public void clickSearchBtn (){
        log.info("\nClicking on the search button\n");
        actions.moveToElement(searchBtn).perform();
        waitUntilElementIsClickable(searchBtn);
    }

    public void enterValueToSearch (String data){
        log.info("\nEntering the value to search\n");
        waitUntilElementIsClickable(searchField);
        searchField.sendKeys(data + Keys.ENTER);
    }

    public void scrollDown() {
        log.info("\nScrolling down\n");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    public void waitUntilElementIsClickable(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
        } catch (TimeoutException e) {
            log.warning("Element not clickable after 10 seconds: " + webElement);
        }
    }

    public void searchForInformationInTheResults(String data) {
        log.info("\nSearching for data in the results\n");
        for (WebElement searchResult : searchResult) {
            if (searchResult.getText().equals(data)) { // Condition to find the element
                System.out.println("Item found: " + searchResult.getText());
                break;
            }
        }
    }

    public String currentUrl() {
        return driver.getCurrentUrl();
    }

    public String expectedUrl(String text) {
        String separateText = splitData(text);
        String uri = "https://hipertextual.com/?s=";
        return uri+separateText;
    }

    public String splitData(String text) {
        String[] words = text.split("\\s+");
        return String.join("+", words);
    }

}
