package tests;

import dto.StudentDTO;
import main.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests extends TestBase {
    @AfterMethod
    public void preCondition(){
        if(app.getHelperUser().isElementSignOutPresent()){
            app.getHelperUser().logout();
        }
    }

    @Test
    public void loginPositiveTest(){
        StudentDTO studentDTO = StudentDTO.builder()
                .userName("locker@gmail.com")
                .password("Qwerty1234!")
                .build();
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(studentDTO);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isElementSignOutPresent());
    }
    @Test
    public void loginWrongEmail(){
        StudentDTO studentDTO = StudentDTO.builder()
                .userName("lockergmail.com")
                .password("Qwerty1234!")
                .build();
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(studentDTO);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }
    @Test
    public void loginWrongPassword(){
        StudentDTO studentDTO = StudentDTO.builder()
                .userName("locker@gmail.com")
                .password("Qw34")
                .build();
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(studentDTO);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }
}
