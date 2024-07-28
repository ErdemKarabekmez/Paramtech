package com.param.step_definitions;

import com.param.pages.RegisterPage;
import com.param.utilities.Driver;
import com.param.utilities.ReusableMethods;
import io.cucumber.java.en.*;
import org.junit.Assert;


public class RegisterSteps extends ReusableMethods {

    RegisterPage registerPage = new RegisterPage();

    @And("Kullanıcı Giriş Yap butonunun altında bulunan Hesap Oluştur seçeneğini tıklar")
    public void kullanıcıGirisYapButonununAltındaBulunanHesapOlusturSeceneginiTıklar() {

        clickWithJS(registerPage.hesapOluştur);
    }

    @And("Kullanıcı hesap oluşturmak için gerekli bilgileri doldurur")
    public void kullanıcıHesapOlusturmakIcinGerekliBilgileriDoldurur() {

        registerPage.adKutusu.sendKeys("Test");
        registerPage.soyadKutusu.sendKeys("Test");
        registerPage.epostaAdresiKutusu.sendKeys("test3467@gmail.com");
        registerPage.gsmNumarasıKutusu.sendKeys("5441228244");
    }

    @And("Kullanıcı hesap oluşturmak için gerekli checkBoxları işaretler ve devam butonuna tıklar")
    public void kullanıcıHesapOlusturmakIcinGerekliCheckBoxlarıIsaretlerVeDevamButonunaTıklar() {

        registerPage.checkBox1.click();
        registerPage.checkBox2.click();
        clickWithJS(registerPage.checkBox3);
        clickWithJS(registerPage.devamButonu);
    }

    @And("Kullanıcı OTP ekranında yanlış şifre girer ve onayla butonuna basar")
    public void kullanıcıOTPEkranındaYanlısSifreGirerVeOnaylaButonunaBasar() {

        registerPage.onayKoduGirme();
        clickWithJS(registerPage.onaylaButonu);
    }

    @Then("Kullanıcı onay kodunun hatalı olduğu uyarısını doğrular")
    public void kullanıcıOnayKodununHatalıOlduguUyarısınıDogrular() {

        String expectedValidasyonUyarısı = "Girdiğiniz onay kodu hatalıdır.";

        String actualValidasyonUyarısı = registerPage.uyarıMesajı.getText();

        Assert.assertEquals(expectedValidasyonUyarısı, actualValidasyonUyarısı);
        Driver.closeDriver();
    }



}
