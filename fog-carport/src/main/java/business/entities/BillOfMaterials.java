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
// TODO: GetTotalPrice
}




