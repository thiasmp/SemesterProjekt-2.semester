package business.entities;

public class Request {

    private int id;
    private String status;
    private int length;
    private int width;
    private int price;
    private int userID;
    private String email;

    public Request(int id, String status, int length, int width, int price, int userID, String email) {
        this.id = id;
        this.status = status;
        this.length = length;
        this.width = width;
        this.price = price;
        this.userID = userID;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}