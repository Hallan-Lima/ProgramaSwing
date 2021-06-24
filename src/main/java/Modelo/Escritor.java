package Modelo;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.print.event.PrintEvent;
import javax.sound.sampled.SourceDataLine;

public class Escritor {

    public static void main(String[] args) {
        
        int variavel=0, variavel2=2, variavel1=3;

    


        try {                                   // quando funciona normalmente
            
            FileOutputStream arquivo = new FileOutputStream("arquivo.txt");         //criando objeto e arquivo
            PrintWriter pr = new PrintWriter (arquivo);                             //obj que escreve no arquivo
            
            pr.println(variavel +" ; "+ variavel1 +" ; "+ variavel2);
            pr.println("Nayane ; L2-C2 L2-C2 ; L2-C3 ; L2-C4 ;");
            pr.println("L3-C1 ; L3-C2 L3-C2 ; Te-amo ; L3-C4 ;");
            System.out.println("feito");

            pr.close();
            arquivo.close();

        } catch (Exception e) {                 //quando da algum erro

            System.out.println("Erro ao executar");

        }


    }
    
}
