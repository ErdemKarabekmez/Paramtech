package com.param.pages;

import com.param.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    /***
    Bu classta Login Page ile ilgili locatorlar bulunmaktadır.
    ***/
    public LoginPage() {
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy (id = "menu_login")
    public WebElement girisYap;

    @FindBy (xpath = "(//a[@class='btn btn-outline-primary btn-icon'])[1]")
    public WebElement kurumsalGiris;

    @FindBy (xpath = "//input[@type='number']")
    public WebElement gsmNo;

    @FindBy (xpath = "//input[@type='password']")
    public WebElement sifre;

    @FindBy (xpath = "//button[@id='loginbutton']")
    public WebElement girisYapButonu;

    @FindBy (xpath = "//div[@class='modalTitle___WE5UD']")
    public WebElement uyarıMesajı;


}
