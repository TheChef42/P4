import java.sql.*;
public class Products {
    private int productID;
    private String name;
    private float price;
    private int stock;
    public static String[] products;

    public Products() {
    }

    public Products(int productID) {
        try {
            Connection con = ConnectionManager.getConnection();
            String qry = "SELECT * FROM products WHERE id = ?";
            PreparedStatement st = con.prepareStatement(qry);
            st.setInt(1, productID);
            ResultSet rs = st.executeQuery();
            rs.next();
            this.name = rs.getString("product");
            this.price = (float) rs.getInt("price");
            this.stock = rs.getInt("stock");
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Products(String productName, float productPrice, int productStock) {
        this.name = productName;
        this.price = productPrice;
        this.stock = productStock;
    }

    public static void main(String[] args) throws Exception {
        Products cola = new Products("Cola", 100.0F, 2);
        System.out.println(cola.name + " " + cola.price + " " + cola.stock);
        Products fanta = new Products(2);
        System.out.println(fanta.name + " " + fanta.price + " " + fanta.stock);
    }
    public static String[] getProducts() {
        //TODO: implement how to return the products
        try {
            Connection con = ConnectionManager.getConnection();
            String qry = "SELECT * FROM products";
            PreparedStatement st = con.prepareStatement(qry);
            ResultSet rs = st.executeQuery();
            System.out.print("id" + "\t\t");
            System.out.print("product" + "\t\t");
            System.out.print("price" + "\t\t");
            System.out.println(("stock") + "\t\t");
            while(rs.next()){
                System.out.print(rs.getInt("id") + "\t\t");
                System.out.print(rs.getString("product") + "\t\t");
                System.out.print(rs.getString("price") + "\t\t");
                System.out.println(rs.getString("stock") + "\t\t");
            }

        } catch(SQLException e){
            e.printStackTrace();
        }
        return products;
    }

    public int getProductID() {
        return this.productID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int newStock) {
        this.stock = newStock;
    }
}
