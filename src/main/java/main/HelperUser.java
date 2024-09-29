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
        try {
            return isElementPresent(btnSignOut);
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    public boolean isAlertPresent(String message) {
        Alert alert = new WebDriverWait(wd, 10).until(ExpectedConditions.alertIsPresent());
        if (alert != null && alert.getText().contains(message)) {
            alert.accept();
            return true;
        }
        return false;
    }

    public void logout() {
        clickBaseWait(btnSignOut,5);
    }
}
