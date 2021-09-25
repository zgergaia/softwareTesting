import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;


public class WebElementsTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void task1() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        var text = driver.findElement(By.xpath("//button[text()='Add Element']"));
        for (int i = 0; i < 3; i++) {
            text.click();
        }
        WebElement delete_btn = driver.findElement(By.xpath("//button[text()='Delete']//following::button[2]"));
        System.out.println(delete_btn.getText());

        List<WebElement> delete_btns = driver.findElements(By.cssSelector("button[class^='added']"));
        System.out.println(delete_btns.get(delete_btns.size() - 1).getText());
    }

    @Test
    public void task2() {
        driver.get("http://the-internet.herokuapp.com/challenging_dom");
        WebElement ipsum = driver.findElement(By.xpath("//td[text()='Apeirian9']//preceding::td[1]"));
        System.out.println(ipsum.getText());
        WebElement next = driver.findElement(By.xpath("//td[text()='Apeirian9']//following::td"));
        System.out.println(next.getText());
    }

    @AfterTest
    public void shutDown() {
        driver.quit();
    }

}
