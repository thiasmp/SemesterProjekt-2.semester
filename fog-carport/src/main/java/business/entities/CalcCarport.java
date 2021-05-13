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
        return new Result(rafterLength, quantity, 12);
    }
}
