package domaci_24_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class zadatak4 {
    public static void main(String[] args) throws InterruptedException {
        //Zadatak
        //Maksimizirati prozor
        //Ucitati stranicu https://artplayer.org/
        //U fokusu je player sa desne strane
        //Ceka 3-4s
        //Klik na play dugme
        //Klik na na zvucnik za mute
        //Ceka 3s
        //Klik na screenshot
        //Klik na PIP mode
        //Ceka 1s
        //Klik na Exit PIP mode
        //Klik na WebFullscreen
        //Klik na Exit WebFullscreen
        //Cekanje od 5s
        //Zatvorite pretrazivac

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://artplayer.org/");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@aria-label='Play']")).click();
        driver.findElement(By.xpath("//*[@aria-label='Mute']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@aria-label='Screenshot']")).click();
        driver.findElement(By.xpath("//*[@aria-label='PIP Mode']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@aria-label='Exit PIP Mode']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@aria-label='Web Fullscreen']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@aria-label='Exit Web Fullscreen']")).click();
        Thread.sleep(5000);

        driver.quit();





    }
}
