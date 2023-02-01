package domaci_31_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class zadatak4_zaVezbanje {
    public static void main(String[] args) throws InterruptedException {


        //4.Zadatak (za vezbanje)
        //Napisati program koji:
        //Ucitava stranicu https://blueimp.github.io/jQuery-File-Upload/
        //Uploaduje sve cetiri slike odjenom (slike iz prvog zadatka)
        //Ceka da se prikazu 4 item-a a upload
        //Klik na upload
        //Ceka da se upload zavrsi

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        List<String> nizSlika = new ArrayList<>();
        nizSlika.add("test_data/1.jpg");
        nizSlika.add("test_data/2.jpg");
        nizSlika.add("test_data/3.jpg");
        nizSlika.add("test_data/4.jpg");

        for (int i = 0; i < nizSlika.size(); i++) {
            driver.findElement(By.xpath("//input[@type='file']"))
                    .sendKeys(new File(nizSlika.get(i)).getAbsolutePath());
            Thread.sleep(1000);

        }

        wait.until(ExpectedConditions.numberOfElementsToBe(By.className("name"),4));

        driver.findElement(By.className("start")).click();

        wait.until(ExpectedConditions.numberOfElementsToBe(By.className("template-download"),4));


        Thread.sleep(3000);
        driver.quit();
    }
}
