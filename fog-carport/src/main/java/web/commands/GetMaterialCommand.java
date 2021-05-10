package web.commands;

import business.entities.Request;
import business.entities.Stykliste;
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

public class GetMaterialCommand extends CommandProtectedPage{

    CarportFacade carportFacade;
    UserFacade userFacade;


    public GetMaterialCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.carportFacade = new CarportFacade(database);
        this.userFacade = new UserFacade(database);

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("forespørgsel"));
        List<Stykliste> materialList = carportFacade.getMaterialListFromRequestID(id);

        session.setAttribute("materialList", materialList);

        return pageToShow;
    }
}
