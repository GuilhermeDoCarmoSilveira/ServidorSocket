package com.imagem;

import java.io.*;
import java.net.*;

public class ServidorSocketImagem {
    public static void main(String[] args) {
        int porta = 12346; 
        String diretorioDestino = "C:\\Users\\dti\\Pictures\\Saved Pictures"; 

        try {
            ServerSocket servidorSocket = new ServerSocket(porta);
            System.out.println("Servidor iniciado. Aguardando conexão...");

            Socket clienteSocket = servidorSocket.accept();
            System.out.println("Cliente conectado: " + clienteSocket);

            InputStream inputStream = clienteSocket.getInputStream();

            byte[] buffer = new byte[4096];
            int bytesRead;
            FileOutputStream fileOutputStream = new FileOutputStream(diretorioDestino + "imagem_recebida.jpg");
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }

            inputStream.close();
            clienteSocket.close();

            System.out.println("Imagem recebida e salva com sucesso em: " + diretorioDestino + "imagem_recebida.jpg");

            servidorSocket.close();
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

