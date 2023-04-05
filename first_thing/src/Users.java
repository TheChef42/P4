public class Users {
    private int ID;
    private String email;
    protected String password;
    public String firstName;
    public String lastName;

    protected void createUser(String email, String password, String firstName, String lastName) {
        try {
            String qry = "insert into users (USERNAME,PASSWORD,EMAIL, BALANCE) values(?,?,?,?)";
            PreparedStatement st = con.prepareStatement(qry);
            st.setString(1, email);
            st.setString(2, password);
            st.setString(3, firstName);
            st.setString(4, lastName);
            st.executeUpdate();
            System.out.println("User created succesfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
