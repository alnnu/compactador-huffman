package main;

import huffman.Huffman;

public class Main {
    public static void main(String[] args) {
       String test = "Ana Carolina ama arroz";

       int frequncia[] = new int[256];

       for(char c : test.toCharArray())
           frequncia[c] ++;

        Huffman tree = new Huffman(frequncia);

        tree.printFrequncia();
    }
}
