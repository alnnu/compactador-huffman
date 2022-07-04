package arquivo;


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Imput {


    public String imput() {

        String url = "";

        while (url.equals("") || url == null){
            url = uploadFoto();
        }

        Path file = Paths.get(url);
        try{

           byte[] textoB = Files.readAllBytes(file);
           String texto = new String(textoB);

            System.out.println("Tamanho Original: " + textoB.length );
           return texto;
        }catch (Exception e){
            System.out.println(e);
            return "";
        }

    }

    public String uploadFoto() {
        JFileChooser escolherFoto = new JFileChooser();

        escolherFoto.setDialogTitle("Escolher texto");

        FileNameExtensionFilter filter = new FileNameExtensionFilter("texto", "txt");

        escolherFoto.setFileSelectionMode(JFileChooser.FILES_ONLY);
        escolherFoto.setFileFilter(filter);

        int res = escolherFoto.showOpenDialog(escolherFoto);

        if(res == JFileChooser.APPROVE_OPTION)
        {
            File arquivo = escolherFoto.getSelectedFile();
            return arquivo.getPath();
        }
        return "";
    }

}
