package reposiitories.interfaces;

import entities.Contact;

import java.util.ArrayList;

public interface IContactsRepository {
    boolean createContact(Contact contact);
    boolean editContact(int id, String param, String newValue);
    boolean deleteContact(int id);
    ArrayList<Contact> findContact(String name);
    Contact getContact(int id);
    ArrayList<Contact> getAllContacts();
}
