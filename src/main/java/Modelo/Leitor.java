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

            String linha, a="a", v2=null,v3=null,v4=null,v1=null;
            int b;

            linha = br.readLine();                      //esta lendo cada linha (cabeçalho)
            do{

                linha = br.readLine();                  //pula para a segunda linha
                if (linha != null) {                    // fazer tratamento dos dados
                    
                    String[] vect = linha.split(";");

                    v1 = vect[0];
                    v2 = vect[1];
                    v3 = vect[2];
                    v4 = vect[3];
                    
                    // 
                    //v1 = vect[0];
                    //
                    //if (v1 == "nome") {
                    //    v2 = vect[1];
                    //    v3 = vect[2];
                    //    v4 = vect[3];
                    //}
                    
                    System.out.println(linha);
                    System.out.println(v1+" - "+v2+" - "+v3+" - "+v4);
                    System.out.println("---------");

                }

            }while (linha != null); {
                
            }



        } catch (Exception e) {

            System.out.println("Erro ao let o arquivo");

        }

    }

}
