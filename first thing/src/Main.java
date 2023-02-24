import java.sql.*;
import java.util.Scanner;
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

        System.out.println("1. Insert New Data");

        System.out.println("Enter username : ");
        usernamedb =str.nextLine();
        System.out.println("Enter password : ");
        passworddb=str.nextLine();
        System.out.println("Enter email : ");
        email=str.nextLine();
        System.out.println("Enter balance : ");
        balance=in.nextInt();

        qry="insert into new_table (username,password,email, balance) values(?,?,?,?)";

        st= con.prepareStatement(qry);
        st.setString(1, usernamedb);
        st.setString(2, passworddb);
        st.setString(3, email);
        st.setInt(4, balance);
        st.executeUpdate();
        System.out.println("Data Insert Success");





    }
}