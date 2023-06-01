package actividades.ud7.act74;

import actividades.ud5.practica5.Person;

public class Contact extends Person {
    private String address;
    private Integer phoneNumber;

    public Contact() {

    }

    public Contact(String name, String address, Integer phoneNumber) {
        super(name);
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
