package domaci_31_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        //2. Zadatak
        //Napisati program koji:
        //Ucitava stranu https://itbootcamp.rs/
        //Misem prelazi preko Vesti iz navigacionog menija
        //Ceka da se prikaze padajuci meni za Vesti
        //Misem prelazi preko Kursevi iz navigacionog menija
        //Ceka da se prikaze padajuci meni za Kursevi
        //Misem prelazi preko Prijava i pravilnik iz navigacionog menija
        //Ceka da se prikaze padajuci meni za Prijava i pravilnik
        //Koristan link. Mouse over preko seleniuma https://www.selenium.dev/documentation/webdriver/actions_api/mouse/#move-to-element


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://itbootcamp.rs/");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        WebElement hoverable1 = driver.findElement(By.id("menu-item-6408"));
        new Actions(driver)
                .moveToElement(hoverable1)
                .perform();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("dropdown-toggle")));
        Thread.sleep(1000);

        WebElement hoverable2 = driver.findElement(By.id("menu-item-5362"));
        new Actions(driver)
                .moveToElement(hoverable2)
                .perform();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("dropdown-toggle")));
        Thread.sleep(1000);

        WebElement hoverable3 = driver.findElement(By.id("menu-item-5453"));
        new Actions(driver)
                .moveToElement(hoverable3)
                .perform();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("dropdown-toggle")));
        Thread.sleep(1000);


        Thread.sleep(4000);
       driver.quit();


    }
}
