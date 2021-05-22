package web.commands;

import business.entities.CarportItem;
import business.exceptions.UserException;
import business.services.CarportFacade;
import business.services.SVG;
import business.services.UserFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
            int length = carportFacade.getLengthFromDB(id);
            int width = carportFacade.getWidthFromDB(id);
            int startOffset = 100;
            int endOffSet = 40;
            int endPost = length - endOffSet;
            int startPost = 100 + 110;
            int sixPostX = (startPost + (length - startPost - endOffSet) / 2);
            int eightPostX = (startPost + (length - startPost - endOffSet) / 3);
            int offSetEightPostX = (length - startPost - endOffSet) / 3;

            List<CarportItem> materialList = carportFacade.readFromOrderline(id);
            session.setAttribute("materialList", materialList);

            double price = materialList.get(0).getPrice();
            session.setAttribute("price", price);
            session.setAttribute("length", length);
            session.setAttribute("width", width);

            SVG svg = new SVG(0, 0, "0 0 1000 800", 100, 50);
            //tilføjer spær
            for (int x = 0; x < materialList.get(2).getQuantity(); x++) {
                svg.addRect(startOffset + 55 * x, 0, materialList.get(2).getLength(), 5);
            }
            //tilføjer remme
            svg.addRect(startOffset, 37, 5, length);
            svg.addRect(startOffset, width - 42, 5, length);

            //tilføjer stolper
            if (length > 400) {
                svg.addRect(startPost, 35, 10, 10);
                svg.addRect(endPost, 35, 10, 10);
                svg.addRect(startPost, width - 45, 10, 10);
                svg.addRect(endPost, width - 45, 10, 10);
            } else {
                svg.addRect(startOffset + 50, 35, 10, 10);
                svg.addRect(startOffset + length - endOffSet, 35, 10, 10);
                svg.addRect(startOffset + 50, width - 45, 10, 10);
                svg.addRect(startOffset + length - endOffSet, width - 45, 10, 10);

            }

            if (materialList.get(0).getQuantity() == 6) {
                svg.addRect(sixPostX, 35, 10, 10);
                svg.addRect(sixPostX, width - 45, 10, 10);
            } else if (materialList.get(0).getQuantity() == 8) {
                svg.addRect(eightPostX, 35, 10, 10);
                svg.addRect(eightPostX, width - 45, 10, 10);
                svg.addRect(eightPostX + offSetEightPostX, 35, 10, 10);
                svg.addRect(eightPostX + offSetEightPostX, width - 45, 10, 10);
            }

            svg.addLine(70, 0, 70, width);
            svg.addLine(startOffset, width + 30, length + startOffset, width + 30);
            svg.lengthTextTemplate(startOffset + (length / 2) - 20, width + 50, length);
            svg.widthTextTemplate(0, width / 2, width);

            request.setAttribute("svgdrawing", svg.toString());
            return pageToShow;
    }
}