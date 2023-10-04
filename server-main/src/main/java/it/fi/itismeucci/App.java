package it.fi.itismeucci;

public class App {
    public static void main( String[] args ) throws Exception
    {
        Server servente = new Server();
        servente.attendi();
        servente.comuninca();
    }
}
