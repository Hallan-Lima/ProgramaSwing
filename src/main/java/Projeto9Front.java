
import java.util.Scanner;

//https://www.youtube.com/watch?v=6i-_R5cAcEc

public class Projeto9Front {
    public static void main(String[] args) {

        Projeto9Back back = new Projeto9Back();
                
        int x = 0;
        while( x < 5){
        
            back.status();
            
            back.setQtFazendas(x);
            back.setQtConstrucao(x);

            System.out.println("final etapa");
            back.status();
        
            back.setQtFazendas(x-1);
            back.setQtConstrucao(x-1);

            back.status();
            System.out.println("---- FINAL ----");
            
            x++;
        }
        
      

        
    }
    
}
