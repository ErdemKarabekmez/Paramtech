Feature: Api üzerinden yeni kayıt oluşturulması ve oluşturulan yeni kaydın silinmesi

  @scenario3
  Scenario: Restful-booker herokuapp.com adresinde POST methoduyla yeni kayıt oluşturma ve silme
    Given Kullanıcı request body oluşturur end pointe gönderir yeni bir kayıt oluşturur ve dönen responsu doğrular
    When Kullanıcı gerekli bilgileri girerek token alır
    Then Kullanıcı yeni oluşturduğu kaydı siler ve silindiğini doğrular


