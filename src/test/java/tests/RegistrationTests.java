package tests;

import dto.StudentDTO;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase {
    @AfterMethod
    public void preCondition(){
        if(app.getHelperUser().isElementSignOutPresent()){
            app.getHelperUser().logout();
        }
    }
    @Test
    public void registrationPositiveTest() {
        int i = (int) (System.currentTimeMillis()/1000)%3600;
        StudentDTO studentDTO = StudentDTO.builder()
                .userName("locker"+i+"@gmail.com")
                .password("Qwerty1234!")
                .build();
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(studentDTO);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isElementSignOutPresent());
        Assert.assertTrue(app.getHelperUser().isNoContactsHere());
    }

    @Test
    public void registrationWrongEmail() {

        StudentDTO studentDTO = StudentDTO.builder()
                .userName("lockergmail.com")
                .password("Qwerty1234!")
                .build();//ss
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(studentDTO);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));

    }

    @Test
    public void registrationWrongPassword() {

        int i = (int) (System.currentTimeMillis()/1000)%3600;
        StudentDTO studentDTO = StudentDTO.builder()
                .userName("locker"+i+"@gmail.com")
                .password("werty")
                .build();
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(studentDTO);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));

    }
    @Test
    public void registrationExistUser() {

        int i = (int) (System.currentTimeMillis()/1000)%3600;
        StudentDTO studentDTO = StudentDTO.builder()
                .userName("locker@gmail.com")
                .password("Qwerty1234!")
                .build();
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(studentDTO);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));

    }

}
