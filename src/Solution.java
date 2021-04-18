/*

    Description: Java program that takes in a JSON object as input from stdin and
    outputs the input as a flattened version of the input.
    Date: 19/4/2021
    Author: Wedaad Haruna

*/

import java.io.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.util.*;


public class Solution {

    public static void main(String args[]) {
        
        //JSON Parser to parse JSON from a string to an object
        JSONParser jParser = new JSONParser();

        try {

            JSONObject output = new JSONObject();
            
            Scanner scan = new Scanner(System.in);

            //Prompting the user to enter the name of the file
            System.out.println("Please enter in a JSON Object: ");

            String input = scan.nextLine();

            System.out.println("Input: " + input);

            Object obj = jParser.parse(input); //parsing json from a string to an object

            output = (JSONObject)obj; 

            //Getting the keys from the JSON object input and putting them in an array list
            ArrayList<String> keyList = new ArrayList<String>(output.keySet());

            //Flattening the JSON input here 
            for(int i = 0; i < keyList.size(); i++) {

                String key = keyList.get(i);

                if(output.get(key) instanceof JSONObject) { //checking if the value of a key is a JSONObject
   
                    JSONObject subObj = new JSONObject();

                    subObj = (JSONObject)output.get(key);

                    ArrayList<String> subKeyList = new ArrayList<String>(subObj.keySet());
                    

                    for (int j = 0; j < subKeyList.size(); j++) {

                        String subKey = subKeyList.get(j);

                        output.put(key.concat("." + subKey), subObj.get(subKey));
                    }
    
                    output.remove(key); //removing the old key 
                   
                }

            }

            System.out.println("Output: " + output.toString());

        } //ends try block
        catch (ParseException pe) {

            System.out.println("Error please enter in a valid JSON Object");

        }  //ends catch block

    } //ends main

}//ends Solution class