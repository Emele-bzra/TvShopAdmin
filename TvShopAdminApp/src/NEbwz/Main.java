package NEbwz;

import NEbwz.Controller.MainFrameController;
import NEbwz.View.MainFrame;

public class Main {
    public static void main(String[] args) {
        MainFrameController mainFrameConroller = new MainFrameController();
        MainFrame frame = new MainFrame(mainFrameConroller);
            frame.setVisible(true);
    }
}