public class Users {
    private String email;
    protected String password;
    public String firstName;
    public String lastName;

    protected void login() {
        //TODO: Implement login
    }
    private void verifyPassword() {
        //TODO: create method to verify password
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
