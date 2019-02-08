package steps_defentions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.ValuesPage;
import utilities.Config;
import utilities.Driver;

public class Hooks {

    ValuesPage hp=new ValuesPage();
    
  
    @Before
    public void setUp(){
//    	Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		Driver.getDriver().manage().window().fullscreen();
//		Driver.getDriver().get(Config.getProperty("url"));

    }

	@After
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
			scenario.write("THIS SCENARIO FAILED");
		}
		Driver.closeDriver();
}
}
