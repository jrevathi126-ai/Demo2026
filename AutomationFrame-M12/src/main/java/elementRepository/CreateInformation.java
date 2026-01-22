package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateInformation {
	
	public CreateInformation(WebDriver driver) {
		PageFactory.initElements(driver,this);
		}
	@FindBy(xpath=("//span[@class='dvHeaderText']"))
	private WebElement createinfo;
	
	public WebElement getCreateinfo() {
		return createinfo;
	}
	

}
