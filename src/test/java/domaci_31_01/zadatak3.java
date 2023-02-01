package domaci_31_01;

import heleper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class zadatak3 {
    public static void main(String[] args) throws InterruptedException, IOException {
        //3. Zadatak
        //Napisati program koji:
        //Ucitava stranicu https://itbootcamp.rs/
        //Skrola do slajdera na dnu stranice (u kome su slike Java, Php, Selenium, …)
        //Cita sve linkove slika iz slajdera
        //Proverava url svake slike, i za sve slike koje imaju status veci i jednak od 200 a manji od 300, skida i smesta u folder itbootcamp_slider u okviru projekta
        //Azurirajte gitignore da ignorise itbootcamp_slider folder

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://itbootcamp.rs/");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.className("slider_bkgd")));
        actions.perform();


        List<WebElement> srcNiz = driver.findElements(By.xpath("//*[@class='carousel-item']/img"));

        for (int i = 0; i < srcNiz.size(); i++) {
            String srcLink =  srcNiz.get(i).getAttribute("src");
            URL url = new URL(srcLink);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            if (http.getResponseCode() >= 200 && http.getResponseCode() < 400) {
                System.out.println("Link: " + url + " is active.");
            } else {
                System.out.println("Link: " + url + " is not active.");
            }
        }

        for (int i = 0; i < srcNiz.size(); i++) {


            try {
                new Helper().downloadUsingStream(srcNiz.get(i).getAttribute("src"),
                        "itbootcamp_slider/src.jpg"+(i+1));


            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        Thread.sleep(4000);
        driver.quit();
    }
}



