/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package fi.tuni.prog3.wordgame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author vudinhthi2304
 */
public class WordGame {

    private WordGameState gameState;
    private final ArrayList<String> words;
    private boolean is_active;
    private String word_master;
    private final int N;

    public static class WordGameState {
        private String word;
        private int mistakes;
        private int mistakeLimit;
        private int missingChars;

        private WordGameState(String word, int mistakes, int mistakeLimit, int missingChars) {
            this.word = word;
            this.mistakes = mistakes;
            this.mistakeLimit = mistakeLimit;
            this.missingChars = missingChars;
        }

        public String getWord() {
            return word;
        }

        public int getMistakes() {
            return mistakes;
        }

        public int getMistakeLimit() {
            return mistakeLimit;
        }

        public int getMissingChars() {
            return missingChars;
        }
    }

    public WordGame(String wordFilename) throws IOException {
        words = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(wordFilename))){
            String line;
            while((line = reader.readLine()) != null){
                words.add(line);
            }
        }
        N = words.size(); 
        is_active = false;
    }

    public void initGame(int wordIndex, int mistakeLimit) {
        word_master = words.get(wordIndex % N);
        String initialWord = "_".repeat(word_master.length());
        gameState = new WordGameState(initialWord, 0, mistakeLimit, word_master.length());
        is_active = true;
    }

    public boolean isGameActive() {
        return is_active;
    }

    public WordGameState getGameState() throws GameStateException{
        if (!is_active){
            throw new GameStateException("There is currently no active word game!");
        } else {
            return gameState;
        }
    }

    public WordGameState guess(char c) throws GameStateException{
        WordGameState game = getGameState();
        int count = 0;
        for (int i = 0; i < game.word.length(); i++){
            if (Character.toLowerCase(word_master.charAt(i)) == 
            Character.toLowerCase(c)){
                count +=1;
                game.missingChars -=1;
                game.word = game.word.substring(0, i) + Character.toLowerCase(c) + game.word.substring(i + 1);
            }
        }
        if (count == 0){
            game.mistakes +=1;
        }
        return game;
        
    }

    public WordGameState guess(String word) throws GameStateException{
        WordGameState game = getGameState();
            if (word.toLowerCase().equals(word_master)){
                game.missingChars = 0;
                game.word = word_master;
                is_active = false;
            }
            else {
                game.mistakes += 1;
            }
        return game;
        
    }

    
}