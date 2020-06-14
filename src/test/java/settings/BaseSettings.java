package settings;

import io.restassured.RestAssured;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseSettings {

    private static Properties prop;
    private static final String configFilePath = "src/test/resources/config.properties";

    @BeforeClass
    public void baseSettings() throws IOException {
        readPropertyFileValues();
        setEnvironmentForTest();
    }


    protected void readPropertyFileValues() throws IOException {
        prop = new Properties();
        try (FileInputStream fis = new FileInputStream(configFilePath)) {
            prop.load(fis);
        }
        System.getenv().forEach((key, value) -> prop.setProperty(key, value));
    }

    public static void setEnvironmentForTest() {
        RestAssured.reset();
        RestAssured.baseURI = prop.getProperty("baseURI");
    }

    public static String getSampleAmazonUrl() {
        return prop.getProperty("sampleAmazonUrl");
    }

    public static String getAmazonProfile() {
        return prop.getProperty("amazonProfile");
    }

    public static String getAmazonRegion() {
        return prop.getProperty("region");
    }

    public static String basePath() {
        return prop.getProperty("basePath");
    }

    public static String baseURI() {
        return prop.getProperty("baseURI");
    }


}
