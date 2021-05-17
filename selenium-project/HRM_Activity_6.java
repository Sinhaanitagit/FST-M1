import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class HRM_Activity_6 {
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
                
        
        boolean directorybuttonPresence = driver.findElement(By.id("menu_directory_viewDirectory")).isDisplayed();
        boolean directorybuttoEnabled = driver.findElement(By.id("menu_directory_viewDirectory")).isEnabled();
        
        Assert.assertTrue(directorybuttonPresence);
        Assert.assertTrue(directorybuttoEnabled);
        
        driver.findElement(By.id("menu_directory_viewDirectory")).click();
        driver.findElement(By.id("menu_directory_viewDirectory")).click();
        
        String searchDir = driver.findElement(By.xpath("//h1[text()='Search Directory']")).getText();
        Assert.assertEquals("Search Directory", searchDir);
        
    }

    @AfterClass
    public void afterClass() {
        driver.close();
   }
}
