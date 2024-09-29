package main;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public WebElement findElementBase(By locator) {
        return wd.findElement(locator);
    }

    public void clickBaseWait(By locator, int time) {
        new WebDriverWait(wd, time).until(ExpectedConditions.elementToBeClickable(locator)).click();

    }

    public void typeBase(By locator, String text) {
        WebElement element = findElementBase(locator);
        element.click();
        element.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        element.sendKeys(text);

    }

    public void pause(int time) {
        try {
            Thread.sleep(1000L * time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isElementPresent(By locator) {
        return  wd.findElement(locator).isDisplayed();
    }
}
