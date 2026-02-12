package NEbwz.Controller;

import NEbwz.Model.Fernseher;
import NEbwz.Persistance.FernseherPersistence;

import java.util.ArrayList;
import java.util.List;

public class FernseherController {
    private FernseherPersistence fernseherPersistence;

    public FernseherController(FernseherPersistence fernseherPersistence) {
        this.fernseherPersistence = fernseherPersistence;
    }

    public List<Fernseher> readFernseher() {
        return new ArrayList<>();
    }

    public void addFernseher(Fernseher toAdd)  {

    }

    public void updateFernseher(int index, Fernseher toUpdate)  {

    }

    public void deleteFernseher(Fernseher toDelete) {

    }

}
