import java.sql.*;
import java.util.Scanner;
import java.util.Objects;

public class Users {
    private int ID;
    private String email;
    protected String password;
    public String firstName;
    public String lastName;
    public boolean authenticated;

    public Users(){
        authenticated = false;
    }

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
    public void login(String email, String password) {
        if (verifyPassword(email, password)) {
            System.out.println("Logged in!");
            Users currentUser = new Users();
        } else {
            System.out.println("Access denied!");
        }
    }

    public boolean verifyPassword(String email, String password) {
        Connection con = ConnectionManager.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        String query = "SELECT PASSWORD FROM users WHERE EMAIL=?";
        try {
            st = con.prepareStatement(query);
            st.setString(1, email);
            rs = st.executeQuery();
            if (rs.next() && Objects.equals(rs.getString("PASSWORD"), password)) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
            // closing the connection:
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void logout() {
        //TODO: Implement logout
    }
    public void seeUserAccount() {
        //TODO: Implement the possibilitie to see user account
    }
    public void deleteAccount(int accountId) {
        //TODO: Implement how to delete a useraccount
        Connection con = ConnectionManager.getConnection();
        PreparedStatement pstmt = null;
        boolean success = false;
    
        try {
            // Prepare the SQL query to delete the account
            String sql = "DELETE FROM accounts WHERE account_id = ?";
            pstmt = con.prepareStatement(sql);
    
            // Set the account ID parameter
            pstmt.setInt(1, accountId);
    
            // Execute the query and check the return value
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Account deleted successfully");
                success = true;
            } else {
                System.out.println("Account not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the prepared statement and database connection
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}