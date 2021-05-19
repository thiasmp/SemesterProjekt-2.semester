package business.entities;

public class CarportItem {

    private int length;
    private int quantity;
    private double price;
    private String description;
    private int id;

    public CarportItem(int length, int quantity, double price, String description, int id) {
        this.length = length;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.id = id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
