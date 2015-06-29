package fietsenzaak.test;


import java.io.IOException;

import ing.cursus.fietsenzaak.core.Winkel;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class TestRunner {

	int bedrag = 20;
	
	@Test
	public void testEen() throws IOException{
		Winkel winkel = new Winkel();
		winkel.maakFiets("Brutus", bedrag);
		String xavier =	winkel.eenFietsNaam(1);
		Assert.assertThat(xavier, CoreMatchers.containsString("Brutus"));
	}
	
	@Test
	public void testTwee()throws IOException{
		Winkel winkel = new Winkel();
		winkel.maakFiets("Brutus", 50.00);
		String xavier =	winkel.eenFietsNaam(4);
		Assert.assertThat(xavier, CoreMatchers.containsString("Fietsnummer bestaat niet"));
	}
	
	@Test
	public void testDelete()throws IOException{
		Winkel winkel = new Winkel();
		winkel.maakFiets("Batavus", bedrag );
		winkel.maakFiets("Batavus", bedrag );
		winkel.maakFiets("Batavus", bedrag );
		winkel.maakFiets("Batavus", bedrag );
		winkel.maakFiets("Batavus", bedrag );
		
		String xavier2 = winkel.eenFietsNaam(1);
		winkel.deleteFiets(1);
		String xavier =	winkel.eenFietsNaam(1);
		Assert.assertThat(xavier, CoreMatchers.containsString("Fietsnummer bestaat niet"));
		Assert.assertThat(xavier2, CoreMatchers.containsString("Batavus"));
		
		System.out.println(winkel.showFietsen());
	}
	
	@Test
	public void updateNaam() throws IOException{
		Winkel winkel = new Winkel();
		winkel.maakFiets("Batavus1", bedrag);
		winkel.maakFiets("Batavus2", bedrag);
		winkel.maakFiets("Batavus3", bedrag);
		winkel.maakFiets("Batavus4", bedrag);
		winkel.maakFiets("Batavus5", bedrag);
		winkel.maakFiets("Batavus6", bedrag);
		
		winkel.updateNaam(5, "Bananenboot");
		
		String xavier = winkel.eenFietsNaam(5);
		
		Assert.assertThat(xavier, CoreMatchers.containsString("Bananenboot"));
		
		
	}
	
}
