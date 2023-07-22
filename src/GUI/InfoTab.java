package GUI;

import Application.Controller.Controller;
import Application.Model.Fighter;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class InfoTab extends GridPane {
    private Controller controller;
    private ListView<Fighter> lvwFighters;
    private Label lblTotalNumber, lblTotalHours;
    private TextField txfTotalNumberActual, txfTotalHours;
    public InfoTab() {
        controller = new Controller();
        this.setVgap(10);
        this.setHgap(10);
        this.setGridLinesVisible(false);
        this.autosize();

        lvwFighters = new ListView<>();
        lvwFighters.getItems().setAll(controller.getFighters());
        lvwFighters.getSelectionModel().selectedItemProperty().addListener((ov, oldValue, newValue) -> this.selectedFighterChanged(newValue));
        this.add(lvwFighters, 0, 0, 1, 3);

        lblTotalNumber = new Label("Total number of trainings:");
        this.add(lblTotalNumber, 1, 0);
        txfTotalNumberActual = new TextField();
        this.add(txfTotalNumberActual, 2, 0);

        lblTotalHours = new Label("Total hours:");
        this.add(lblTotalHours, 1, 1);
        txfTotalHours = new TextField();
        this.add(txfTotalHours, 2, 1);
    }

    private void selectedFighterChanged(Fighter newValue) {
        if (newValue != null) {
            if (lvwFighters.getSelectionModel().getSelectedItem() != null) {
                txfTotalNumberActual.setText(String.valueOf(lvwFighters.getSelectionModel().getSelectedItem().getTotalNumberOfClasses()));
                txfTotalHours.setText(String.valueOf(lvwFighters.getSelectionModel().getSelectedItem().getTotalDuration()));
            }
        }
    }
}
