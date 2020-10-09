package exceptions;

public class UserDoesNotExist extends Exception {
    public UserDoesNotExist(int userId){
        super("User with the userId:"+userId+" does not exist");
    }
}
