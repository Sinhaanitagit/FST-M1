import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HRM_Activity_8 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void loginTest() throws InterruptedException {
        WebElement username = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.id("txtPassword"));
               
        username.sendKeys("orange");
        password.sendKeys("orangepassword123");
        
        driver.findElement(By.id("btnLogin")).click();
        
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        driver.findElement(By.xpath("//b[text()='Dashboard']")).click();
        driver.findElement(By.xpath("//span[text()='Apply Leave']")).click();
        
        Thread.sleep(1000);
        
        Select leaveType = new Select(driver.findElement(By.name("applyleave[txtLeaveType]")));
        leaveType.selectByVisibleText("Paid Leave");
        
        Thread.sleep(1000);
        
        WebElement fromDate = driver.findElement(By.id("applyleave_txtFromDate"));
        WebElement toDate = driver.findElement(By.id("applyleave_txtToDate"));
        
        driver.findElement(By.id("applyleave_txtFromDate")).clear();
        fromDate.sendKeys("2021-04-01");
        Thread.sleep(1000);
        
        driver.findElement(By.id("applyleave_txtToDate")).clear();
        toDate.sendKeys("2021-04-29");
        Thread.sleep(1000);
        
        driver.findElement(By.id("applyBtn")).click();
        Thread.sleep(1000);
        
        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
        Thread.sleep(1000);
        
        WebElement leaveFromDate = driver.findElement(By.id("calFromDate"));
        WebElement leaveToDate = driver.findElement(By.id("calToDate"));
        
        driver.findElement(By.id("calFromDate")).clear();
        leaveFromDate.sendKeys("2021-04-01");
        Thread.sleep(1000);
        
        driver.findElement(By.id("calToDate")).clear();
        leaveToDate.sendKeys("2021-04-29");
        Thread.sleep(1000);
        
        driver.findElement(By.id("btnSearch")).click();
        Thread.sleep(1000);
        
        String verifyLeaveStatus = driver.findElement(By.xpath("//a[text()='Pending Approval(0.50)']")).getText(); 
        Assert.assertEquals("Pending Approval(0.50)", verifyLeaveStatus);
        
        Thread.sleep(1000);
    }

    @AfterClass
    public void afterClass() {
        driver.close();
   }
}
