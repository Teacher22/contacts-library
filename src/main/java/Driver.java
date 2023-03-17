import models.ContactBook;
import models.User;

import java.util.List;

public class Driver {
    public static void main(String... args){
        ContactBook contactBook = new ContactBook();
        User user1 = new User("Ramesh",81629871);
        User user2 = new User("Ramachandran",186781671);
        User user3 = new User("Abhilash",261221271);
        User user4 = new User("Abhishek",127162722);
        User user5 = new User("Abiram",982162787);
        contactBook.addContact(user1);
        contactBook.addContact(user2);
        contactBook.addContact(user3);
        contactBook.addContact(user4);
        contactBook.addContact(user5);
        List<User> userList = contactBook.getAllUsersWithPrefix("ram");
        printUsers(userList);
    }
    public static void printUsers(List<User> userList){
        if(userList == null) {
            throw new RuntimeException("Invalid user list");
        }
        for(User user:userList){
            System.out.println(String.format("USERNAME      : %s \nCONTACT NUMBER: %d ",
                    user.getName(),user.getPhoneNumber()));
            System.out.println();
        }
        for(User user:userList){
            System.out.println(String.format("Repeat username      : %s \nCONTACT NUMBER: %d ",
                    user.getName(),user.getPhoneNumber()));

            System.out.println(String.format("Repeat username      : %s \nCONTACT NUMBER: %d ",
                    user.getName(),user.getPhoneNumber()));
            System.out.println();
        }
    }
}
