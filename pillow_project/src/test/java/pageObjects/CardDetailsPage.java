package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CardDetailsPage {
    WebDriver driver;
    WebDriverWait wait;

    private By cardNumber = By.xpath("//input[contains(@name, 'cardnumber')]");
    private By expiryDate = By.xpath("//input[contains(@placeholder, 'MM / YY')]");
    private By cvv = By.xpath("//input[contains(@placeholder, '123')]");
    private By payNow = By.xpath("//span[contains(text(), 'Pay Now')]");

    public CardDetailsPage(WebDriver driver){this.driver = driver;}

    public void enterCreditCardDetails(String creditCardNumber, String creditCardExpiryDate, String creditCardCvv){
        wait = new WebDriverWait(driver,20);
        WebElement cardNumber, expiryDate, cvv;
        try{
            cardNumber = wait.until(ExpectedConditions.elementToBeClickable(this.cardNumber));
            cardNumber.clear();
            cardNumber.sendKeys(creditCardNumber);
            expiryDate = driver.findElement(this.expiryDate);
            expiryDate.click();
            expiryDate.sendKeys(creditCardExpiryDate);
            cvv = wait.until(ExpectedConditions.elementToBeClickable(this.cvv));
            cvv.sendKeys(creditCardCvv);
        }catch (ElementNotVisibleException e) {
            e.printStackTrace();
        }
    }

    public void clickPayNowButton(){
        wait = new WebDriverWait(driver,20);
        WebElement clickPayNow;
        try{
            clickPayNow = wait.until(ExpectedConditions.elementToBeClickable(payNow));
            clickPayNow.click();
        }catch (ElementNotVisibleException e){
            e.printStackTrace();
        }catch (ElementClickInterceptedException e){
            e.printStackTrace();
        }
    }

    public String getTitle(){
        return driver.getTitle();
    }
}
