package com.SMPseleniumTesting.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * The Class CreateAccount.
 */
public class CreateAccount {
	
	/** The driver. */
	private WebDriver driver;
	
	/** The titulo pagina. */
	//Localizadores
    @FindBy(how = How.XPATH,using = "//h3")
    WebElement tituloPagina;
    
    /** The nombre. */
    @FindBy(how = How.NAME,using = "name")
    WebElement nombre;
    
    /** The apellidos. */
    @FindBy(how = How.NAME,using = "lastname")
    WebElement apellidos;
    
    /** The usuario. */
    @FindBy(how = How.NAME,using = "username")
    WebElement usuario;
    
    /** The pwd 1. */
    @FindBy(how = How.NAME,using = "password")
    WebElement pwd1;
    
    /** The pwd 2. */
    @FindBy(how = How.NAME,using = "password2")
    WebElement pwd2;
    
    /** The perfil. */
    @FindBy(how = How.XPATH,using = "//div[6]/select")
    WebElement perfil;
   
   /** The perfil option. */
   @FindBy(how = How.XPATH,using = "//div[6]/select/option[2]")
    WebElement perfilOption;
   
   /** The crear. */
   @FindBy(how = How.XPATH,using = "//button")
   WebElement crear;
    
    /**
     * Instantiates a new creates the account.
     *
     * @param driver the driver
     */
    public CreateAccount(WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
    
    /**
     * Fill form join.
     *
     * @param name the name
     * @param lastName the last name
     * @param username the username
     * @param password the password
     */
    public void fillFormJoin(String name,String lastName,String username,String password){

        sendText(nombre, name);
        sendText(apellidos, lastName);
        sendText(usuario, username);
        sendText(pwd1,password);
        sendText(pwd2,password);
        clickOnElement(perfil);
        clickOnElement(perfilOption);
        clickOnElement(crear);

    }
    
    /**
     * Click on element.
     *
     * @param element the element
     */
    //Metodo generico para dar clic a un elemento
    public void clickOnElement(WebElement element){
        element.click();
    }
    
    /**
     * Send text.
     *
     * @param element the element
     * @param text the text
     */
    //Metodo generico para enviar texto a los input
    public void sendText(WebElement element,String text){
        element.clear();
        element.sendKeys(text);
    }
    
    /**
     * Checks if is page opened.
     *
     * @param titulo the titulo
     * @return true, if is page opened
     */
    public boolean isPageOpened(String titulo){
        return tituloPagina.getText().contains(titulo);
    }
	
	

}
