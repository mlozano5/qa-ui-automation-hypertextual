package stepDefinitions;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TC_002_Subscribe_to_the_newsletter extends BaseTest {

    @Given("The user opens the home page {string}")
    public void the_user_opens_the_home_page(String browserName) {
        beforeTest(browserName);
        newsletterPage.driver.get("https://hipertextual.com/");
    }

    @When("I enter a valid email address in the newsletter subscription field")
    public void i_enter_a_valid_email_address_in_the_newsletter_subscription_field() {
        newsletterPage.clickNewsletterTab();
        newsletterPage.scrollDown();
        newsletterPage.switchToIframe();
    }

    @Then("I expect to see a confirmation message indicating that the subscription was successful")
    public void i_expect_to_see_a_confirmation_message_indicating_that_the_subscription_was_successful() {
        newsletterPage.handleAlert();
        Assert.assertTrue(
                newsletterPage.confirm().contains("Confirma tu dirección de correo electrónico") ||
                        newsletterPage.confirm().contains("Promete una suscripción")
                ,"The subscription was not successful");
    }

}
