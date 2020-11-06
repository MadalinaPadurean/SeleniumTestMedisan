package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.SecureRandom;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegisterTest {


    @Test
    public void addNewUserFromRegister() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        System.out.println("Opened homepage.");
        WebElement accountBtn = driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[@class='label']"));
        accountBtn.click();

        Thread.sleep(1000);

        WebElement registerBtn = driver.findElement(By.xpath("//div[@class='links']//a[@title='Register']"));
        registerBtn.click();
        Thread.sleep(1000);

        String first_name = "Madalina";
        WebElement firstName = driver.findElement(By.id("firstname"));
        firstName.sendKeys(first_name);
        Thread.sleep(1000);

        String middle_name = "C";
        WebElement middleName = driver.findElement(By.id("middlename"));
        middleName.sendKeys(middle_name);
        Thread.sleep(1000);

        String last_name = "Padurean";
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys(last_name);
        Thread.sleep(1000);

        final String uniqueEmail = generateUniqueEmail();

        WebElement email = driver.findElement(By.className("validate-email"));
        email.sendKeys(uniqueEmail);
        Thread.sleep(1000);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123456");
        Thread.sleep(1000);

        WebElement confirmPasword = driver.findElement(By.name("confirmation"));
        confirmPasword.sendKeys("123456");
        Thread.sleep(1000);

        WebElement signUpForNewsletter = driver.findElement(By.className("checkbox"));
        signUpForNewsletter.click();
        Thread.sleep(2500);
        WebElement register = driver.findElement(By.xpath("//div[@class='buttons-set']//button[@title='Register']"));
        register.click();
        Thread.sleep(1500);

        WebElement successMsgContainer = driver.findElement(By.cssSelector(".success-msg span"));
        String successMessage = successMsgContainer.getText();

        assertThat("Missing succes message on the registration page!",
                successMessage, containsString("Thank you for registering with Madison Island."));

        WebElement wellcomeMsgContainer = driver.findElement(By.cssSelector(".welcome-msg "));
        String wellcomeMsg = wellcomeMsgContainer.getText();

        assertThat("Missing wellcome message on the top of the page containing the name of the user. ",
                wellcomeMsg,
                containsString(first_name.toUpperCase() + " " + middle_name.toUpperCase() + " " + last_name.toUpperCase()));
        Thread.sleep(1000);
        driver.quit();
    }

    private static String generateUniqueEmail() {
        final String AB = "1";
        SecureRandom rnd = new SecureRandom();

        int len = 1;
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));


        return "madapadurean" + sb.toString() + "@email.com";

    }

        @Test
    public void addUserWithExistingEmail() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        System.out.println("Opened homepage.");
        WebElement accountBtn = driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[@class='label']"));
        accountBtn.click();
        WebElement registerBtn = driver.findElement(By.xpath("//div[@class='links']//a[@title='Register']"));
        registerBtn.click();
        WebElement firstName = driver.findElement(By.id("firstname"));
        firstName.sendKeys("alina");
        Thread.sleep(1000);

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("marina");
        Thread.sleep(1000);

        WebElement email = driver.findElement(By.className("validate-email"));
        email.sendKeys("madapadurean11@yahoo.com");
        Thread.sleep(1000);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123456");
        Thread.sleep(1000);

        WebElement confirmPasword = driver.findElement(By.name("confirmation"));
        confirmPasword.sendKeys("123456");

        WebElement signUpForNewsletter = driver.findElement(By.className("checkbox"));
        signUpForNewsletter.click();
        Thread.sleep(1000);

        WebElement register = driver.findElement(By.xpath("//div[@class='buttons-set']//button[@title='Register']"));
        register.click();
        Thread.sleep(1000);

        WebElement errorMsgContainer = driver.findElement(By.cssSelector(".error-msg span"));
        String errorMessage = errorMsgContainer.getText();

        assertThat("There is no error message on page stating another account has the same email adress!",
                errorMessage, containsString("There is already an account with this email address."));

        Thread.sleep(3000);
        driver.quit();


    }
    @Test
    public void addUserWithoutFirstName() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        System.out.println("Opened homepage.");
        WebElement accountBtn = driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[@class='label']"));
        accountBtn.click();

        Thread.sleep(1000);

        WebElement registerBtn = driver.findElement(By.xpath("//div[@class='links']//a[@title='Register']"));
        registerBtn.click();
        Thread.sleep(1000);
        WebElement firstName = driver.findElement(By.id("firstname"));
        firstName.sendKeys("");

        WebElement middleName = driver.findElement(By.id("middlename"));
        middleName.sendKeys("lavinia ");
        Thread.sleep(1000);

        WebElement email = driver.findElement(By.className("validate-email"));
        email.sendKeys("martin@yahoo.com");
        Thread.sleep(1000);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123456");
        WebElement confirmPasword = driver.findElement(By.name("confirmation"));
        confirmPasword.sendKeys("123456");
        Thread.sleep(1000);

        WebElement signUpForNewsletter = driver.findElement(By.className("checkbox"));
        signUpForNewsletter.click();
        Thread.sleep(1000);

        WebElement register = driver.findElement(By.xpath("//div[@class='buttons-set']//button[@title='Register']"));
        register.click();
        Thread.sleep(1000);

        WebElement adviceContainer = driver.findElement(By.cssSelector(".validation-advice"));
        String validation_advice = adviceContainer.getText();

        assertThat("The validation advice for missing firstname is not present on page!",
                validation_advice, containsString("This is a required field."));

        driver.quit();
    }
    @Test
    public void addUserWithoutEmail() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        System.out.println("Opened homepage.");
        WebElement accountBtn = driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[@class='label']"));
        accountBtn.click();

        Thread.sleep(1000);

        WebElement registerBtn = driver.findElement(By.xpath("//div[@class='links']//a[@title='Register']"));
        registerBtn.click();
        Thread.sleep(1000);

        WebElement firstName = driver.findElement(By.id("firstname"));
        firstName.sendKeys("tina");
        Thread.sleep(1000);

        WebElement middleName = driver.findElement(By.id("middlename"));
        middleName.sendKeys("m");
        Thread.sleep(1000);

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("pop");
        Thread.sleep(1000);

        WebElement email = driver.findElement(By.className("validate-email"));
        email.sendKeys("");
        Thread.sleep(1000);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123456");
        Thread.sleep(1000);

        WebElement confirmPasword = driver.findElement(By.name("confirmation"));
        confirmPasword.sendKeys("123456");

        Thread.sleep(1000);
        WebElement signUpForNewsletter = driver.findElement(By.className("checkbox"));
        signUpForNewsletter.click();

        Thread.sleep(1000);

        WebElement register = driver.findElement(By.xpath("//div[@class='buttons-set']//button[@title='Register']"));
        register.click();
        Thread.sleep(1000);

        WebElement adviceContainer = driver.findElement(By.cssSelector(".validation-advice"));
        String validation_advice = adviceContainer.getText();

        assertThat("The validation advice for missing email is not present on page!",
                validation_advice,containsString("This is a required field."));

        driver.quit();
    }
    @Test
    public void addUserWithInvalidPassword() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        System.out.println("Opened homepage.");
        WebElement accountBtn = driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[@class='label']"));
        accountBtn.click();

        Thread.sleep(1000);

        WebElement registerBtn = driver.findElement(By.xpath("//div[@class='links']//a[@title='Register']"));
        registerBtn.click();
        Thread.sleep(1000);

        WebElement firstName = driver.findElement(By.id("firstname"));
        firstName.sendKeys("oancea");
        Thread.sleep(1000);

        WebElement middleName = driver.findElement(By.id("middlename"));
        middleName.sendKeys("g");
        Thread.sleep(1000);

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("rodica");
        Thread.sleep(1000);

        WebElement email = driver.findElement(By.className("validate-email"));
        email.sendKeys("oancea@yahoo.com");
        Thread.sleep(1000);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123");
        Thread.sleep(1000);

        WebElement confirmPasword = driver.findElement(By.name("confirmation"));
        confirmPasword.sendKeys("123");

        Thread.sleep(1000);
        WebElement signUpForNewsletter = driver.findElement(By.className("checkbox"));
        signUpForNewsletter.click();

        Thread.sleep(1000);

        WebElement register = driver.findElement(By.xpath("//div[@class='buttons-set']//button[@title='Register']"));
        register.click();
        Thread.sleep(1000);

        WebElement adviceContainer = driver.findElement(By.cssSelector(".validation-advice"));
        String validation_advice = adviceContainer.getText();

        assertThat("The validation advice for incorrect password is not present on page!",
                validation_advice,
                containsString("Please enter 6 or more characters without leading or trailing spaces."));

        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void addUserWhenPasswordsDontMatch() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        System.out.println("Opened homepage.");

        WebElement accountBtn = driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[@class='label']"));
        accountBtn.click();

        Thread.sleep(1000);

        WebElement registerBtn = driver.findElement(By.xpath("//div[@class='links']//a[@title='Register']"));
        registerBtn.click();
        Thread.sleep(1000);

        WebElement firstName = driver.findElement(By.id("firstname"));
        firstName.sendKeys("gabriela");
        Thread.sleep(1000);

        WebElement middleName = driver.findElement(By.id("middlename"));
        middleName.sendKeys("r");
        Thread.sleep(1000);

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("bill");
        Thread.sleep(1000);

        WebElement email = driver.findElement(By.className("validate-email"));
        email.sendKeys("bill@yahoo.com");
        Thread.sleep(1000);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("11111111");
        Thread.sleep(1000);

        WebElement confirmPasword = driver.findElement(By.name("confirmation"));
        confirmPasword.sendKeys("11234564");
        Thread.sleep(1000);
        WebElement signUpForNewsletter = driver.findElement(By.className("checkbox"));
        signUpForNewsletter.click();

        Thread.sleep(1000);

        WebElement register = driver.findElement(By.xpath("//div[@class='buttons-set']//button[@title='Register']"));
        register.click();
        Thread.sleep(1000);

        WebElement adviceContainer = driver.findElement(By.cssSelector(".validation-advice"));
        String validation_advice = adviceContainer.getText();

        assertThat("The validation advice for non matching passwords is not present on page!",
                validation_advice,
                containsString("Please make sure your passwords match."));


        driver.quit();
    }

    @Test
    public void addUserWithInvalidEmailAdress() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        System.out.println("Opened homepage.");

        WebElement accountBtn = driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[@class='label']"));
        accountBtn.click();

        Thread.sleep(1000);

        WebElement registerBtn = driver.findElement(By.xpath("//div[@class='links']//a[@title='Register']"));
        registerBtn.click();
        Thread.sleep(1000);

        WebElement firstName = driver.findElement(By.id("firstname"));
        firstName.sendKeys("denisa");
        Thread.sleep(1000);

        WebElement middleName = driver.findElement(By.id("middlename"));
        middleName.sendKeys("f");
        Thread.sleep(1000);

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("popovici");
        Thread.sleep(1000);

        WebElement email = driver.findElement(By.className("validate-email"));
        email.sendKeys("denisayahoo.com");
        Thread.sleep(1000);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("000000");
        Thread.sleep(1000);

        WebElement confirmPasword = driver.findElement(By.name("confirmation"));
        confirmPasword.sendKeys("000000");
        Thread.sleep(1000);

        WebElement signUpForNewsletter = driver.findElement(By.className("checkbox"));
        signUpForNewsletter.click();
        Thread.sleep(1000);

        WebElement register = driver.findElement(By.xpath("//div[@class='buttons-set']//button[@title='Register']"));
        register.click();
        Thread.sleep(2500);
        driver.quit();
    }
    }
