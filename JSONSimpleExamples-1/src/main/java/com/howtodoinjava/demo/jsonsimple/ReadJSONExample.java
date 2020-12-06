package com.howtodoinjava.demo.jsonsimple;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSONExample 
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) 
	{
		//JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();
		
		try (FileReader reader = new FileReader("employees.json"))
		{
			//Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray quizList = (JSONArray) obj;
            System.out.println(quizList);
            
            //Iterate over employee array
            quizList.forEach( emp -> parsequizObject( (JSONObject) emp ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}

	private static void parsequizObject(JSONObject quiz)
	{
		//Get employee object within list
		JSONObject quizObject = (JSONObject) quiz.get("quiz");

		//Get employee first name
		String q = (String) quizObject.get("q");
		System.out.println(q);
		
		//Get employee first name
		String q1 = (String) quizObject.get("q1");
		System.out.println(q1);
		
		//Get employee last name
		String q2 = (String) quizObject.get("q2");
		System.out.println(q2);

		//Get employee website name
		String q3 = (String) quizObject.get("q3");
		System.out.println(q3);

		//Get employee website name
		String q4 = (String) quizObject.get("q4");
		System.out.println(q4);

	}
}
