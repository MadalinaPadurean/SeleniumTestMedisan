package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class WishList {



    @Test
    public void logoutFromAnExistingAccount () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        System.out.println("Opened homepage.");
        WebElement accountBtn = driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[@class='label']"));
        accountBtn.click();
        WebElement loginLink = driver.findElement(By.xpath("//div[@class='links']//a[@title='Log In']"));
        loginLink.click();
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("madapadurean11@yahoo.com");
        Thread.sleep(1000);


        WebElement password = driver.findElement(By.id("pass"));
        password.sendKeys("123456");
        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.xpath("//span[text() ='Login']"));
        loginButton.click();
        Thread.sleep(2500);


        Thread.sleep(1500);

        Thread.sleep(5000);

        String homepage =driver.getCurrentUrl();


        driver.get("https://fasttrackit.org/selenium-test/");
        driver.findElement(By.linkText("SALE")).click();
        driver.findElement(By.linkText("VIEW DETAILS")).click();
        driver.findElement(By.linkText("Add to Wishlist")).click();
        WebElement accountBtn1 = driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[@class='label']"));
        accountBtn1.click();

//        WebElement successMessageContainer = driver.findElement(By.className("success-msg"));
//        assertThat("Login successuful and the discounted product was added.", successMessageContainer.getText(),
//                is("Hello , Madalina C Padurean and the product is in Wishlist."));

//        driver.quit();
    }
}
