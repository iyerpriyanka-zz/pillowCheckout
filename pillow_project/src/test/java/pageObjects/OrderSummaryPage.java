package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderSummaryPage {
    WebDriver driver;
    WebDriverWait wait;

    private By orderSummaryClickContinue = By.xpath("//a[contains(@class, 'button-main-content')]");

    public OrderSummaryPage(WebDriver driver){this.driver = driver;}

    public void clickContinue(){
        wait = new WebDriverWait(driver,20);
        WebElement clickContinueButton;
        driver.switchTo().frame("snap-midtrans");
        try{
            clickContinueButton = wait.until(ExpectedConditions.elementToBeClickable(orderSummaryClickContinue));
            clickContinueButton.click();
        }catch (ElementNotVisibleException e) {
            e.printStackTrace();
        }
    }

    public String getTitle(){ return driver.getTitle(); }
}
