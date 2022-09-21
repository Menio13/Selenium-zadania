package pl.coderslab.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelMyAccountPage {

    private WebDriver driver;
    @FindBy(className = "alert")
    private WebElement alert;

    @FindBy(id = "address-link")
    private WebElement newAddressButton;

    @FindBy(css = ".footer_links span")
    private WebElement homeButton;

    public HotelMyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickAddressButton() {this.newAddressButton.click();}

    public String getAlertText() {
        return alert.getText();
    }
}
