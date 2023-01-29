package domaci_26_01;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.ArrayList;
import java.util.List;

public class zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        //3.Zadatak
        //Napisati program koji:
        //Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
        //Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element obrisao sa stranice i
        // ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
        //POMOC: Brisite elemente odozdo.
        //(ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://s.bootsnipp.com/iframe/Dq2X");
        List<WebElement> lista = new ArrayList<>(driver.findElements(By.xpath("//button")));

        int prikaz = lista.size() - 1;

            for (int i = prikaz; i >= 0; i--) {
                lista.get(i).click();
                try {
                    if (!lista.get(i).equals(driver.findElement(By.xpath("(//button)[last()]")))) {
                        System.out.println("Element je izbrisan!");
                        lista.remove(i);
                        Thread.sleep(1000);
                    }
                } catch (NoSuchElementException error) {
                    System.out.println("Element je izbrisan!");
                    lista.remove(i);
                }
            }
        driver.quit();
    }
}





