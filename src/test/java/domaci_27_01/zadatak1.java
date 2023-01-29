package domaci_27_01;

import heleper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


public class zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        //1.Zadatak
        //Ucitati stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
        //Klik na svako dugme od PRIMARY do DARK
        //Sacekati da se toasts u desnom gornjem uglu pojavi
        //Pauza izmedju klikova 1s
        //Postavite implicitno cekanje za ucitavanje stranice i trazenje elemenata na 10s


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
        Helper helper = new Helper();

        List<WebElement> niz = driver.findElements(By.xpath("//*[@id='section-basic-example']/section[1]/div/section/div/button"));

            if (helper.elementExist(driver, By.className("show"))){

                for (int i = 0; i < niz.size(); i++) {
                    niz.get(i).click();
                    Thread.sleep(2000);
            }

        }  System.out.println("Postoji "+ niz.size()+ " toast-eva.");


        Thread.sleep(4000);
        driver.quit();

    }
}



