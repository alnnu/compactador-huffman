package huffman;

import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanTree {
    private HashMap<Character,Integer> frequecia = new HashMap<Character, Integer>();
    private PriorityQueue<HuffmanNode> valores;
    public HuffmanNode root = null;

    public HuffmanTree(int frequecia[])
    {

        for (int i = 0; i < 256; i++) {
            if(frequecia[i] > 0){
                this.frequecia.put((char)i,frequecia[i]);
            }
        }

        for (int value: this.frequecia.values()) {
            HuffmanNode no = new HuffmanNode();

            no.valor = value;

            no.left = null;
            no.right = null;

            valores.add(no);


        }
        criarArvore();
    }

    private void criarArvore(){

        HuffmanNode novoNo = new HuffmanNode();

        HuffmanNode left = valores.peek();
        valores.poll();

        HuffmanNode right = valores.peek();
        valores.poll();

        novoNo.valor = left.valor + right.valor;
        novoNo.left = left;
        novoNo.right = right;

        root = novoNo;
    }

    public void printFrequncia() {
        System.out.println(frequecia);
    }

}
