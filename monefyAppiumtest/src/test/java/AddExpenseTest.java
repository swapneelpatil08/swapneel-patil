import PageObjects.AddExpensePage;
import PageObjects.DashboardPage;
import Utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddExpenseTest {
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
    public void shouldBeAbleToAddExpenses() {
        dashboard.tacklePopIssue();
        dashboard.addExpense()
                .fillDetails("Car", "Cash", 15000, "CarEMI")
                .addExpense()
                .fillDetails("House", "Cash", 20000, "House Rent")
                .addExpense()
                .fillDetails("Bills", "Card", 1000, "Broadband bill")
                .addExpense()
                .fillDetails("Bills", "Cash", 700, "Telephone bill")
                .addExpense()
                .fillDetails("Bills", "Card", 800, "Electricity bill")
                .addExpense()
                .fillDetails("Car", "Cash", 4000, "Fuel bill");
        assertEquals(dashboard.getTotalExpense(), "$41,500.00");
    }

    @Test
    public void shouldBeAbleToEditExpenses() {
        dashboard.tacklePopIssue();
        dashboard.addExpense().fillDetails("Bills", "Card", 800, "Electricity bill");
        dashboard.toggleListOfExpenses();
        dashboard.expandSpecificCategoryExpenses("Bills");
        AddExpensePage addExpensePage = dashboard.modifyExpense("Electricity bill");
        addExpensePage.clearAmount();
        addExpensePage.fillDetails("Bills", "Card", 1200, "Updated Electricity bill");
        dashboard.toggleListOfExpenses();
        assertEquals(dashboard.getTotalExpense(), "$1,200.00");
    }
}
