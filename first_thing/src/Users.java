import java.sql.*;
<<<<<<< HEAD

=======
>>>>>>> b8901f198c7db196a3b108a8f1758a02a2490582
public class Users {
    private int ID;
    private String email;
    protected String password;
    public String firstName;
    public String lastName;

    protected void createUser(String email, String password, String firstName, String lastName) {
        try {
            Connection con = ConnectionManager.getConnection();
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
    }
    protected void login() {
        //TODO: Implement login
    }
    public boolean verifyPassword(String email, String password) {
        Connection con = ConnectionManager.getConnection();
        try {
            System.out.println("Login");
            System.out.println("Enter username : ");
            email = str.nextLine();
            System.out.println("Enter password : ");
            password = str.nextLine();
            String qry = "SELECT PASSWORD FROM users WHERE USERNAME = ?";
            PreparedStatement st = con.prepareStatement(qry);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            if (rs.next() && Objects.equals(rs.getString("PASSWORD"), password)) {
                System.out.println("You are logged in!!!");
                return true;
            } else {
                System.out.println("FAIL!");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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