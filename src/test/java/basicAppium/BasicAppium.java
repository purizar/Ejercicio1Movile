package basicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasicAppium {

    private AppiumDriver driver;

    @BeforeEach
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Cato");
        capabilities.setCapability("platformVersion","9");
        capabilities.setCapability("appPackage","com.android.calculator2");
        capabilities.setCapability("appActivity","com.android.calculator2.Calculator");
        capabilities.setCapability("platformName","Android");
        driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        // implicit 8 appium
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }

    @AfterEach
    public void cleanup(){
        driver.quit();
    }

    @Test
    public void verifyCalculator() throws InterruptedException {
        //   5+3 = 8

        //click button 5
        driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();
        // click button +
        driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
        // click button 3
        driver.findElement(By.id("com.android.calculator2:id/digit_3")).click();
        // click  button =
        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"equals\"]")).click();

        // verification expected vs actual
        String expectedResult="8";
        String actualResult= driver.findElement(By.id("com.android.calculator2:id/result")).getText();
        Assertions.assertEquals( expectedResult,actualResult," ERROR !! la suma esta mal");

        Thread.sleep(5000);
    }

}
