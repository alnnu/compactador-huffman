package main;

import arquivo.Imput;
import arquivo.Output;
import huffman.HuffmanTree;

public class Main {
    public static void main(String[] args) {
        Imput file = new Imput();
        String texto;

        texto = file.imput();


        HuffmanTree tree = new HuffmanTree(texto);

        tree.printFrequncia();

        Output output = new Output();

        output.salvar(tree.getBits());

    }
}
