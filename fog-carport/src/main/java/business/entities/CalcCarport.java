package business.entities;

import business.exceptions.UserException;
import business.persistence.CarportMapper;

public class CalcCarport {

    CarportMapper carportMapper;

    public Result calcPosts(int length) throws UserException {
        int quantity = 2*(2+(length - 110 - 30)/310);
        int postLength = 300;
        int id = 3;
        double pricePerUnit = 120;
        double price = pricePerUnit * quantity;
        return new Result(postLength, quantity, id, price);
    }

    public Result calcBeams(int length) throws UserException {
        int quantity = 2;
        int beamLength = length;
        int id = 10;
        double pricePerUnit = 0.46;
        double price = (beamLength * pricePerUnit) * quantity;
        return new Result(beamLength, quantity, id, price);
    }

    public Result calcRafter(int length, int width) throws UserException {
        int quantity = length/55;
        int rafterLength = width;
        int id = 12;
        double pricePerUnit = 0.46;
        double price = (pricePerUnit * rafterLength) * quantity;
        return new Result(rafterLength, quantity, id, price);
    }

    public Result calcPlastmo(int length, int width) throws UserException {
        int plastmoWidth = 109;
        int plastmoLength = width;
        int amount = (int) Math.ceil((float)length/plastmoWidth);
        int overlap = (amount - 1) * 20;
        int totalLength = overlap + length;
        int quantity = (int) Math.ceil((float)totalLength/plastmoWidth);
        int id = 16;
        double pricePerUnit = 0.37;
        double price = (pricePerUnit * plastmoLength) * quantity;
        return new Result(plastmoLength, quantity, id, price);
    }

    public Result calcPostbolts(int length) throws UserException {
        int boltLength = 12;
        Result posts = calcPosts(length);
        int quantity = posts.getQuantity() * 2;
        int id = 23;
        double pricePerUnit = 4.16;
        double price = pricePerUnit * quantity;
        return new Result(boltLength, quantity, id, price);
    }

    public Result calcSquareDiscs(int length) throws UserException {
        int discSize = 4;
        Result bolts = calcPostbolts(length);
        int quantity = bolts.getQuantity();
        int id = 24;
        double pricePerUnit = 2.58;
        double price = pricePerUnit * quantity;
        return new Result(discSize, quantity, id, price);
    }

    public Result calcUniRight(int length, int width) throws UserException {
        int uniSize = 19;
        Result rafters = calcRafter(length, width);
        int quantity = rafters.getQuantity();
        int id = 19;
        double pricePerUnit = 50;
        double price = pricePerUnit * quantity;
        return new Result(uniSize, quantity, id, price);
    }

    public Result calcUniLeft(int length, int width) throws UserException {
        int uniSize = 19;
        Result rafters = calcRafter(length, width);
        int quantity = rafters.getQuantity();
        int id = 20;
        double pricePerUnit = 50;
        double price = pricePerUnit * quantity;
        return new Result(uniSize, quantity, id, price);
    }

    public Result calcPlastmoBolt(int length, int width) throws UserException {
        int boltSize = 0;
        Result plastmo = calcPlastmo(length, width);
        int quantity = (int) Math.ceil((float)plastmo.getQuantity()/4);
        int id = 17;
        double pricePerUnit = 195;
        double price = pricePerUnit * quantity;
        return new Result(boltSize, quantity, id, price);
    }
}
