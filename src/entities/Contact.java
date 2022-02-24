package entities;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.*;

public class Contact {
    private int id;
    private String name;
    private String phone;
    private String email;

    public Contact(String name, String number, String email) {
        this.name = name;
        this.email = email;
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        try {
            this.phone = phoneUtil.format(phoneUtil.parse(number, "KZ"), PhoneNumberFormat.INTERNATIONAL);
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
    }

    public Contact(int id, String name, String number, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        try {
            this.phone = phoneUtil.format(phoneUtil.parse(number, "KZ"), PhoneNumberFormat.INTERNATIONAL);
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
