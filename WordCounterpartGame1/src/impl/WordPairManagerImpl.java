package impl;
import model.WordPair;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.*;
import java.util.*;
import service.WordPairManagerInterface;

public class WordPairManagerImpl implements WordPairManagerInterface {
    private WordPair[] wordPairs;
    private int size;

    public WordPairManagerImpl() {
        wordPairs = new WordPair[10]; 
        size = 0;
    }

    @Override
    public void addWordPair(WordPair pair) {
       
        if (size == wordPairs.length) {
            wordPairs = Arrays.copyOf(wordPairs, size * 2);
        }
        wordPairs[size] = pair;
        size++;
    }

    @Override
    public WordPair findCounterpart(String word, String language) {
        WordPair randomPair = null;
        int filteredSize = 0;

        for (int i = 0; i < size; i++) {
            if (wordPairs[i].getWord().equals(word) && wordPairs[i].getLanguage().equalsIgnoreCase(language)) {
                if (new Random().nextInt(++filteredSize) == 0) {
                   
                    randomPair = wordPairs[i];
                }
            }
        }

        return randomPair;
    }

    @Override
    public void loadWordPairsFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    addWordPair(new WordPair(parts[0].trim(), parts[1].trim(), parts[2].trim()));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading word pairs from file: " + e.getMessage());
        }
    }
}
