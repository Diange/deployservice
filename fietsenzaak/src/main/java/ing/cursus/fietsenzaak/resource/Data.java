package ing.cursus.fietsenzaak.resource;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import ing.cursus.fietsenzaak.core.Fiets;

public class Data {

	private Fiets fietsdata;
	private String extension = ".txt";
	private int fietsID;
	
	public Data(Fiets fiets){
		this.fietsdata = fiets;
	}
	
	public Data(Fiets fiets, int fietsID) {
		this.fietsdata = fiets;
		this.fietsID = fietsID;
	}

	public void createFile(String location) throws IOException{
		
		Gson gson = new Gson();
		JsonElement je = gson.toJsonTree(fietsdata);
		JsonObject jo = new JsonObject();
		jo.add("ID"+fietsID, je);
		
		//String json = new Gson().toJson(fietsdata);
		
		File file = new File(location+extension);
		
		if(!file.exists()){
			file.createNewFile();
		}
		
		FileWriter fw = new FileWriter(file,true);
		fw.write(jo.toString());
		fw.flush();
		fw.close();
		
	}
	
	
	public String returnJson(){
		return null;
	}
	
}
