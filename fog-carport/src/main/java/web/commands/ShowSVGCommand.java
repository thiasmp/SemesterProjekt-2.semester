package web.commands;

import business.entities.CarportItem;
import business.exceptions.UserException;
import business.persistence.CarportMapper;
import business.services.CarportFacade;
import business.services.SVG;
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
        int length = carportFacade.getLengthFromDB(id);
        int width = carportFacade.getWidthFromDB(id);
        int offset = 40;
        int endpost = length - offset;
        int startpost = 100 + 110;
        int sixpostX = (startpost + (length - startpost - offset)/2);
        int eightpostX = (startpost + (length - startpost - offset)/3);
        int offseteightpostX = (length - startpost -offset)/3;



        List<CarportItem> materialList = carportFacade.readFromOrderline(id);
        session.setAttribute("materialList", materialList);

        double price = materialList.get(0).getPrice();
        session.setAttribute("price", price);
        session.setAttribute("length",length);
        session.setAttribute("width",width);

        SVG svg = new SVG(0, 0, "0 0 800 600", 100, 50 );
        //tilføjer spær
        for (int x = 0; x < materialList.get(2).getQuantity(); x++)
        {
            svg.addRect(100 + 55 * x, 0, materialList.get(2).getLength(), 5);
        }

        //tilføjer stolper
        if (length > 450) {
            svg.addRect(startpost, 35, 10, 10);
            svg.addRect(endpost, 35, 10, 10);
            svg.addRect(startpost, width - 45, 10, 10);
            svg.addRect(endpost, width - 45, 10, 10);
        }
        else
        {
            svg.addRect(100 + 50,35,10,10);
            svg.addRect(length - 40,35,10,10);
            svg.addRect(100 + 50,width - 45,10,10);
            svg.addRect(length - 40,width - 45,10,10);

        }

        if (materialList.get(0).getQuantity() == 6)
        {
            svg.addRect(sixpostX,35,10,10);
            svg.addRect(sixpostX,width-45,10,10);
        }
        else if (materialList.get(0).getQuantity() == 8)
        {
            svg.addRect(eightpostX,35,10,10);
            svg.addRect(eightpostX,width-45,10,10);
            svg.addRect(eightpostX + offseteightpostX,35,10,10);
            svg.addRect(eightpostX + offseteightpostX,width-45,10,10);
        }
        else


//        for (int x = 0; x < materialList.get(0).getQuantity(); x++)
//        {
//            svg.addRect(100 + 110 * x,35,10,10 );
//        }
        request.setAttribute("svgdrawing", svg.toString());


        return pageToShow;
    }

}
