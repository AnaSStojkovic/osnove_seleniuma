package domaci_24_01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class zadatak2 {
    public static void main(String[] args) throws InterruptedException {
//Zadatak
//Niz todo-a (niz stringova) koje treba da uneti. Niz je:
//Visit Paris
//Visit Prague
//Visit London
//Visit New York
//Visit Belgrade
//Maksimizirati prozor
//Ucitati stranicu https://example.cypress.io/todo
//Program petljom prolazi kroz niz todo-a i svaki unosi na stranicu
//Nakon svakog unosa todo-a, unosi se enter
//Cekanje od 5s
//Zatvorite pretrazivac

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        ArrayList<String> nizTodoa=new ArrayList<>();
        nizTodoa.add("Visit Paris");
        nizTodoa.add("Visit Prague");
        nizTodoa.add("Visit London");
        nizTodoa.add("Visit New York");
        nizTodoa.add("Visit Belgrade");

        driver.manage().window().maximize();

        driver.get("https://example.cypress.io/todo");


        for (int i = 0; i < nizTodoa.size(); i++) {


            driver.findElement(By.xpath("//*[@placeholder='What needs to be done?']")).sendKeys(nizTodoa.get(i));
            driver.findElement(By.xpath("//*[@placeholder='What needs to be done?']")).sendKeys(Keys.ENTER);

        }

        Thread.sleep(5000);

        driver.quit();


    }
}
