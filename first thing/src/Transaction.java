public class Transaction {
    private int id;
    private Time date;
    private String[] products;
    private String user;

    public String[] getProducts() {
        //TODO: implement how to return the products
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
