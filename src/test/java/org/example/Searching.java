package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import java.time.Duration;

public class Searching {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://www.google.com/");
            driver.manage().window().maximize();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));

            searchBox.sendKeys("Skillfactory");


            searchBox.sendKeys(Keys.ENTER);


            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));

            driver.findElement(By.xpath("//span[text()='Skillfactory']")).click();
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Закрыть браузер после завершения
            driver.quit();
        }
    }
}
