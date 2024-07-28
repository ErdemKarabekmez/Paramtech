Feature: Geçersiz bilgiler(credentials) ile Login olunamaması

  @scenario1
  Scenario: Kurumsal giriş seçeneği seçilerek yanlış kullanıcı adı ve şifre ile giriş yapılarak verilen validasyon uyarısının doğrulanması
    Given Kullanıcı ana sayfaya gider
    When Kullanıcı anasayfada yer alan giriş yap butonuna tıklar
    And Kullanıcı Kurumsal Giriş butonuna tıklar ve yeni sayfaya geçer
    And Kullanıcı geçersiz bilgilerle giriş yapmayı dener
    Then Kullanıcı bilgilerin hatalı olduğu uyarısını doğrular


