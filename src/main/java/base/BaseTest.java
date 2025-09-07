package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    private static final ThreadLocal<WebDriver> TL_DRIVER = new ThreadLocal<>();

    private final String baseUrl = "https://demo.nopcommerce.com";
    private final int implicitWait = 5;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        TL_DRIVER.set(driver);

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        getDriver().manage().window().maximize();
        getDriver().get(baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            TL_DRIVER.remove();
        }
    }

    // 🔹 Make sure this exists and is public static
    public static WebDriver getDriver() {
        return TL_DRIVER.get();
    }
}
