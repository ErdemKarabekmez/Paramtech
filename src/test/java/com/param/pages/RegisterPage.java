package com.param.pages;

import com.param.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    /***
     Bu classta Register Page ile ilgili locatorlar ve metodlar bulunmaktadır.
     ***/
    public RegisterPage() {
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy (xpath = "//span[@class='signUp___3OOhy']")
    public WebElement hesapOluştur;

    @FindBy (xpath = "//input[@placeholder='Ad']")
    public WebElement adKutusu;

    @FindBy (xpath = "//input[@placeholder='Soyad']")
    public WebElement soyadKutusu;

    @FindBy (xpath = "//input[@placeholder='E-Posta Adresi']")
    public WebElement epostaAdresiKutusu;

    @FindBy (xpath = "//input[@placeholder='GSM Numarası']")
    public WebElement gsmNumarasıKutusu;

    @FindBy (xpath = "//div[@name='checkBox1']")
    public WebElement checkBox1;

    @FindBy (xpath = "//div[@name='checkBox2']")
    public WebElement checkBox2;

    @FindBy (xpath = "//div[@name='checkBox3']")
    public WebElement checkBox3;

    @FindBy (xpath = "//button[@id='continue_from_signup']")
    public WebElement devamButonu;

    @FindBy (xpath = "//button[@id='continue_from_otp']")
    public WebElement onaylaButonu;

    @FindBy (xpath = "//div[@id='errorVerificationNo']")
    public WebElement uyarıMesajı;

    /***
     Bu metod OTP ekranına onay kodunu girmektedir.
     ***/
    public void onayKoduGirme(){

        for (int i=1;i<7;i++){
           WebElement input = Driver.get().findElement(By.xpath("//input[@name='input" + i + "']"));
           input.sendKeys("0");
        }




    }

}
