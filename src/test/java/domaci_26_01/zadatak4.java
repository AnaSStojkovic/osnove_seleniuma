package domaci_26_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class zadatak4 {
    public static void main(String[] args) throws InterruptedException {
        //
//        4.Zadatak
//        Napisati program koji ucitava stranicu https://geodata.solutions/
//        Bira Country, State i City po vasoj zelji
//        Pritom potrebno je izvrsiti cekanje da se povaje State-ovi nakon izbora Country-a
//        I takodje je potrebno izvrsiti cekanje da se ucitaju gradovi nakon izbora State-a
//        Izabrerit Country, State i City tako da imate podatke da selektujete!

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://geodata.solutions/");

        Select se = new Select(driver.findElement(By.xpath("//*[@id='countryId']")));
        se.selectByVisibleText("Serbia");
        Thread.sleep(1000);

        se = new Select(driver.findElement(By.xpath("//*[@id='stateId']")));
        se.selectByValue("Central Serbia");
        Thread.sleep(1000);

        se = new Select(driver.findElement(By.xpath("//*[@id='cityId']")));
        se.selectByVisibleText("Nis");
        Thread.sleep(1000);

        driver.quit();

    }
}
