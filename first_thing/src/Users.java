public class Users {
    private int ID;
    private String email;
    protected String password;
    public String firstName;
    public String lastName;

    protected void login() {
        //TODO: Implement login
    }
    public boolean verifyPassword(String username, String password) {
        //TODO: create method to verify password
        
        return false;
    }
    public void logout() {
        //TODO: Implement logout
    }
    public void seeUserAccount() {
        //TODO: Implement the possibilitie to see user account
    }
    public void deleteAccount() {
        //TODO: Implement how to delete a useraccount
    }

    public String getName() {
        return firstName + " " + lastName;
    }
}
