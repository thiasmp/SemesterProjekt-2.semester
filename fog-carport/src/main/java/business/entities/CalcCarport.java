package business.entities;

public class CalcCarport {

    public Result calcPosts(int length) {
        int quantity = 2*(2+(length - 100 - 20)/310);
        int postLength = 300;
        int id = 3;
        return new Result(postLength, quantity, id);
    }

    public Result calcBeams(int length) {
        int quantity = 2;
        int beamLength = length;
        int id = 10;
        return new Result(beamLength, quantity, id);
    }

    public Result calcRafter(int length, int width) {
        int quantity = length/55;
        int rafterLength = width;
        int id = 12;
        return new Result(rafterLength, quantity, id);
    }

    public Result calcPlastmo(int length, int width){
        int plastmoWidth = 109;
        int plastmoLength = width;
        int amount = (int) Math.ceil((float)length/plastmoWidth);
        int overlap = (amount - 1) * 20;
        int totalLength = overlap + length;
        int quantity = (int) Math.ceil((float)totalLength/plastmoWidth);
        int id = 16;
        return new Result(plastmoLength, quantity, id);
    }

    public Result calcPostbolts(int length) {
        int boltLength = 12;
        Result posts = calcPosts(length);
        int quantity = posts.getQuantity() * 2;
        int id = 23;
        return new Result(boltLength, quantity, id);
    }

    public Result calcSquareDiscs(int length) {
        int discSize = 4;
        Result bolts = calcPostbolts(length);
        int quantity = bolts.getQuantity();
        int id = 24;
        return new Result(discSize, quantity, id);
    }

    public Result calcUniRight(int length, int width) {
        int uniSize = 19;
        Result rafters = calcRafter(length, width);
        int quantity = rafters.getQuantity();
        int id = 19;
        return new Result(uniSize, quantity, id);
    }

    public Result calcUniLeft(int length, int width) {
        int uniSize = 19;
        Result rafters = calcRafter(length, width);
        int quantity = rafters.getQuantity();
        int id = 20;
        return new Result(uniSize, quantity, id);
    }

    public Result calcPlastmoBolt(int length, int width) {
        int boltSize = 0;
        Result plastmo = calcPlastmo(length, width);
        int quantity = (int) Math.ceil((float)plastmo.getQuantity()/4);
        int id = 17;
        return new Result(boltSize, quantity, id);
    }
}
