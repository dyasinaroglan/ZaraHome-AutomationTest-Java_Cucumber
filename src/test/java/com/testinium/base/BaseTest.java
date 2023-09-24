package com.testinium.base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import net.bytebuddy.pool.TypePool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseTest {

    //Instance Veriables
    protected static WebDriver driver;
    protected static Actions actions;
    protected Logger logger = (Logger) LoggerFactory.getLogger(getClass());
    ChromeOptions chromeOptions;
    FirefoxOptions firefoxOptions;
    DesiredCapabilities capabilities;

    String browserName = "chrome";
    String selectPlatform = "win";
    String gotoUrl = "https://www.zarahome.com/tr/";

    @Before
    public void setUp() {
        logger.info("*************************BeforeStep***********************");
        try {
            logger.info("Local cihazda " + selectPlatform + " ortamında " + browserName + " browserında test ayağa kalkacak.");
            if ("win".equalsIgnoreCase(selectPlatform)) {
                if ("chrome".equalsIgnoreCase(browserName)) {
                    driver = new ChromeDriver(chromeOptions());
                    driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
                    driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
                    driver.get(gotoUrl);
                } else if ("firefox".equalsIgnoreCase(browserName)) {
                    driver = new FirefoxDriver(firefoxOptions);
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
                    driver.get(gotoUrl);
                }
            } else if ("windows".equalsIgnoreCase(selectPlatform)) {
                if ("chrome".equalsIgnoreCase(browserName)) {
                    driver = new ChromeDriver(chromeOptions());
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
                    driver.get(gotoUrl);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
            logger.info("Hata oluştu : " + e.getMessage());
        }
    }
    @After
    public void quitDriver(){
        driver.quit();
    }
    public ChromeOptions chromeOptions(){
        chromeOptions = new ChromeOptions(); //chromeOptions oluşturuyoruz. bir kutu oluşturmak
        capabilities = DesiredCapabilities.chrome(); //chrome'un yeteneklerini oluşturuyoruz. Kutuya koyacak özelliklerin listesi
        Map<String, Object> prefs = new HashMap<>(); // Tarayıcı özelliştirmek için prefs oluşturuyoruz
        prefs.put("profile.default_content_setting_values.notifications",2); //web sitenin gönderdiği bildirimleri bildirimleri kapatıyoruz. evinizdeki kapı zilini kapatmak gibi
        chromeOptions.setExperimentalOption("prefs", prefs);
        chromeOptions.addArguments("--kiosk");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--start-fullscreen");
        System.setProperty("webdriver.chrome.driver", "web_driver/chromedriver.exe"); //chromeDriver'ın bilgisayarınızda nerede olduğunu belirtiyorsunuz. evin anahtarı ile kapıyı açmak gibi
        chromeOptions.merge(capabilities); //bu kutuyu oluşturduğumuz capabilities ile birleştiriyoruz. Kutunun içine oluşturduğumuz özellikleri içine atma
        return chromeOptions; //chromeoptions döndürmek. Bu hazırladığımız kutuyu kullanıma sunmak gibi
    }
}

