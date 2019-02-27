package com.SMPseleniumTesting.pom;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.SMPseleniumTesting.pom.users.User;

/**
 * The Class AltaUsuarios.
 */
public class RegisterUsers {

    /** The pathdriver. */
    private static String PATHDRIVER = "src/main/resources/drivers/";
    
    /** The base URL. */
    private static String baseURL = "localhost:4200/login";
    
    /** The driver. */
    static WebDriver driver;
    
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		setup();
		signUp();
		
	}
	
    /**
     * Setup.
     */
    public static void setup(){
        System.setProperty("webdriver.chrome.driver",PATHDRIVER+"chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
    }
    
    /**
     * Sign up.
     */
    public static void signUp(){
    	
        driver.get(baseURL);
                
        //Crear objeto de las clases Page
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CreateAccount crearCuenta = new CreateAccount(driver);
        //Hacemos clic en el enlace "Apply as a Freelancer"
        loginPage.login("victor.bedmarlam@plexus.es", "admin");

        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        homePage.clickAccount();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        homePage.clickCreate();

        if(crearCuenta.isPageOpened("Nueva cuenta")) {
        	System.out.println("Se ha abierto la pagina CREAR CUENTA");
        }

        List<User> lista = new ArrayList<User>();
        User user1 = new User("Mario1","Romo1","mario1@gmail.com","prueba1");
        User user2 = new User("Mario2","Romo2","mario2@gmail.com","prueba2");
        User user3 = new User("Mario3","Romo3","mario3@gmail.com","prueba3");
        User user4 = new User("Mario4","Romo4","mario4@gmail.com","prueba4");
        lista.add(user1);
        lista.add(user2);
        lista.add(user3);
        lista.add(user4);
        //Llenamos el formulario
        for(User usuario: lista) {
            crearCuenta.fillFormJoin(usuario.getNombre(),usuario.getApellidos(),usuario.getUsuario(), usuario.getPassword());
            waitForAlert(driver);

        }
        System.out.println("Proceso de alta completado correctamente");
        driver.close();
    }
    
    /**
     * Wait for alert.
     *
     * @param driver the driver
     */
    public static void waitForAlert(WebDriver driver)
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
