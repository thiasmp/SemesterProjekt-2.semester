package web.commands;

import business.exceptions.UserException;
import business.services.CarportFacade;
import business.services.UserFacade;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetRequestCommand extends CommandProtectedPage{

    CarportFacade carportFacade;
    UserFacade userFacade;

    public GetRequestCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.carportFacade = new CarportFacade(database);
        this.userFacade = new UserFacade(database);

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        HttpSession session = request.getSession();
        int length = Integer.parseInt(request.getParameter("længde"));
        int width = Integer.parseInt(request.getParameter("bredde"));
        int id = userFacade.getUserIDFromDB((String) session.getAttribute("email"));

        if (length < 0 || length > 800 || width < 0 || width > 700) {
            Boolean test = true;
            request.setAttribute("booleanTest", test);
            String errorMsg = "Brug kun tal i felterne der er positive, over 0 og under (længde) 800 & (bredde) 700";
            request.setAttribute("newError", errorMsg);
            return "nyforespørgselpage";
        } else {
            request.setAttribute("længde", length);
            request.setAttribute("bredde", width);
            carportFacade.createRequest(length, width, id);

            return pageToShow;
        }
    }
}
