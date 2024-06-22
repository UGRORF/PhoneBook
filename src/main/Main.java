package main;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер, имя или команду:");

        while (sc.hasNext()) {
            String command = sc.next();
            if(command.equals("LIST")) {
                System.out.println(pb.getAllContacts());
            } else if(PhoneBook.isName(command)) {
                Set<String> names = pb.getContactByName(command);
                if(names.isEmpty()) {
                    System.out.printf("Такого имени в телефонной книге нет.\n" +
                            "Введите номер телефона для абонента “%s”:", command);
                    String phone = sc.next();
                    pb.addContact(phone, command);
                } else {
                    System.out.println(names);
                }
            } else if(PhoneBook.isNumber(command)){
                String names = pb.getContactByPhone(command);
                if(names.isEmpty()) {
                    System.out.printf("Такого номера нет в телефонной книге.\n" +
                            "Введите имя абонента для номера “%s”:", command);
                    String name = sc.next();
                    pb.addContact(command, name);
                } else {
                    System.out.println(names);
                }
            } else {
                System.out.println("Неверный формат ввода");
            }
        }
    }
}
