public class Projeto9Back {
    
    private int QtFazendas;
    private int QtConstrucao;
    private int Valor;
    
    
    public void exportaValor(int valor){
        Valor = valor;
        System.out.println(valor);
    }
    
    void msg(){
        System.out.println(Valor);
    }
    
    public int getValor(int valor){
        Valor = valor;
        return this.Valor;
        
    }
    
    public void setValor(int v){
        this.Valor = v;
    }
        
    public int getQtFazendas(){
        return this.QtFazendas;
    }

    public int getQtConstrucao(){
        return this.QtConstrucao;
    }
    
    public void setQtFazendas(int f){
        this.QtFazendas = f;
    }
    
    public void setQtConstrucao(int c){
        this.QtConstrucao = c;
    }
    
    public void mensagem(){
    System.out.println("Opções");
    System.out.println("1 - para incluir um valor");
    System.out.println("2 - para exibir");
    System.out.println("3 - para diminuir um valor");
    System.out.println("----/ FINAL /----");
    }
    
    public void status(){
        
        System.out.println("Qt Fazendas "+QtFazendas);
        System.out.println("Qt Construcao "+QtConstrucao);
        
    }
    
}
