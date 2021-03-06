package business.persistence;

import business.entities.CarportItem;
import business.entities.Request;
import business.entities.RequestConfirm;
import business.entities.Stykliste;
import business.exceptions.UserException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarportMapper {
    private Database database;

    public CarportMapper(Database database) {
        this.database = database;
    }


    public void createRequest(int length, int width, int id) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO forespørgsel (længde, bredde, user_id) VALUES (?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, length);
                ps.setInt(2, width);
                ps.setInt(3, id);
                ps.executeUpdate();
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }

    public List<Request> getAllRequestsFromDB() throws UserException {

        ArrayList<Request> requestList = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT forespørgsel.id, status, længde, bredde, pris, user_id, users.email " +
                    "FROM forespørgsel INNER JOIN users ON forespørgsel.user_id = users.id WHERE status IS NULL;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("forespørgsel.id");
                    String status = rs.getString("status");
                    int length = rs.getInt("længde");
                    int width = rs.getInt("bredde");
                    int price = rs.getInt("pris");
                    int userID = rs.getInt("user_id");
                    String userEmail = rs.getString("users.email");
                    requestList.add(new Request(id, status, length, width, price, userID, userEmail));
                }
                return requestList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());
        }
    }

    public int getLengthFromDB(int id) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "SELECT længde FROM forespørgsel WHERE id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int length = rs.getInt("længde");
                    return length;
                }

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());
        }
        return 0;
    }

    public int getWidthFromDB(int id) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "SELECT bredde FROM forespørgsel WHERE id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int width = rs.getInt("bredde");
                    return width;
                }

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());
        }
        return 0;
    }

    public void writeToOrderline(int requestID, int materialID, String description, int amount, int length) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO orderline (forespørgsel_id, materiale_id, beskrivelse, antal, længde) " +
                    "VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, requestID);
                ps.setInt(2, materialID);
                ps.setString(3, description);
                ps.setInt(4, amount);
                ps.setInt(5, length);
                ps.executeUpdate();
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }

    public void updateStatus(int id, String status, double price) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "UPDATE forespørgsel SET status = ?, pris = ? WHERE id = ?;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, status);
                ps.setDouble(2, price);
                ps.setInt(3, id);
                ps.executeUpdate();
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }

    public List<RequestConfirm> getConfirmedUserRequestsFromDB(int id) throws UserException {

        ArrayList<RequestConfirm> requestList = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT forespørgsel.id, status, længde, bredde FROM forespørgsel  WHERE status = 'Godkendt' AND user_id = ?;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int forespørgsel_id = rs.getInt("forespørgsel.id");
                    String status = rs.getString("status");
                    int length = rs.getInt("længde");
                    int width = rs.getInt("bredde");

                    requestList.add(new RequestConfirm(forespørgsel_id, status, length, width));
                }
                return requestList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());
        }
    }
    public List<CarportItem> readFromOrderline(int id) throws UserException {
        List<CarportItem> materialList = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT materiale_id, beskrivelse, antal, orderline.længde, forespørgsel.pris " +
                    "FROM orderline INNER JOIN forespørgsel ON orderline.forespørgsel_id = forespørgsel.id WHERE forespørgsel_id = ?;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int materialID = rs.getInt("materiale_id");
                    String description = rs.getString("beskrivelse");
                    int amount = rs.getInt("antal");
                    int length = rs.getInt("længde");
                    int price = rs.getInt("pris");
                    materialList.add(new CarportItem(length, amount, price, description, materialID));
                }
                return materialList;

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());
        }
    }
}