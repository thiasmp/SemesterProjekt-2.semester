package web.commands;

import business.entities.CarportItem;
import business.exceptions.UserException;
import business.persistence.CarportMapper;
import business.services.CarportFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class ShowSVGCommand extends CommandProtectedPage {

    CarportFacade carportFacade;
    UserFacade userFacade;
    public ShowSVGCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.carportFacade = new CarportFacade(database);
        this.userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        HttpSession session = request.getSession();

        int id = Integer.parseInt(request.getParameter("forespørgsel"));

        List<CarportItem> materialList = carportFacade.readFromOrderline(id);
        session.setAttribute("materialList", materialList);


        return pageToShow;
    }
}
