package page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ReluiPage extends Page {

    private static final String HOMEPAGE_URL = "https://relouis.by/collection/complimenti/";

    @FindBy(xpath = "//div[@datatype=\"4810438013055\"]")
    private WebElement addButton;

    @FindBy(xpath ="//div[@datatype=\"3\"]]")
    private WebElement addProductButton;

    public ReluiPage(WebDriver driver){
        super(driver);
    }
    public ReluiPage openPage() {

        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(jQueryAJAXCompleted());
        return this;

    }
    public ReluiPage addToCart() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(addButton))
                .click();
        return this;
    }
    public ReluiBagPage goToCart() {
        WebElement goToCartButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Перейти в корзину")));
          new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                  .until(ExpectedConditions.elementToBeClickable(goToCartButton));
        goToCartButton.click();
       return new ReluiBagPage(driver);
    }
    public ReluiProductPage goToProduct(){
        WebElement goToCartButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(addProductButton));
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(goToCartButton));
        goToCartButton.click();
        return new ReluiProductPage(driver);
    }
}
