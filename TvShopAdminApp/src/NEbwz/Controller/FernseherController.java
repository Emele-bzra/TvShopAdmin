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
        return this.fernseherPersistence.getFernseher();
    }

    public void addFernseher(Fernseher toAdd)  {
        this.fernseherPersistence.addFernseher(toAdd);
    }

    public void updateFernseher(Fernseher toUpdate)  {
        this.fernseherPersistence.updateFernseher(toUpdate);
    }

    public void deleteFernseher(Fernseher toDelete) {
        this.fernseherPersistence.deleteFernseher(toDelete);
    }

}
