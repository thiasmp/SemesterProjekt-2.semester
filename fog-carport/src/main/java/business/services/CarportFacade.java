package business.services;

import business.entities.CarportItem;
import business.entities.Request;
import business.entities.RequestConfirm;
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

    public int getLengthFromDB(int id) throws UserException {
        return carportMapper.getLengthFromDB(id);
    }

    public int getWidthFromDB(int id) throws UserException {
        return carportMapper.getWidthFromDB(id);
    }

    public void writeToOrderline( int requestID, int materialID, String description, int amount, int length) throws UserException {
        carportMapper.writeToOrderline(requestID, materialID, description, amount, length);
    }

    public void updateStatus(int id, String status, double price) throws UserException {
        carportMapper.updateStatus(id, status, price);
    }

    public List<RequestConfirm> getConfirmedUserRequestsFromDB(int id) throws UserException {
        return carportMapper.getConfirmedUserRequestsFromDB(id);
    }

    public List<CarportItem> readFromOrderline(int id) throws UserException {
        return carportMapper.readFromOrderline(id);
    }
}