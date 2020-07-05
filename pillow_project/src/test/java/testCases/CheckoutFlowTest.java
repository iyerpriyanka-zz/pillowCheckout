package testCases;

import configuration.ChromeDriverConfiguration;
import configuration.ReadExcelFile;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CheckoutFlowTest {

    String path = System.getProperty("user.dir");

    WebDriver driver;
    Properties prop = new Properties();
    ChromeDriverConfiguration chromeDriver ;
    HomePage homePage;
    CheckoutPage checkoutPage;
    OrderSummaryPage orderSummaryPage;
    PaymentsPage paymentsPage;
    CardDetailsPage cardDetailsPage;

    @BeforeClass
    public void setUp() {
        chromeDriver = new ChromeDriverConfiguration(driver);
        driver = chromeDriver.startChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            prop.load(new FileInputStream(path+ "/src/test/java/properties/setup.properties"));
        }catch (FileNotFoundException e){
            e.getStackTrace();
        }catch (IOException e) {
            e.getStackTrace();
        }
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
    }

    @Test
    public void goTillCheckout(){
        homePage = new HomePage(driver);
        homePage.clickBuyNow();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCheckoutButton();
        orderSummaryPage = new OrderSummaryPage(driver);
        orderSummaryPage.clickContinue();
        paymentsPage = new PaymentsPage(driver);
        paymentsPage.clickCreditCardPayment();
    }

    @Test(dataProvider = "creditCardData", dependsOnMethods = {"goTillCheckout"})
    public void checkoutFlowTest(String cardNumber, String expiryDate, String cvv, String otp){
        cardDetailsPage = new CardDetailsPage(driver);
        cardDetailsPage.enterCreditCardDetails(cardNumber, expiryDate, cvv);
        cardDetailsPage.clickPayNowButton();
        Assert.assertTrue(driver.getTitle().matches("SUCCESSFUL"), "FAILED");

    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }

    @DataProvider(name="creditCardData")
    public Object[][] testDataExample(){
        ReadExcelFile config = new ReadExcelFile(path+"/src/test/java/testData/CreditCardDetails.xlsx");
        int rows = config.getRowCount(0);
        Object[][]data = new Object[rows][4];

        for(int i=0;i<rows;i++)
        {
            data[i][0] = config.getData(0, i, 0);
            data[i][1] = config.getData(0, i, 1);
            data[i][2] = config.getData(0, i, 2);
            data[i][3] = config.getData(0, i, 3);

        }
        return data;
    }
}
