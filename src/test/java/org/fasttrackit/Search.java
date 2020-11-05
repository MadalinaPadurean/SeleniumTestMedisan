package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Search {
    @Test
    public void SearchOneWord() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        driver.findElement(By.cssSelector("#search")).sendKeys("vase" + Keys.ENTER);
//        driver.quit();
    }

    @Test
    public void SearchWithButton() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        driver.findElement(By.cssSelector("#search")).sendKeys("vase");
        driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button")).click();
//        driver.quit();

    }

    @Test
    public void FilterByCategory() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys("vase" + Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/dd/ol/li[1]/a")).click();
//        driver.quit();
    }

    @Test
    public void ClearCategoryFilter() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys("vase" + Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/dd/ol/li[1]/a")).click();
        driver.findElement(By.cssSelector("div.actions>a")).click();
//        driver.quit();
    }

    @Test
    public void SortByNameAscending() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        driver.findElement(By.cssSelector("#search")).sendKeys("vase" + Keys.ENTER);
        driver.findElement(By.cssSelector("div.sort-by > select > option:nth-child(2)")).click();
        driver.findElement(By.cssSelector("div.sort-by > a")).click();
        List<WebElement> productNames = driver.findElements(By.cssSelector("h2.product-name > a"));
        for (WebElement element : productNames) {
            System.out.println(element);
//            driver.quit();
        }
    }


    @Test
    public void ViewAsList() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        driver.findElement(By.cssSelector("#search")).sendKeys("vase" + Keys.ENTER);
        driver.findElement(By.cssSelector("a.list")).click();
//        driver.quit();
    }

    @Test
    public void NumberOfItemsPerPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys("vase" + Keys.ENTER);
        driver.findElement(By.xpath("//*[@title=\"Results per page\"]/option[2]")).click();
        driver.quit();
    }

    @Test
    public void SwitchColor() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys("vase" + Keys.ENTER);
        driver.findElement(By.xpath("//*[@name=\"black\"]/span/img")).click();
//        driver.quit();
    }
    @Test
    public void ClickPicture() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        driver.findElement(By.cssSelector("#search")).sendKeys("vase" + Keys.ENTER);
        driver.findElement(By.cssSelector("a.product-image")).click();
//        driver.quit();
    }
    @Test
    public void ClickViewDetails() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        driver.findElement(By.cssSelector("#search")).sendKeys("vase" + Keys.ENTER);
        driver.findElement(By.cssSelector("div.actions>a")).click();
//        driver.quit();
    }
}
