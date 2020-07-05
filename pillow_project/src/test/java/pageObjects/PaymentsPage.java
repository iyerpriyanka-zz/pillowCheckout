package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentsPage {
    WebDriver driver;
    WebDriverWait wait;

    By creditCardPayment = By.xpath("//a[contains(@href, '#/credit-card')]");

    public PaymentsPage(WebDriver driver){this.driver = driver;}

    public void clickCreditCardPayment(){
        wait = new WebDriverWait(driver,20);
        WebElement creditCardPaymentLink;
        try{
            creditCardPaymentLink = wait.until(ExpectedConditions.elementToBeClickable(creditCardPayment));
            creditCardPaymentLink.click();
        }catch (ElementNotVisibleException e) {
            e.printStackTrace();
        }
    }
}
