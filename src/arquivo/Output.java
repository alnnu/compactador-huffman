package arquivo;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;


public class Output {
    public void salvar(byte[] dados){
        try {
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            java.io.File file = new java.io.File("C:/Users/luann/IdeaProjects/compactador-ruffman/teste.zin");
            FileOutputStream in = new FileOutputStream(file) ;
            in.write(dados);
            in.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
