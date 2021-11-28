package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class AddExpensePage extends BasePage {
    enum KeyboardLayout {MINUS, PLUS, MULTIPLY, DIVIDE, EQUALS, DOT}

    public AddExpensePage(AndroidDriver _driver) {
        super(_driver);
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    @AndroidFindBy(id = "amount_text")
    private AndroidElement amountText;

    @AndroidFindBy(id = "textViewNote")
    private AndroidElement textViewNote;

    @AndroidFindBy(id = "keyboard_action_button")
    private AndroidElement chooseCategoryButton;

    @AndroidFindBy(id = "account_spinner")
    private AndroidElement paymentMode;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Cash']")
    private AndroidElement paymentModeCash;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Payment card']")
    private AndroidElement paymentModeCard;

    @AndroidFindBy(id = "buttonKeyboardClear")
    private AndroidElement amountClearButton;

    private AndroidElement calculatorNumberButton(char number) {
        String id = "buttonKeyboard" + number;
        return (AndroidElement) this.driver.findElement(By.id(id));
    }

    private AndroidElement calculatorActionButton(String action) {
        String id = "buttonKeyboard" + action;
        return (AndroidElement) this.driver.findElementByAccessibilityId(id);
    }

    private AndroidElement getCategoryButton(String category) {
        return (AndroidElement) this.driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + category + "\")");
    }

    public DashboardPage fillDetails(String category, String paymentMode, int amount, String note) {
        this.setPaymentMode(paymentMode);
        for (char number : Integer.toString(amount).toCharArray()) {
            this.calculatorNumberButton(number).click();
        }
        this.textViewNote.sendKeys(note);
        this.chooseCategoryButton.click(); //new UiSelector().text("CHOOSE CATEGORY")
        this.getCategoryButton(category).click();
        return new DashboardPage(driver);
    }

    public void clearAmount() {
        int charLength = this.amountText.getText().toCharArray().length;
        for (int i = 0; i <= charLength; i++) {
            this.amountClearButton.click();
        }
    }

    private void setPaymentMode(String mode) {
        this.paymentMode.click();
        if (mode.equalsIgnoreCase("card"))
            this.paymentModeCard.click();
        else
            this.paymentModeCash.click();
    }
}
