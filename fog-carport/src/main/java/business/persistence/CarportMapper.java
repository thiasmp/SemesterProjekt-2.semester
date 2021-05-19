package business.persistence;

import business.entities.Request;
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

    public List<Stykliste> getMaterialListFromRequestID(int id) throws UserException {

        ArrayList<Stykliste> materialList = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT forespørgsel_id, materiale_id, navn, beskrivelse, længde, antal, enhed.enhed " +
                    "FROM orderline INNER JOIN materiale ON orderline.materiale_id = materiale.id " +
                    "INNER JOIN enhed ON materiale.enhed = enhed.id WHERE forespørgsel_id = ?;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int requestID = rs.getInt("forespørgsel_id");
                    int materialeID = rs.getInt("materiale_id");
                    String name = rs.getString("navn");
                    String description = rs.getString("beskrivelse");
                    int length = rs.getInt("længde");
                    int amount = rs.getInt("antal");
                    String unit = rs.getString("enhed.enhed");
                    materialList.add(new Stykliste(requestID, materialeID, name, description, length, amount, unit));
                }
                return materialList;
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

    public void writeToOrderline( int requestID, int materialID, String description, int amount, int length) throws UserException {
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

    public double getPriceFromDB(int id) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "SELECT priceperunit FROM materiale WHERE id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int price = rs.getInt("priceperunit");
                    return price;
                }

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());
        }
        return 0;
    }
}

