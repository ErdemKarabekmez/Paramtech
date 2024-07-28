package com.param.pojos;

public class PojoHerokuAppRequestBody {

    /***
     Bu class RequestBody oluşturmak için kullanacağımız datalar için oluşturulmuş bir POJO classıdır.
     Bu class ı bir kere oluşturduktan sonra tüm testlerde tekrar tekrar kullanabiliriz.
     ***/

    private String firstname;

    private String lastname;

    private int totalprice;

    private boolean depositpaid;

    private PojoHerokuAppBookingDates bookingdates;

    private String additionalneeds;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public PojoHerokuAppBookingDates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(PojoHerokuAppBookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public PojoHerokuAppRequestBody(String firstname, String lastname, int totalprice, boolean depositpaid, PojoHerokuAppBookingDates bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }

    public PojoHerokuAppRequestBody() {
    }

    @Override
    public String toString() {
        return "PojoHerokuAppRequestBody{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }
}
