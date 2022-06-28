package main;

import arquivo.Imput;
import huffman.HuffmanTree;

public class Main {
    public static void main(String[] args) {
        Imput file = new Imput();
        String texto;

        texto = file.imput();

        int frequncia[] = new int[256];

        for(char c : texto.toCharArray())
            frequncia[c] ++;

        HuffmanTree tree = new HuffmanTree(frequncia);

        tree.printFrequncia();




    }
}
