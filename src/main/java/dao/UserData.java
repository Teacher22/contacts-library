package dao;

import exceptions.UserDoesNotExist;
import models.User;

import java.util.HashMap;
import java.util.Map;

public enum UserData {
    USER_DATA;
    private Map<Integer, User> userMap = new HashMap<Integer, User>();
    public void addUser(User user){
        userMap.put(user.getUserId(),user);
    }
    public User getUser(int userId) throws UserDoesNotExist {
        if(!userMap.containsKey(userId)) throw new UserDoesNotExist(userId);
        return userMap.get(userId);
    }
}
