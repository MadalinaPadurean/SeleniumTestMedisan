package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginTest {
    @Test
    public void loginAnAlreadyRegisteredUser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        System.out.println("Opened homepage.");
        WebElement accountBtn = driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[@class='label']"));
        accountBtn.click();

        WebElement loginLink = driver.findElement(By.xpath("//div[@class='links']//a[@title='Log In']"));
        loginLink.click();
        String valid_email = "madapadurean@yahoo.com";

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(valid_email);
        Thread.sleep(2500);

        WebElement password = driver.findElement(By.id("pass"));
        password.sendKeys("madalina");
        Thread.sleep(2500);
        WebElement loginButton = driver.findElement(By.xpath("//span[text() ='Login']"));
        loginButton.click();

        Thread.sleep(2500);

        WebElement contactInfo = driver.findElement(By.cssSelector(".box-content p"));
        String contactEmail = contactInfo.getText();

        assertThat("The contact info page does not display the correct e-mail adress",contactEmail,containsString(valid_email));

        Thread.sleep(2500);
//        driver.quit();
    }
    @Test
    public void loginWithAWrongEmail () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        System.out.println("Opened homepage.");
        WebElement accountBtn = driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[@class='label']"));
        accountBtn.click();
        WebElement loginLink = driver.findElement(By.xpath("//div[@class='links']//a[@title='Log In']"));
        loginLink.click();
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("test_email@yahoo.com");
        Thread.sleep(2500);
        WebElement password = driver.findElement(By.id("pass"));
        password.sendKeys("123456789");
        Thread.sleep(2500);
        WebElement loginButton = driver.findElement(By.xpath("//span[text() ='Login']"));
        loginButton.click();

        Thread.sleep(2500);

        WebElement errorMessageContainer = driver.findElement(By.cssSelector(".error-msg span"));
        String error_message = errorMessageContainer.getText();

        assertThat("The error message 'Invalid  login or password.' does not appear on the page!",error_message,
                containsString("Invalid login or password."));

        Thread.sleep(2500);

//        driver.quit();
    }
    @Test
    public void loginWithExistingEmailAndWrongPassword () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        WebElement accountBtn = driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[@class='label']"));
        accountBtn.click();
        WebElement loginLink = driver.findElement(By.xpath("//div[@class='links']//a[@title='Log In']"));
        loginLink.click();
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("madapadurean@yahoo.com");
        Thread.sleep(2500);
        WebElement password = driver.findElement(By.id("pass"));
        password.sendKeys("123456789");
        Thread.sleep(2500);
        WebElement loginButton = driver.findElement(By.xpath("//span[text() ='Login']"));
        loginButton.click();

        Thread.sleep(2500);

        WebElement errorMessageContainer = driver.findElement(By.cssSelector(".error-msg span"));
        String error_message = errorMessageContainer.getText();

        assertThat("The error message 'Invalid  login or password.' does not appear on the page!",error_message,
                containsString("Invalid login or password."));

        Thread.sleep(2500);

        driver.quit();

    }
    @Test
    public void logoutFromAnExistingAccount () throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        System.out.println("Opened homepage.");
        WebElement accountBtn = driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[@class='label']"));
        accountBtn.click();
        WebElement loginLink = driver.findElement(By.xpath("//div[@class='links']//a[@title='Log In']"));
        loginLink.click();
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("madapadurean@yahoo.com");
        Thread.sleep(1000);


        WebElement password = driver.findElement(By.id("pass"));
        password.sendKeys("madalina");
        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.xpath("//span[text() ='Login']"));
        loginButton.click();
        Thread.sleep(2500);
        WebElement accountBtn1 = driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[@class='label']"));
        accountBtn1.click();;

        Thread.sleep(1500);
        WebElement logoutLink = driver.findElement(By.xpath("//div[@class='links']//a[@title='Log Out']"));
        logoutLink.click();
        WebElement logoutMessageContainer = driver.findElement(By.cssSelector(".page-title h1"));
        String logout_confirmation_message = logoutMessageContainer.getText().toLowerCase();

        assertThat("The logout confirmation message is not properly displayed!",
                logout_confirmation_message,containsString("logged out"));

        Thread.sleep(5000);

        String homepage =driver.getCurrentUrl();


        driver.quit();
    }
    }

