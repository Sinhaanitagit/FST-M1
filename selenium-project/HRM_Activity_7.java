import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HRM_Activity_7 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void loginTest() {
        WebElement username = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.id("txtPassword"));
               
        username.sendKeys("orange");
        password.sendKeys("orangepassword123");
        
        driver.findElement(By.id("btnLogin")).click();
        
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        driver.findElement(By.xpath("//b[text()='My Info']")).click();
        driver.findElement(By.xpath("(//a[text()='Qualifications'])[2]")).click();
        driver.findElement(By.id("addWorkExperience")).click();
        
        WebElement companyName = driver.findElement(By.id("experience_employer"));
        WebElement jobTitle = driver.findElement(By.id("experience_jobtitle"));
        WebElement fromDate = driver.findElement(By.id("experience_from_date"));
        WebElement toDate = driver.findElement(By.id("experience_to_date"));
        WebElement comment = driver.findElement(By.id("experience_comments"));
        
        companyName.sendKeys("orange");
        jobTitle.sendKeys("HR");
        fromDate.sendKeys("2020-04-01");
        toDate.sendKeys("2021-04-29");
        comment.sendKeys("Comment");
        
        
        driver.findElement(By.id("btnWorkExpSave")).click();
    }

    @AfterClass
    public void afterClass() {
        driver.close();
   }
}
