import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HRM_Activity_3 {
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
        
        driver.findElement(By.id("btnLogin")).click();
        
        //Read login message
        String loginMessage = driver.findElement(By.id("welcome")).getText();
        Assert.assertEquals("Welcome Chandra15", loginMessage);
    }

    @AfterClass
    public void afterClass() {
        driver.close();
   }
}