package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass {

	@FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")
	WebElement bankWireMethod;

	@FindBy(xpath = "//a[@title='Pay by check.']")
	WebElement payByCheckMethod;

	@FindBy(xpath = "//button[contains(@class,'button btn')]/span")
	WebElement confirmOrderBtn;

	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public OrderSummary clickOnPaymentMethod() {
		
		Action.explicitWait(getDriver(), bankWireMethod, 15);
		Action.click(getDriver(), bankWireMethod);
		return new OrderSummary();
	}

}
