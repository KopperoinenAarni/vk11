package com.example.vk11;

import java.util.ArrayList;

public class ContactStorage {

    private ArrayList<Contact> contacts = new ArrayList<>();

    private static ContactStorage storage = null;
    private ContactStorage() {
    }

    public static ContactStorage getInstance() {
        if(storage == null) {
            storage = new ContactStorage();
        }
        return storage;
    }
    public ArrayList<Contact> getContacts() {
        return contacts;
    }
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(int id) {
        contacts.remove(id);
    }



}
