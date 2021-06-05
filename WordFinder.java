// Name: Isha Kulkarni
// USC NetID: ikulkarn
// CS 455 PA4
// Spring 2021

import java.util.*;
import java.io.*;
/*
   Class containing main method to play Scrabble game.
   Can take dictionary file as a command line argument.
   If not specified, uses sowpods.txt as default dictionary file.
   
   
   Representation Invariants:
   
   This class has no instance variables of its own, and has only static methods.
   So, doesn't have a representation invariants.
*/
public class WordFinder
{
   public static void main(String[] args)   {
      
      String dict_name = "";
      if(args.length > 0){
         dict_name = args[0];
      }
      else{
         dict_name = "sowpods.txt";
      }
         
      try{
      
         AnagramDictionary d = new AnagramDictionary(dict_name);
    
         play_scrabble(d);     
      }
      catch (IllegalDictionaryException exception)
         {
            System.out.println(exception.getMessage());
            System.out.println("Exiting program"); 
         }
      catch (FileNotFoundException exception)
         {
            String[] errmsg = exception.getMessage().split("\\s+");
            System.out.println("ERROR: Dictionary file " + errmsg[0] + " does not exist." );
            System.out.println("Exiting program");
         }

   }
   
   /*
   Asks user to input letters present on the rack.
   Creates their possible combinations and finds valid words from them using dictionary.
   
   @param d AnagramDictionary object
            We use it to refer the dictionary for valid words combination.
   */
   public static void play_scrabble(AnagramDictionary d){
      
      Scanner in = new Scanner(System.in);
      
      System.out.println("Type . to quit.");
      System.out.print("Rack? ");
      String inputWord = in.nextLine();
      
      while(inputWord.equals(".") == false ){
         
         Rack rack = new Rack(inputWord);
		 ScoreTable st = new ScoreTable();
         ArrayList<String> subsets = rack.getSubsets();
         find_words(d, subsets, st, inputWord);
         
         System.out.print("Rack? ");
         inputWord = in.nextLine(); 
      }
      
   }
   
    /*
   Takes subsets of rack letters as input argument and finds the possible valid words from dictionary.
   Prints them according to their score in descending order.
   
   @param d AnagramDictionary object
            We use it to refer the dictionary for valid words combination.
   @param subsets List of all possible combinations of input letters.
   @param st Scoretable object. Used to calculate score of each word formed.
   @param inputWord Rack letters entered by user
   
   */
   public static void find_words(AnagramDictionary d, ArrayList<String> subsets, ScoreTable st, String inputWord){
      
      Map<Integer, ArrayList<String>> word_map = new TreeMap<Integer, ArrayList<String>>(Collections.reverseOrder());
      
      for(String a: subsets){

         ArrayList<String> validWords = new ArrayList<String>(d.getAnagramsOf(a));
         
         if(validWords.isEmpty() == false){
            
            int score = st.getScore(a);
            
            if (word_map.containsKey(score)) {	
				ArrayList<String> words_before = new ArrayList<String>(word_map.get(score));
				validWords.addAll(words_before);	
			}
            Collections.sort(validWords);
            word_map.put(score,validWords);
            
         }
         
      }
      
      int size=0;
      
      for(ArrayList<String> list : word_map.values()){ 
         size = size + list.size();
      }
      
      System.out.println("We can make " + size + " words from " +"\""+ inputWord + "\"");
      if(size>0){
         System.out.println("All of the words with their scores (sorted by score): ");
         
         for (Map.Entry<Integer, ArrayList<String>> entry : word_map.entrySet()) {
            ArrayList<String> list = new ArrayList<String>(entry.getValue());
            for (String word: list) {
               System.out.println(entry.getKey() + ": " + word);
               
            }	
			
		}
      }
   }
   
}