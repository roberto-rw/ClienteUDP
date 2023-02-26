import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;

public class ClientServerUDP extends Thread{

    public ClientServerUDP() {

    }

    @Override
    public void run(){

        try{
            DatagramSocket serverSocket = new DatagramSocket(5000);
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            while (true) {
                serverSocket.receive(receivePacket);
                System.out.println("Archivo recibido.");

                byte[] fileData = receivePacket.getData();
                int fileSize = receivePacket.getLength();
                String fileName = "archivo_recibido.txt"; // Nombre de el archivo recibido
                String filePath = "D:\\Documentos HDD\\Sexto Semestre\\Sistemas Distribuidos\\ArchivosCliente/" + fileName; // Ruta de destino

                FileOutputStream fileOutput = new FileOutputStream(filePath);
                fileOutput.write(fileData, 0, fileSize);
                fileOutput.close();

                System.out.println("Archivo guardado en: " + filePath);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
