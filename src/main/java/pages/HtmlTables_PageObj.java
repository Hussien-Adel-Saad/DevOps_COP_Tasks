package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class HtmlTables_PageObj {

    private WebDriver driver;

    // -------------Constructor-------------------//
    public HtmlTables_PageObj(WebDriver driver) {
        this.driver = driver;
    }

    // -------------Page Actions-------------------//
    public String getCountryByCompanyName(String companyName) {
        By country = By.xpath(String.format("//td[normalize-space()='%s']/following-sibling::td[2]", companyName));
        return WaitUtils.waitForVisibility(driver,country).getText();
    }

}
