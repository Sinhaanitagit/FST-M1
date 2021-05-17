import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HRM_Activity_2 {
    WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void exampleTestCase() {
        //String url = driver.findElement(By.id("divLogo")).getAttribute("src");
        //String url = driver.findElement(By.xpath("//div[@id=’divLogo’]/img")).getAttribute("src");
        //System.out.println("OrangeHRM Image url is: " + url);
        
        WebElement l =driver.findElement(By.xpath("//div[@id='divLogo']/img"));
        System.out.println("Src attribute is: "+ l.getAttribute("src"));
        
    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}