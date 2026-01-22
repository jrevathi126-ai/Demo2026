package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateInformationOrganization {
	
	public CreateInformationOrganization(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement createinfoorganisation;
	
	
	public WebElement getCreateinfoorganisation() {
		return createinfoorganisation;
		
	}
	}
