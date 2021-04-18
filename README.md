# MongoDB Coding Challenge
Solution to MongoDB Coding Challenge

## The challenge 
I was given the challenge of writing a program that takes in a JSON object from input and flattens the nested object and returns a flattened version as an output. I implemented this problem using java. 

---

## How the program works 
1.	The user will be prompted to enter in a JSON object. This JSON object is typed in as a string via stdin
2.	Using the JSON simple library to parse the input from a string to an object
3.	I made an ArrayList to hold the keys of the JSON object (needed a way to access and loop through the keys) 
4.	I loop through the keys to get the value associated with a specific key
5.	I check to see if the value of a key is a nested JSONObject
6.	When the program finds a value that is a nested JSONObject I make another JSONObject (a temporary JSONObject) which holds the nested JSONObject 
7.	Another ArrayList is made to hold the key value pairs of the nested JSONObject 
8.	Looping through the keys of the nested JSONObject allows me to add new key value pairs to the original JSONObject 
9.	I concatenate the key which had a JSONObject as a value for example key `“c”` is concatenated with a `“.”` and the keys of the nested JSONObject - This is where the flattening of the input takes place
10.	Resulting in something like this: `{ “c.d” : 3, “c.e” : “test” }`
11.	I removed the original key `c` as its value have been modified 

--- 

## My Assumptions 
- I assumed that the input would be directly typed via stdin because I needed to import libraries to parse the input from a string into an object 

---

## Command line interface

- You can compile and run the code via the command line
  Compile with: javac -cp /JSON/json-simple-1.1.1.jar Solution.java
  
  Run with: java -cp /JSON/json-simple-1.1.1.jar Solution.java
  
---
  
## Testing 
I tested the program by inputting various JSONObjects via stdin
  
- Testing the input given in the program description:
  `{"a" : 1, "b" : true, "c" : { "d" : 3, "e" : "test"}}`
    
   Output: `{"a":1,"b":true,"c.d":3,"c.e":"test"}`
   
-Testing another nested JSONObject: 
 
  `{"bool" : true, "num" : {"zero" : 0, "two" : 2}}`
  
   Output: `{"bool":true,"num.zero":0,"num.two":2}`
    
- Testing a JSONObject that  is not nested:
  `{"a" : 1, "b" : true, "c" : “hello”}`
    
   Output: `{"a" : 1, "b" : true, "c" : “hello”}`
    
- Testing an empty JSONObject
  `{}`
    
   Output: `{}`
     
---

## Time Spent 
I spent a total of 2hrs and 15mins on this challenge. 
