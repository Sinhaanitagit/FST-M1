import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HRM_Activity_5 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void loginTest() {
        WebElement username = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.id("txtPassword"));
               
        username.sendKeys("orange");
        password.sendKeys("orangepassword123");
        
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        driver.findElement(By.id("btnLogin")).click();
                
        //String loginMessage = driver.findElement(By.id("welcome")).getText();
        //Assert.assertEquals("Welcome Chandra15", loginMessage);
        
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
               
        driver.findElement(By.id("btnSave")).click();
                
        WebElement Fname = driver.findElement(By.id("personal_txtEmpFirstName"));
        WebElement Lname = driver.findElement(By.id("personal_txtEmpLastName"));
        WebElement DOB = driver.findElement(By.id("personal_DOB"));
        
        Fname.sendKeys("Anita1");
        Lname.sendKeys("Sinha1");
        DOB.sendKeys("01/01/0001");
        
        driver.findElement(By.id("personal_optGender_1")).click();
        
        Select nationality = new Select(driver.findElement(By.name("personal[cmbNation]")));
        nationality.selectByVisibleText("Indian");
        
        driver.findElement(By.id("btnSave")).click();
        
        
    }

    @AfterClass
    public void afterClass() {
        driver.close();
   }
}
