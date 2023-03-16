import java.sql.*;
import java.util.Objects;
import java.util.Scanner;


/*
to create table from selfservice DB:

CREATE DATABASE IF NOT EXISTS selfservice;
USE selfservice;
DROP TABLE IF EXISTS users;
CREATE TABLE users (
  ID int(11) NOT NULL AUTO_INCREMENT,
  USERNAME varchar(50) DEFAULT NULL,
  PASSWORD varchar(50) DEFAULT NULL,
  EMAIL varchar(50) DEFAULT NULL,
  BALANCE int(11) DEFAULT NULL,
  PRIMARY KEY (ID)
) ENGINE=InnoDB AUTO_INCREMENT=1;

 */


//https://www.tutorjoes.in/java_programming_tutorial/mysql_crud_method_in_java
public class Main {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/selfservice?characterEncoding=utf8";
        String username = "root";
        String password = "root";
        Connection con = DriverManager.getConnection(url,username,password);

        Statement stmt =con.createStatement();
        ResultSet rs;
        PreparedStatement st;

        String qry="";

        int id, balance;
        String usernamedb, email, passworddb;

        Scanner in = new Scanner(System.in);
        Scanner str = new Scanner(System.in);


        while(true) {
            System.out.println("MySQL Java CRUD Operation");
            System.out.println("1. Create");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Select");
            System.out.println("5. Exit");
            System.out.println("6. Login");
            System.out.print("Enter a choice: ");
            int choice = in.nextInt();
            System.out.println("-----------------------------------------");
            switch (choice) {
                case 1:
                    System.out.println("1. Insert New Data");
                    System.out.println("Enter username : ");
                    usernamedb = str.nextLine();
                    System.out.println("Enter password : ");
                    passworddb = str.nextLine();
                    System.out.println("Enter email : ");
                    email = str.nextLine();
                    if(checkEmail(email)== false){
                        break;
                    };
                    
                    System.out.println("Enter balance : ");
                    balance = in.nextInt();

                    qry = "insert into users (USERNAME,PASSWORD,EMAIL, BALANCE) values(?,?,?,?)";

                    st = con.prepareStatement(qry);
                    st.setString(1, usernamedb);
                    st.setString(2, passworddb);
                    st.setString(3, email);
                    st.setInt(4, balance);
                    st.executeUpdate();
                    System.out.println("Data Insert Success");
                    break;

                case 2:
                    System.out.println("2. Update user");
                    System.out.println("Enter username : ");
                    usernamedb = str.nextLine();
                    System.out.println("Enter password : ");
                    passworddb = str.nextLine();
                    System.out.println("Enter email : ");
                    email = str.nextLine();
                    System.out.println("Enter balance : ");
                    balance = in.nextInt();

                    qry = "update users set USERNAME=?, PASSWORD = ?, BALANCE = ? where EMAIL=?";
                    st = con.prepareStatement(qry);
                    st.setString(1, usernamedb);
                    st.setString(2, passworddb);
                    st.setString(4, email);
                    st.setInt(3, balance);
                    st.executeUpdate();
                    System.out.println("Data Update Success");
                    break;

                case 3:
                    System.out.println("3. Delete user");
                    System.out.println("Enter 1 to delete by email, 2 to delete by username: ");
                    int deleteOption = in.nextInt();
                    email = "";
                    usernamedb = "";
                    if (deleteOption == 1) {
                        System.out.println("Enter email: ");
                        email = str.nextLine();
                        if (checkPassword())
                        qry = "DELETE FROM users WHERE EMAIL=?";
                    } else if (deleteOption == 2) {
                        System.out.println("Enter username: ");
                        usernamedb = str.nextLine();
                        qry = "DELETE FROM users WHERE USERNAME=?";
                    } else {
                        System.out.println("Invalid option");
                        break;
                    }

                    st = con.prepareStatement(qry);
                    if (deleteOption == 1) {
                        st.setString(1, email);
                    } else if (deleteOption == 2) {
                        st.setString(1, usernamedb);
                    }
                    st.executeUpdate();
                    System.out.println("Data Delete Success");
                    break;

                case 4:
                    System.out.println("Coming soon");
                    break;

                case 5:
                    System.out.println("Thank You");
                    System.exit(0);
                    break;

                case 6:
                    System.out.println("Coming soon");
                    System.out.println("6. Login to CRUD JAVA 3000!!!!");
                    System.out.println("Enter username : ");
                    usernamedb = str.nextLine();
                    System.out.println("Enter password : ");
                    passworddb = str.nextLine();

                    qry="SELECT PASSWORD FROM users WHERE USERNAME = 'daniel'";
                    rs=stmt.executeQuery(qry);
                    rs.next();
                    if (Objects.equals(rs.getString("password"), passworddb)){
                        System.out.println("You are logged in!!!");
                    } else {
                        System.out.println(rs.getInt("password"));
                        System.out.println("FAIL!");
                    }
                    break;
            }
        }
    }

    public static boolean checkEmail(String email) {
    String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z0-9.-]+$";
    if (email.matches(regex)) {
        return true;
    } else {
        System.out.println("Invalid email");
        return false;
    }
    }
    public static boolean checkPassword(ResultSet user, String password) throws SQLException {
    return Objects.equals(user.getString("password"), password);
}
}
