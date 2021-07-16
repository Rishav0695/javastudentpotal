package com.luv2code.springdemo.mvc;

public class AddressDto {
    private String housenumber = " " ;
    private String street = " ";
    private String country = " ";
    private String city = " ";
    private int pincode = 0;

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setPincode(int pincode) {
        this.pincode = pincode;
    }
    @Override
    public String toString() {
        return housenumber+" "+street+"   "+city+"  "+country+" "+pincode;

    }
}

