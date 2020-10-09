package models;

import static dao.UserData.USER_DATA;

public class User {
    private int userId;
    private String name;

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private long phoneNumber;
    private static int NEW_ID = 0;
    public User(String name,long phoneNumber){
        this.userId = NEW_ID++;
        this.name = name;
        this.phoneNumber = phoneNumber;
        addToDb(this);
    }
    private static void addToDb(User user){
        USER_DATA.addUser(user);
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }
}
