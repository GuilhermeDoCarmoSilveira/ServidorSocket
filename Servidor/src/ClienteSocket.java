import java.io.*;
import java.net.*;
import java.util.Scanner;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteSocket {
    public static void main(String[] args) {
        try {
        	
            Socket socket = new Socket("localhost", 12345);

            PrintWriter saida = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite a mensagem para enviar ao servidor: ");
            String mensagemParaEnviar = scanner.nextLine();

            saida.println(mensagemParaEnviar);
            System.out.println("Mensagem enviada para o servidor: " + mensagemParaEnviar);

            String mensagemRecebida = entrada.readLine();
            System.out.println("Resposta do servidor: " + mensagemRecebida);

            saida.close();
            entrada.close();
            scanner.close();
            socket.close();
            
        } catch (IOException e) {
        	
            System.out.println("Erro: " + e.getMessage());
            
        }
    }
}

