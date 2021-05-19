package web.commands;

import business.entities.CarportItem;
import business.entities.Request;
import business.exceptions.UserException;
import business.services.CarportFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


public class StatusCommand extends CommandProtectedPage {

    CarportFacade carportFacade;

    public StatusCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.carportFacade = new CarportFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        HttpSession session = request.getSession();

        System.out.println("here i am");
        int id = (int) session.getAttribute("id");
        double price = (double) session.getAttribute("totalpris");
        System.out.println(id);
        String status = "";
        String denied = request.getParameter("Afvis");
        String approved = request.getParameter("Godkend");
        if (denied !=null && denied.equals("Afvist")){
            status = denied;
        } else if (approved !=null && approved.equals("Godkendt")){
            status = approved;
            List<CarportItem> materialList = (List<CarportItem>) session.getAttribute("billOfMaterials");
            for (CarportItem c:materialList) {
                carportFacade.writeToOrderline(id, c.getId(), c.getDescription(), c.getQuantity(), c.getLength());
            }
        }
        carportFacade.updateStatus(id, status, price);
        List<Request> requestList = carportFacade.getAllRequestsFromDB();

        session.setAttribute("requestList", requestList);
        return pageToShow;
    }
}
