package it.fi.itismeucci;
import java.io.*;
import java.net.*;


public class Server {
    ServerSocket server = null;
    Socket client = null;
    String strRicevuta = null;
    String strMod = null;
    BufferedReader inDaClient;
    DataOutputStream outVersoClient;

    public Socket attendi() {

        try {
            System.out.println("1 server partito in esecuzione...");
            server = new ServerSocket(6789);
            client = server.accept();
            //server.close();
            

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            System.out.println("errore durante l'istanza del serevr ");
            System.exit(1);
        }
        
        return client;
        
    }

    public void comuninca()throws Exception{
        inDaClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
        outVersoClient = new DataOutputStream(client.getOutputStream());
        for(;;){
        try {

            //System.out.println("3 benvenuto client ,scrivi una frase e la trasformo in maiuscolo, Attendo....");
            strRicevuta = inDaClient.readLine();

            if(strRicevuta == null || strRicevuta.equals("BYE")){
                outVersoClient.writeBytes(strRicevuta+"=>(server in chiusura)"+"\n");
                System.out.println("server in chiusura :"+strRicevuta);
                break;
            }else{
                System.out.println("6 ricevuto e trasmesso la stringa : "+strRicevuta);
                strMod = strRicevuta.toUpperCase();
                strMod = strRicevuta.toUpperCase();
                System.out.println("7 invio la stringa modificata al client ... "+strMod);
                outVersoClient.writeBytes(strMod+'\n');
            }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
            outVersoClient.close();
            inDaClient.close();
            System.out.println("9 fine");   
            client.close();
        
    }
    
}

