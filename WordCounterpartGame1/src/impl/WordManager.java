package impl;

import model.WordPair;
import service.WordPairManagerInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordManager {
    private WordPairManagerInterface wordPairManager;

    public WordManager() {
        wordPairManager = new WordPairManagerImpl();
    }

    public void addWordPair(WordPair pair) {
        wordPairManager.addWordPair(pair);
    }

    public WordPair findCounterpart(String word, String language) {
        return wordPairManager.findCounterpart(word, language);
    }

    public void loadWordPairsFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s*\\|\\s*"); 
                if (parts.length == 2) {
                    String word = parts[0];
                    String counterpart = parts[1];
                   
                    WordPair wordPair = new WordPair(word, counterpart, "YourLanguage"); 
                    addWordPair(wordPair);
                }
            }
        } catch (IOException e) {
          e.printStackTrace();
        }
    }


      
    }

