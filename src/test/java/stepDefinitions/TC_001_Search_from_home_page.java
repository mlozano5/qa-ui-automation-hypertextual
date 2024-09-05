package stepDefinitions;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class TC_001_Search_from_home_page extends BaseTest {

    @Given("The user is on the home page {string}")
    public void the_user_is_on_the_home_page(String browserName) {
        beforeTest(browserName);
        homePage.driver.get("https://hipertextual.com/");
    }

    @When("The user searches for {string}")
    public void the_user_searches_for(String data) {
        homePage.clickSearchBtn();
        homePage.enterValueToSearch(data);
        Assert.assertEquals(homePage.currentUrl(),homePage.expectedUrl(data));
    }

    @And("The user scrolls to the first post about")
    public void the_user_scrolls_to_the_first_post_about() {
        homePage.scrollDown();
    }

    @Then("I expect the URL and some of the text on the page is correct {string}")
    public void i_expect_the_url_and_some_of_the_text_on_the_page_is_correct(String data) {
        homePage.searchForInformationInTheResults(data);
    }

}