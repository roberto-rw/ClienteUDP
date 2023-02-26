import java.io.*;
import java.net.Socket;

public class ClientServerTCP extends Thread{

    Socket socket;

    public ClientServerTCP(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
         try{
             DataInputStream in = new DataInputStream(socket.getInputStream());
             // Escuchar al servidor continuamente
             while (true) {
                 System.out.println("Esperando lista de archivos del servidor...");
                 ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                 String[] arreglo = (String[]) objectInputStream.readObject();
                 showFileNames(arreglo);
             }

         }catch(Exception e){
             e.printStackTrace();
         }
    }

    private void showFileNames(String[] stringArray) throws Exception{
            // Imprimir el array de nombres de archivos
            for (String s : stringArray) {
                System.out.println(s);
            }
        }

    }

