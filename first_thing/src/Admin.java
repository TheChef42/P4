import java.sql.*;
public class Admin {

    //public Admin(){}
    public void editUser(){
        //TODO: how to edit admin
    }
    public void viewUser(){
        //TODO: implement how to view a user or users
    }
    public void deleteUser(){
        //TODO: implement hpw to delete a user as admin
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
        chris.createProduct("sprite",10,200);
        System.out.println("Du go");

    }
    public void updateProduct(){
        //TODO: implement updateProduct
    }
    public void removeProduct(){
        //TODO: implement removeProduct
    }
}
