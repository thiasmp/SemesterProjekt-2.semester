package web.commands;

import business.entities.Request;
import business.exceptions.UserException;
import business.persistence.CarportMapper;
import business.services.CarportFacade;
import business.services.UserFacade;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class GetAllRequestCommand extends CommandProtectedPage{

    CarportFacade carportFacade;
    UserFacade userFacade;


    public GetAllRequestCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.carportFacade = new CarportFacade(database);
        this.userFacade = new UserFacade(database);

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        HttpSession session = request.getSession();
        List<Request> requestList = carportFacade.getAllRequestsFromDB();

        session.setAttribute("requestList", requestList);
        return pageToShow;
    }
}
