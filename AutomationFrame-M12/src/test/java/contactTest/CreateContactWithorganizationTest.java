package contactTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import elementRepository.ContactPage;
import elementRepository.CreateInformation;
import elementRepository.CreatenewContact;
import elementRepository.HomePage;
import genericUtility.BaseClass;
import genericUtility.ExcelFileUtilitie;
import genericUtility.WebDriverUtility;
@Listeners(genericUtility.Listenerimplimentation.class)
// packAge one class Listenerimplimentation it will take a screen shot 
public class CreateContactWithorganizationTest extends BaseClass{
	
		@Test(groups="smoke")
		public void toCreatecontactOrgan_005() throws EncryptedDocumentException, IOException {
			HomePage hp = new HomePage(driver);
			hp.getContacts().click();

			ContactPage cp = new ContactPage(driver);
			cp.getClickcontactimage().click();
			
			
			CreatenewContact cnc = new CreatenewContact(driver);
		 	ExcelFileUtilitie eutil = new ExcelFileUtilitie();
			String LASTNAME = eutil.toReadDataFromExcelFile("Contacts", 1, 2);
			cnc.getCreatenewcontactlastname().sendKeys(LASTNAME);
			cnc.getOrganizationdropdownlookup().click();
			
			WebDriverUtility wutil = new WebDriverUtility();
			wutil.toSwitchwindow(driver, "Accounts");
			cnc.getOraganizatinNameclick().click();
	         wutil.toSwitchwindow(driver, "Contacts");
	         cnc.getTosaveclick().click();

			// step 6:
	         CreateInformation cif = new CreateInformation(driver);
	 		String lastname = cif.getCreateinfo().getText();
			

	 		CreateInformation cip = new CreateInformation(driver);
			String lastname1 = cip.getCreateinfo().getText();
			Assert.assertTrue(lastname1.contains(LASTNAME));
	}
		}
	

