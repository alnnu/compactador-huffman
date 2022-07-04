package huffman;
import java.util.*;


public class HuffmanTree {
    private HashMap<Character,Integer> frequecia = new HashMap<Character, Integer>();
    private HashMap<Character, String> codigo = new HashMap<Character, String>();
    private ArrayList<HuffmanNode> list = new ArrayList<HuffmanNode>();
    public HuffmanNode root = null;
    public String texto;

    public HuffmanTree(String texto)
    {
        this.texto = texto;
        sequncia(texto);
        ordena();

        criarArvore();
        compactar(root, "");


    }

    private void sequncia(String texto){
        int caracteres[] = new int[256];

        for(char c : texto.toCharArray())
            caracteres[c] ++;

        for (int i = 0; i < 256; i++) {
            if(caracteres[i] > 0){
                HuffmanNode no = new HuffmanNode(caracteres[i], (char)i);
                this.frequecia.put((char) i, caracteres[i]);
                list.add(no);
            }
        }
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

            HuffmanNode novoNo = new HuffmanNode(0,'"');

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
//        for (String code : codigo.keySet()) {
//            for (int i = codigo.get(code); i > 0; i--){
//                dado = dado + code;
//
//            }
//        }

//        System.out.println("total de bits: " + dado.length());
//        System.out.println("sequncia: " + dado);
//        System.out.println("\nfrequencia: " + frequecia);
//        System.out.println("codigo: " + codigo);


    }

    public byte[] getBits()
    {

        //11100101
       String bitTexto = "";
       int bits = 0;
       int i = 0;
       int j = 0;
       for (char c : texto.toCharArray())
       {
           bitTexto += codigo.get(c);
       }

        byte dado[] = new byte[bitTexto.length()/8];
       System.out.println("Novo tamanho: "+ (bitTexto.length()/8));


        for (char c : bitTexto.toCharArray())
        {
           if (i == 8)
           {
               dado[j] = (byte)bits;
               bits = 0;
               i=0;
               j ++;
           }
            bits = (bits << 1) | (c - 48) ;
            i++;
        }

        return dado;
    }


    private void compactar(HuffmanNode root, String binario) {

            if(root.left == null && root.right == null){
                codigo.put(root.caracter, binario);
            }else {
                compactar(root.left, binario + 0);
                compactar(root.right, binario + 1);
            }
    }
}
