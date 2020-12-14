package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import page.ReluiPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ReluiTest {

    private static WebDriver driver;

    @BeforeAll
    static void BrowserSetup(){
        System.setProperty("webdriver.chrome.driver","/C:/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeEach
    public void clearCookies(){
        //Удалил всё куки
        driver.manage().deleteAllCookies();
    }

    @Test
    void AddingItemsToCartTest(){
        WebElement itemName = new ReluiPage(driver)
                .openPage()
                .addToCart()
                .goToCart()
                .getNameOfFirstItem();
        assertTrue(itemName.isDisplayed());
    }

    @Test
    void ChooseColorAndAddToCartTest(){
        WebElement itemColor=new ReluiPage(driver)
                .openPage()
                .goToProduct()
                .chooseColor("13")
                .addToBag()
                .goToBag()
                .getProductColor();
        assertTrue(itemColor.isDisplayed());
    }

    @AfterAll
    static void driverShutDown(){
        driver.quit();
        driver=null;
    }
}
