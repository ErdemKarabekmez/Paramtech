package com.param.pojos;

public class PojoHerokuAppResponseBody {

    /***
     Bu class RsponseBody yi doğrulamak için oluşturulmuş bir POJO classıdır.
     Bu class ı bir kere oluşturduktan sonra tüm testlerde tekrar tekrar kullanabiliriz.
     ***/
    private int bookingid;

    private PojoHerokuAppRequestBody booking;

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public PojoHerokuAppRequestBody getBooking() {
        return booking;
    }

    public void setBooking(PojoHerokuAppRequestBody booking) {
        this.booking = booking;
    }

    public PojoHerokuAppResponseBody(int bookingid, PojoHerokuAppRequestBody booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public PojoHerokuAppResponseBody() {
    }

    @Override
    public String toString() {
        return "PojoHerokuAppResponseBody{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
