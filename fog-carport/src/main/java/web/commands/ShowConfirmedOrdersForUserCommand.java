package web.commands;

import business.entities.Request;
import business.entities.RequestConfirm;
import business.exceptions.UserException;
import business.services.CarportFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowConfirmedOrdersForUserCommand extends CommandProtectedPage
{
    CarportFacade carportFacade;
    UserFacade userFacade;

    public ShowConfirmedOrdersForUserCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.carportFacade = new CarportFacade(database);
        this.userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        int id = userFacade.getUserIDFromDB((String) session.getAttribute("email"));
        List<RequestConfirm> requestConfirmList = carportFacade.getConfirmedUserRequestsFromDB(id);


        session.setAttribute("requestConfirmList", requestConfirmList);



        return pageToShow;


    }
}
