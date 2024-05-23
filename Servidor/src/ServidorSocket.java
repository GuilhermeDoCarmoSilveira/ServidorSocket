import java.io.*;
import java.net.*;

public class ServidorSocket {
    public static void main(String[] args) {
        int porta = 12345; 
        
        try {
            ServerSocket servidorSocket = new ServerSocket(porta);
            System.out.println("Servidor iniciado. Aguardando conexão...");

            Socket clienteSocket = servidorSocket.accept();
            System.out.println("Cliente conectado");

            BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            PrintWriter saida = new PrintWriter(clienteSocket.getOutputStream(), true);

            String mensagemRecebida = entrada.readLine();
            System.out.println("Mensagem recebida: " + mensagemRecebida);

            String mensagemEmMaiusculas = mensagemRecebida.toUpperCase();

            saida.println(mensagemEmMaiusculas);
            System.out.println("Mensagem enviada: " + mensagemEmMaiusculas);

            entrada.close();
            saida.close();
            clienteSocket.close();

            servidorSocket.close();
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
