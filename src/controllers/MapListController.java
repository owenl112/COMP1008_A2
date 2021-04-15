package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import models.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MapListController implements Initializable {
    public static ArrayList<Object> allMaps = new ArrayList<>();

    @FXML
    public Label mapName, mapAuthor, mapType, mapPool, mapMaxPlayers, mapTeams, mapTimer, mapRage, mapBlitz, extra1, extra2;

    @FXML
    public ListView listMaps;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(allMaps.size()==0)
            allMaps.addAll(utilities.DBUtility.getMaps());
        listMaps.getItems().clear();
        listMaps.getItems().addAll(allMaps);
        updateText();
    }

    /**
     * Code to create a new window for adding a map
     * @param event
     * @throws Exception
     */
    @FXML
    public void addMap(ActionEvent event) throws Exception {
        Parent allMapsParent = FXMLLoader.load(getClass().getResource("../views/addMap.fxml"));
        Scene allMapsScene = new Scene(allMapsParent);
        Stage window = (Stage) (((Node)event.getSource()).getScene().getWindow());
        window.setScene(allMapsScene);
        window.show();
    }

    /**
     * Updates the text of map information when a new item is clicked
     */
    public void updateText() {
        // create an Object for the selected Object
        Map currentMap;
        if(listMaps.getSelectionModel().getSelectedIndex() == -1) // if it just launched it is set to -1,
            currentMap = (Map)allMaps.get(0);// so just make that the first one
        else
            currentMap = (Map) allMaps.get(listMaps.getSelectionModel().getSelectedIndex()); // otherwise make it the selected one

        // set all the stuff that stays the same
        mapName.setText( currentMap.getName());
        mapAuthor.setText("By: " + currentMap.getAuthorUUID());
        mapPool.setText("Pools: " +currentMap.getPool());
        mapMaxPlayers.setText("Max Players: " + currentMap.getMaxPlayers());
        if(currentMap.getTeams() != -1) {
            mapTeams.setText("Teams: " + currentMap.getTeams());
        } else {
            mapTeams.setText("There are no Teams");
        }
        if(currentMap.getTimer() != -1)
            mapTimer.setText( currentMap.getTimer()/60 +" minutes set");
        else
            mapTimer.setText("No Timer Set");

        mapBlitz.setText("Blitz OFF");
        mapRage.setText("Rage OFF");
        extra1.setText("");
        extra2.setText("");
        if(currentMap.isBlitz() == true) {
            mapBlitz.setText("Blitz ON");
        }

        if(currentMap.isRage() == true) {
            mapRage.setText("Rage ON");
        }
        // if it's actually a CTW then set the other stuff
        if(currentMap.getClass().getName() == "models.CTW"){
            CTW map = (CTW) currentMap;
            mapType.setText("CTW");
            extra1.setText("Number of wools: " + map.getNumOfWool());
            extra2.setText("");
        }
        else if(currentMap.getClass().getName() == "models.DM"){
            DM map = (DM) currentMap;
            mapType.setText("DM");
            if(map.isFree4All())
                extra1.setText("Free for All");
            if(map.isRandomSpawns())
                extra2.setText("Spawn's are Random");
        }
        else if(currentMap.getClass().getName() == "models.KOTH"){
            KOTH map = (KOTH) currentMap;
            mapType.setText("KOTH");
            extra1.setText( map.getNumOfHills() + " hills");
            extra2.setText( map.getMaxScore() + " points required");
        }
        else if(currentMap.getClass().getName() == "models.DTM"){
            DTM map = (DTM) currentMap;
            mapType.setText("DTM");
            extra1.setText(map.monPerTeam() + ", " + map.getMonumentSize() + " sized monuments");
            if(map.isMonumentObs())
                extra2.setText("The Obsidian monuments ");
            else
                extra2.setText("The monuments");
            if(map.isMonumentModes())
                extra2.setText(extra2.getText() + "have modes");
            else
                extra2.setText(extra2.getText() + "don't have modes");
        }
        else if(currentMap.getClass().getName() == "models.DTC"){
            DTC map = (DTC) currentMap;
            mapType.setText("DTC");
            extra1.setText(map.coresPerTeam() + " cores per team made of " + map.getCoreMaterial());
            extra2.setText("The cores need to leak " + map.getLeakDown() + " and ");
            if(map.isCoreModes())
                extra2.setText(extra2.getText() + "does have modes");
            else
                extra2.setText(extra2.getText() + "doesn't have modes");
        }


    }
}
