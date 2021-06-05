# scrabble

# This is a console-based program that finds all possible words that can be made from a rack of Scrabble tiles (so it could help someone playing Scrabble).

Detailed description of classes and its methods is given in comments in the class files.

class WordFinder:
Contains main method. Uses objects of classes Rack, AnagramDictionary and ScoreTable.
handels user Interface, processes user input using these class objects and prints possible valid words that can be constructed from the rack along with their scores in descending order.
data structure used: treemap to keep word scores sorted in descending  order

class AnagramDictionary: 
Processes given dictionary and stores in a map for better usage.
Finds and returns anagrams for a given word, present in that dictionary.
data structure used: hashmap

class Rack:
Takes current letters on the rack as input, and gives its all possible subsets.
data structure used: treemap to keep unique letters sorted.

class ScoreTable: Calculates score of given word by taking sum of the scores of its individual letters.
Stores scores of english letters in a hashmap.
data structure used: hashmap

class IllegalDictionaryException:
It extends IOExceptions, specially designed to report invalid dictionary.
e.g. dictionary containning repeated words.
