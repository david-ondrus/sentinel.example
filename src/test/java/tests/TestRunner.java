package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.dougnoel.sentinel.configurations.Configuration;
import com.dougnoel.sentinel.webdrivers.WebDriverFactory;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true
	, features = "src/test/java/features"
	, glue = { "com.dougnoel.sentinel.steps", "steps" }
	, plugin = {"json:target/cucumber.json",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
	, strict = true
)

public class TestRunner {
    private static final Logger log = LogManager.getLogger(TestRunner.class); // Create a logger.

	@BeforeClass
	public static void setUpBeforeAnyTestsAreRun() {
		WebDriverFactory.instantiateWebDriver();
	}
	
    @AfterClass
    public static void tearDownAfterClass() {
        String totalWaitTime = Configuration.toString("totalWaitTime");
        if (totalWaitTime != null) {
        	log.warn("This test took {} total seconds longer due to explicit waits. Sentinel handles dynamic waits. If you have a reason for adding explicit waits, you should probably be logging a bug ticket to get the framework fixed at: http://https://github.com/dougnoel/sentinel/issues", totalWaitTime);
        }
    	log.info("Driver: {}", WebDriverFactory.getWebDriver());
        if (System.getProperty("leaveBrowserOpen", "false") == "false") {
        	WebDriverFactory.quit();
        }
    }
}