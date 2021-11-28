package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage {

    public DashboardPage(AndroidDriver _driver) {
        super(_driver);
        ;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    @AndroidFindBy(accessibility = "Settings")
    private AndroidElement settingsKebabMenu;

    @AndroidFindBy(id = "expense_amount_text")
    private AndroidElement expenseAmountTextInChart;

    @AndroidFindBy(id = "income_amount_text")
    private AndroidElement incomeAmountTextInChart;

    @AndroidFindBy(id = "balance_amount")
    private AndroidElement balanceAmount;

    @AndroidFindBy(id = "expense_button")
    private AndroidElement expenseButton;

    @AndroidFindBy(id = "income_button")
    private AndroidElement incomeButton;

    @AndroidFindBy(id = "snackbar_action")
    private AndroidElement snackbarMessageCancelButton;

    @AndroidFindBy(id = "categories_button")
    private AndroidElement rightSideBarCategoriesButton;

    @AndroidFindBy(id = "leftLinesImageView")
    private AndroidElement expandTransactions;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.monefy.app.lite:id/piegraph']//android.widget.ImageView[2]")
    private AndroidElement carExpenseIcon;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.monefy.app.lite:id/piegraph']//android.widget.TextView[@index='5']")
    private AndroidElement carExpensePercentage;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.monefy.app.lite:id/piegraph']//android.widget.ImageView[5]")
    private AndroidElement houseExpenseIcon;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.monefy.app.lite:id/piegraph']//android.widget.TextView[@index='5']")
    private AndroidElement houseExpensePercentage;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.TextView")
    private AndroidElement popUps;

    private AndroidElement getCategoryFromExpandedList(String category) {
        return (AndroidElement) this.driver.findElement(By.xpath("//android.widget.ExpandableListView//android.widget.TextView[@text='" + category + "']"));
    }

    private AndroidElement getExpense(String note) {
        return (AndroidElement) this.driver.findElement(By.xpath("//*[@resource-id='com.monefy.app.lite:id/textViewTransactionNote'][@text='" + note + "']"));
    }

    public AddExpensePage addExpense() {
        waitUntilInvisible(this.snackbarMessageCancelButton);
        this.expenseButton.click();
        return new AddExpensePage(driver);
    }

    public AddExpensePage addIncome() {
        this.waitUntilClickable(this.incomeButton);
        this.incomeButton.click();
        return new AddExpensePage(driver);
    }

    public void tacklePopIssue() {
        for (int i = 0; i < 4; i++) {
            this.settingsKebabMenu.click();
            sleep(1000);
            this.settingsKebabMenu.click();
        }
        try {
            if (this.rightSideBarCategoriesButton.isDisplayed())
                this.settingsKebabMenu.click();
        } catch (Exception ignore) {

        }
    }

    public String getBalanceAmount() {
        return this.balanceAmount.getText().split(" ")[1].replace("$", "");
    }

    public String getTotalIncome() {
        return this.incomeAmountTextInChart.getText();
    }

    public String getTotalExpense() {
        return this.expenseAmountTextInChart.getText();
    }

    public void toggleListOfExpenses() {
        waitUntilClickable(this.expandTransactions);
        this.expandTransactions.click();
    }

    public void expandSpecificCategoryExpenses(String category) {
        this.getCategoryFromExpandedList(category).click();
    }

    public AddExpensePage modifyExpense(String note) {
        this.getExpense(note).click();
        return new AddExpensePage(driver);
    }
}
