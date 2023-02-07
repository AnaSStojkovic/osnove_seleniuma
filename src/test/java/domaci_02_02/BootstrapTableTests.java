package domaci_02_02;

import heleper.Helper;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;


public class BootstrapTableTests {

    //Kreirati BootstrapTableTests klasu koja ima:
    //Base url: https://s.bootsnipp.com
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl="https://s.bootsnipp.com";

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @BeforeMethod
    public void beforeMethod(){
        driver.get(baseUrl);
    }

    @Test(priority = 1)
    @Description("TC-1: Edit Row")
    public void editRow() throws InterruptedException {
                ////Test #1: Edit Row
        //    //Podaci:
        //    //First Name: ime polaznika
        //    //Last Name: prezime polaznika
        //    //Middle Name: srednje ime polanzika
        //    //Koraci:
        //    //Ucitati stranu /iframe/K5yrx
        //    //Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
        //    //Klik na Edit dugme prvog reda
        //    //Sacekati da dijalog za Editovanje bude vidljiv
        //    //Popuniti formu podacima.
        //    //Bice potrebno da pre unosa tekst pobrisete tekst koji vec postoji, za to se koristi metoda clear. Koristan link
        //    //Klik na Update dugme
        //    //Sacekati da dijalog za Editovanje postane nevidljiv
        //    //Verifikovati da se u First Name celiji prvog reda tabele javlja uneto ime
        //    //Verifikovati da se u Last Name celiji prvog reda tabele javlja uneto prezime
        //    //Verifikovati da se u Middle Name celiji prvog reda tabele javlja uneto srednje ime
        //    //Za sve validacije ispisati odgovarajuce poruke u slucaju greske

        driver.get(baseUrl + "/iframe/K5yrx");
        String nazivStranice = driver.getTitle();
        Assert.assertEquals(nazivStranice, "Table with Edit and Update Data - Bootsnipp.com", "Wrong title of page");
        driver.findElement(By.xpath("//*[@id='d1']/td[5]/button")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("modal-content")));
        driver.findElement(By.id("fn")).clear();
        driver.findElement(By.id("ln")).clear();
        driver.findElement(By.id("mn")).clear();
        driver.findElement(By.id("fn")).sendKeys("Ana");
        driver.findElement(By.id("ln")).sendKeys("Stojkovic");
        driver.findElement(By.id("mn")).sendKeys("Sasa");
        driver.findElement(By.id("up")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-content")));
        Assert.assertEquals(driver.findElement(By.id("f1")).getText(),"Ana","Invalid First name");
        Assert.assertEquals(driver.findElement(By.id("l1")).getText(),"Stojkovic","Invalid Last name");
        Assert.assertEquals(driver.findElement(By.id("m1")).getText(),"Sasa","Invalid Middle name");
    }

    @Test(priority = 2)
    @Description("TC-2: Delete Row")
    public void deleteRow() throws InterruptedException {
        //Podaci:
        //First Name: ime polaznika
        //Last Name: prezime polaznika
        //Middle Name: srednje ime polanzika
        //Koraci:
        //Ucitati stranu /iframe/K5yrx
        //Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
        //Klik na Delete dugme prvog reda
        //Sacekati da dijalog za brisanje bude vidljiv
        //Klik na Delete dugme iz dijaloga
        //Sacekati da dijalog za Editovanje postane nevidljiv
        //Verifikovati da je broj redova u tabeli za jedan manji
        //Za sve validacije ispisati odgovarajuce poruke u slucaju greske

        driver.get(baseUrl + "/iframe/K5yrx");
        String nazivStranice = driver.getTitle();
        Assert.assertEquals(nazivStranice, "Table with Edit and Update Data - Bootsnipp.com", "Wrong title of page");
//        int rowCount=driver.findElements(By.xpath("//table/tbody/tr")).size();
        driver.findElement(By.xpath("//tbody/tr/td/*[contains(@class, 'delete')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("delete")));
        driver.findElement(By.id("del")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("delete")));
//        Assert.assertEquals(rowCount,rowCount-1,"Number of rows is invalid.");
        //Ne brise redove, samo vrednosti iz redova.
        //Alternativa je da se odradi waiterom
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("d1")));

    }
    @Test(priority = 3)
    @Description("TC-3: Take a Screenshot")
    public void takeScreenshot() throws InterruptedException {
    //       Koraci:
    //Ucitati stranu  /iframe/K5yrx
    //Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
    //Kreirati screenshot stranice.
    //Fajl cuvajte na putanji gde su vam bile slike od proslog domaceg. Na putanji: screenshots/slike.png

        driver.get(baseUrl + "/iframe/K5yrx");
        String nazivStranice = driver.getTitle();
        Assert.assertEquals(nazivStranice, "Table with Edit and Update Data - Bootsnipp.com", "Wrong title of page");

        try {
            new Helper()
                    .takeScreenshot(driver,
                            "screenshots/slike.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @AfterMethod
//    public void afterMethod(){
//        System.out.println("AFTER TEST");
//    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }
}
