package ing.cursus.fietsenzaak.runner;

import java.io.IOException;

import ing.cursus.fietsenzaak.core.Winkel;

public class Runner {
		public static void main(String[] args) throws IOException {
			Winkel winkel = new Winkel();
			
			winkel.maakFiets("Xavierfiets1", 50.00);
			winkel.maakFiets("Xavierfiets2", 50.00);
			winkel.maakFiets("Xavierfiets3", 50.00);
			winkel.maakFiets("Xavierfiets4", 50.00);
			winkel.maakFiets("Xavierfiets5", 50.00);
			winkel.maakFiets("Xavierfiets1", 50.00);
			winkel.maakFiets("Xavierfiets2", 50.00);
			winkel.maakFiets("Xavierfiets3", 50.00);
			winkel.maakFiets("Xavierfiets4", 50.00);
			winkel.maakFiets("Xavierfiets5", 50.00);
			winkel.maakFiets("Xavierfiets1", 50.00);
			winkel.maakFiets("Xavierfiets2", 50.00);
			winkel.maakFiets("Xavierfiets3", 50.00);
			winkel.maakFiets("Xavierfiets4", 50.00);
			winkel.maakFiets("Xavierfiets5", 50.00);
			winkel.maakFiets("Xavierfiets1", 50.00);
			winkel.maakFiets("Xavierfiets2", 50.00);
			winkel.maakFiets("Xavierfiets3", 50.00);
			winkel.maakFiets("Xavierfiets4", 50.00);
			winkel.maakFiets("Xavierfiets5", 50.00);
			winkel.deleteFiets(11);
		}
}
