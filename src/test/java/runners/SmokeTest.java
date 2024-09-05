package runners;

import base.BaseTest;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.awt.*;

@CucumberOptions(features = {"${cucumber.features}"},tags = "@SmokeTest",glue = "stepDefinitions", monochrome = true,plugin = {"json:target/cucumber.json","html:target/cucumber.html"})
public class SmokeTest extends AbstractTestNGCucumberTests{

    @BeforeClass
    public void beforeClass() throws AWTException {

    }

    @AfterTest
    public void afterTest() throws AWTException {
        BaseTest baseTest= new BaseTest();
        baseTest.afterTest();
    }

}
