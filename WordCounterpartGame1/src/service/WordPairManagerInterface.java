
	package service;
	import model.WordPair;

	public interface WordPairManagerInterface {
		
		    void addWordPair(WordPair pair);
		    WordPair findCounterpart(String word, String language);
		    void loadWordPairsFromFile(String fileName);

}
