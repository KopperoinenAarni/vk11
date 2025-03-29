package com.example.vk11;

public class Contact {
    String firstName;
    String lastName;
    String number;
    String contactGroup;

    public Contact(String firstName, String lastName, String number, String contactGroup) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.contactGroup = contactGroup;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getNumber() {
        return number;
    }

    public String getContactGroup() {
        return contactGroup;
    }
}
