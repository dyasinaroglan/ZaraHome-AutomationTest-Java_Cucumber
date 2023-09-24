package com.testinium.step;

import com.testinium.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseStep extends BaseTest{

    WebDriverWait wait = new WebDriverWait(BaseTest.driver,2);

    public void clickTo(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }
    public void clickToBy(By element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void sendKeys(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }
    public void sendKeysBy(By element, String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element)).sendKeys(text);
    }

}
