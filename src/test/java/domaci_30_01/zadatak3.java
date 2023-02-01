package domaci_30_01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        //Zadatak
        //Napisati program koji:
        //Pre nego sto krenete u automatizaciju prvo sve korake uradite rucno
        //Implicitno cekanje za trazenje elemenata je maksimalno 10s
        //Implicitno cekanje za ucitavanje stranice je 5s
        //Ucitava stranicu https://docs.katalon.com/
        //Maksimizuje prozor
        //Od html elementa cita data-theme atribut.
        //Proverava da li je sadrzaj u tom atributu light i ispisuje odgovarajuce poruke
        //Klikce na dugme za zamenu tema
        //Ponovo cita data-theme atribut html elementa i validira da u atributu stoji vrednost dark
        //Izvrsava kombinaciju tastera CTRL + K. Koristan link  za keyboard actions…kako izvrsavati precice preko Actions objekta
        //Ceka da se dijalog za pretragu pojavi
        //Zatim od inputa za pretragu cita atribut type i proverava da je vrednost tog atributa search
        //Zatvara pretrazivac

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://docs.katalon.com/");
        driver.manage().window().maximize();



        WebElement mod1 = driver.findElement(By.xpath("/html"));
        String xpath = mod1.getAttribute("data-theme");

        if (xpath.equals("light")) {
            System.out.println("Ukljucen je light mod.");
        } else {
            System.out.println("Ukljucen je dark mod.");
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='clean-btn toggleButton_rCf9']")).click();
        WebElement mod2 = driver.findElement(By.xpath("/html"));
        String xpath2 = mod2.getAttribute("data-theme");
        Thread.sleep(1000);

        if (xpath2.equals("dark")) {
            System.out.println("Ukljucen je dark mod.");
        } else {
            System.out.println("Ukljucen je light mod.");
        }
        Thread.sleep(1000);

        new Actions(driver).keyDown(Keys.CONTROL)
                .sendKeys("k")
                .keyUp(Keys.CONTROL)
                .perform();

        String xpath3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("DocSearch-Input")))
                .getAttribute("type");

        if(xpath3.equals("search")){
            System.out.println("Type atribut sadrzi 'search'.");
        } else {
            System.out.println("Type atribut ne sadrzi 'search'.");
        }

        Thread.sleep(2000);
        driver.quit();





    }
}
