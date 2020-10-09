package models;

import models.User;
import tries.TrieNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ContactBook {
    private TrieNode root;
    public ContactBook(){
        this.root = new TrieNode();
    }
    public void addContact(User user){
        TrieNode currNode = root;
        String userName = user.getName().toLowerCase();
        for(int i = 0; i<userName.length();i++){
            char c = userName.charAt(i);
            currNode.addChildren(c);
            currNode = currNode.getChild(c);
        }
        currNode.setUser(user);
    }
    public void deleteUser(User user){
        TrieNode currNode = root;
        String userName = user.getName().toLowerCase();
        for(int i=0;i<userName.length();i++){
            TrieNode tempChild = currNode.getChild(userName.charAt(i));
            currNode.deleteChild(userName.charAt(i));
            currNode = tempChild;
        }
        currNode.removeUser();
    }
    public List<User> getAllUsers(){
        return getAllUsersWithPrefix("");
    }
    public List<User> getAllUsersWithPrefix(String prefix){
        prefix = prefix.toLowerCase();
        TrieNode currNode = root;
        for(int i=0;i<prefix.length();i++){
            currNode = currNode.getChild(prefix.charAt(i));
        }
        return getAllUsersWithPrefix(currNode);
    }
    private List<User> getAllUsersWithPrefix(TrieNode node){
        List<User> userList = new ArrayList<User>();
        addUsers(node,userList);
        return userList;
    }
    private void addUsers(TrieNode node,List<User> users){
        if(node==null) return;
        if(node.getUser()!=null) users.add(node.getUser());
        Set<Character> childSet = node.getAllChildren();
        for(Character c : childSet){
            addUsers(node.getChild(c),users);
        }
    }
}
