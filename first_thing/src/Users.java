import java.sql.*;
import java.util.Scanner;
import java.util.Objects;
public class Users {
    private int ID;
    private String email;
    protected String password;
    public String firstName;
    public String lastName;
    private float balance;
    public Timestamp created_at;

    public Users(){
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
    public Users login(String email, String password) {
        // declaring it out of the if statement to return it at the end
        Users currentUser = null;
        if (verifyPassword(email, password)) {
            currentUser = new Users();
            Connection con = ConnectionManager.getConnection();
            PreparedStatement st = null;
            ResultSet rs = null;
            String query = "SELECT * FROM users WHERE EMAIL=?";
    
            try {
                st = con.prepareStatement(query);
                st.setString(1, email);
                rs = st.executeQuery();
    
                if (rs.next()) {
                    currentUser.ID = rs.getInt("id");
                    currentUser.email = email;
                    currentUser.password = password;
                    currentUser.firstName = rs.getString("firstname");
                    currentUser.lastName = rs.getString("lastname");
                    currentUser.balance = rs.getFloat("balance");
                    currentUser.created_at = rs.getTimestamp("created_at");
                }
    
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            } finally {
                try{
                    // closing input options
                    rs.close();
                    st.close();
                    con.close();

                } catch (SQLException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        } else {
            System.out.println("Access denied!");
        }
        return currentUser;
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

    public void logout(Users currentUser) {
        currentUser = null;
    }
    public void seeUserAccount() {
        System.out.print(this.ID);
        System.out.print(this.email);
        // may have to be protected somehow:
        System.out.print(this.password);
        System.out.print(this.firstName);
        System.out.print(this.lastName);
        System.out.print(this.balance);
        System.out.print(this.created_at);
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
            pstmt.setInt(1, this.ID);
    
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
        return this.firstName + " " + this.lastName;
    }

    // what is this for??
    public void setEmail(String email) {
        this.email = email;
    }
}