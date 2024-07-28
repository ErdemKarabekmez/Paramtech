Feature: Hesap oluştururken yanlış OTP şifresi girilmesi

  @scenario2
  Scenario: OTP Ekranında yanlış şifre girişi yapılarak verilen validasyon uyarısının doğrulanması
    Given Kullanıcı ana sayfaya gider
    When Kullanıcı anasayfada yer alan giriş yap butonuna tıklar
    And Kullanıcı Kurumsal Giriş butonuna tıklar ve yeni sayfaya geçer
    And Kullanıcı Giriş Yap butonunun altında bulunan Hesap Oluştur seçeneğini tıklar
    And Kullanıcı hesap oluşturmak için gerekli bilgileri doldurur
    And Kullanıcı hesap oluşturmak için gerekli checkBoxları işaretler ve devam butonuna tıklar
    And Kullanıcı OTP ekranında yanlış şifre girer ve onayla butonuna basar
    Then Kullanıcı onay kodunun hatalı olduğu uyarısını doğrular



