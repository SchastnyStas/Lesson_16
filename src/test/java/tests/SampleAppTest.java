package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleAppTest {

    @Test
    public void checkUserRegistration() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.uitestingplayground.com/sampleapp");
        driver.findElement(By.name("UserName")).sendKeys("Cheburaska");
        driver.findElement(By.name("Password")).sendKeys("pwd");
        driver.findElement(By.xpath("//*[@class=\"btn btn-primary\"]")).click();

        String expectedResult = "Welcome, Cheburaska!";
        String actualResult = driver.findElement(By.xpath("//*[@id=\"loginstatus\"]")).getText();
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();
    }
}
