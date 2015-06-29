package ing.cursus.fietsenzaak.core;

import ing.cursus.fietsenzaak.resource.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Winkel {
	
	
	
	private int fietsID = 0;
	private List<Fiets> fietsen = new ArrayList<Fiets>();
	
	public Fiets maakFiets(String fietsnaam, double bedrag ) throws IOException{
		
		Fiets fiets = new Fiets(++fietsID, fietsnaam,bedrag);
		fietsen.add(fiets);
		Data data = new Data(fiets,fietsID);
		data.createFile("c:/Temp/test2");
		return fiets;
	}
	
	public String showFietsen(){
		
		String json = new Gson().toJson(fietsen);
		
		return json;
	}
	
	public String eenFietsNaam(int fietsId){
	
		Fiets fiets = null;
		
		for (Fiets collect: fietsen){
			if(collect.getId() == fietsId){
				fiets = collect;	
				break;
			}
			
		}
		if(fiets != null){
			String json = new Gson().toJson(fiets);
			return json;
		}
		else{
			String error = "Fietsnummer bestaat niet";
			return error;
		}
		
	}

	public void deleteFiets(int fietsId) {
		
		int count = 0;
		
		for (Fiets collect: fietsen){
			if(collect.getId() == fietsId){
				System.out.println(count);
				fietsen.remove(count);
				break;
			}
			count++;
		}
		
	}
	
	

	public String updateNaam(int fietsId, String naam) {
		
		int count = 0;
		for (Fiets collect: fietsen){
			if(collect.getId() == fietsId){
			    fietsen.get(count).setNaam(naam);	
				break;	
				}	
			count++;
		
	}
		return eenFietsNaam(fietsId);
		
}
}
