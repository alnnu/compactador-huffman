package huffman;

import java.util.Comparator;
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
        int size = this.frequecia.size();
        valores = new PriorityQueue<HuffmanNode>(size, new Comparator<HuffmanNode>() {
            @Override
            public int compare(HuffmanNode x, HuffmanNode y) {
                return x.valor - y.valor;
            }
        });

        for (char value: this.frequecia.keySet()) {
            HuffmanNode no = new HuffmanNode();

            no.caracter = value;
            no.valor = this.frequecia.get(value);

            no.left = null;
            no.right = null;

            valores.add(no);
        }
        criarArvore();
    }

    private void criarArvore(){
        int total = valores.size();
        for (int i = 0; i < total && valores.size() > 1; i++) {

            HuffmanNode novoNo = new HuffmanNode();

            HuffmanNode right = valores.peek();
            valores.poll();

            HuffmanNode left = valores.peek();
            valores.poll();

            novoNo.valor = left.valor + right.valor;
            novoNo.right = right;
            novoNo.left = left;

            valores.add(novoNo);
            //System.out.println(valores.size());
        }
        root = valores.peek();
        valores.poll();
        System.out.println(valores.size());
    }


    public void printFrequncia() {
        System.out.println(frequecia);
    }

}
