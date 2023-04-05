import java.sql.*;
public class Admin {

    //public Admin(){}
    public void editUser(){
        //TODO: how to edit admin
    }
    private void viewUsers(){
        try {
            Connection con = ConnectionManager.getConnection();
            String qry = "SELECT * customers";
            PreparedStatement st = con.prepareStatement(qry);
            ResultSet rs = st.executeQuery();
            
        } catch(SQLException e){
            e.printStackTrace();
        }
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
        //Admin chris = new Admin();
        //chris.createProduct("sprite",10,200);
        Products cola = new Products(2);
        System.out.println(cola.getName() + cola.getPrice());
        System.out.println("Du go");

    }
    public void updateProduct(){
        //TODO: implement updateProduct
    }
    public void removeProduct(){
        //TODO: implement removeProduct
    }
}
