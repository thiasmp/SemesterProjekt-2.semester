package business.entities;

public class Result {
    private int length;
    private int quantity;
    private int id;

    public Result(int length, int quantity, int id) {
        this.length = length;
        this.quantity = quantity;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
