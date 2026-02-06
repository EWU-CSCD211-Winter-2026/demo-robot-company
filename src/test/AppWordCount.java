

package test;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class AppWordCount {

    public static void main(String[] args) {
        String text = "The dog is a large dog, and a good dog, and a loyal dog, but the cat isn't a dog. The dog and the cat are friends."; 
        List<WordCount> sortedWords = wordFrequencies(text);
        System.out.println("Word count: " + sortedWords);
    }

    private static class WordCount implements Comparable<WordCount> {
        private String word;
        private int count;

        public WordCount(String word, int count) {
            this.word = word;
            this.count = count;
        }

        public String getWord() {
            return word;
        }

        public int getCount() {
            return count;
        }

        @Override
        public int compareTo(WordCount other) {
            return count - other.count;
        }

        @Override
        public String toString() {
            return word + ": " + count;
        }
    }

    public static List<WordCount> wordFrequencies(String text) {
        if (text == null || text.isEmpty()) {
            return new ArrayList<>();
        }
        String[] words = text.split("[ ]+");

        Map<String, Integer> wordCount = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            word = word.toLowerCase().replaceAll("[^a-z]", ""); // Let's just consider alphabetic characters, ignore punctuation, case
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        
        // for the following line, consider:
        // Map.keySet() returns an implementation of a Set, which is a collection that contains no duplicate elements.
        // The ArrayList constructor can take a Collection as an argument and creates a new ArrayList containing the elements of the specified collection, in the order they are returned by the collection's iterator.
        List<String> keys = new ArrayList<>(wordCount.keySet());
        List<WordCount> wordCounts = new ArrayList<>();
        for (int i = 0; i < keys.size(); i++) {
            WordCount wordCount1 = new WordCount(keys.get(i), wordCount.get(keys.get(i)));
            wordCounts.add(wordCount1);
        }

        Collections.sort(wordCounts);

        return wordCounts;

    }
}
