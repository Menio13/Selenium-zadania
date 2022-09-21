package pl.coderslab.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.model.HotelLoginPage;
import pl.coderslab.model.HotelMainPage;
import pl.coderslab.model.HotelMyAccountPage;
import pl.coderslab.model.HotelNewAddresPage;

import java.time.Duration;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class HotelSteps {

    private WebDriver driver;

    private final static String PERMANENT_LOGIN = "LucjuszDabrowski@rhyta.com";
    private final static String PERMANENT_PASSWORD = "Admin1";
    @Given("an open browser with {}")
    public void openBrowser(String url){
        //        Ustaw gdzie jest chromedriver -> STEROWNIK
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        //        Otworz przegladarke
        this.driver = new ChromeDriver();
        //        Jesli test nie przechodzi poprawnie, to pewnie za wolno laduje sie strona -> Dodaj czekanie.
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver.get(url);
    }

    @When ("user is logged in")
    public void userLoggedIn(){
        HotelMainPage hotelMainPage = new HotelMainPage(this.driver);
        hotelMainPage.clickSignIn();

        HotelLoginPage  hotelLoginPage = new HotelLoginPage(this.driver);
        hotelLoginPage.signInWithCredentials(PERMANENT_LOGIN,PERMANENT_PASSWORD);

    }

    @And ("address page is opened")
    public void addressPageIsOpened(){
        HotelMyAccountPage hotelMyAccountPage = new HotelMyAccountPage(this.driver);
        hotelMyAccountPage.clickAddressButton();
    }

    @And("address form is populated with {} and {} and {} and {} and {} and {} and submitted")
    public void populatedAddressFormAndSubmitted(String alias, String address, String city, String zipcode, String country, String phone){
        HotelNewAddresPage hotelNewAddresPage = new HotelNewAddresPage(this.driver);
        hotelNewAddresPage.fillFormAndSubmit(alias, address, city, zipcode, country, phone);
    }

    @Then("address is created")
    public void addressIsCreated(){
        String expectedAlertText = "Address successfully added!";

        HotelMyAccountPage hotelMyAccountPage = new HotelMyAccountPage(driver);
        String alertText = hotelMyAccountPage.getAlertText();
        assertEquals(expectedAlertText, alertText);
    }



    @And("close browser")
    public void closeBrowser(){
        this.driver.quit();
    }

}
