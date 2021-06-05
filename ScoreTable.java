// Name: Isha Kulkarni
// USC NetID: ikulkarn
// CS 455 PA4
// Spring 2021
import java.util.Map;
import java.util.HashMap;
import java.util.Locale;
/**
   This class has information about Scrabble scores for scrabble letters and words. In scrabble not every 
   letter has the same value. Letters that occur more often in the English language are worth less and letters
   that occur less often are worth more.
   
   Score of a word is sum of the scores of individual characters forming that word.
    
   Representation invariant: 
   
   Each letter has 1 score value only.
   Score is same for both upper and lower case versions of the letters.
   The map storing scorevalues consists of 26 entries, which is equal to number of english alphabets.
   
 */
public class ScoreTable
{
   private static Map<Character, Integer> scoretable; //Stores the score for each letter.
  
   /**
      Creates a score table using hashmap. 
      Key field of hashmap stores letter, and value field stores is corresponding score.
    */
   public ScoreTable(){
      
      scoretable = new HashMap<Character, Integer>();
      
      scoretable.put('a', 1);
      scoretable.put('b', 3);
      scoretable.put('c', 3);
      scoretable.put('d', 2);
      scoretable.put('e', 1);
      scoretable.put('f', 4);
      scoretable.put('g', 2);
      scoretable.put('h', 4);
      scoretable.put('i', 1);
      scoretable.put('j', 8);
      scoretable.put('k', 5);
      scoretable.put('l', 1);
      scoretable.put('m', 3);
      scoretable.put('n', 1);
      scoretable.put('o', 1);
      scoretable.put('p', 3);
      scoretable.put('q', 10);
      scoretable.put('r', 1);	
      scoretable.put('s', 1);
      scoretable.put('t', 1);
      scoretable.put('u', 1);
      scoretable.put('v', 4);
      scoretable.put('w', 4);
      scoretable.put('x', 8);
      scoretable.put('y', 4);
      scoretable.put('z', 10);
      
   }
   
   /**
      Calculates the score for input word s using score table hashmap. 
      Hashmap stores all letters in the lower case format. Since upper and lower case letters have the same  
      score, input word is converted to lowercase word first, and then, the score is calculated
      
      @param s word whose score needs to be calculated.
      @return sum of the scores of individual letters in the input word.
    */
   public int getScore(String s){
      
      String copy = s.toLowerCase(Locale.ROOT);
      int sum = 0;
      for (int i = 0; i < copy.length(); i++){
         sum = sum + scoretable.get(copy.charAt(i));
      }
      return sum;
   }
   
}