package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;

    By buyNowButton = By.xpath("//*[contains(text(),\"BUY NOW\")]");

    public HomePage(WebDriver driver){this.driver = driver;}

    public void clickBuyNow(){
        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement buyNowClick;
        try{
            buyNowClick = wait.until(ExpectedConditions.elementToBeClickable(buyNowButton));
            buyNowClick.click();
        }catch (ElementNotVisibleException e) {
            e.printStackTrace();
        }
    }

    public String getTitle(){ return driver.getTitle(); }

}
