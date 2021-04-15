package controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.*;

import java.net.URL;
import java.util.ResourceBundle;

public class AddMapController implements Initializable {


    @FXML
    private ChoiceBox mapPicker;

    @FXML
    private TextField newName, newAuthor, newPool, optString;

    @FXML
    private CheckBox newRage, newBlitz, showTeams, showTimer, optCheckBox1, optCheckBox2;

    @FXML
    private Spinner newTeams, newTimer, newPlayerCap, optSpinner1, optSpinner2;

    @FXML
    private Label optStringLabel, optCheckBox1Label, optCheckBox2Label, optSpinner1Label, optSpinner2Label, selectedLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mapPicker.getItems().addAll("CTW","DM","DTC","DTM","KOTH");
        mapPicker.setValue("CTW");
        SpinnerValueFactory<Integer> maxPlayerFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(2,2674,64);
        newPlayerCap.setValueFactory(maxPlayerFactory);
        SpinnerValueFactory<Integer> teamFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(2,8,2);
        newTeams.setValueFactory(teamFactory);
        SpinnerValueFactory<Integer> timeFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,7200,600);
        newTimer.setValueFactory(timeFactory);
        SpinnerValueFactory<Integer> objectiveFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(2,16,4);
        optSpinner1.setValueFactory(objectiveFactory);
        newTeams.setVisible(false);
        newTimer.setVisible(false);
        mapSelected();
    }

    @FXML
    public void addMap(ActionEvent event) throws Exception {
        Parent mapListParent = FXMLLoader.load(getClass().getResource("../views/mapList.fxml"));
        Scene mapListScene = new Scene(mapListParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Map Creator");
        window.setScene(mapListScene);
        window.show();
    }

    /**
     * saves the map
     */
    @FXML
    void saveMap(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        int teams = 0,timer = -1;
        if(showTeams.isSelected())
            teams = Integer.parseInt(newTeams.getValue().toString());
        if(showTimer.isSelected())
            timer = Integer.parseInt(newTimer.getValue().toString());
        String selected = mapPicker.getValue().toString();
        if(selected == "CTW") {
            try {
                CTW newMap = new CTW( newName.getText(),"giga", newAuthor.getText(), Integer.parseInt(newPlayerCap.getValue().toString()), newRage.isSelected(), newBlitz.isSelected(), teams, timer, Integer.parseInt(optSpinner1.getValue().toString()));
                MapListController.allMaps.add(newMap);
                System.out.println(MapListController.allMaps.get(2));
                addMap(event);
            } catch (Exception e) {
                alert.setContentText("Something went wrong. " + e.getMessage());
                alert.showAndWait();
            }
        }
    }

    /**
     * hides / shows the set teams spinner
     */
    @FXML
    void allowTeams(){
        if(newTeams.isVisible())
            newTeams.setVisible(false);
        else
            newTeams.setVisible(true);
    }

    /**
     * hides / shows the set timer spinner
     */
    @FXML
    void allowTimer(){
        if(newTimer.isVisible())
            newTimer.setVisible(false);
        else
            newTimer.setVisible(true);
    }

    /**
     * Clears all the optional options
     * Then checks to see which options to fill in
     */
    @FXML
    public void mapSelected(){
        String selected = mapPicker.getValue().toString();
        optStringLabel.setText("");
        optCheckBox1Label.setText("");
        optCheckBox2Label.setText("");
        optSpinner1Label.setText("");
        optSpinner2Label.setText("");
        optString.setVisible(false);
        optCheckBox1.setVisible(false);
        optCheckBox2.setVisible(false);
        optSpinner1.setVisible(false);
        optSpinner2.setVisible(false);
        if(selected == "CTW")
            setCTW();
        if(selected == "DM")
            setDM();
        if(selected == "DTC")
            setDTC();
        if(selected == "DTM")
            setDTM();
        if(selected == "KOTH")
            setKOTH();
    }

    /**
     * Fills in all the capture the wool options
     */
    private void setCTW() {
        selectedLabel.setText("Capture the Wool");
        optSpinner1Label.setText("Number of Wools:");
        optSpinner1.setVisible(true);
        showTeams.setSelected(true);
        newTeams.setVisible(true);
    }

    /**
     * Fills in all the death match options
     */
    private void setDM() {
        selectedLabel.setText("Death Match");
        optCheckBox1Label.setText("Free for All:");
        optCheckBox1.setVisible(true);
        optCheckBox2Label.setText("Random Spawns:");
        optCheckBox2.setVisible(true);
    }

    /**
     * Fills in all the destroy the core options
     */
    private void setDTC() {
        selectedLabel.setText("Destroy the Core");
        optStringLabel.setText("Core Material:");
        optString.setVisible(true);
        optCheckBox1Label.setText("Modes:");
        optCheckBox1.setVisible(true);
        optSpinner1Label.setText("Number of Cores:");
        optSpinner1.setVisible(true);
        optSpinner2Label.setText("Leak Down Required:");
        SpinnerValueFactory<Integer> leakDownFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,15,5);
        optSpinner2.setValueFactory(leakDownFactory);
        optSpinner2.setVisible(true);
        showTeams.setSelected(true);
        newTeams.setVisible(true);
    }

    /**
     * Fills in all the destroy the monument options
     */
    private void setDTM() {
        selectedLabel.setText("Destroy the Monument");
        optSpinner1Label.setText("Number of Monuments:");
        optSpinner1.setVisible(true);
        optSpinner2Label.setText("Monument Size:");
        SpinnerValueFactory<Integer> sizeFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,20,3);
        optSpinner2.setValueFactory(sizeFactory);
        optSpinner2.setVisible(true);
        optCheckBox1Label.setText("Obsidian:");
        optCheckBox1.setVisible(true);
        optCheckBox2Label.setText("Modes:");
        optCheckBox2.setVisible(true);
        showTeams.setSelected(true);
        newTeams.setVisible(true);
    }

    /**
     * Fills in all the king of the hill options
     */
    private void setKOTH() {
        selectedLabel.setText("King of the Hill");
        optSpinner1Label.setText("Number of Hills:");
        optSpinner1.setVisible(true);
        optSpinner2Label.setText("Number of points:");
        SpinnerValueFactory<Integer> pointsFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,4000,2000);
        optSpinner2.setValueFactory(pointsFactory);
        optSpinner2.setVisible(true);
    }

}
