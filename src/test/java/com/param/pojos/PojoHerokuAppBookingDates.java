package com.param.pojos;

public class PojoHerokuAppBookingDates {

    /***
     Bu class BookingDates dataları için oluşturulmuş bir POJO classıdır.
     Bu class ı bir kere oluşturduktan sonra tüm testlerde tekrar tekrar kullanabiliriz.
     ***/

    private String checkin;

    private String checkout;

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public PojoHerokuAppBookingDates(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public PojoHerokuAppBookingDates() {
    }

    @Override
    public String toString() {
        return "PojoHerokuAppBookingDates{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
