package Modelo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.sound.sampled.SourceDataLine;

public class Leitor {
    
    public static void main(String[] args) {
        
        try {
            
            FileInputStream arquivo = new FileInputStream("arquivo.txt");           //criando objeto e arquivo
            InputStreamReader input = new InputStreamReader(arquivo);               //vai ler o arquivo
            BufferedReader      br  = new BufferedReader(input);                    //ele modifica a leitura (le linha a linha)

            String linha, a;
            int b;

            do{

                linha = br.readLine();                  //esta lendo cada linha
                if (linha != null) {
                
                    System.out.println("-----");
                    String[] palavras = linha.split(";");
                    for (int i=0; i<1; i++){

                        System.out.println("Palavras lida ="+palavras[1]);
                        a = palavras[1];
                        b = Integer.parseInt(a);

                        System.out.println("valor de a ="+b);
                       
                    }
                    

                }

            }while (linha != null); {
                
            }



        } catch (Exception e) {

            System.out.println("Erro ao let o arquivo");

        }

    }

}
