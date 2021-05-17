import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HRM_Activity_4 {
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
        
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
               
        driver.findElement(By.id("btnAdd")).click();
                
        WebElement Fname = driver.findElement(By.id("firstName"));
        WebElement Lname = driver.findElement(By.id("lastName"));
        
        Fname.sendKeys("Anita1");
        Lname.sendKeys("Sinha1");
        
        
        driver.findElement(By.id("btnSave")).click();
        
        
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
        
        
        WebElement empname = driver.findElement(By.id("empsearch_employee_name_empName"));
        empname.sendKeys("Anita1 Sinha1");
        
        
        driver.findElement(By.id("searchBtn")).click();
        
        
        //selenium.FindElement(By.XPath("xpath=//a[contains(@href,'/orangehrm/symfony/web/index.php/pim/viewEmployee/empNumber/2416')")).Click()
        
        String verifyEmpFname = driver.findElement(By.xpath("//a[text()='Anita1']")).getText(); 
        Assert.assertEquals("Anita1", verifyEmpFname);
           
        
    }

    @AfterClass
    public void afterClass() {
        driver.close();
   }
}
