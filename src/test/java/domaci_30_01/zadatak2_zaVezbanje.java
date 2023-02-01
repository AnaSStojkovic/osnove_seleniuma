package domaci_30_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class zadatak2_zaVezbanje {
    //Zadatak (ZA VEZBANJE)
    //Modifikovati zadatak 1 tako da se skrol vrsi u vise iteracija, npr u 5
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        Select select = new Select(driver.findElement(By.id("delay-select")));
        select.selectByValue("2000");
        Thread.sleep(2000);

        for (int i = 0; i < 4; i++) {
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.xpath("//div[@class='item'][last()" + -1 +"]")));
            actions.moveToElement(driver.findElement(By.xpath("//div[@class='item'][last()]")));
            actions.perform();
            Thread.sleep(1000);

            actions.moveToElement(driver.findElement(By.className("disabled-text")));
            actions.perform();
            Thread.sleep(1000);

            wait.until(ExpectedConditions.elementToBeClickable(By.className("active-text")));

            driver.findElement(By.id("infinite-scroll-button")).click();

            wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='item']"),3));
            wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.className("active-text"))));

            actions.moveToElement(driver.findElement(By.className("footer")));
            actions.perform();
        }



        Thread.sleep(5000);
        driver.quit();
    }
}
