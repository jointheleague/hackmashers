import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;

public class Main {
	
	public Main(){
		this.startUI();
	}

	public static void main(String[] args) {

		Main m = new Main();
		
	}
	
	public void startUI(){
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fileChooser.getSelectedFile();
		    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		    ReadFile.readFile(selectedFile);
		}
	}
	
	public static GeocodeResponse geoCode(String add) throws IOException{
		Geocoder geocoder = new Geocoder(); 
		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(add).setLanguage("en").getGeocoderRequest(); 
		GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
		return geocoderResponse;
	}

}
