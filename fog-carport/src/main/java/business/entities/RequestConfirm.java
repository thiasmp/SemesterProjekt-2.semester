package business.entities;

public class RequestConfirm {

        private int id;
        private String status;
        private int length;
        private int width;

    public RequestConfirm(int id, String status, int length, int width) {
        this.id = id;
        this.status = status;
        this.length = length;
        this.width = width;
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
}
