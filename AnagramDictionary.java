// Name: Isha Kulkarni
// USC NetID: ikulkarn
// CS 455 PA4
// Spring 2021

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.*;

/**
   A dictionary of all anagram sets. 
   Note: the processing is case-sensitive; so if the dictionary has all lower
   case words, you will likely want any string you test to have all lower case
   letters too, and likewise if the dictionary words are all upper case.
   
   
   Representation invariant: 
   
   Words formed with same set of characters have same string ID.
   Every word has only 1 corresponding string id.
   
 */
public class AnagramDictionary {
   
   private Map<String, ArrayList<String>> ana_dictionary;
   /**
      Create an anagram dictionary from the list of words given in the file
      indicated by fileName.  
      @param fileName  the name of the file to read from
      @throws FileNotFoundException  if the file is not found
      @throws IllegalDictionaryException  if the dictionary has any duplicate words
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException, IllegalDictionaryException {
      
      ana_dictionary = new HashMap<String, ArrayList<String>>();                                                 
      Scanner sc = new Scanner( new File(fileName) );
      
      while (sc.hasNextLine()) {
         String word = sc.nextLine();
            
         ArrayList<String> wordlist = new ArrayList<String>();
         String id = getId(word);

         if (ana_dictionary.containsKey(id)){
            wordlist = ana_dictionary.get(id);

            if(wordlist.contains(word)){
               throw new IllegalDictionaryException("ERROR: Illegal dictionary: dictionary file has a duplicate word:"+word);
            }
         }   

         wordlist.add(word);
         ana_dictionary.put(id,wordlist);
         
 
      }
                                                       
   }
   

   /**
      Get all anagrams of the given string. This method is case-sensitive.
      E.g. "CARE" and "race" would not be recognized as anagrams.
      @param s string to process
      @return a list of the anagrams of s
    */
   public ArrayList<String> getAnagramsOf(String s) {
      
      ArrayList<String> arr_anagrams = new ArrayList<String>();
      
      String id = getId(s);                     
	 
	  if (ana_dictionary.containsKey(id)) {
		arr_anagrams = ana_dictionary.get(id);
	  }
         
      return  arr_anagrams;
   }
   
   
   /* Returns ID of string in form of sorted character sequence
      @param str string to process
      @return ID of input string 
   */
   private String getId(String str){
	  
	  char[] chararr = str.toCharArray();
	  Arrays.sort(chararr);
	  
      return String.valueOf(chararr);  
   }
   
   
}
