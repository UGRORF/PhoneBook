package main;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class PhoneBook {

    private static final String REGEX_NAME = "[a-zA-Zа-яА-Я]+";
    private static final String REGEX_NUMBER = "[0-9]{11}";

    private TreeMap<String, String> phoneBook;

    public PhoneBook(){
        phoneBook = new TreeMap<>();
    }

    public static boolean isName(String name){
        return name.matches(REGEX_NAME);
    }

    public static boolean isNumber(String name){
        return name.matches(REGEX_NUMBER);
    }


    public void addContact(String phone, String name) {
        if(PhoneBook.isName(name) && PhoneBook.isNumber(phone)){
            if(phoneBook.containsKey(name)){
                updateContact(name, phone);
            } else {
                phoneBook.put(name, phone);
            }
        }
    }

    public String getContactByPhone(String phone) {
        for (Map.Entry<String, String> entry : phoneBook.entrySet()){
            if(entry.getValue().contains(phone)){
                return entry.getKey();
            }
        }

        return "";
    }

    public Set<String> getContactByName(String name) {
        TreeSet<String> contact = new TreeSet<>();
        if(phoneBook.containsKey(name)){
            contact.add(name + " - " + phoneBook.get(name));
        }

        return contact;
    }

    public Set<String> getAllContacts() {
        TreeSet<String> contacts = new TreeSet<>();
        for (Map.Entry<String, String> entry : phoneBook.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            contacts.add(key + " - " + value);
        }

        return contacts;
    }

    private void updateContact(String name, String phone) {
        for (Map.Entry<String, String> entry : phoneBook.entrySet()){
            if(entry.getKey().equals(name) && !entry.getValue().contains(phone)){
                String phoneNumber = entry.getValue() + ", " + phone;
                entry.setValue(phoneNumber);
            }
        }
    }
}
