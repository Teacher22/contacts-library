package tries;

import models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TrieNode {
    Map<Character,TrieNode> children;
    int userCount;
    private User user;
    public TrieNode(){
        this.children = new HashMap<Character, TrieNode>();
    }
    public void addChildren(char c){
        if(!children.containsKey(c)) {
            children.put(c,new TrieNode());
        }
        TrieNode child = children.get(c);
        child.addCount();
    }
    public void setUser(User user){
        this.user = user;
    }
    public User getUser(){
        return this.user;
    }
    public TrieNode getChild(char c){
        return this.children.get(c);
    }
    private void addCount(){
        this.userCount++;
    }
    public int getUserCount(){
        return userCount;
    }
    public void deleteChild(char c){
        TrieNode child = children.get(c);
        if(child.userCount==1) children.remove(c);
        child.userCount--;
    }
    public Set<Character> getAllChildren(){
        return children.keySet();
    }
    public void removeUser(){
        this.user = null;
    }

}
