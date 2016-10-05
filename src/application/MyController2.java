package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

import javafx.scene.control.ComboBox;

public class MyController2 implements Initializable {

	@FXML
	private ComboBox cbM;
	ObservableList<String> list1 = FXCollections.observableArrayList("Ø25cm|26 RON", "Ø30cm|29 RON", "Ø40cm|34 RON");
	@FXML
	private ComboBox cbQ;
	ObservableList<String> list2 = FXCollections.observableArrayList("Ø25cm|25 RON", "Ø30cm|28 RON", "Ø40cm|33 RON");
	@FXML
	private ComboBox cbP;
	ObservableList<String> list3 = FXCollections.observableArrayList("Ø25cm|27 RON", "Ø30cm|30 RON", "Ø40cm|34 RON");
	@FXML
	private ComboBox cbD;
	ObservableList<String> list4 = FXCollections.observableArrayList("Ø25cm|25 RON", "Ø30cm|27 RON", "Ø40cm|31 RON");

	@FXML
	private ComboBox buc1;
	ObservableList<String> l1 = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
	@FXML
	private ComboBox buc2;
	ObservableList<String> l2 = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
	@FXML
	private ComboBox buc3;
	ObservableList<String> l3 = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
	@FXML
	private ComboBox buc4;
	ObservableList<String> l4 = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

	@FXML
	private Button btn1, btn2, btn3, btn4;

	Pizza mexicana = new Pizza();
	Pizza diavolo = new Pizza();
	Pizza prosciutto = new Pizza();
	Pizza quattro = new Pizza();

	// @FXML
	// private ButtonBar btnTotal;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cbM.setItems(list1);
		cbQ.setItems(list2);
		cbP.setItems(list3);
		cbD.setItems(list4);

		buc1.setItems(l1);
		buc2.setItems(l2);
		buc3.setItems(l3);
		buc4.setItems(l4);

