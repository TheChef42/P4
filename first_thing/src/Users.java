import java.sql.*;
import java.util.Scanner;
import java.util.Objects;

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
    protected boolean login() {
        Connection con = ConnectionManager.getConnection();
        Scanner str = new Scanner(System.in);
        try {
            System.out.println("Login");
            System.out.println("Enter email : ");
            email = str.nextLine();
            System.out.println("Enter password : ");
            password = str.nextLine();
    
            if (verifyPassword(email, password) == true) {
                //somtehing
                        }
    }
    public boolean verifyPassword(String email, String password) {
        Connection con = ConnectionManager.getConnection();
        Scanner str = new Scanner(System.in);
        try {
            String qry = "SELECT PASSWORD FROM users WHERE USERNAME = ?";
            PreparedStatement st = con.prepareStatement(qry);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            str.close();
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