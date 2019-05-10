import controller.Controller;
import model.Model;
import view.View;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                View view = new View();
                Model model = new Model();
                Controller controller = new Controller(view, model);
                view.setVisible(true);
            }
        });
    }
}
