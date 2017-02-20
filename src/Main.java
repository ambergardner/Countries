/* Requirements for this assignment
   Create a Country class to store both the name and abbreviation. DONE

    Read and parse the "countries.txt" file into an HashMap<String, ArrayList<Country>> where the key
is a single letter and the value is a list of countries whose names start with that letter. DONE

Ask the user to type a letter DONE (if they don't type a single letter, throw an exception).


Save an "X_countries.txt" file, where X is the letter they typed, which only lists the country's name
(not the abbrev) for just those countries that start with that letter.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Main {

    static HashMap<String, ArrayList<Country>> worldmap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        readFileLoadMap();
        System.out.println("Please enter a letter");
        Scanner scanner = new Scanner(System.in);

        String userInput = (scanner.nextLine());
        if (userInput.isEmpty()) {
            throw new Exception();
        }

        writeFile(userInput);
    }

    static void readFileLoadMap() throws FileNotFoundException {

        File f = new File("countries.txt");
        Scanner fileScanner = new Scanner(f);

        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();

            String[] columns = line.split("\\|");
            Country country = new Country(columns[1], columns[0]);


            String key = country.name.substring(0, 1);
            ArrayList<Country> countryList;

            if (worldmap.containsKey(key)) {

                countryList = worldmap.get(key);
                //put the country into the list

            } else {
                countryList = new ArrayList<Country>();
                worldmap.put(key, countryList);
            }

            countryList.add(country);

        }
        fileScanner.close();
    }

    public static HashMap<String, ArrayList<Country>> getWorldmap() {
        return worldmap;
    }

    public static void writeFile(String letter) throws IOException {
        //save the new list
        //from the map get a list thats mapped to the key
        ArrayList<Country> countryList = worldmap.get(letter);


        File f = new File(letter + "_countries.txt");
        FileWriter fileWriter = new FileWriter(f);
        if (worldmap.containsKey(letter)) {

            worldmap.get(letter);
            System.out.println(worldmap.get(letter)); //this returns a list of objects

        }


    }


}