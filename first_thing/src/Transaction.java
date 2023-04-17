import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Transaction {
    private int id;
    //private Time date;
    private String[] products;
    private String user;
    private ArrayList basket = new ArrayList<>();

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
    public void addProductToTransaction(String product){
        //TODO: implement to add product to transaction
        try {
            Connection con = ConnectionManager.getConnection();
            String qry = "SELECT * FROM products";
            PreparedStatement st = con.prepareStatement(qry);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                // Retrieve product data from the result set
                int productId = rs.getInt("id");
                String productName = rs.getString("product");
                double productPrice = rs.getDouble("price");
                int productStock = rs.getInt("stock");
    
                // Create a new Product object with the retrieved data
                Product product = new Product(productId, productName, productPrice, productStock);

                // Add the Product object to the basket ArrayList
                basket.add(product);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void getTransactionsList(){
        //TODO: implement how to return the transactions
    }
    
    public void storeTransaction(){
        //TODO: implement to store the transaction in the databse
    }
    public void deleteProductFromList(){
        //TODO: implement to delete a product from the list
        if (basket.contains(product)) {
            basket.remove(product);
            System.out.println("Product '" + product + "' removed from basket.");
        } else {
            System.out.println("Product '" + product + "' not found in basket.");
        }
    }
    public void checkOut(){
        //TODO: implement the checkout
    }
}
