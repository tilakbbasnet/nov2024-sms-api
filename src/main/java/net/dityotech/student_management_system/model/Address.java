package net.dityotech.student_management_system.model;

public class Address {
    private String state;
    private String city;
    private String streetName;

    public Address() {
    }

    public Address(String state, String city, String streetName) {
        this.state = state;
        this.city = city;
        this.streetName = streetName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @Override
    public String toString() {
        return "Address{" +
                "state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", street name='" + streetName + '\'' +
                '}';
    }
}
