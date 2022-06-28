package huffman;

import java.util.*;


public class HuffmanTree {
    private HashMap<Character,Integer> frequecia = new HashMap<Character, Integer>();
    private ArrayList<HuffmanNode> list = new ArrayList<HuffmanNode>();
    public HuffmanNode root = null;

    public HuffmanTree(int frequecia[])
    {

        for (int i = 0; i < 256; i++) {
            if(frequecia[i] > 0){
                HuffmanNode no = new HuffmanNode(frequecia[i]);
                this.frequecia.put((char) i, frequecia[i]);
                list.add(no);
            }
        }
        ordena();

        criarArvore();
        compactar(root, "");

    }

    private void ordena() {
        HuffmanNode aux1;
        HuffmanNode aux2;
        for (int i=0; i < list.size(); ++i){
            for (int j=i; j < list.size(); ++j){
                if (list.get(i).valor>list.get(j).valor){
                    aux1 = list.get(i);
                    aux2 = list.get(j);
                    list.set(i, aux2);
                    list.set(j, aux1);
                }
            }
        }
    }

    private void criarArvore(){
        while (list.size() > 1) {

            HuffmanNode novoNo = new HuffmanNode(0);

            HuffmanNode right = list.remove(0);

            HuffmanNode left = list.remove(0);

            novoNo.valor = left.valor + right.valor;
            novoNo.right = right;
            novoNo.left = left;

            list.add(novoNo);
            ordena();
            //System.out.println(valores.size());
        }
        root = list.remove(0);
        //System.out.println(valores.size());
    }


    public void printFrequncia() {
        System.out.println("\n" + frequecia);
    }

    private void compactar(HuffmanNode root, String binario) {

            if(root.left == null && root.right == null){
                System.out.print(binario);
            }else {
                compactar(root.left, binario + 0);
                compactar(root.right, binario + 1);
            }
    }
}
