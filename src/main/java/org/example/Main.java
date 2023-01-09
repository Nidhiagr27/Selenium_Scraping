package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.google.com/");

        // Maximize the browser
        // using maximize() method
        driver.manage().window().maximize();
        WebElement element=driver.findElement(By.name("q"));
       //enter text with sendKeys() then apply submit()
        element.sendKeys("Selenium Java");
        // Explicit wait condition for search results
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
        w.until(ExpectedConditions.presenceOfElementLocated(By.className("gNO89b")));
        element.submit();
        List<WebElement> list= driver.findElements(By.linkText("selenium"));
        Iterator<WebElement> it= list.iterator();
        System.out.println(it.next());
        driver.close();

        // Launching website
       /* driver.get("https://eproc.cgstate.gov.in/CHEPS/security/getSignInAction.do");*/
    }
}