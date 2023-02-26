import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {


    public static void main(String[] args) {

        ObjectOutputStream outputStream;
        Socket socket = null;
        Scanner tec;
        String respuesta;
        PrintWriter printWriter;

        try {
            //Se crea el socket
            socket = new Socket("localhost", 8080);

            //Pone a la escucha al cliente por TCP para recibir datos del servidor
            ClientServerTCP clientServerTCP = new ClientServerTCP(socket);
            clientServerTCP.start();

            //Pone a la escucha al cliente por UDP para recibir archivos del servidor
            ClientServerUDP clientServerUDP = new ClientServerUDP();
            clientServerUDP.start();


            do{
                tec = new Scanner(System.in);
                System.out.println("Escriba su peticion al servidor: ");
                respuesta = tec.nextLine();
                printWriter = new PrintWriter(socket.getOutputStream(), true);
                printWriter.println(respuesta);

            }while(respuesta != "0");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}