import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.event.*;

import java.util.Random;

class Stoppbehandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
  Platform.exit();
}
}
