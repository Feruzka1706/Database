package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utility.ConfigReader;
import utility.DB_Util;
import utility.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    /**
     * This @Before  for UI part
     */
    @Before("@ui")
    public void setupDriver() {
        // set up implicit wait
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // you can add maximize browser if you want to do it
        // Driver.getDriver().manage().window().maximize();
    }



    /**
     * This @After for UI part
     * @param scenario
     */
    @After("@ui")
    public void tearDown(Scenario scenario) {

        // check if scenario failed or not
        if(scenario.isFailed()){
            //this is how we take screenshot in selenium
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            // scenario.attach(screenshot,"image/png","what ever we want");
            scenario.attach(screenshot,"image/png","Image for failed step");
        }
        Driver.closeBrowser();
    }

    @Before("@db")
    public void dbSetup() {

        String url= ConfigReader.read("library2.database.url");
        String username=ConfigReader.read("library2.database.username");
        String password=ConfigReader.read("library2.database.password");

        DB_Util.createConnection(url,username,password);

    }



    @After("@db")
    public void dbTearDown() {

        DB_Util.destroy();
    }



}
