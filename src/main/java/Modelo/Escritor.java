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
            
            pr.println("Qt1;Qt2;Qt3;Qt4");
            pr.println("1;"+variavel +";"+ variavel1 +";"+ variavel2+";5");
            pr.println("nome;1;1;1;1");
            pr.println("3;6;6;6;6");
            System.out.println("feito");

            pr.close();
            arquivo.close();

        } catch (Exception e) {                 //quando da algum erro

            System.out.println("Erro ao executar");

        }


    }
    
}
