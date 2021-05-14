package web.commands;

import business.entities.*;
import business.exceptions.UserException;
import business.services.CarportFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CalcCarportCommand extends CommandProtectedPage {

    CarportFacade carportFacade;

    public CalcCarportCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.carportFacade = new CarportFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        HttpSession session = request.getSession();
        CalcCarport calcCarport = new CalcCarport();
        BillOfMaterials billOfMaterials = new BillOfMaterials();

        int id = Integer.parseInt(request.getParameter("forespørgsel"));
        int length = carportFacade.getLengthFromDB(id);
        int width = carportFacade.getWidthFromDB(id);

        String postDesc = "Stolper nedgraves 90 cm. i jord";
        String beamDesc = "Remme i sider, sadles ned i stolper";
        String rafterDesc = "Spær, monteres på rem";
        String plastmoDesc = "Tagplader monteres på spær";
        String boltDesc = "Til montering af rem på stolper";
        String squareDiscDesc = "Til montering af rem på stolper";
        String uniRightDesc = "Til montering af spær på rem";
        String uniLeftDesc = "Til montering af spær på rem";
        String plastmoBoltDesc = "Skruer til tagplader";

        Result post = calcCarport.calcPosts(length);
        Result beam = calcCarport.calcBeams(length);
        Result rafter = calcCarport.calcRafter(length, width);
        Result plastmo = calcCarport.calcPlastmo(length, width);
        Result bolt = calcCarport.calcPostbolts(length);
        Result squareDisc = calcCarport.calcSquareDiscs(length);
        Result uniRight = calcCarport.calcUniRight(length, width);
        Result uniLeft = calcCarport.calcUniLeft(length, width);
        Result plastmoBolt = calcCarport.calcPlastmoBolt(length, width);


        CarportItem posts = new CarportItem(post.getLength(), post.getQuantity(), 0 , postDesc, post.getId());
        CarportItem beams = new CarportItem(beam.getLength(), beam.getQuantity(), 0 , beamDesc, beam.getId());
        CarportItem rafters = new CarportItem(rafter.getLength(), rafter.getQuantity(), 0, rafterDesc, rafter.getId());
        CarportItem plastmos = new CarportItem(plastmo.getLength(), plastmo.getQuantity(), 0, plastmoDesc, plastmo.getId());
        CarportItem bolts = new CarportItem(bolt.getLength(), bolt.getQuantity(), 0, boltDesc, bolt.getId());
        CarportItem squareDiscs = new CarportItem(squareDisc.getLength(), squareDisc.getQuantity(), 0, squareDiscDesc, squareDisc.getId());
        CarportItem uniRights = new CarportItem(uniRight.getLength(), uniRight.getQuantity(), 0, uniRightDesc, uniRight.getId());
        CarportItem uniLefts = new CarportItem(uniLeft.getLength(), uniLeft.getQuantity(), 0, uniLeftDesc, uniLeft.getId());
        CarportItem plastmoBolts = new CarportItem(plastmoBolt.getLength(), plastmoBolt.getQuantity(), 0 ,plastmoBoltDesc, plastmoBolt.getId());

        billOfMaterials.addItem(posts);
        billOfMaterials.addItem(beams);
        billOfMaterials.addItem(rafters);
        billOfMaterials.addItem(plastmos);
        billOfMaterials.addItem(bolts);
        billOfMaterials.addItem(squareDiscs);
        billOfMaterials.addItem(uniRights);
        billOfMaterials.addItem(uniLefts);
        billOfMaterials.addItem(plastmoBolts);

        for (CarportItem c: billOfMaterials.getMaterialList()) {
            carportFacade.writeToOrderline(id,c.getId(), c.getDescription(), c.getQuantity(), c.getLength());
        }

        List<Stykliste> materialList = carportFacade.getMaterialListFromRequestID(id);

        session.setAttribute("billOfMaterials", materialList);
        session.setAttribute("længde", length);
        session.setAttribute("bredde", width);

        return pageToShow;
    }
}
