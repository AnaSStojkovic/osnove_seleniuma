package domaci_03_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;


public class KatalonShopTests {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl="https://cms.demo.katalon.com";

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
    @Test(priority = 10)
    public void addingProductsWithQuantityToTheCart(){
        //Test #1:  Adding product with quantity to the cart
        //	Prioritet = 10
        //	Koraci:
        //Ucitati stranicu /product/flying-ninja/
        //Unesite kolicinu 3
        //Klik na Add to cart dugme
        //Verifikovati da poruka sadrzi tekst “Flying Ninja”.
        //Klik na Cart link iz navigacije
        //Verifikovati da u url-u stoji /cart ruta
        //Verifikovati da je broj proizvoda u korpi jednako 1

        driver.get(baseUrl+"/product/flying-ninja/");
        driver.findElement(By.name("quantity")).clear();
        driver.findElement(By.name("quantity")).sendKeys("3");
        driver.findElement(By.name("add-to-cart")).click();

        WebElement message = driver.findElement(By.className("woocommerce-message"));
        Assert.assertTrue(message.getText().contains("Flying Ninja"),"Message doesn't contain right text");
        driver.findElement(By.className("woocommerce-message")).findElement(By.tagName("a")).click();
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl+ "/cart/", "Url is not right");
        int cartNo = driver.findElements(By.xpath("//*[@class='entry-content']/div/form")).size();
        Assert.assertEquals(cartNo,1,"There are no products in the cart");
    }
    @Test(priority = 20)
    public void RemovingProductFromCart() throws InterruptedException {

        //Test #2:  Removing product from cart
        //	Prioritet = 20
        //	Koraci:
        //Klik na Cart link iz navigacije
        //Verifikovati da u url-u stoji /cart ruta
        //Verifikovati da je broj proizvoda u korpi jednako 1
        //Klik na remove dugme iz prvog reda
        //Verifikovati da je broj proizvoda u korpi jedako 0

        driver.findElement(By.xpath("//*[@id='primary-menu']//li/a")).click();
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl+ "/cart/", "Url is not right");
        int cartNo = driver.findElements(By.xpath("//*[@class='entry-content']/div/form")).size();
        Assert.assertEquals(cartNo,1,"There are no products in the cart");
        driver.findElement(By.xpath("//*[@class='product-remove']/a")).click();
        Thread.sleep(3000);
        cartNo = driver.findElements(By.xpath("//*[@class='entry-content']/div/form")).size();
        Assert.assertEquals(cartNo,0,"There are no products in the cart");

    }
    @Test(priority = 30)
    public void verifyErrorIsDisplayedWhenUsernameIsMissing(){
        //Test #3:  Verify error is displayed when username is missing
        //	Prioritet = 30
        //	Koraci:
        //Kliknite na my account link
        //Klik na login dugme
        //Verifikovati da je prikazana poruka Error: Username is required.
        //Click on my account link
        driver.findElement(By.xpath("//*[@id='primary-menu']//li[3]/a")).click();
        driver.findElement(By.name("login")).click();
        String errorMessage = driver.findElement(By.xpath("//*[@class='woocommerce-error']/li")).getText();
        Assert.assertEquals(errorMessage, "Error: Username is required.","Error message is wrong" );
    }
    @Test(priority = 40)
    public void verifyErrorIsDisplayedWhenPasswordIsMissing(){
        //Koraci:
        //Kliknite na my account link
        //Unesite username customer
        //Klik na login dugme
        //Verifikovati da je prikazana poruka ERROR: The password field is empty.

        driver.findElement(By.xpath("//*[@href='https://cms.demo.katalon.com/my-account/']")).click();
        driver.findElement(By.id("username")).sendKeys("customer");
        driver.findElement(By.xpath("//button[@name='login']")).click();
        String message = driver.findElement(By.className("woocommerce-error")).getText();
        Assert.assertEquals(message,"ERROR: The password field is empty.","Password field is required.");
    }

    @Test(priority = 50)
    public void verifyErrorIsDisplayedWhenPasswordIsWrong() {
        //Test #5:  Verify error is displayed when password is wrong
        //	Prioritet = 50
        //	Koraci:
        //Kliknite na my account link
        //Unesite username customer
        //Unesite nevalidan pass invalidpassword
        //Klik na login dugme
        //Verifikovati da je prikazana poruka ERROR: The password you entered for the username customer is incorrect. Lost your password?

        driver.findElement(By.xpath("//*[@href='https://cms.demo.katalon.com/my-account/']")).click();
        driver.findElement(By.id("username")).sendKeys("customer");
        driver.findElement(By.id("password")).sendKeys("invalidpassword");
        driver.findElement(By.xpath("//button[@name='login']")).click();
        String message = driver.findElement(By.className("woocommerce-error")).getText();
        Assert.assertEquals(message,"ERROR: The password you entered for the username customer is incorrect. Lost your password?","Password is incorrect.");
    }

    @Test(priority = 60)
    public void verifyErrorIsDisplayedWhenUserDoesNotExist() {
        //Test #6:  Verify error is displayed when user does not exist
        //	Prioritet = 60
        //	Koraci:
        //Kliknite na my account link
        //Unesite username invaliduser
        //Unesite nevalidan pass (ex: pass1234)
        //Klik na login dugme
        //Verifikovati da je prikazana poruka ERROR: Invalid username. Lost your password?

        driver.findElement(By.xpath("//*[@href='https://cms.demo.katalon.com/my-account/']")).click();
        driver.findElement(By.id("username")).sendKeys("invaliduser");
        driver.findElement(By.id("password")).sendKeys("pass1234");
        driver.findElement(By.xpath("//button[@name='login']")).click();
        String message = driver.findElement(By.className("woocommerce-error")).getText();
        Assert.assertEquals(message,"ERROR: Invalid username. Lost your password?","Username is incorrect.");
    }

    @Test(priority = 70)
    public void verifySuccessfulLogin() {
        //Test #7:  Verify successful login
        //	Prioritet = 70
        //	Koraci:
        //Kliknite na my account link
        //Unesite username customer
        //Unesite validan pass crz7mrb.KNG3yxv1fbn
        //Klik na login dugme
        //Verifikovati na stranici pise Hello Katalon Parlitul_Changed
        //	Dopunite pageve za sve sto je potrebno za ove testove, ako je potrebno kreirajte i nove pageve

        driver.findElement(By.xpath("//*[@href='https://cms.demo.katalon.com/my-account/']")).click();
        driver.findElement(By.id("username")).sendKeys("customer");
        driver.findElement(By.id("password")).sendKeys("crz7mrb.KNG3yxv1fbn");
        driver.findElement(By.xpath("//button[@name='login']")).click();
        String message = driver.findElement(By.xpath("//*[@id='post-10']/div/div/div/p[1]")).getText();
        Assert.assertEquals(message,"Hello Katalon Parlitul_Changed (not Katalon Parlitul_Changed? Log out)","Username is incorrect.");
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }
}