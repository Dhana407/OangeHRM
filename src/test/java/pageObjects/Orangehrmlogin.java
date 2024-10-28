package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Orangehrmlogin {
public 	WebDriver ldriver;
public  Orangehrmlogin(WebDriver rdriver) {
	ldriver=rdriver;
	PageFactory.initElements(rdriver,this);
	
}
     @FindBy(name="username")
     WebElement txtusername;
     
     @FindBy(name="password")
     WebElement txtpassword;
     
     @FindBy(xpath="//button[normalize-space()='Login']")
     WebElement loginbtn;
     
     public void setusername() {
    	 txtusername.sendKeys("Admin");
     }
     public void setPassword() {
    	 txtpassword.sendKeys("admin123");
     }
     public void clickonlogin() {
    	 loginbtn.click();
     }

}
