import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Transaction {
    private int id;
    //private Time date;
    private ArrayList<Products> products = new ArrayList<Products>();
    private String user;
    private final ArrayList<Products> basket = new ArrayList<Products>();

    public Transaction() {
        products = this.getProducts();
    }
    public ArrayList<Products> getProducts() {
        //TODO: implement how to return the products
        try {
            Connection con = ConnectionManager.getConnection();
            String qry = "SELECT id FROM products";
            PreparedStatement st = con.prepareStatement(qry);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Products product = new Products(rs.getInt("id"));
                products.add(product);
            }

        } catch(SQLException e){
            e.printStackTrace();
        }
        return products;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        int quit = 0;
        Transaction currentTransaction = new Transaction();
        while(true) {

            System.out.println("Available products: ");
            //https://www.callicoder.com/java-arraylist/
            currentTransaction.products.forEach(products -> {
                System.out.println(products.getProductID() + "\t" + products.name + "\t" + products.price + "\t" + products.getStock());
            });
            System.out.println("\n\n");
            System.out.println("Current basket:");
            if (currentTransaction.basket.isEmpty())
                System.out.println("Basket is empty");
            else {
                currentTransaction.basket.forEach(products -> {
                    System.out.println(products.name + "\t" + products.price + "\t" + products.selectAmount + "\t" +(products.price * products.selectAmount));
                });
            }
            System.out.print("\n Add product to basket (select id): ");
            choice = scan.nextInt();
            if (choice == -1){
                break;
            }
            currentTransaction.addProductToTransaction(choice);
        }
    }
    public void addProductToTransaction(int productID){
        //TODO: implement to add product to transaction
        if(searchBasketID(productID) != null){
            Products product = searchBasketID(productID);
            product.selectAmount++;
        } else {
        Products product = new Products(productID, 1);
        basket.add(product);
        }
    }
    private Products searchBasketID (int parameterValue){
        Products product = null;
        for (Products products1: basket) {
            if (products1.getProductID() == parameterValue)
                product = products1;
        }
        return product;
    }

    public void getTransactionsList(){
        //TODO: implement how to return the transactions
    }

    public void storeTransaction(String [] basket){
        //TODO: implement to store the transaction in the database

        try{
            Connection con = ConnectionManager.getConnection();
            String transactions_qry = "INSERT INTO transactions (sum, customer) values(?,?)";
            PreparedStatement st = con.prepareStatement(transactions_qry);
            float sum = 0;
            /*for (int i = 0; i <= this.products.length; i++){
                sum += this.products[i].price;
            }*/

            for (String products: basket) {
                String transactions_info_qry = "INSERT INTO transactions_info (transaction_id, product, amount, price, sum_price) values(?,?,?,?,?)";
                
            }


        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void deleteProductFromList(Products product){
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

    public void setUser(Users user) {
    }
}
