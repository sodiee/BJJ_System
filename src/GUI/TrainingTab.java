package GUI;

import Application.Controller.Controller;
import Application.Model.Fighter;
import Application.Model.JiuClass;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class TrainingTab extends GridPane {
    private Controller controller;
    private ListView<JiuClass> lvwJiuClasses;
    private ListView<Fighter> lvwFighters;
    private Button btnPromote, btnCreate;
    private Label lblFighter, lblFighterAge, lblFighterBelt, lblNumber, lblTotalNumber, lblRating, lblGym, lblGear, lblTopic, lblPromote, lblOpret;
    private TextField txfTotalNumberActual, txfNumberActual, txfRatingActual, txfGymActual, txfWearActual, txfFightersAgeActual, txfFightersNameActual, txfFighersBeltActualt;
    private TextArea txaTopic;

    public TrainingTab() {
        controller = new Controller();
        this.setVgap(10);
        this.setHgap(10);
        this.setGridLinesVisible(false);
        this.autosize();

        lvwFighters = new ListView<>();
        lvwFighters.getItems().setAll(controller.getFighters());
        this.add(lvwFighters, 0, 1);
        lvwFighters.getSelectionModel().selectedItemProperty().addListener((ov, oldValue, newValue) -> this.selectedFighterChanged(newValue));

        lvwJiuClasses = new ListView<>();
        lvwJiuClasses.getItems().setAll(controller.getJiuClasses());
        this.add(lvwJiuClasses, 2, 1);
        lvwJiuClasses.getSelectionModel().selectedItemProperty().addListener((ov, oldValue, newValue) -> this.selectedClassChanged(newValue));


        lblFighter = new Label("Fighter: ");
        this.add(lblFighter, 5, 1);
        lblFighterAge = new Label("Fighter's age: ");
        this.add(lblFighterAge, 5, 3);
        lblFighterBelt = new Label("Belt: ");
        this.add(lblFighterBelt, 5, 5);
        lblNumber = new Label("Training number: ");
        this.add(lblNumber, 5, 7);
        lblTotalNumber = new Label("Total number of trainings: ");
        this.add(lblTotalNumber, 5, 9);
        lblRating = new Label("Rating: ");
        this.add(lblRating, 5, 11);
        lblGym = new Label("Gym: ");
        this.add(lblGym, 5, 13);
        lblGear = new Label("Gear: ");
        this.add(lblGear, 5, 15);
        lblTopic = new Label("Topic: ");
        this.add(lblTopic, 5, 17);
        lblPromote = new Label("Promote to next belt: ");
        this.add(lblPromote, 0, 15);
        lblOpret = new Label("Register new class: ");
        this.add(lblOpret, 0, 13);

        btnCreate = new Button("Register Class");
        this.add(btnCreate, 0, 14);
        btnCreate.setOnAction(event -> this.createAction());

        btnPromote = new Button("Promote");
        this.add(btnPromote, 0, 16);
        btnPromote.setOnAction(event -> this.promoteToNewBelt());

        txfNumberActual = new TextField("");
        this.add(txfNumberActual, 6, 7);
        txfTotalNumberActual = new TextField("");
        this.add(txfTotalNumberActual, 6, 9);
        txfRatingActual = new TextField("");
        this.add(txfRatingActual, 6, 11);
        txfGymActual = new TextField("");
        this.add(txfGymActual, 6, 13);
        txfWearActual = new TextField("");
        this.add(txfWearActual, 6, 15);
        txfFightersNameActual = new TextField("");
        this.add(txfFightersNameActual, 6, 1);
        txfFightersAgeActual = new TextField();
        this.add(txfFightersAgeActual, 6, 3);
        txfFighersBeltActualt = new TextField();
        this.add(txfFighersBeltActualt, 6, 5);

        txaTopic = new TextArea();
        this.add(txaTopic, 6, 17);
    }

    private void createAction() {
        JiuClassCreateWindow jiuClassCreateWindow = new JiuClassCreateWindow();
        jiuClassCreateWindow.showAndWait();
        lvwJiuClasses.getItems().setAll(controller.getJiuClasses());
    }

    private void promoteToNewBelt() {
        controller.promoteJiuBelt(lvwFighters.getSelectionModel().getSelectedItem());
        Alert promoteAlert = new Alert(Alert.AlertType.INFORMATION);
        promoteAlert.setContentText("Promotion to new belt for " + lvwFighters.getSelectionModel().getSelectedItem() + " succeeded!");
        promoteAlert.showAndWait();
    }

    private void selectedClassChanged(JiuClass newValue) {
        if (newValue != null) {
            if (lvwJiuClasses.getSelectionModel().getSelectedItem() != null) {
                txfNumberActual.setText(String.valueOf(lvwJiuClasses.getSelectionModel().getSelectedItem().getNumber()));
                txfTotalNumberActual.setText(String.valueOf(lvwJiuClasses.getSelectionModel().getSelectedItem().getTotalNumber()));
                txfRatingActual.setText(String.valueOf(lvwJiuClasses.getSelectionModel().getSelectedItem().getRating()));
                txfGymActual.setText(String.valueOf(lvwJiuClasses.getSelectionModel().getSelectedItem().getGym()));
                txfWearActual.setText(String.valueOf(lvwJiuClasses.getSelectionModel().getSelectedItem().getWear()));
                txaTopic.setText(lvwJiuClasses.getSelectionModel().getSelectedItem().getTopic());
            }
        }
    }

    private void selectedFighterChanged(Fighter newValue) {
        if (newValue != null) {
            if (lvwFighters.getSelectionModel().getSelectedItem() != null) {
                txfFightersNameActual.setText(lvwFighters.getSelectionModel().getSelectedItem().getName());
                txfFightersAgeActual.setText(String.valueOf(lvwFighters.getSelectionModel().getSelectedItem().getAge()));
                txfFighersBeltActualt.setText(String.valueOf(lvwFighters.getSelectionModel().getSelectedItem().getBelt()));
            }
        }
    }

    private void init() {
        controller.initStorage();
    }
}
