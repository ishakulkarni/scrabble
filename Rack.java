// Name: Isha Kulkarni
// USC NetID: ikulkarn
// CS 455 PA4
// Spring 2021

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
/*
   This class takes letters present on rack as input and returns all the possible word combinations from them.
   All unique letters are stored in a map rackmap. 
   Its key=unique letter from the rack, value=number of times that letter appears on the rack.
   
   Representation Invariants:
	
   Rackmap has all keys as unique letters from the input string.
   Maximum size of rackmap is equal to length of letters currently present on the rack.
   String unique and array mult from method getSubsets, allSubsets has length equal to number of entries 
   in the map.
 */

public class Rack {
   
   private String currentRack;	//String currently present on Rack.
   private Map<Character, Integer> rackmap;	 //key=unique letter, value=number of times the letter appears.
   
   /**
	 Construct a Rack class from the given input.
     Initialize rackmap.
	 
	 @param s String of letters currently present on Rack.
	 */
   
   public Rack(String s) {
		currentRack = s;
		rackmap = new TreeMap<Character, Integer>();
      
		create_map(s);
		
   }
   
   /**
      Stores rackmap key in a string unique, and their corresponding values in an array mult.
      mult[i] is the multiplicity of the char unique.charAt(i).

      Finds all subsets of the rack letters multiset starting at position 0 of unique and mult 
      if they are not empty.

      @return all subsets of the letters on the rack. 
      Each subset is represented as a String that can have repeated characters in it.

    */
   
   public ArrayList<String> getSubsets(){ 
	   
      int i=0;
      int[] mult = new int[rackmap.size()];  //String of all the unique letters from the word on rack.
	  String unique = "";                    //Stores number of times each letter from unique string appears on the rack respectively.
	  
	  for (Map.Entry<Character, Integer> entry : rackmap.entrySet()) {
		  unique = unique + entry.getKey();
		  mult[i] = entry.getValue();
		  i++;
	  }
      
      ArrayList<String> subsetlist = allSubsets(unique, mult, 0);
      subsetlist.remove(0);
      return subsetlist;
   } 
   
   
   /**
	 Creates a rackmap from input string s.
	 key=unique letter from the rack, value=number of times that letter appears on the rack.
     
	 @param s String of letters currently present on Rack.
	 */
   
   private void create_map(String s){
      
      for (int i = 0; i < s.length(); i++) {
         char letter = s.charAt(i);
         
         if(rackmap.containsKey(letter)){
            rackmap.put(letter, rackmap.get(letter) +1);
         }
         else{
            rackmap.put(letter, 1);
         }

      }

   }
   
   

   /**
      Finds all subsets of the multiset starting at position k in unique and mult.
      unique and mult describe a multiset such that mult[i] is the multiplicity of the char
           unique.charAt(i).
      PRE: mult.length must be at least as big as unique.length()
           0 <= k <= unique.length()
      @param unique a string of unique letters
      @param mult the multiplicity of each letter from unique.  
      @param k the smallest index of unique and mult to consider.
      @return all subsets of the indicated multiset.  Unlike the multiset in the parameters,
      each subset is represented as a String that can have repeated characters in it.
      @author Claire Bono
    */
   private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
      ArrayList<String> allCombos = new ArrayList<>();
      
      if (k == unique.length()) {  // multiset is empty
         allCombos.add("");
         return allCombos;
      }
      
      // get all subsets of the multiset without the first unique char
      ArrayList<String> restCombos = allSubsets(unique, mult, k+1);
      
      // prepend all possible numbers of the first char (i.e., the one at position k) 
      // to the front of each string in restCombos.  Suppose that char is 'a'...
      
      String firstPart = "";          // in outer loop firstPart takes on the values: "", "a", "aa", ...
      for (int n = 0; n <= mult[k]; n++) {   
         for (int i = 0; i < restCombos.size(); i++) {  // for each of the subsets 
                                                        // we found in the recursive call
            // create and add a new string with n 'a's in front of that subset
            allCombos.add(firstPart + restCombos.get(i));  
         }
         firstPart += unique.charAt(k);  // append another instance of 'a' to the first part
      }
      
      return allCombos;
   }

   
   
   
   
}
