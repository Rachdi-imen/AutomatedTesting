package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {
	// Chemin d'accès au fichier CSV
	private static final String CSV_PATH = "/nopEcommerceTestData.csv";

	// Méthode pour lire les données à partir d'un fichier CSV
	public static List<String[]> readCSV(String filePath) throws CsvValidationException {
		// Crée une liste pour stocker les données lues
		List<String[]> data = new ArrayList<>();
		try (
				// Utilise un CSVReader pour lire le fichier CSV à partir d'un flux d'entrée
				CSVReader reader = new CSVReader(new InputStreamReader(CSVUtils.class.getResourceAsStream(filePath)))) {
			String[] line;
			// Lit chaque ligne du fichier CSV jusqu'à ce qu'il n'y en ait plus
			while ((line = reader.readNext()) != null) {
				// Ajoute la ligne lue à la liste de données
				data.add(line);
			}
		} catch (IOException e) {
			// Gère les exceptions liées à la lecture du fichier CSV
			e.printStackTrace();
		}
		// Retourne les données lues à partir du fichier CSV
		return data;
	}

	// Méthode fournissant des données pour les tests depuis le fichier CSV
	@DataProvider(name = "csvData")
	public static Object[][] getDataFromCSV() throws CsvValidationException {
		// Lit les données à partir du fichier CSV
		List<String[]> csvData = readCSV(CSV_PATH);
		// Crée un tableau d'objets à deux dimensions
		// pour stocker les données lues
		Object[][] data = new Object[csvData.size()][];
		// Remplit le tableau avec les données lues
		for (int i = 0; i < csvData.size(); i++) {
			data[i] = csvData.get(i);
		}
		// Retourne le tableau de données pour les tests
		return data;
	}
}
