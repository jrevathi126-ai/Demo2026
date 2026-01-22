package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatenewContact {
	public CreatenewContact(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
		 @FindBy(name="lastname")
		 private WebElement createnewcontactlastname;
		 
		 @FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
		  private WebElement organizationdropdownlookup;
		 
		 @FindBy(linkText="jspider")
		 private WebElement oraganizatinNameclick;
		//save
		 @FindBy(name="button")
		 private WebElement tosaveclick;
		
		public WebElement getTosaveclick() {
			return tosaveclick;
		}
		public WebElement getOrganizationdropdownlookup() {
			return organizationdropdownlookup;
		}
		public WebElement getCreatenewcontactlastname() {
			return createnewcontactlastname;
		}
		public WebElement getOraganizatinNameclick() {
			return oraganizatinNameclick;
		}
		 
	}