		// citesc din fis txt:
		try {
			BufferedReader bf = new BufferedReader(new FileReader("Mexicana.txt"));
			//scriere in binar:
			FileOutputStream fos = new FileOutputStream(new File("fisier.dat"));
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			
			
			String linie = "";
			String[] tmp = new String[6];
			int i = 0;

			linie = bf.readLine();
			mexicana.setNume(linie);

			while ((linie = bf.readLine()) != null) {
				tmp[i] = linie;
				i++;
			}
			mexicana.setDen(tmp);
			oos.writeObject(mexicana);
			

			i = 0;
			// fis 2:
			bf = new BufferedReader(new FileReader("Diavolo.txt"));
			linie = bf.readLine();
			diavolo.setNume(linie);
			while ((linie = bf.readLine()) != null) {
				tmp[i] = linie;
				i++;
			}
			diavolo.setDen(tmp);
			oos.writeObject(diavolo);
			
			i = 0;
			// fis3:
			bf = new BufferedReader(new FileReader("Prosciutto.txt"));
			linie = bf.readLine();
			prosciutto.setNume(linie);
			while ((linie = bf.readLine()) != null) {
				tmp[i] = linie;
				i++;
			}
			prosciutto.setDen(tmp);
			oos.writeObject(prosciutto);
			
			i = 0;
			// fis4:
			bf = new BufferedReader(new FileReader("Quattro.txt"));
			linie = bf.readLine();
			quattro.setNume(linie);
			while ((linie = bf.readLine()) != null) {
				tmp[i] = linie;
				i++;
			}
			quattro.setDen(tmp);
			oos.writeObject(quattro);
			oos.close();
			fos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	public void Clicked(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Ingrediente " + mexicana.getNume());
		alert.setHeaderText(null);
		alert.setContentText(mexicana.afiseaza());

		alert.showAndWait();
	}

	public void Clicked2(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Ingrediente " + quattro.getNume());
		alert.setHeaderText(null);
		alert.setContentText(quattro.afiseaza());

		alert.showAndWait();
	}

	public void Clicked3(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Ingrediente " + prosciutto.getNume());
		alert.setHeaderText(null);
		alert.setContentText(prosciutto.afiseaza());

		alert.showAndWait();
	}

	public void Clicked4(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Ingrediente " + diavolo.getNume());
		alert.setHeaderText(null);
		alert.setContentText(diavolo.afiseaza());

		alert.showAndWait();
	}

	Map<Integer,Pizza>vector=new HashMap<Integer,Pizza>();
	int tota=0;
	public void total(ActionEvent event)
	{
		if( cbM.getValue()!=null && buc1.getValue()!=null)
		{
			if(cbM.getValue().toString()=="Ø25cm|26 RON")
			{
				int i=Integer.parseInt((String) buc1.getValue());
				tota=tota+i*26;
				vector.put(i,mexicana);
			}
			if(cbM.getValue().toString()=="Ø30cm|29 RON")
			{
				int i=Integer.parseInt((String) buc1.getValue());
				tota=tota+i*29;
				vector.put(i,mexicana);
			}
			if(cbM.getValue().toString()=="Ø40cm|34 RON")
			{
				int i=Integer.parseInt((String) buc1.getValue());
				tota=tota+i*34;
				vector.put(i,mexicana);
			}
		}
		if(cbQ.getValue()!=null && buc2.getValue()!=null)
		{
			if(cbQ.getValue().toString()=="Ø25cm|25 RON")
			{
				int i=Integer.parseInt((String) buc2.getValue());
				tota=tota+i*25;
				vector.put(i,quattro);
			}
			
			if(cbQ.getValue().toString()=="Ø30cm|28 RON")
			{
				int i=Integer.parseInt((String) buc2.getValue());
				tota=tota+i*28;
				vector.put(i,quattro);
			}
			if(cbQ.getValue().toString()=="Ø40cm|33 RON")
			{
				int i=Integer.parseInt((String) buc2.getValue());
				tota=tota+i*33;
				vector.put(i,quattro);
			}
		}
		if(cbP.getValue()!=null && buc3.getValue()!=null)
		{
			if(cbP.getValue().toString()=="Ø25cm|27 RON")
			{
				int i=Integer.parseInt((String) buc3.getValue());
				tota=tota+i*27;
				vector.put(i,prosciutto);
			}
			
			if(cbP.getValue().toString()=="Ø30cm|30 RON")
			{
				int i=Integer.parseInt((String) buc3.getValue());
				tota=tota+i*30;
				vector.put(i,prosciutto);
			}
			if(cbP.getValue().toString()=="Ø40cm|34 RON")
			{
				int i=Integer.parseInt((String) buc3.getValue());
				tota=tota+i*34;
				vector.put(i,prosciutto);
			}
		}
		if(cbD.getValue()!=null && buc4.getValue()!=null)
		{
			if(cbD.getValue().toString()=="Ø25cm|25 RON")
			{
				int i=Integer.parseInt((String) buc4.getValue());
				tota=tota+i*25;
				vector.put(i,diavolo);
			}
			
			if(cbD.getValue().toString()=="Ø30cm|27 RON")
			{
				int i=Integer.parseInt((String) buc4.getValue());
				tota=tota+i*27;
				vector.put(i,diavolo);
			}
			if(cbD.getValue().toString()=="Ø40cm|31 RON")
			{
				int i=Integer.parseInt((String) buc4.getValue());
				tota=tota+i*31;
				vector.put(i,diavolo);
			}
		}
		
		System.out.println(tota);
		tota=0;
		cbM.setValue(null);
		cbQ.setValue(null);
		cbP.setValue(null);
		cbD.setValue(null);
		buc1.setValue(null);
		buc2.setValue(null);
		buc3.setValue(null);
		buc4.setValue(null);
		

		Utilizator utilizator=new Utilizator();
		//citire din baza si scriere in fisier txt:
		 try {
		     Connection co = application.SQLiteConnection.conectare();
		     String line = "select * from Comenzi";
		     PreparedStatement ps = co.prepareStatement(line);
		     ResultSet rs = ps.executeQuery();
		     //scriere in fis txt:
		     BufferedWriter bw = new BufferedWriter(new FileWriter(new File("comenzi.txt")));
		     while (rs.next()) {
		    	utilizator.setNume(rs.getString("nume"));
		    	utilizator.setNr_telefon(Integer.parseInt(rs.getString("nr_telefon")));		    
		    	utilizator.setSector(rs.getString("zona"));
		    	utilizator.setAdresa(rs.getString("adresa"));
		      bw.write("Utilizatorul "+utilizator.getNume()+" cu nr de telefon "+utilizator.getNr_telefon()+" e din "+utilizator.getSector()+" si locuieste pe Strada "+utilizator.getAdresa());

	
		     }
		 }catch(Exception e){
			 
		 }
	

	
	//scriere in XML:
	try{   
		   DocumentBuilderFactory dbf1 = DocumentBuilderFactory.newInstance();
		   DocumentBuilder db1=dbf1.newDocumentBuilder();
		   Document doc1 = db1.newDocument(); 
		   
		   Element elementTata=doc1.createElement("Pizza"); 
		         
		  
		   Element element1 = doc1.createElement("PizzaMexicana"); 
		   String [] tmp = new String[6];
		   tmp=mexicana.getDen();
		   
		   element1.appendChild(doc1.createTextNode(tmp[0]+", "+tmp[1]+", "+tmp[2]+", "+tmp[3]+", "+tmp[4]+", "+tmp[5]));
		   
		   Element element2 = doc1.createElement("PizzaProsciuttoEFunghi");
		   tmp=prosciutto.getDen();
		   
		   element2.appendChild(doc1.createTextNode(tmp[0]+", "+tmp[1]+", "+tmp[2]+", "+tmp[3]+", "+tmp[4]+", "+tmp[5]));

		   Element element3 = doc1.createElement("PizzaQuattroStagioni");
		   tmp=quattro.getDen();
		   
		   element3.appendChild(doc1.createTextNode(tmp[0]+", "+tmp[1]+", "+tmp[2]+", "+tmp[3]+", "+tmp[4]+", "+tmp[5]));

		   Element element4 = doc1.createElement("PizzaDiavolo");
		   tmp=diavolo.getDen();
		   
		   element4.appendChild(doc1.createTextNode(tmp[0]+", "+tmp[1]+", "+tmp[2]+", "+tmp[3]+", "+tmp[4]+", "+tmp[5]));

		   
		   elementTata.appendChild(element1);
		   elementTata.appendChild(element2);
		   elementTata.appendChild(element3);
		   elementTata.appendChild(element4);
		   
		   doc1.appendChild(elementTata);
		   
		   TransformerFactory trasformerFac = TransformerFactory.newInstance();
		   Transformer transformer;
		try {
			transformer = trasformerFac.newTransformer();
			DOMSource dms = new DOMSource(doc1);
			   StreamResult sr = new StreamResult(new File("pizza.xml"));
			   transformer.transform(dms, sr);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		      
		  }catch(DOMException | TransformerException | ParserConfigurationException e){
		   e.printStackTrace();
		  }
	
	//citire din XML
	DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
	try {
		DocumentBuilder db= dbf.newDocumentBuilder();
		Document doc=db.parse("pizza.xml");

		NodeList list=doc.getElementsByTagName("Pizza");
		//NodeList l1=doc.getElementsByTagName("PizzaMexicana");
		//NodeList l2=doc.getElementsByTagName("PizzaProsciuttoEFunghi");
		//NodeList l3=doc.getElementsByTagName("PizzaQuattroStagioni");
		//NodeList l4=doc.getElementsByTagName("PizzaDiavolo");

		/////?????????????????????????????????????????????????????????????????????????????????
		for(int i=0;i<list.getLength();i++)
		{//pt rate
			Element elem=(Element) list.item(i);
			String ingr=elem.getAttribute("PizzaMexicana");
			String[] s=new String[6];
			s=mexicana.getDen();
			s[i]=elem.getFirstChild().getNodeValue();
			
			

		System.out.println(s[i]);
		}
		
	} catch (ParserConfigurationException e) {
		e.printStackTrace();
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
/*
 * "Ø25cm|25 RON","Ø30cm|27 RON","Ø40cm|31 RON" ingrediente mexi: Sos de pizza,
 * mozzarella, chorizo,bacon,sunca,jalapeno ingrediente quattro: Sos de
 * pizza,mozzarella,sunca,masline,ciuperci,busuioc,porumb ingre prosiutto:
 * sos,mozzarella,prosciutto crudo,funghi,oregano ingre diavolo: sos,mzza,salam
 * picant,ardei iute,ceapa
 * 
 * 
 * 
 */
