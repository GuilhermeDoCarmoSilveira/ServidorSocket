package com.imagem;

import java.io.*;
import java.net.*;

public class ClienteSocketImagem {
    public static void main(String[] args) {
    	
        String enderecoServidor = "localhost"; 
        int porta = 12346; 
   
        String caminhoImagem = "C:\\Users\\dti\\Desktop\\Nova pasta\\timao.jpg";

        try {
            Socket socket = new Socket(enderecoServidor, porta);

            OutputStream outputStream = socket.getOutputStream();

            FileInputStream fileInputStream = new FileInputStream(caminhoImagem);
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.close();
            socket.close();

            System.out.println("Imagem enviada para o servidor.");

        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
