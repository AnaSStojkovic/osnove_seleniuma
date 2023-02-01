package domaci_31_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;


public class zadatak1 {
    public static void main(String[] args) throws InterruptedException {
//        /1.Zadatak
//        Napisati program koji:
//        Podesava:
//        implicitno cekanje za trazenje elemenata od 10s
//        implicitno cekanje za ucitavanje stranice od 10s
//        eksplicitno cekanje podeseno na 10s
//        Podaci:
//        Potrebno je u projektu ukljuciti 4 slike:
//        front.jpg
//        left.jpg`````
//        right.jpg
//        back.jpg
//        Koraci:
//        Ucitava stranicu https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you
//        Maksimizuje prozor
//        Klik na edit ikonicu
//        Klik na delete iz iskacuceg dijaloga
//        Klik na Add Image dugme
//        Sacekajte da se pojavi desni meni
//        Uploadujte front.jpg sliku
//        Sacekajte da je ispod uploada slike, broj slika 1.
//        Klik na sliku
//        Klik na Done dugme
//        Sacekajte 2s
//        Klik na Add Image dugme
//        Sacekajte da se pojavi desni meni
//        Uploadujte right.jpg sliku
//        Sacekajte da je ispod uploada slike, broj slika 2.
//        Klik na sliku
//        Klik na Done dugme
//        Sacekajte 2s
//        Klik na Add Image dugme
//        Sacekajte da se pojavi desni meni
//        Uploadujte back.jpg sliku
//        Sacekajte da je ispod uploada slike, broj slika 3.
//        Klik na sliku
//        Klik na Done dugme
//        Sacekajte 2s
//        Klik na Add Image dugme
//        Sacekajte da se pojavi desni meni
//        Uploadujte back.jpg sliku
//        Sacekajte da je ispod uploada slike, broj slika 3.
//        Klik na sliku
//        Klik na Done dugme
//        Sacekajte 2s
//        Sacekajte da Next dugme bude klikljivo
//        Klik na Next dugme
//        Unesite tekst
//        Klik na Next
//        Klik na Preview
//        Klik na Add to cart
//        Sacekajte 5s
//                Quit


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        File uploadImg1 = new File("test_data/1.jpg");
        String uploadImgPath1 = uploadImg1.getAbsolutePath();
        File uploadImg2 = new File("test_data/2.jpg");
        String uploadImgPath2 = uploadImg2.getAbsolutePath();
        File uploadImg3 = new File("test_data/3.jpg");
        String uploadImgPath3 = uploadImg3.getAbsolutePath();
        File uploadImg4 = new File("test_data/4.jpg");
        String uploadImgPath4 = uploadImg4.getAbsolutePath();

        driver.findElement(By.cssSelector("img.edit-image")).click();
        driver.findElement(By.id("image-option-remove")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("img.edit-image")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("imageUpload")));
        driver.findElement(By.id("imageUpload")).sendKeys(uploadImgPath1);

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//img[contains(@id,'image-option')]"), 1));
        driver.findElement(By.id("image-option-0")).click();
        driver.findElement(By.id("image-crop-done-button")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("img.edit-image")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("imageUpload")));
        driver.findElement(By.id("imageUpload")).sendKeys(uploadImgPath2);

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//img[contains(@id,'image-option')]"), 2));
        driver.findElement(By.id("image-option-0")).click();
        driver.findElement(By.id("image-crop-done-button")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("img.edit-image")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("imageUpload")));
        driver.findElement(By.id("imageUpload")).sendKeys(uploadImgPath3);

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//img[contains(@id,'image-option')]"), 3));
        driver.findElement(By.id("image-option-0")).click();
        driver.findElement(By.id("image-crop-done-button")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("img.edit-image")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("imageUpload")));
        driver.findElement(By.id("imageUpload")).sendKeys(uploadImgPath4);

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//img[contains(@id,'image-option')]"), 4));
        driver.findElement(By.id("image-option-0")).click();
        driver.findElement(By.id("image-crop-done-button")).click();
        Thread.sleep(2000);


        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("next-button"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("next-button"))).click();
        driver.findElement(By.id("textareaID")).sendKeys("Weather cartoon!");
        driver.findElement(By.id("next-button")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("next-button")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("next-button")).click();

        Thread.sleep(5000);
        driver.quit();
    }
}


