package NEbwz;

import NEbwz.Controller.BestellungController;
import NEbwz.Controller.FernseherController;
import NEbwz.Controller.KundenController;
import NEbwz.Controller.MainFrameController;
import NEbwz.View.MainFrame;

public class Main {
    public static void main(String[] args) {

        MainFrame frame = new MainFrame(new MainFrameController());
        frame.setVisible(true);
    }
}