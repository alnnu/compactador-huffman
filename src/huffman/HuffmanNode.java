package huffman;

public class HuffmanNode {
    public int valor;
    public char caracter;

    public HuffmanNode left,right;

    public HuffmanNode(int valor,char caracter){
        this.caracter = caracter;
        this.valor = valor;
        this.right = null;
        this.left = null;
    }

}
