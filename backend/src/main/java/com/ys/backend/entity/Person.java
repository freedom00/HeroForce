package com.ys.backend.entity;

public class Person {
    private String firstName;
    private String lastName;
    private String birthday;
    private String phoneNumber;
    private String email;
    private boolean isMessageOnBirthday;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getIsMessageOnBirthday() {
        return isMessageOnBirthday;
    }

    public void setIsMessageOnBirthday(boolean isMessageOnBirthday) {
        this.isMessageOnBirthday = isMessageOnBirthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName: '" + firstName + '\'' +
                ", lastName: '" + lastName + '\'' +
                ", birthday: '" + birthday + '\'' +
                ", phoneNumber: '" + phoneNumber + '\'' +
                ", email: '" + email + '\'' +
                ", isMessageOnBirthday: " + isMessageOnBirthday +
                '}';
    }
}