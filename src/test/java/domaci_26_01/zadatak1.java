package domaci_26_01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import java.util.ArrayList;
import java.util.List;

public class zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        //1. Zadatak
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
        //Validira da li je novi todo dodat na stranici
        //Na kraju programa proci petljom i izbrisati svaki todo sa stranice (klikom na x dugme svakog todo-a)
        //Validirati da je na kraju programa broj todo-a na stranici 0.
        //Cekanje od 5s
        //Zatvorite pretrazivac

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://example.cypress.io/todo");

        ArrayList<String> toDo = new ArrayList<>();
        toDo.add("Visit Paris");
        toDo.add("Visit Prague");
        toDo.add("Visit London");
        toDo.add("Visit New York");
        toDo.add("Visit Belgrade");
        List<WebElement> x = driver.findElements(By.xpath("//button[contains(@class,'destroy')]"));
        for (int i = 1; i < x.size()-1; i++) {
            x.get(i).click();
        }

        for (int i = 0; i < toDo.size(); i++) {
            driver.findElement(By.xpath("//input[(@placeholder='What needs to be done?')]"))
                    .sendKeys(toDo.get(i));
            Thread.sleep(500);
            driver.findElement(By.xpath("//input[(@placeholder='What needs to be done?')]"))
                    .sendKeys(Keys.ENTER);
            Thread.sleep(500);

        }
        System.out.println("Duzina niza je "+toDo.size());
        Thread.sleep(1000);

        for (int i = 0; i < toDo.size(); i++) {
            driver.findElement(By.xpath("/html/body/section/div/section/ul/li/div")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//button[contains(@class,'destroy')]")).click();
        }

        System.out.println("Duzina niza je "+(x.size()-2));


        Thread.sleep(4000);
        driver.quit();
    }
}
