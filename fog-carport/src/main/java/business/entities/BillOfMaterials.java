package business.entities;

import java.util.ArrayList;
import java.util.List;

public class BillOfMaterials {

    List<CarportItem> materialList = new ArrayList<>();

    public List<CarportItem> getMaterialList() {
        return materialList;
    }

    public void addItem(CarportItem carportItem) {
        materialList.add(carportItem);
    }

    public int GetTotalPrice (List<CarportItem> materialList){
        int totalPrice = 0;
        for (CarportItem c: materialList) {
            totalPrice += c.getPrice();
        }
        return totalPrice;
    }
}