package tpsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author dmr
 */
public class TPSocket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            
            // Création et ouverture du socket vers le site
            Socket socket = new Socket("www.checkupdown.com", 80);
            
            // récupération flux entrée/sortie e binaire
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();
            
            // Conversion flux de sortie binaire en flux de sortie caractère
            PrintStream p = new PrintStream(out);            
            // Envoie requête http type GET
            p.println("GET");
            
            // Conversion flux d'entrée binaire en flux d'entrée caractère
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            // Lecture du 
            String line = br.readLine();
            while (line!=null){
                //affichage du contenu du flux
                System.out.println(line);
                line = br.readLine();
            }
            //fermeture de la socket
            socket.close();
            
        } catch (IOException e) {
            System.out.println("Erreur : " + e);
            e.printStackTrace();
        }
    }
    
}
