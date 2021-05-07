package business.persistence;

import business.exceptions.UserException;
import business.entities.User;

import java.sql.*;

    public class CarportMapper
    {
        private Database database;

        public CarportMapper(Database database)
        {
            this.database = database;
        }


        public void createRequest(int length, int width, int id) throws UserException
        {
            try (Connection connection = database.connect())
            {
                String sql = "INSERT INTO forespørgsel (længde, bredde, user_id) VALUES (?, ?, ?)";

                try (PreparedStatement ps = connection.prepareStatement(sql))
                {
                    ps.setInt(1, length);
                    ps.setInt(2, width);
                    ps.setInt(3, id);
                    ps.executeUpdate();
                }
                catch (SQLException ex)
                {
                    throw new UserException(ex.getMessage());
                }
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
}
