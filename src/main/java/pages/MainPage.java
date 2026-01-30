package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.Constants.DEFAULT_TIMEOUT;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    //Заголовок Digest Authentication
    private final By digestAuthenticationLocator = By.xpath("//a[text()='Digest Authentication']");


    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
    }

    @Step("Клик по гиперссыке 'Digest Authentication'")
    public void clickLoginLink() {
        wait.until(ExpectedConditions.elementToBeClickable(digestAuthenticationLocator)).click();
    }
}


