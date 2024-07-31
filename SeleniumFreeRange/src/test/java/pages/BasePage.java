package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
    /*
     * Declaration of a static variable 'Driver' type WebDriver
     * This variable is gonna be share with the other instances of BasePage an his subclasses
    */
    protected static WebDriver driver;
    /*
     * Declaration of the variable 'wait' type WebDriver
     * Initialization WebDriverWait using static 'driver'
     * WebDriverWait the use is for explicit waits in the web elements
    */
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    /*
     * Config the WebDriver for Chrome using WebDriverManager
     * WebDriverManager is gonna be downloading and updating automatically the web driver
    */

    static {
        WebDriverManager.chromedriver().setup();

        // Inicializa la variable estatica 'driver' con una instancia de ChromDriver
        driver = new ChromeDriver();
    }

    // Este es el constructor de BasePage que acepta un objeto WebDriver como argumento
    public BasePage(WebDriver driver){
        BasePage.driver = driver;
    }

    // Método estático para navegar a una URL
    public static void navigateTo(String url) {
        driver.get(url);
    }

    public static void closeBrowser(){
        driver.quit();
    }

    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator){
        Find(locator).click();
    }

    public void write(String locator, String keysToSend){
        Find(locator).clear();
        Find(locator).sendKeys(keysToSend);
    }

    public void selectFromDropdownByValue(String locator, String value){
        Select dropdown = new Select(Find(locator));

        dropdown.selectByValue(value);
    }

    public void selectFromDropdownByIndex(String locator, Integer index){
        Select dropdown = new Select(Find(locator));

        dropdown.selectByIndex(index);
    }

    public int dropdownSize(String locator){
        Select dropdown = new Select(Find(locator));

        List<WebElement> dropdownOptions = dropdown.getOptions();

        return dropdownOptions.size();
    }

    public List<String> getDropdownValues(String locator) {
        Select dropdown = new Select(Find(locator));

        List<WebElement> dropdownOptions = dropdown.getOptions();
        List<String> values = new ArrayList<>();
        for(WebElement option : dropdownOptions) {
            values.add(option.getText());
        }

        return values;
    }
}