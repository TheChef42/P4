import java.sql.*;
import java.util.Scanner;

public class Admin {

    //public Admin(){}
    public void editUser(){
        //TODO: how to edit admin
    }
    private void viewUsers(){
        try {
            Connection con = ConnectionManager.getConnection();
            String qry = "SELECT * FROM customer";
            PreparedStatement st = con.prepareStatement(qry);
            ResultSet rs = st.executeQuery();
            System.out.print("id" + "\t\t");
            System.out.print("email" + "\t\t");
            System.out.print("password" + "\t\t");
            System.out.print(("firstname") + "\t\t");
            System.out.print(("lastname") + "\t\t");
            System.out.print(("balance") + "\t\t");
            System.out.println(("created_at"));
            while(rs.next()){
                System.out.print(rs.getInt("id") + "\t\t");
                System.out.print(rs.getString("email") + "\t\t");
                System.out.print(rs.getString("password") + "\t\t");
                System.out.print(rs.getString("firstname") + "\t\t");
                System.out.print(rs.getString("lastname") + "\t\t");
                System.out.print(rs.getFloat("balance") + "\t\t");
                System.out.println(rs.getTimestamp("created_at"));
            }

        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void deleteUser(int id){
        //TODO: implement hpw to delete a user as admin
        try{
            Connection con = ConnectionManager.getConnection();
            String qry = "DELETE FROM customer WHERE id = ?";
            PreparedStatement st = con.prepareStatement(qry);
            st.setInt(1,id);
            st.executeUpdate();
    }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public int viewProducts(){
        //TODO: implement how to view and select a product
        int productID = 0;
        return productID;
    }
    public void createProduct(String productName, float productPrice, int productStock){
        try {
            Connection con = ConnectionManager.getConnection();
            String qry = "INSERT INTO products (product, price, stock) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(qry);
            st.setString(1,productName);
            st.setFloat(2, productPrice);
            st.setInt(3, productStock);
            st.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        Admin chris = new Admin();
        Products cola = new Products(2);
        System.out.println(cola.getName() + cola.getPrice());
        System.out.println("Du go");
        chris.viewUsers();
        System.out.print("Who do you want to delete, bitch!");
        Scanner scan = new Scanner(System.in);
        int in = scan.nextInt();
        chris.deleteUser(in);
        chris.viewUsers();
        Products.getProducts();
    }
    public void updateProduct(){
        //TODO: implement updateProduct
    }
    public void removeProduct(){
        //TODO: implement removeProduct
    }
}
