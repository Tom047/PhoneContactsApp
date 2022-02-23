package controllers;

import entities.Contact;
import reposiitories.interfaces.IContactsRepository;

import java.util.ArrayList;

public class ContactController {
    private final IContactsRepository repo;

    public ContactController(IContactsRepository repo) {
        this.repo = repo;
    }

    public String createContact(String name, String phone, String email) {
        Contact contact = new Contact(name, phone, email);

        boolean created = repo.createContact(contact);

        return (created ? "Contact was created!" : "Contact creation was failed!");
    }

    public String deleteContact(int id) {
        boolean deleted = repo.deleteContact(id);

        return (deleted ? "Contact was deleted!" : "Contact deletion was failed!");
    }

    public String findContact(String name) {
        ArrayList<Contact> contacts = repo.findContact(name);

        return contacts.toString();
    }

    public String getContact(int id) {
        Contact contact = repo.getContact(id);

        return (contact == null ? "Contact was not found!" : contact.toString());
    }

    public String getAllContacts() {
        ArrayList<Contact> contacts = repo.getAllContacts();

        return ((contacts.isEmpty()) ? "There is no contacts!" : contacts.toString());
    }
}
