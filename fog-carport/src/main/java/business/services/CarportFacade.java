package business.services;

import business.entities.User;
import business.persistence.CarportMapper;
import business.persistence.Database;
import business.persistence.UserMapper;
import business.exceptions.UserException;

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

}
