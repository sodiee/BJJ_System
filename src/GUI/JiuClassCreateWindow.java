package GUI;

import Application.Controller.Controller;
import Application.Model.Class;
import Application.Model.Fighter;
import Application.Model.Wear;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class JiuClassCreateWindow extends Stage {
    private Controller controller;
    private ListView<Fighter> lvwFighters;
    private Label lblNumber, lblRating, lblGym, lblGear, lblTopic, lblFighter, lblClass;
    private TextField txfNumber, txfRating, txfGym, txfTopic;
    private Button btnRegister, btnCancel;
    private ComboBox cBoxGear, cBoxClass;
    private ObservableList<String> cBoxGearValues = FXCollections.observableArrayList("GI", "NOGI");
    private ObservableList<String> cBoxClassValues = FXCollections.observableArrayList("BASICS", "BJJ", "NOGI");

    public JiuClassCreateWindow() {
        controller = new Controller();
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setTitle("Register Jiu Class");
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane);
        this.setScene(scene);
        this.setHeight(600);
        this.initGUI(pane);
    }

    private void initGUI(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(5);
        pane.setGridLinesVisible(false);

        lblNumber = new Label("Number:");
        pane.add(lblNumber, 0, 0);
        txfNumber = new TextField();
        pane.add(txfNumber, 0, 1);

        lblRating = new Label("Rating:");
        pane.add(lblRating, 0, 2);
        txfRating = new TextField();
        pane.add(txfRating, 0, 3);

        lblGym = new Label("Gym:");
        pane.add(lblGym, 0, 4);
        txfGym = new TextField();
        pane.add(txfGym, 0, 5);

        lblGear = new Label("Gear:");
        pane.add(lblGear, 0, 6);
        cBoxGear = new ComboBox(cBoxGearValues);
        pane.add(cBoxGear, 0, 7);


        lblTopic = new Label("Topic:");
        pane.add(lblTopic, 0, 9);
        txfTopic = new TextField();
        pane.add(txfTopic, 0, 10);

        lblClass = new Label("Class:");
        pane.add(lblClass, 0, 11);
        cBoxClass = new ComboBox(cBoxClassValues);
        pane.add(cBoxClass, 0, 12);

        lblFighter = new Label("Fighter:");
        pane.add(lblFighter, 0, 13);

        lvwFighters = new ListView<>();
        lvwFighters.getItems().setAll(controller.getFighters());
        pane.add(lvwFighters, 0, 14);

        //Buttons
        HBox hbxButtons = new HBox(5);
        pane.add(hbxButtons, 0, 16);
        btnRegister = new Button("Register");
        btnRegister.setOnAction(event -> registerAction());
        hbxButtons.getChildren().add(btnRegister);
        btnCancel = new Button("Cancel");
        btnCancel.setOnAction(event -> cancelAction());
        hbxButtons.getChildren().add(btnCancel);
    }

    private void registerAction() {
        if (cBoxGear.getSelectionModel().getSelectedItem() == "GI") {
            controller.createJiuClass(Integer.parseInt(txfNumber.getText()), Integer.parseInt(txfRating.getText()), txfGym.getText(), Wear.GI, txfTopic.getText(), lvwFighters.getSelectionModel().getSelectedItem().getBelt(), lvwFighters.getSelectionModel().getSelectedItem(), Class.valueOf(cBoxClass.getSelectionModel().getSelectedItem().toString()));
        } else {
            controller.createJiuClass(Integer.parseInt(txfNumber.getText()), Integer.parseInt(txfRating.getText()), txfGym.getText(), Wear.NOGI, txfTopic.getText(), lvwFighters.getSelectionModel().getSelectedItem().getBelt(), lvwFighters.getSelectionModel().getSelectedItem(), Class.valueOf(cBoxClass.getSelectionModel().getSelectedItem().toString()));
        }
        this.hide();
    }

    private void cancelAction() {
        this.hide();
    }
}
