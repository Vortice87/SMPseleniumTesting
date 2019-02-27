package com.SMPseleniumTesting.pom;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * The Class HomePage.
 */
public class HomePage {

	/** The driver. */
	private WebDriver driver;

	/** The account. */
	@FindBy(how = How.XPATH, using = "//*[@id=\"menu-content\"]/li[1]/a/span[1]")
	WebElement account;

	/**
	 * Instantiates a new home page.
	 *
	 * @param driver
	 *            the driver
	 */
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Click account.
	 */
	public void clickAccount() {
		account.click();
		waitForLoadPAge(driver);
	}

	/**
	 * Click create.
	 */
	public void clickCreate() {

		List<WebElement> allLinks = driver.findElements(By.xpath("//*[@id='menu-content']/ul[1]/li"));

		for (WebElement element : allLinks) {
			if(element.getText().equals("Crear cuentas"))
				element.click();
		}

	}
	
    /**
     * Wait for load P age.
     *
     * @param driver the driver
     */
    public static void waitForLoadPAge(WebDriver driver)
    {
    	   int i=0;
    	   while(i++<5)
    	   {
    	        try
    	        {
    	            Alert alert = driver.switchTo().alert();
    	            break;
    	        }
    	        catch(NoAlertPresentException e)
    	        {
    	          try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
    	          continue;
    	        }
    	   }
    	}

}
