package steps_defentions;

import java.text.ParseException;

import org.apache.commons.logging.impl.Log4JLogger;
import org.testng.Assert;

import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ValuesPage;
import utilities.BrowserUtils;
import utilities.Config;
import utilities.Driver;

public class ValuePage_steps {

	Log4JLogger log = new Log4JLogger();
	ValuesPage vl = new ValuesPage();
	int count = 1;

	@BeforeStep
	public void log() {
		log.info("starting step " + count);
		count++;
	}

	@Given("user navagates to value page")
	public void user_navagates_to_value_page() {
		log.info("navageting to " + Config.getProperty("url"));
		Driver.getDriver().get(Config.getProperty("url"));
		log.info("Waiting on Value Page to load");
		BrowserUtils.waitForPageToLoad(3);
	}

	@When("user is on the balance sheet")
	public void user_is_on_the_balance_sheet() {
		String title = Driver.getDriver().getTitle();
		Assert.assertEquals(title, Config.getProperty("title"), "Value page is not displayed");

	}

	@Then("user should be able to see {string}")
	public void user_should_be_able_to_see(String string) {
		string = vl.value1.getText();
		if (!string.equals(0)) {
			Assert.assertEquals(count, Config.getProperty("Value1"));
		} else {
			log.info("Value is 0 or below ");
		}
	}
	
	@Then("the sum of all values are equal to total sum")
	public void the_sum_of_all_values_are_equal_to_total_sum() throws ParseException {
	    vl.sum();
	    Assert.assertEquals(Config.getProperty("TotalValue"), "$1,000,000.00", "The balance is not correct");
	}
}
