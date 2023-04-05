import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transaction {
    private int id;
    //private Time date;
    private String[] products;
    private String user;

    public String[] getProducts() {
        //TODO: implement how to return the products
        try {
            Connection con = ConnectionManager.getConnection();
            String qry = "SELECT * FROM products";
            PreparedStatement st = con.prepareStatement(qry);
            ResultSet rs = st.executeQuery();
            System.out.print("id" + "\t\t");
            System.out.print("product" + "\t\t");
            System.out.print("price" + "\t\t");
            System.out.print(("stock") + "\t\t");
            while(rs.next()){
                System.out.print(rs.getInt("id") + "\t\t");
                System.out.print(rs.getString("product") + "\t\t");
                System.out.print(rs.getString("price") + "\t\t");
                System.out.print(rs.getString("stock") + "\t\t");
            }

        } catch(SQLException e){
            e.printStackTrace();
        }
        return products;
    }
    public void getTransactionsList(){
        //TODO: implement how to return the transactions
    }
    public void addProductToTransaction(){
        //TODO: implement to add product to transaction
    }
    public void storeTransaction(){
        //TODO: implement to store the transaction in the databse
    }
    public void deleteProductFromList(){
        //TODO: implement to delete a product from the list
    }
    public void checkOut(){
        //TODO: implement the checkout
    }
}
