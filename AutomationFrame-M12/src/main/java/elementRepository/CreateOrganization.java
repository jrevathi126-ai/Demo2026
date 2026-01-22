 package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganization {
	public CreateOrganization(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="accountname")
	 private WebElement createnewOrganozation;
	
	@FindBy(name="industry")
	 private WebElement industryType;
	
	@FindBy(name="accounttype")
	 private WebElement accountType;
	
	 @FindBy(name="button")
	 private WebElement tosaveclick;

	public WebElement getCreatenewOrganozation() {
		return createnewOrganozation;
	}

	public WebElement getIndustryType() {
		return industryType;
	}

	public WebElement getAccountType() {
		return accountType;
	}

	public WebElement getTosaveclick() {
		return tosaveclick;
	}

	

}
