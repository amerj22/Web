package pages;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Config;
import utilities.Driver;

public class ValuesPage {

	//4352345235
	private WebDriver driver = Driver.getDriver();

	public ValuesPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "lbl_val_1")
	public WebElement value1;

	@FindBy(id = "lbl_val_2")
	public WebElement value2;

	@FindBy(id = "lbl_val_3")
	public WebElement value3;

	@FindBy(id = "lbl_val_4")
	public WebElement value4;

	@FindBy(id = "lbl_val_5")
	public WebElement value5;

	@FindBy(id = "lbl_ttl_val")
	public WebElement totalValue;

	public void sum() throws ParseException {

		List<Double> value = new ArrayList<>();
		List<String> values = new ArrayList<>();
		values.add(Config.getProperty(("Value1")));
		values.add(Config.getProperty("Value2"));
		values.add(Config.getProperty("Value3"));
		values.add(Config.getProperty("Value4"));
		values.add(Config.getProperty("Value5"));

		double num;
		String str = "";
		Double sum = 0.00;
		for (String s : values) {
			str = s.replaceAll("[$,]", "");

			num = Double.parseDouble(str);
			value.add(num);
			System.out.println(num);
			sum = sum + num;

		}
		DecimalFormat formatter = new DecimalFormat("#0.00");
		System.out.println(formatter.format(sum));

	}

}
