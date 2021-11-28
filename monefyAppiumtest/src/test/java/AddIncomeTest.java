import PageObjects.DashboardPage;
import Utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddIncomeTest {
    static AndroidDriver driver;
    private DashboardPage dashboard;

    @BeforeAll
    public static void setup() {
        driver = DriverManager.openDriver();
    }

    @BeforeEach
    public void launch() {
        DriverManager.launchApp();
        dashboard = new DashboardPage(driver);
    }

    @AfterAll
    public static void tearDown() {
        DriverManager.closeDriver();
    }

    @Test
    public void shouldBeAbleToAddIncome() {
        dashboard.addIncome()
                .fillDetails("Salary", "Cash", 120000, "Salary Nov-21");
        assertEquals(dashboard.getTotalIncome(), "$120,000.00");
    }
}
