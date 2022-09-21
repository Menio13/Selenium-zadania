package pl.coderslab.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HotelNewAddresPage {

    private WebDriver driver;

    @FindBy(name = "alias")
    private WebElement customerAlias;

    @FindBy(name = "address1")
    private WebElement customerAddress;

    @FindBy(name = "postcode")
    private WebElement customerPostecode;

    @FindBy(name = "city")
    private WebElement customerCity;

    @FindBy(name = "id_country")
    private WebElement customerCountry;

    @FindBy(name = "phone")
    private WebElement customerPhone;

    @FindBy(xpath = "/html//div[@class='address-form']//footer[contains(@class,'form-footer')]//button[@type='submit']")
    private WebElement submitButton;

    public HotelNewAddresPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void fillFormAndSubmit(String alias, String address, String city, String zipcode, String country, String phone){
        customerAlias.clear();
        customerAlias.sendKeys(alias);
        customerAddress.clear();
        customerAddress.sendKeys(address);
        customerCity.clear();
        customerCity.sendKeys(city);
        customerPostecode.clear();
        customerPostecode.sendKeys(zipcode);
        Select countrySelect = new Select(customerCountry);
        countrySelect.selectByVisibleText(country);
        customerPhone.clear();
        customerPhone.sendKeys(phone);

        submitButton.click();
    }

}
