package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Orangehrmlogin;

public class Steps {
	public WebDriver driver;
	public Orangehrmlogin lp;
	public Properties configprop;
	@Before
	public void setup() throws IOException{
		
		
		//Reading properties file
		configprop=new Properties();
		FileInputStream configpropfile= new FileInputStream("config.properties");
        configprop.load(configpropfile);
        
		String  br=configprop.getProperty("browser");
		
		if(br.equals("chrome")) {
		//System.setProperty("webdriver.chrome.driver",configprop.getProperty("chromepath"));
	    driver=new ChromeDriver();
	    }
		else if(br.equals("ie")) {
			System.setProperty("webdriver.ie.driver",configprop.getProperty("iepath"));
		    driver=new InternetExplorerDriver();
		    }
	    
	
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().window().maximize();
	}

	@Given("open browser")
	public void open_browser() {
		//System.setProperty("webdriver.vhrome.driver","D:/DHANAS/SeleniumCucumber/Drivers/chromedriver.exe");
	   // driver=new ChromeDriver();
	  //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  //  driver.manage().window().maximize();
	}

	@When("enter the url of the OrangeHRM")
	public void enter_the_url_of_the_orange_hrm() {
	   driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Then("homepage is displayed")
	public void homepage_is_displayed() {
	boolean status= driver.findElement(By.className("orangehrm-login-logo")).isDisplayed();
	System.out.println(status);
	
	}
	@When("enter the username and password")
	public void enter_the_username_and_password() {
	    lp=new Orangehrmlogin(driver);
	    lp.setusername();
	    lp.setPassword();
	}

	@And("click on login")
	public void click_on_login() {
	    lp.clickonlogin();
	}

	@Then("dashboard will displayed")
	public void dashboard_will_displayed() {
	    driver.getPageSource().contains("Dashboard");
	    
	}


	@And("close browser")
	public void close_browser() {
	    driver.quit();
	}
}
