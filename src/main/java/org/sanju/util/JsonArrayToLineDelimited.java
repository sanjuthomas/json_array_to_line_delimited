package org.sanju.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * input file format - 
 * 
 * [{"id" : "1", "name" : "sanju"}, {"id" : "2", "name" : "thomas"}]
 * 
 * output file format - 
 * 
 * {"id" : "1", "name" : "sanju"}
 * {"id" : "2", "name" : "thomas"}
 * 
 * 
 * @author Sanju Thomas
 *
 */
public class JsonArrayToLineDelimited {

	public static void main(final String[] args) throws FileNotFoundException, IOException, ParseException {
		
		if(args.length != 2){
			System.out.println("Usage JsonArrayToLineDelimited <<input file>> <<output file>>");
			System.exit(0);
		}
		
		FileWriter writer = null;
		try {
			writer = new FileWriter(new File(args[1]));
			final JSONParser parser = new JSONParser();
			final Object obj = parser.parse(new FileReader(args[0]));
			final JSONArray jsonArrayObject = (JSONArray) obj;
			final Object[] jsonArray = jsonArrayObject.toArray();
			for(Object arrayElement : jsonArray) {
				final JSONObject json = (JSONObject)arrayElement;
				writer.write(json.toJSONString());
				writer.write("\n");
			} 
		} finally {
			writer.close();
		}
	}
	
}
