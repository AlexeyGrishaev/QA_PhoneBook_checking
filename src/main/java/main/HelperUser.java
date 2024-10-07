package main;

import dto.StudentDTO;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    By btnLogin = By.xpath("//a[@href='/login']");
    By inputEmail = By.xpath("//input[@name='email']");
    By inputPassword = By.xpath("//input[@name='password']");
    By btnSubmitLogin = By.xpath("//button[@name='login']");
    By btnSubmitRegistration = By.xpath("//button[@name='registration']");
    By btnSignOut = By.xpath("//button[text()='Sign Out']");
    By headerNoContacts = By.xpath("//div[@class='contact-page_message__2qafk']/h1");


    public boolean isNoContactsHere(){
        return new WebDriverWait(wd,5).until(ExpectedConditions.textToBePresentInElement(findElementBase(headerNoContacts),"No Contacts here!"));
    }
    public void openLoginRegistrationForm() {
        clickBaseWait(btnLogin, 5);
    }

    public void fillLoginRegistrationForm(StudentDTO student) {
        typeBase(inputEmail, student.getUserName());
        typeBase(inputPassword, student.getPassword());
    }

    public void submitLogin() {
        clickBaseWait(btnSubmitLogin, 5);
    }

    public boolean isElementSignOutPresent() {
        return isElementPresent(btnSignOut);
    }


    public boolean isAlertPresent(String message) {
        Alert alert = new WebDriverWait(wd, 5).until(ExpectedConditions.alertIsPresent());
        if (alert != null && alert.getText().contains(message)) {
            alert.accept();
            return true;
        }
        return false;
    }

    public void logout() {
        clickBaseWait(btnSignOut, 5);
    }

    public void submitRegistration() {
        clickBaseWait(btnSubmitRegistration, 5);
    }


}
