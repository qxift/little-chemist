import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataParsing {

	public static List<Element> parseJson(String fileName) {
		JSONParser parser = new JSONParser();

		List<Element> elements = new ArrayList();
		try {

            Object obj = parser.parse(new FileReader(fileName));

            JSONObject jsonObject = (JSONObject) obj;

            JSONObject names = (JSONObject) jsonObject.get("names");

            int i = 0;
            String name = "";
            
            
            do {
            		name = (String)names.get(String.valueOf(i));
            		i++;
            		if (name != null) {
            			elements.add(new Element(i, name));
            		}
            	
            } while (name != null);
            
            JSONArray recipes = (JSONArray) jsonObject.get("recipes");

            
            Iterator<JSONObject> iterator = recipes.iterator();
            
            while (iterator.hasNext()) {
            		JSONObject recipe = iterator.next();
            		JSONArray ingredients = (JSONArray) recipe.get("ingredients");
            		JSONArray results = (JSONArray) recipe.get("results");
                List<Long> ingredientsList = getInts(ingredients);
                List<Long> resultsList = getInts(results);
                
                for (int k = 0; k < elements.size(); k++) {
                		if (resultsList.get(0) == elements.get(k).id) {
                			elements.get(k).addIngredients(ingredientsList);
                		}
                }
            }
            
            for (int g = 0; g < elements.size(); g++) {
            		System.out.println("g = " + elements.get(g).id + ", name = " + elements.get(g).name + ", ingredients = " + elements.get(g).ingredients);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		return elements;
	}
	
	public static List<Long> getInts(JSONArray arr) {
		Iterator<Long> iterator = arr.iterator();
		List<Long> elements = new ArrayList();
		
        while (iterator.hasNext()) {
        		Long element = (Long)iterator.next();
        		elements.add(element);
        }
        return elements;
	}
	public static void main(String[] args) {

        // parseJson("/Users/Margo/ws/git-repos/little-chemist/res/Rules.json");
        parseJson("../little-chemist/res/Rules.json");
    }
}