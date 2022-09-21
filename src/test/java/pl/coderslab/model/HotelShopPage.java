package pl.coderslab.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HotelShopPage {
    private WebDriver driver;

    @FindBy(xpath= "/html//*[@id='category-3']/a")
    private WebElement clothesButton;
    @FindBy(xpath = "/html//div[@class='products row']//article[@data-id-product='2']")
    private WebElement clothesProducts;

    @FindBy(id = "group_1")
    private WebElement sizeClothes;

    @FindBy(id = "quantity_wanted")
    private WebElement quantityClothes;

    @FindBy(xpath = "/html//button[@data-button-action='add-to-cart']")
    private WebElement addCardButton;

    @FindBy(xpath = "/html//div[@class='cart-content-btn']/a")
    private WebElement checkoutButton1;

    @FindBy(xpath = "/html//div[@class='text-sm-center']/a")
    private WebElement checkoutButton2;

    @FindBy(name = "address1")
    private WebElement customerAddress;

    @FindBy( name = "city")
    private WebElement customerCity;

    @FindBy( name = "postcode")
    private WebElement customerPostcode;

    @FindBy ( name = "id_country")
    private WebElement customerCountry;

    @FindBy ( name = "confirm-addresses")
    private WebElement addressSubmit;

    @FindBy ( name= "confirmDeliveryOption")
    private WebElement confirmCheckoutButton;

    @FindBy ( id= "payment-option-1" )
    private WebElement payment;

    @FindBy (name = "conditions_to_approve[terms-and-conditions]")
    private WebElement conditions_to_approve;

    @FindBy (id= "payment-confirmation")
    private WebElement checkoutButton3;

    public HotelShopPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickClothesButton(){this.clothesButton.click();}

    public void clickClothes(){this.clothesProducts.click();}

    public void fillFormAndSubmit(char size, int quantity){
        Select clothesSize = new Select(sizeClothes);
        clothesSize.selectByVisibleText(String.valueOf(size));
        quantityClothes.clear();
        quantityClothes.sendKeys(String.valueOf(quantity));
        addCardButton.click();
    }

    public void checkoutButtonClick1(){this.checkoutButton1.click();}

    public void checkoutButtonClick2() {this.checkoutButton2.click();}
    public void checkoutButtonClick3 (String address, String postcode, String city ,String country) {



        customerPostcode.clear();
        customerPostcode.sendKeys(postcode);
        customerAddress.clear();
        customerAddress.sendKeys(address);
        customerCity.clear();
        customerCity.sendKeys(city);
        Select countrySelect = new Select(customerCountry);
        countrySelect.selectByVisibleText(country);


    }


    public void button(){this.addressSubmit.click();}
    public void confirmCheckoutButtonn(){this.confirmCheckoutButton.click();}

    public void paymentt(){this.payment.click();}

    public void conditions_to_approvee(){this.conditions_to_approve.click();}

    public void  paymen (){this.checkoutButton3.click();}



}
