package pl.coderslab;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.model.*;

import java.time.Duration;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;


public class HotelTest {

    private final static String PERMANENT_LOGIN = "LucjuszDabrowski@rhyta.com";
    private final static String PERMANENT_PASSWORD = "Admin1";
    private WebDriver driver;

    @Before
    public void setUp() {
        //        Ustaw gdzie jest chromedriver -> STEROWNIK
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        //        Otworz przegladarke
        this.driver = new ChromeDriver();
        //        Jesli test nie przechodzi poprawnie, to pewnie za wolno laduje sie strona -> Dodaj czekanie.
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver.get("https://mystore-testlab.coderslab.pl");

    }

    @After
    public void tearDown() throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("C:\\Users\\Puszek\\Pictures\\Saved Pictures\\homePageScreenshot.png"));

        driver.quit();
     }

     @Test
    public void testSearchAnyHotel() {
        HotelMainPage hotelMainPage = new HotelMainPage(this.driver);
        hotelMainPage.clickSignIn();

        HotelLoginPage hotelLoginPage = new HotelLoginPage(this.driver);
        hotelLoginPage.signInWithCredentials(PERMANENT_LOGIN, PERMANENT_PASSWORD);

        HotelShopPage hotelShopPage = new HotelShopPage(this.driver);
        hotelShopPage.clickClothesButton();
        hotelShopPage.clickClothes();
        hotelShopPage.fillFormAndSubmit('M',5);
        hotelShopPage.checkoutButtonClick1();
        hotelShopPage.checkoutButtonClick2();
        hotelShopPage.checkoutButtonClick3("Huta","31-111","Kraków","United Kingdom");
        hotelShopPage.button();
        hotelShopPage.confirmCheckoutButtonn();
        hotelShopPage.paymentt();
        hotelShopPage.conditions_to_approvee();
        hotelShopPage.paymen();
    }


}
