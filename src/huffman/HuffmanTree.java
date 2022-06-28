package huffman;
import java.util.*;


public class HuffmanTree {
    private HashMap<Character,Integer> frequecia = new HashMap<Character, Integer>();
    private HashMap<String, Integer> codigo = new HashMap<String, Integer>();
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

        //eLight, uma AI modelada com foco a eficiencia energetia


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

            HuffmanNode left = list.remove(0);

            HuffmanNode right = list.remove(0);

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
        String dado = "";

        for (String code : codigo.keySet()) {
            for (int i = codigo.get(code); i > 0; i--){
                dado = dado + code;
            }
        }

        System.out.println("total de bits: " + dado.length());
        System.out.println("sequncia: " + dado);
        System.out.println("\nfrequencia: " + frequecia);
        System.out.println("codigo: " + codigo);


    }

    private void compactar(HuffmanNode root, String binario) {

            if(root.left == null && root.right == null){
                codigo.put(binario, root.valor);
            }else {
                compactar(root.left, binario + 0);
                compactar(root.right, binario + 1);
            }
    }
}
