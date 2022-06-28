package huffman;

public class HuffmanNode {
    public int valor;

    public HuffmanNode left,right;

    public HuffmanNode(int valor){
        this.valor = valor;
        this.right = null;
        this.left = null;
    }

}
