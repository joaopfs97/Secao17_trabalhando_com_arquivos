package entities;

public class Product {
    private String name;
    private Double price;
    private Double quantity;

    public Product(String name, Double price, Double quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
    
    public Double totalPrice(){
        return price * quantity;
    }
    
    
}
