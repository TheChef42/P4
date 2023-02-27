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
        String url = "jdbc:mysql://localhost:3306/sys?characterEncoding=utf8";
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
            System.out.println("1. Insert");
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
                    System.out.println("Enter balance : ");
                    balance = in.nextInt();

                    qry = "insert into new_table (username,password,email, balance) values(?,?,?,?)";

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

                    qry = "update new_table set username=?, password = ?, balance = ? where email=?";
                    st = con.prepareStatement(qry);
                    st.setString(1, usernamedb);
                    st.setString(2, passworddb);
                    st.setString(4, email);
                    st.setInt(3, balance);
                    st.executeUpdate();
                    System.out.println("Data Update Success");
                    break;

                case 3:
                    System.out.println("Coming soon");
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

                    qry="SELECT password FROM new_table WHERE username = 'daniel'";
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
}