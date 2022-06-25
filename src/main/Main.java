package main;

import huffman.HuffmanTree;

public class Main {
    public static void main(String[] args) {
       String test = "Ana Carolina ama arroz";

       int frequncia[] = new int[256];

       for(char c : test.toCharArray())
           frequncia[c] ++;

        HuffmanTree tree = new HuffmanTree(frequncia);

        tree.printFrequncia();

    }
}
