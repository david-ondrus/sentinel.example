package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.dougnoel.sentinel.exceptions.SentinelException;
import com.dougnoel.sentinel.webdrivers.WebDriverFactory;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true
	, features = "src/test/java/features"
	, glue = { "stepdefinitions", "com.dougnoel.sentinel.steps", "steps" }
	, plugin = {"json:target/cucumber.json",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
	, strict = true
)

public class TestRunner {
    private static final Logger log = LogManager.getLogger(TestRunner.class); // Create a logger.
    
    @BeforeClass
    public static void setUpBeforeClass() throws IOException, SentinelException {
        WebDriverFactory.instantiateWebDriver();
    }

    @AfterClass
    public static void tearDownAfterClass() throws SentinelException {
        log.info("Driver: {}", WebDriverFactory.getWebDriver());
        if (System.getProperty("leaveBrowserOpen", "false") == "false") {
        	WebDriverFactory.quit();
        }
    }
}