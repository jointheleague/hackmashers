import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	
	public static int geocodeId = 0;
	
public static void readFile(File f){
	String csvFile = f.getAbsolutePath();
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";

	try {

		br = new BufferedReader(new FileReader(f));
		while ((line = br.readLine()) != null) {

		        // use comma as separator
			line.replaceAll("BLOCK", "");
			String[] data = line.split(cvsSplitBy);

		try{
			System.out.println("Geocode for Location:" + data[6]);
			System.out.println(Main.geoCode(data[6]).getResults().get(0).getGeometry().getViewport() + "");
			geocodeId++;
		}catch (Exception e){
			System.out.println("Invalid GeoCode Location");
		}

		}

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	System.out.println("Done");
  }

}


