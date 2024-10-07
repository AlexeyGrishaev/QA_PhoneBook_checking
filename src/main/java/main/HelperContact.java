package main;

import dto.ContactDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperContact extends HelperBase{
    public HelperContact(WebDriver wd) {
        super(wd);
    }
    By buttonAdd = By.xpath("//a[@href='/add']");

    By inputName = By.xpath("//input[@placeholder='Name']");
    By inputLastName = By.xpath("//input[@placeholder='Last Name']");
    By inputPhone = By.xpath("//input[@placeholder='Phone']");
    By inputEmail = By.xpath("//input[@placeholder='email']");
    By inputAddress = By.xpath("//input[@placeholder='Address']");
    By inputDescription = By.xpath("//input[@placeholder='description']");

    By btnSave = By.xpath("//button[text()='Save']");
    public void openContactForm(){
        clickBaseWait(buttonAdd,5);
    }

    public void fillContactForm(ContactDTO contact){
        typeBase(inputName,contact.getName());
        typeBase(inputLastName,contact.getLastName());
        typeBase(inputPhone,contact.getPhone());
        typeBase(inputEmail,contact.getEmail());
        typeBase(inputAddress,contact.getAddress());
        typeBase(inputDescription,contact.getDescription());
    }
    public void submitNewContact(){
        clickBaseWait(btnSave,5);
    }
}
