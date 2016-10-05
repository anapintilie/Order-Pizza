package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MyController implements Initializable{

	@FXML
	private Button btnComanda;
	@FXML
	private TextField tfNume;
	@FXML
	private TextField tfNr;
	@FXML
	private ComboBox<String> comboSector;
	ObservableList<String> list=FXCollections.observableArrayList("Sector1","Sector2","Sector3","Sector4","Sector5","Sector6");
	@FXML
	private TextField tfAdr;
	@FXML
	Utilizator utilizator=new Utilizator();
	
	@Override
	public void initialize(URL location, ResourceBundle rb) {
		
		comboSector.setItems(list);
		
		
	}
	
	
	@FXML
	private void buttonClicked(ActionEvent event) throws IOException
	{
		//scriere in baza
		
		Connection co = application.SQLiteConnection.conectare();
	     String line = "insert into Comenzi(nume,nr_telefon,zona,adresa) values(?,?,?,?)";
	     try {
	    	 utilizator.setNume(tfNume.getText());
	    	 utilizator.setNr_telefon(Integer.parseInt(tfNr.getText()));
	    	 utilizator.setSector(comboSector.getValue());
	    	 utilizator.setAdresa(tfAdr.getText());
			PreparedStatement ps = co.prepareStatement(line);
			ps.setString(1,utilizator.getNume());
			ps.setInt(2,utilizator.getNr_telefon());
			ps.setString(3,utilizator.getSector());
			ps.setString(4,utilizator.getAdresa());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
		//new scene:
		Parent parent2=FXMLLoader.load(getClass().getResource("FrameMENIU.fxml"));
		Scene scene2=new Scene(parent2);
		Stage stage2=(Stage)((Node) event.getSource()).getScene().getWindow();
		stage2.hide();
		stage2.setScene(scene2);
		stage2.show();
	}
	
	
	
	}


