package tests;

import core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HtmlTables_PageObj;

public class HtmlTablesTest {
    private WebDriver driver;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setup() {
        driver = DriverManager.getDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        softAssert = new SoftAssert();

    }

    @Test
    public void testGetCountryByCompanyName() {
        HtmlTables_PageObj htmlTablesPageObj = new HtmlTables_PageObj(driver);

        String actualCountry = htmlTablesPageObj.getCountryByCompanyName("Ernst Handel");
        softAssert.assertEquals(actualCountry,"Austria","Not the right country for selected company");
        System.out.println("Country is :" + actualCountry);

        actualCountry = htmlTablesPageObj.getCountryByCompanyName("Alfreds Futterkiste");
        softAssert.assertEquals(actualCountry,"Germany","Not the right country for selected company");
        System.out.println("Country is :" + actualCountry);

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
