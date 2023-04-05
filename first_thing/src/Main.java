import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

/*
to create table from selfservice DB:

CREATE DATABASE IF NOT EXISTS selfservice;
USE selfservice;

CREATE TABLE `customer` (
  `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `email` varchar(255),
  `password` varchar(255),
  `firstname` varchar(255),
  `lastname` varchar(255),
  `balance` float DEFAULT NULL,
  `created_at` timestamp
)ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE `admins` (
  `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `username` varchar(255),
  `password` varchar(255),
  `firstname` varchar(255),
  `lastname` varchar(255),
  `created_by` integer,
  `created_at` timestamp
)ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE `transactions` (
  `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `sum` float,
  `customer` integer,
  `created_at` timestamp
)ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE `transactions_info` (
  `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `transaction_id` integer,
  `product` integer,
  `amount` integer,
  `price` varchar(255),
  `sum_price` float,
  `created_at` timestamp
)ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE `products` (
  `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `product` varchar(255) COMMENT 'name of product',
  `price` float,
  `stock` integer
)ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE `payment` (
  `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `customer_id` integer,
  `amount` float,
  `payment_provider` varchar(255),
  `status` varchar(255),
  `confirmation_id` integer,
  `created_at` timestamp
)ENGINE=InnoDB AUTO_INCREMENT=1;

ALTER TABLE `admins` ADD FOREIGN KEY (`created_by`) REFERENCES `admins` (`id`);

ALTER TABLE `transactions` ADD FOREIGN KEY (`customer`) REFERENCES `customer` (`id`);

ALTER TABLE `transactions_info` ADD FOREIGN KEY (`transaction_id`) REFERENCES `transactions` (`id`);

ALTER TABLE `transactions_info` ADD FOREIGN KEY (`product`) REFERENCES `products` (`id`);

ALTER TABLE `payment` ADD FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`);

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
                case 1 -> {
                    System.out.println("1. Insert New Data");
                    System.out.println("Enter username : ");
                    usernamedb = str.nextLine();
                    System.out.println("Enter password : ");
                    passworddb = str.nextLine();
                    System.out.println("Enter email : ");
                    email = str.nextLine();
                    System.out.println("Enter balance : ");
                    balance = in.nextInt();
                    Users currentUser = new Users();
                    currentUser.login();

                    qry = "insert into users (USERNAME,PASSWORD,EMAIL, BALANCE) values(?,?,?,?)";
                    st = con.prepareStatement(qry);
                    st.setString(1, usernamedb);
                    st.setString(2, passworddb);
                    st.setString(3, email);
                    st.setInt(4, balance);
                    st.executeUpdate();
                    System.out.println("Data Insert Success");
                }
                case 2 -> {
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
                }
                case 3 -> System.out.println("Coming soon");
                case 4 -> System.out.println("Coming soon");
                case 5 -> {
                    System.out.println("Thank You");
                    System.exit(0);
                }
                case 6 -> {
                    System.out.println("Coming soon");
                    System.out.println("6. Login to CRUD JAVA 3000!!!!");
                    System.out.println("Enter username : ");
                    usernamedb = str.nextLine();
                    System.out.println("Enter password : ");
                    passworddb = str.nextLine();
                    qry = "SELECT PASSWORD FROM users WHERE USERNAME = 'daniel'";
                    rs = stmt.executeQuery(qry);
                    rs.next();
                    if (Objects.equals(rs.getString("password"), passworddb)) {
                        System.out.println("You are logged in!!!");
                    } else {
                        System.out.println(rs.getInt("password"));
                        System.out.println("FAIL!");
                    }
                }
            }
        }
    }
}