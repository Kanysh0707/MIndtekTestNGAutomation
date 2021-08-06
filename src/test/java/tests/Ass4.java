package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.LocalDateTime;

public class Ass4 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
    }

    @Test
    public void test1() {
        driver.get(ConfigReader.getProperty("BlazedemoURL"));
        driver.findElement(By.xpath("//select[@name='fromPort']")).sendKeys("San Diego");
        driver.findElement(By.xpath("//select[@name='toPort']")).sendKeys("New York" + Keys.ENTER);
        String actualPrice = driver.findElement(By.xpath("//div[2]/table/tbody/tr[4]/td[6]")).getText();
        driver.findElement(By.xpath("//div[2]/table/tbody/tr[4]/td[1]/input")).click();
        String expectedPrice = "400";
        Assert.assertEquals(actualPrice, expectedPrice);
    }
    @Test
    public void test2(){
        driver.get(ConfigReader.getProperty("BlazedemoURL"));
        driver.findElement(By.xpath("//select[@name='fromPort']")).sendKeys("San Diego");
        driver.findElement(By.xpath("//select[@name='toPort']")).sendKeys("New York" + Keys.ENTER);
        driver.findElement(By.xpath("//div[2]/table/tbody/tr[4]/td[1]/input")).click();
        driver.findElement(By.id("inputName")).sendKeys("John Doe");
        driver.findElement(By.id("address")).sendKeys("123 Washington ave.");
        driver.findElement(By.id("city")).sendKeys("New York");
        driver.findElement(By.id("state")).sendKeys("NY");
        driver.findElement(By.id("zipCode")).sendKeys("12345");
        driver.findElement(By.id("creditCardNumber")).sendKeys("1234567890");
        driver.findElement(By.id("creditCardMonth")).sendKeys("11");
        driver.findElement(By.id("creditCardYear")).sendKeys("2025");
        driver.findElement(By.id("nameOnCard")).sendKeys("John Doe");
        driver.findElement(By.xpath("//div[11]/div/input")).click();

        String expectedMessage="Thank you for your purchase today!";
        String actualMessage=driver.findElement(By.xpath("//div[2]/div/h1")).getText();
        Assert.assertEquals(actualMessage,expectedMessage);

//        String lastDigits=driver.findElement(By.xpath("//div/table/tbody/tr[4]/td[2]")).getText();
//        String providedCard="1111";
//        Assert.assertEquals(lastDigits,providedCard);
    }
    @Test
    public void test3(){
        driver.get(ConfigReader.getProperty("BlazedemoURL"));
        driver.findElement(By.xpath("//select[@name='fromPort']")).sendKeys("San Diego");
        driver.findElement(By.xpath("//select[@name='toPort']")).sendKeys("New York" + Keys.ENTER);
        driver.findElement(By.xpath("//div[2]/table/tbody/tr[4]/td[1]/input")).click();
        driver.findElement(By.id("inputName")).sendKeys("David Clark");
        driver.findElement(By.id("address")).sendKeys("123 Washington ave.");
        driver.findElement(By.id("city")).sendKeys("Austin");
        driver.findElement(By.id("state")).sendKeys("TX");
        driver.findElement(By.id("zipCode")).sendKeys("12345");
      //  driver.findElement(By.xpath("//label[@for='creditCardType']"));
        WebElement dropdown=driver.findElement(By.id("cardType"));
        Select select=new Select(dropdown);
        select.selectByValue("amex");
        driver.findElement(By.id("creditCardNumber")).sendKeys("mycreditnumber");
        driver.findElement(By.id("creditCardMonth")).sendKeys("11");
        driver.findElement(By.id("creditCardYear")).sendKeys("2025");
        driver.findElement(By.id("nameOnCard")).sendKeys("David Clark");
        driver.findElement(By.xpath("//div[2]/form/div[11]/div/input")).click();
       String expectedMessage="Invalid credit card number!";
        String actualMessage=driver.findElement(By.xpath("//div[2]/div/h1")).getText();
        Assert.assertEquals(actualMessage,expectedMessage);

    }

//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
}