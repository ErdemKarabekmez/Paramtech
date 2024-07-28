package com.param.step_definitions;

import com.param.pojos.PojoHerokuAppBookingDates;
import com.param.pojos.PojoHerokuAppRequestBody;
import com.param.pojos.PojoHerokuAppResponseBody;
import com.param.utilities.ConfigurationReader;
import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import static io.restassured.RestAssured.given;

public class HerokuAppApiSteps {

    protected RequestSpecification specHerokuApp;
    int bookingid;
    String token;

    @Given("Kullanıcı request body oluşturur end pointe gönderir yeni bir kayıt oluşturur ve dönen responsu doğrular")
    public void kullanıcıRequestBodyOlustururEndPointeGonderirYeniBirKayıtOlustururVeDonenResponsuDogrular() {

        specHerokuApp = new RequestSpecBuilder().setBaseUri(ConfigurationReader.get("baseUri")).build();
        specHerokuApp.pathParam("pp1","booking");

        PojoHerokuAppBookingDates bookingDatesPojo =
                new PojoHerokuAppBookingDates("2024-06-01","2024-06-10");

        PojoHerokuAppRequestBody requestBodyPojo =
                new PojoHerokuAppRequestBody("Erdem","Türker",500,false,bookingDatesPojo,"Breakfast");

        PojoHerokuAppRequestBody bookingPojo =
                new PojoHerokuAppRequestBody("Erdem","Türker",500,false,bookingDatesPojo,"Breakfast");

        PojoHerokuAppResponseBody expectedResponseBodyPojo = new PojoHerokuAppResponseBody(2989,bookingPojo);

        Response response = given().spec(specHerokuApp).contentType(ContentType.JSON)
                .when().body(requestBodyPojo)
                .post("/{pp1}");

        PojoHerokuAppResponseBody actualResponsePojo = response.as(PojoHerokuAppResponseBody.class);

        //Assertion
        Assert.assertEquals(expectedResponseBodyPojo.getBooking().getFirstname(),
                actualResponsePojo.getBooking().getFirstname());
        Assert.assertEquals(expectedResponseBodyPojo.getBooking().getLastname(),
                actualResponsePojo.getBooking().getLastname());
        Assert.assertEquals(expectedResponseBodyPojo.getBooking().getTotalprice(),
                actualResponsePojo.getBooking().getTotalprice());
        Assert.assertEquals(expectedResponseBodyPojo.getBooking().isDepositpaid(),
                actualResponsePojo.getBooking().isDepositpaid());
        Assert.assertEquals(expectedResponseBodyPojo.getBooking().getAdditionalneeds(),
                actualResponsePojo.getBooking().getAdditionalneeds());
        Assert.assertEquals(expectedResponseBodyPojo.getBooking().getBookingdates().getCheckin(),
                actualResponsePojo.getBooking().getBookingdates().getCheckin());
        Assert.assertEquals(expectedResponseBodyPojo.getBooking().getBookingdates().getCheckout(),
                actualResponsePojo.getBooking().getBookingdates().getCheckout());

        //Status code, ContentType ve id assertion u
        response.then().assertThat().statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("bookingid", Matchers.notNullValue());

        bookingid = actualResponsePojo.getBookingid();

    }

    @When("Kullanıcı gerekli bilgileri girerek token alır")
    public void kullanıcıGerekliBilgileriGirerekTokenAlır() {

        specHerokuApp = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
        specHerokuApp.pathParam("pp1","auth");

        JSONObject requestBodyAuth = new JSONObject();
        requestBodyAuth.put("username", "admin");
        requestBodyAuth.put("password", "password123");

        Response  response = given().spec(specHerokuApp).contentType(ContentType.JSON)
                .when().body(requestBodyAuth.toString())
                .post("/{pp1}");

        JsonPath responseJsonPath = response.jsonPath();
        token = "token="+ responseJsonPath.getString("token");

    }

    @Then("Kullanıcı yeni oluşturduğu kaydı siler ve silindiğini doğrular")
    public void kullanıcıYeniOlusturduguKaydıSilerVeSilindiginiDogrular() {

        specHerokuApp = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
        specHerokuApp.pathParams("pp1","booking","pp2",bookingid)
                     .header("Cookie",token);


        Response response = given().when()
                .spec(specHerokuApp)
                .delete("/{pp1}/{pp2}");

        //Status code ve body assertion u
        response.then().assertThat()
                .statusCode(201)
                .body(Matchers.equalTo("Created"));

    }

}
