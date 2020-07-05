package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    By checkoutButton = By.xpath("//*[contains(text(),\"CHECKOUT\")]");

    public CheckoutPage(WebDriver driver){this.driver = driver;}

    public void clickCheckoutButton(){
        wait = new WebDriverWait(driver,20);
        WebElement CheckoutClick;
        try{
            CheckoutClick = wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
            CheckoutClick.click();
        }catch (ElementNotVisibleException e) {
            e.printStackTrace();
        }
    }

    public String getTitle(){ return driver.getTitle(); }
}
