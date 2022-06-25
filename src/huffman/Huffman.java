package huffman;

import java.util.HashMap;

public class Huffman {
    private HashMap<Character,Integer> frequecia = new HashMap<Character, Integer>();

    public Huffman(int frequecia[])
    {
        for (int i = 0; i < 256; i++) {
            if(frequecia[i] > 0){
                this.frequecia.put((char)i,frequecia[i]);
            }
        }


    }

    public void printFrequncia() {
        System.out.println(frequecia);
    }

}
