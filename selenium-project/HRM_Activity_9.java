import java.util.List;
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

public class HRM_Activity_9 {
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
        
        driver.findElement(By.xpath("//b[text()='My Info']")).click();
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//a[text()='Emergency Contacts']")).click();
        Thread.sleep(1000);
        
        WebElement name = driver.findElement(By.xpath("//a[text()='Hira']"));
        String nameToDisplay = name.getText();
        WebElement relationship = driver.findElement(By.xpath("//td[text()='Brother']"));
        String relationshipToDisplay = relationship.getText();
        WebElement mobile = driver.findElement(By.xpath("//td[text()='9999997777']"));
        String mobileToDisplay = mobile.getText();
        
        System.out.println("Anchor tag text is: " + nameToDisplay);
        System.out.println("Anchor tag text is: " + relationshipToDisplay);
        System.out.println("Anchor tag text is: " + mobileToDisplay);
      
        //Use the th
        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        //Number of columns
        System.out.println(rows.size());

        //Use the td
        List<WebElement> cols = driver.findElements(By.xpath("//table/tbody/tr[1]/td"));
        //Number of columns
        System.out.println(cols.size());

        
        for(int i=1; i<=rows.size(); i++) {
            WebElement row = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]"));
            System.out.println("Row " + i + ": " + row.getText());
        }
        Thread.sleep(1000);
        	
        
        
        Thread.sleep(1000);
    }

    @AfterClass
    public void afterClass() {
        driver.close();
   }
}