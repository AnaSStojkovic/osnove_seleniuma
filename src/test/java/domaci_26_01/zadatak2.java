package domaci_26_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        //2.Zadatak (Za vezbanje)
        //Napisati program koji matematicku formulu koju korisnik unese izvrsaav na stranici:
        //Ucitati stranicu https://www.calculatorsoup.com/calculators/math/basic.php
        //Korisnik unosi formulu, samo osnovne matematicke operacija, npr:
        //1243+329=
        //21912-4=
        //12913÷4=
        //U programu se formula unosi kao jedan string i potrebno je razbiti formulu na karaktere. Za to imate metodu https://www.geeksforgeeks.org/convert-a-string-to-a-list-of-characters-in-java/
        //Zatim u odnosu na karakter uradite odredjenu logiku

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        Scanner s = new Scanner(System.in);
        System.out.println("Unesite izraz koji zelite da izracunate: ");
        String izraz = s.nextLine();
        char[] c = izraz.toCharArray();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.calculatorsoup.com/calculators/math/basic.php");

        for (int i=0; i<izraz.length();i++) {
            if (!c.equals(" ")) {
                driver.findElement(By.xpath("//*[@class='cs_calculator_container']/body")).click();
            }
        }
        Thread.sleep(2000);
        driver.quit();
    }
}
