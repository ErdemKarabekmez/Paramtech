package com.param.step_definitions;

import com.param.pages.LoginPage;
import com.param.utilities.ConfigurationReader;
import com.param.utilities.Driver;
import com.param.utilities.ReusableMethods;
import io.cucumber.java.en.*;
import org.junit.Assert;



public class LoginSteps extends ReusableMethods {

    LoginPage loginPage = new LoginPage();

    @Given("Kullanıcı ana sayfaya gider")
    public void kullanıcı_ana_sayfaya_gider() {

        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("Kullanıcı anasayfada yer alan giriş yap butonuna tıklar")
    public void kullanıcı_anasayfada_yer_alan_giriş_yap_butonuna_tıklar() {

        clickWithJS(loginPage.girisYap);
    }

    @When("Kullanıcı Kurumsal Giriş butonuna tıklar ve yeni sayfaya geçer")
    public void kullanıcı_kurumsal_giriş_butonuna_tıklar_ve_yeni_sayfaya_geçer() {

        String currentWindow = Driver.get().getWindowHandle();
        clickWithJS(loginPage.kurumsalGiris);
        switchToWindow(currentWindow);

    }

    @When("Kullanıcı geçersiz bilgilerle giriş yapmayı dener")
    public void kullanıcı_geçersiz_bilgilerle_giriş_yapmayı_dener() throws InterruptedException {

        loginPage.gsmNo.sendKeys("1234567890");
        loginPage.sifre.sendKeys("123456");
        clickWithJS(loginPage.girisYapButonu);
    }

    @Then("Kullanıcı bilgilerin hatalı olduğu uyarısını doğrular")
    public void kullanıcıBilgilerinHatalıOlduguUyarısınıDogrular() {

        String expectedValidasyonUyarısı = "Hatalı bilgi girişi yaptınız.\n" +
                " Lütfen bilgilerinizi kontrol ediniz.";

        String actualValidasyonUyarısı = loginPage.uyarıMesajı.getText();

        Assert.assertEquals(expectedValidasyonUyarısı, actualValidasyonUyarısı);
        Driver.closeDriver();
    }
}
