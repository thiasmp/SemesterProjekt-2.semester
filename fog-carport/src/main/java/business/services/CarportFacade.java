package business.services;

import business.entities.Request;
import business.entities.Stykliste;
import business.persistence.CarportMapper;
import business.persistence.Database;
import business.exceptions.UserException;

import java.util.List;

public class CarportFacade
{
    CarportMapper carportMapper;

    public CarportFacade(Database database)
    {
        carportMapper = new CarportMapper(database);
    }

    public void createRequest(int length, int width, int id) throws UserException {
        carportMapper.createRequest(length, width, id);
    }

    public List<Request> getAllRequestsFromDB() throws UserException {
        return carportMapper.getAllRequestsFromDB();
    }

    public List<Stykliste> getMaterialListFromRequestID (int id) throws UserException {
        return carportMapper.getMaterialListFromRequestID(id);
    }

    public int getLengthFromDB(int id) throws UserException {
        return carportMapper.getLengthFromDB(id);
    }

    public int getWidthFromDB(int id) throws UserException {
        return carportMapper.getWidthFromDB(id);
    }

    public void writeToOrderline( int requestID, int materialID, String description, int amount, int length) throws UserException {
        carportMapper.writeToOrderline(requestID, materialID, description, amount, length);
    }
}
