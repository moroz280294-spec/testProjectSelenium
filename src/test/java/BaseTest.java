import io.qameta.allure.Allure;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverManager;

import java.awt.*;

import static utils.Constants.BASE_URL;

public abstract class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;

    @Before
    public void setUp() {
        if (driver == null) {
            // Получаем браузер из системного свойства, по умолчанию chrome
            String browser = System.getProperty("browser", "chrome");

            // Запуск браузера
            driver = DriverManager.createDriver(browser);
            driver.manage().window().setSize(new Dimension(1920, 1080));
            driver.get(BASE_URL);

            // Инициализация страниц
            loginPage = new LoginPage(driver);
            Allure.description("Тест запущен в браузере: " + browser);
        }

        @After
        public void tearDown () {
            if (driver != null) {
                driver.quit();
            }

        }
    }
}

