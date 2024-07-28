package com.param.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ReusableMethods {

    /***
     Bu classta projede kullanılan bazı metodlar bulunmaktadır.
     ***/


    /***
     Bu metod Selenium ile click yapamadığımız elementlere JavaScript kullanarak click yapmamızı sağlar.
     ***/
    public void clickWithJS (WebElement element){

        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].click();", element);
    }

    /***
     Bu metod yeni açılan taba geçişi sağlar.
     ***/
    public void switchToWindow(String currentWindow){

        for (String windowHandle : Driver.get().getWindowHandles()) {
            if (!currentWindow.contentEquals(windowHandle)) {
                Driver.get().switchTo().window(windowHandle);
                break;
            }
        }

    }
}
