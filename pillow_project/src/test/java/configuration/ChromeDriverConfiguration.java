package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChromeDriverConfiguration {
    WebDriver driver;
    static Logger log = LoggerFactory.getLogger(ChromeDriverConfiguration.class);

    public ChromeDriverConfiguration(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver startChromeDriver() {
        try {
            String path = System.getProperty("user.dir");
            System.setProperty("webdriver.chrome.driver",path+"/src/test/resources/driver/chromedriver");
            driver = new ChromeDriver();
        } catch(Exception e){
            log.error("Unable to open Chrome Driver");
            e.printStackTrace();
        }
        return driver;
    }
}
