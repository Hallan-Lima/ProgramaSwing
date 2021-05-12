
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import sun.reflect.generics.visitor.Reifier;


/**
 *
 * @author hlima
 */
public class Janela7 extends javax.swing.JDialog {
    
    int a=0; //varial de opção
    int b=100, f=100; //varial da vida, fadiga
    int t,t1, t2, t3=0, t4, t5, d; // variavel temporaria, dias sobrevidos
    int F=100, S=100; // Fome e Sede
    
    int valor;  //variavel da historia
    
    int itemGalho, itemFruta, itemAgua, itemLanca, itemTocha;
    
    //pegar a hora que foi iniciado a partida
/**
 *Date data = new Date();
 *SimpleDateFormat formatar = new SimpleDateFormat("HH:mm");
 *String dataFormatada = formatar.format(data);
 */
    
    Random aleatorio = new Random();    //gerador de numeros
    
    long totalMilisegundos = System.currentTimeMillis()-10800000;
    long totalSegundos = totalMilisegundos / 1000;
    long segundoAtual = totalSegundos % 60;
    long totalMinutos = totalSegundos / 60;
    long minutoAtual = totalMinutos % 60;
    long totalHora = totalMinutos / 60;
    long horaAtual = totalHora % 24;
    
    
    
    void hora(){
    
         // verificar a quantidade de horas    
    if (horaAtual >= 24) {
        d++;
        horaAtual -=24;
    }else{
        if(minutoAtual >= 60){
            minutoAtual -= 60;
            horaAtual += 1;
        }else{};};

    lblHoras.setText(horaAtual+":"+minutoAtual); //atualizar horario        
    
    }
    
    void historia(){
    //gerador de numeros para exibir alguma questão
    
    valor = aleatorio.nextInt(9);
    t1 = aleatorio.nextInt(10)+1;
        
    //começo da função
            switch(valor){
                case 0:         //primeira questão
                    lblMsg.setText("Voce encontrou um tigre");
                        if( a % 2 == 0 ){
                            b = (b - 25);
                            lblMsg2.setText("Ele te arranhou");
                        }else{
                            lblMsg2.setText("Muito bem, continue");
                        }
                        btnOp7.setEnabled(false);
                break;      //final da primeira questão
                    
                case 1:         //segunda questão
                    lblMsg.setText("Voce esta perto!");
                        if( a % 2 == 0 ){
                            lblMsg2.setText("Achou um galho");
                            itemGalho++;
                        }else{
                             b = (b - 10);
                            lblMsg2.setText("Cuidado, voce tropeçou e caiu");
                        }
                break;      //finsl
                    
                case 2:         //segunda questão
                    lblMsg.setText("Não desista");
                        if( a % 2 == 0 ){
                            lblMsg2.setText("Isso ai!");
                        }else{
                             b = (b - 15);
                            lblMsg2.setText("Voce foi picado por uma cobra");
                        }
                break;      //finsl
            
                case 3:         //segunda questão
                    lblMsg.setText("Voce encontrou algumas frutas");
                    lblMsg2.setText("Comer frutas?");
                    t=3;
                    ativa_opcao();                    
                break;      //finsl
                
                case 4:         //segunda questão
                    lblMsg.setText("Um rio, tomar uma agua?");
                    lblMsg2.setText("Voce encheu seu cantil");
                    t=4;
                    itemAgua=100;
                    ativa_opcao();
                break;      //finsl
                
                case 5:         //questao
                    lblMsg.setText("Voce encontrou um chimpanze");
                        if( a % 2 == 0 ){
                            b = (b - 5);
                            lblMsg2.setText("Ele jogou fezes em voce");
                        }else{
                            lblMsg2.setText("Ele te deu uma banana");
                            F+=10;
                            if (F>=100) {
                                F=100;
                            }else{};                            
                        }
                        btnOp7.setEnabled(false);
                break;      //final
            
                case 6:         //questao
                    lblMsg.setText("A natureza é bela!");
                        if (t == 0 ) {
                        lblMsg2.setText("Voce encontrou uma tartaruga");  
                    }
                break;      //final
                
                case 7:         //questao
                    lblMsg.setText("Zebra é um animal muito bonito");
                        if (t==0) {
                        lblMsg2.setText("Continue para encontra o tesouro");                      
                    }
                break;      //final
                
                case 8:         //questao
                    lblMsg.setText("voce encontrou uma arvore com frutas");
                    t=5;
                    ativa_opcao();
                break;      //final
                
                case 9:
                    lblMsg.setText("Voce encontrou alguns galhos");
                    t=6;
                    ativa_opcao();
                break;
            
            }
        
    }
    
    void verificar_vida(){
    
    if (F>50 && f>50 && b>50 && S>50 ) {
        t3=0;
    }else{};
    
        
     for(; F<30 & t3==0 ; t3++){
        String[] opcoes = {"OK"};
        JOptionPane.showOptionDialog(null, "Voce esta morrendo de fome, tente comer alguma coisa.", "CUIDADO!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opcoes, opcoes[0]);
    };
     for(; f<30 & t3==0 ; t3++){
        String[] opcoes = {"OK"};
        JOptionPane.showOptionDialog(null, "Voce esta muito cansado, tente descansar um pouco.", "CUIDADO!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opcoes, opcoes[0]);
    };
     for(; b<30 & t3==0 ; t3++){
        String[] opcoes = {"OK"};
        JOptionPane.showOptionDialog(null, "A sua vida esta muito baixa tome cuidado.", "CUIDADO!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opcoes, opcoes[0]);
    };
     for(; S<30 & t3==0 ; t3++){
        String[] opcoes = {"OK"};
        JOptionPane.showOptionDialog(null, "Voce esta com sede, tome um pouco de agua.", "CUIDADO!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opcoes, opcoes[0]);
    };
     
    }
    
    void programa (){
        
    verificar_vida();
    if (b <= 0 || f <= 0 || F <= 0 || S <= 0 ) {         // verificando se tem vida
           morreu();
        }
            
    desativa_opcao();
    
        f -= 10; // diminuir a fadiga
        
            historia();
            atualizar();
            System.out.println("--- INICIO - debug----");
            System.out.println("--- FIM - debug----");
       
       if (b <= 0 || f <= 0 || F <= 0 || S <= 0 ) {         // verificando se tem vida
           morreu();
        }else{};
        //final da função
        
   
        
    }
    
    void morreu (){
        
        if (b<=0) {
            lblMsg.setText("Voce ficou muito ferido e morreu");
        }
        if (F<=0){
            lblMsg.setText("Voce morreu de fome");
        }
        if (f<=0){
            lblMsg.setText("Voce ficou muito cansado e não conseguiu mais se mexer.");
        }
        if (S<=0){
            lblMsg.setText("Voce ficou com muita sede e morreu.");
        }
    
        lblMsg2.setText("Meus parabens voce sobreviveu "+ d +" dias");
        lblVida1.setText("-");
        lblFadiga.setText("-");
        lblFome.setText("-");
        lblSede.setText("-");
        lblHoras.setText("-");
        btnOp1.setEnabled(false);
        btnOp2.setEnabled(false);
        btn1.setEnabled(false);
        jTabbedPane1.setEnabled(false);
        
        b=0;
        F=0;
        f=0;
        S=0;
        itemGalho=0;
        itemFruta=0;
        itemAgua=0;
        itemLanca=0;
        itemTocha=0;

        t=1;
        btnOp7.setEnabled(true);
        btnOp7.setText("Jogar");
        opcao_reiniciar();
    }
    
    void ativa_opcao(){
    
        btnOp10.setEnabled(true);
        btnOp11.setEnabled(true);
        btnOp10.setText("Sim");
        btnOp11.setText("Não");
        btnOp7.setEnabled(false);
    
    }
    void desativa_opcao(){
    
    btnOp10.setEnabled(false);
    btnOp11.setEnabled(false);
    btnOp10.setText("-");
    btnOp11.setText("-");
    lblMsg2.setText("-");
    btnOp7.setEnabled(true);
    
    }
    
    void atualizar(){
        
        hora();
    
        lblFadiga.setText(Integer.toString(f)); //atualizar o valor
        lblHoras.setText(horaAtual+":"+minutoAtual); //atualizar horario
        lblFome.setText(Integer.toString(F));   // fome
        lblVida1.setText(Integer.toString(b));  //vida
        lblSede.setText(Integer.toString(S));   //sede
        
        lbl_Item_5.setText(Integer.toString(itemGalho));
        lbl_Bolsa_1.setText(Integer.toString(itemFruta));
        lbl_Item_01.setText(Integer.toString(itemFruta));
        lbl_Item_2.setText(Integer.toString(itemAgua));
        lbl_Bolsa_2.setText(Integer.toString(itemAgua));
        
    
    }
    
    void opcao_reiniciar(){
    
        btnOp10.setEnabled(false);
        btnOp11.setEnabled(false);
        btnOp10.setText("-");
        btnOp11.setText("-");

    }
    
    public Janela7(java.awt.Frame parent, boolean modal) {
        /*abrir tela*/
        super(parent, modal);
    //        this.dataFormata = (horaAtual +":"+minutoAtual);
        initComponents();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenu1 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jOptionPane1 = new javax.swing.JOptionPane();
        lblMsg = new javax.swing.JLabel();
        btnOp1 = new javax.swing.JButton();
        btnOp2 = new javax.swing.JButton();
        lblMsg2 = new javax.swing.JLabel();
        btnOp5 = new javax.swing.JButton();
        btnOp7 = new javax.swing.JButton();
        btnOp8 = new javax.swing.JButton();
        btnOp9 = new javax.swing.JButton();
        lbl3 = new javax.swing.JLabel();
        lblHoras = new javax.swing.JLabel();
        btnOp10 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btnOp11 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        lbl_Item_01 = new javax.swing.JLabel();
        lbl_Item_2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_Item_3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbl_Item_4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_Item_5 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel3 = new javax.swing.JLabel();
        btn_Bolsa_1 = new javax.swing.JButton();
        lbl_Bolsa_1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_Bolsa_2 = new javax.swing.JLabel();
        btn_Bolsa_2 = new javax.swing.JButton();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        btn_Contr_1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btn_Contr_2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        lbl1 = new javax.swing.JLabel();
        lblVida1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lblFadiga = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        lblSede = new javax.swing.JLabel();
        lblFome = new javax.swing.JLabel();
        btnOp12 = new javax.swing.JButton();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jMenu1.setText("jMenu1");

        jScrollPane1.setViewportView(jTree1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblMsg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMsg.setText("Encontre o tesouro");

        btnOp1.setText("Esquerda");
        btnOp1.setActionCommand("Opção 1");
        btnOp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOp1ActionPerformed(evt);
            }
        });

        btnOp2.setText("Direita");
        btnOp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOp2ActionPerformed(evt);
            }
        });

        lblMsg2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMsg2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMsg2.setText("Escolha uma direção para seguir");

        btnOp5.setText("Sair");
        btnOp5.setActionCommand("Opção 1");
        btnOp5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOp5ActionPerformed(evt);
            }
        });

        btnOp7.setText("Dormi");
        btnOp7.setActionCommand("Opção 1");
        btnOp7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOp7ActionPerformed(evt);
            }
        });

        btnOp8.setText("Soco");
        btnOp8.setActionCommand("Opção 1");
        btnOp8.setEnabled(false);
        btnOp8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOp8ActionPerformed(evt);
            }
        });

        btnOp9.setText("Fugir");
        btnOp9.setActionCommand("Opção 1");
        btnOp9.setEnabled(false);
        btnOp9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOp9ActionPerformed(evt);
            }
        });

        lbl3.setText("Horas :");

        lblHoras.setText("00:00");

        btnOp10.setText("-");
        btnOp10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnOp10.setEnabled(false);
        btnOp10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOp10ActionPerformed(evt);
            }
        });

        btn1.setText("Ir para tras");
        btn1.setEnabled(false);
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btnOp11.setText("-");
        btnOp11.setEnabled(false);
        btnOp11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOp11ActionPerformed(evt);
            }
        });

        jLabel1.setText("Frutas :");

        lbl_Item_01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Item_01.setText("-");

        lbl_Item_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Item_2.setText("-");

        jLabel2.setText("Tocha :");

        jLabel11.setText("Agua :");

        lbl_Item_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Item_3.setText("-");

        jLabel12.setText("Lança :");

        lbl_Item_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Item_4.setText("-");

        jLabel7.setText("Madeira :");

        lbl_Item_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Item_5.setText("-");

        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lbl_Item_01, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lbl_Item_2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lbl_Item_3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lbl_Item_4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lbl_Item_5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbl_Item_2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Item_01, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Item_3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Item_4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Item_5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(321, 321, 321))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbl_Item_01))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Item_2)
                    .addComponent(jLabel11))
                .addGap(8, 8, 8)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbl_Item_3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lbl_Item_4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbl_Item_5))
                .addGap(21, 21, 21))
        );

        jTabbedPane1.addTab("Itens", jLayeredPane1);

        jLabel3.setText("Frutas :");

        btn_Bolsa_1.setText("Comer");
        btn_Bolsa_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Bolsa_1ActionPerformed(evt);
            }
        });

        lbl_Bolsa_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Bolsa_1.setText("-");

        jLabel5.setText("Agua :");

        lbl_Bolsa_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Bolsa_2.setText("-");

        btn_Bolsa_2.setText("Beber");
        btn_Bolsa_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Bolsa_2ActionPerformed(evt);
            }
        });

        jLayeredPane2.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(btn_Bolsa_1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(lbl_Bolsa_1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(lbl_Bolsa_2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(btn_Bolsa_2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_Bolsa_1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Bolsa_1))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_Bolsa_2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Bolsa_2)))
                .addContainerGap(264, Short.MAX_VALUE))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btn_Bolsa_1)
                    .addComponent(lbl_Bolsa_1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbl_Bolsa_2)
                    .addComponent(btn_Bolsa_2))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bolsa", jLayeredPane2);

        btn_Contr_1.setText("Contruir");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Tocha");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setText("Madeira + pano + esqueiro");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel9.setText("Madeira");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Lança");

        btn_Contr_2.setText("Contruir");
        btn_Contr_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Contr_2ActionPerformed(evt);
            }
        });

        jLayeredPane3.setLayer(btn_Contr_1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btn_Contr_2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jSeparator1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jLayeredPane3Layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn_Contr_1)))
                            .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jLayeredPane3Layout.createSequentialGroup()
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn_Contr_2))))
                        .addGap(0, 260, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btn_Contr_1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(btn_Contr_2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Construir", jLayeredPane3);

        lbl1.setText("Vida :");

        lblVida1.setText("100");

        lbl2.setText("Fadiga :");

        lblFadiga.setText("100");

        lbl4.setText("Fome :");

        lbl5.setText("Sede :");

        lblSede.setText("100");

        lblFome.setText("100");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblVida1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblFadiga, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSede, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFome, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVida1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFadiga, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSede)))
        );

        btnOp12.setText("Ir para frente");
        btnOp12.setEnabled(false);
        btnOp12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOp12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMsg2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnOp1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnOp8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnOp12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnOp9))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnOp7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnOp10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnOp11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnOp5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnOp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addComponent(lblMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(lblMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMsg2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOp1)
                    .addComponent(btnOp2)
                    .addComponent(btnOp8)
                    .addComponent(btnOp9)
                    .addComponent(btnOp12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOp7)
                    .addComponent(btnOp10)
                    .addComponent(btn1)
                    .addComponent(btnOp11)
                    .addComponent(btnOp5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        lblMsg2.getAccessibleContext().setAccessibleName("");
        jTabbedPane1.getAccessibleContext().setAccessibleName("seção");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOp1ActionPerformed
        // Esquerda:
        a++;
        programa();    
        atualizar();
        minutoAtual +=15; //tempo
        f-=5; //fadiga
        F-=1; //Fome
        S-=1; //Sede
       
    }//GEN-LAST:event_btnOp1ActionPerformed

    private void btnOp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOp2ActionPerformed
        // Direita:
        a+=2;
        programa();
        atualizar();
        minutoAtual +=15;
        f-=5;   //fadiga
        F-=1; //Fome
        S-=1; //Sede
       
    }//GEN-LAST:event_btnOp2ActionPerformed

    private void btnOp5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOp5ActionPerformed

        System.exit(0);
        
    }//GEN-LAST:event_btnOp5ActionPerformed
    
    private void btnOp7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOp7ActionPerformed
        //dormir ou morreu
        
        if (t == 1) { //morreu
            
        totalMilisegundos = System.currentTimeMillis()-10800000;
        totalSegundos = totalMilisegundos / 1000;
        segundoAtual = totalSegundos % 60;
        totalMinutos = totalSegundos / 60;
        minutoAtual = totalMinutos % 60;
        totalHora = totalMinutos / 60;
        horaAtual = totalHora % 24;
        //atualizando horario para inicio do novo jogo
                        
            btnOp1.setEnabled(true);
            btnOp2.setEnabled(true);
            jTabbedPane1.setEnabled(true);
            
            hora();
            opcao_reiniciar();
            atualizar();
            
            lblMsg.setText("Sobreviva o maximo que conseguir!");
            btnOp7.setText("Dormi");
        }else{};
                
        if (f >= 100) {
            lblMsg2.setText("Voce não esta cansado");
        }else{
            f+=15;          //esta dormindo
            horaAtual += 1; //tempo passando
            F-=20;          //diminuindo a fome
            S-=20;
            
            if (F <= 0 || S <= 0) {
                morreu();                
            }else{};
                if(f >= 100){
                f=100;
                }else{};
        };
        
        hora();
        atualizar();
        
    }//GEN-LAST:event_btnOp7ActionPerformed

    private void btnOp8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOp8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOp8ActionPerformed

    private void btnOp9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOp9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOp9ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn1ActionPerformed

    private void btnOp10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOp10ActionPerformed
        // opção
        desativa_opcao();
        atualizar();
        
        switch(t){
            case 3:
                lblMsg2.setText("Voce comeu a fruta");
                F += 10; // diminuir a fome
                S += 5; // diminuir a sede
                minutoAtual += 5;
            break;
            case 4:
                lblMsg2.setText("Voce matou a sua sede");
                F += 10; // diminuir a fome
                S = 100; // diminuir a sede
                minutoAtual += 5;
            break;
            case 5:
                lblMsg2.setText("Voce pegou " + t1 + " frutas");
                itemFruta += t1;
                minutoAtual += 15;
            break;
            case 6:
                itemGalho+= t1;
            break;
        }
         
        t=0;
    }//GEN-LAST:event_btnOp10ActionPerformed

    private void btnOp11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOp11ActionPerformed
        // opção
        desativa_opcao();
        atualizar();
        if (t==3) {
            lblMsg2.setText("Voce não comeu a fruta");
        }else{};
        if (t==4) {
            lblMsg2.setText("Voce não bebeu agua");
        }else{};
        if (t==5){
            lblMsg2.setText("Voce não pegou nenhuma fruta");
        }else{};
        
        t=0;
    }//GEN-LAST:event_btnOp11ActionPerformed

    private void btn_Bolsa_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Bolsa_2ActionPerformed

         if (S>=100) {
            lblMsg2.setText("Voce não esta com sede");
            S=100;
        }else{
            t1 =  100-S; 
        itemAgua -= t1;
        if(itemAgua <= 0){
        lblMsg2.setText("Voce esta sem agua");
        itemAgua=0;
        }
        else{
            S=100;
            F+=5;
            minutoAtual+=5;
            };};
        atualizar();
        t1=0;

    }//GEN-LAST:event_btn_Bolsa_2ActionPerformed

    private void btn_Bolsa_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Bolsa_1ActionPerformed
        if (F >= 100) { // esta com fome?
            lblMsg2.setText("Voce não esta com fome");
            F=100;
        }else{
        if(itemFruta <= 0){     // tem fruta?
        lblMsg2.setText("Voce não tem frutas na bolsa");
        itemFruta=0;
        }
        else{
            itemFruta--;
            F+=10;
            S+=5;
            minutoAtual+=5;
            };};
        atualizar();
    }//GEN-LAST:event_btn_Bolsa_1ActionPerformed

    private void btnOp12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOp12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOp12ActionPerformed

    private void btn_Contr_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Contr_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Contr_2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrimeiraJanela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrimeiraJanela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrimeiraJanela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrimeiraJanela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PrimeiraJanela dialog = new PrimeiraJanela(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btnOp1;
    private javax.swing.JButton btnOp10;
    private javax.swing.JButton btnOp11;
    private javax.swing.JButton btnOp12;
    private javax.swing.JButton btnOp2;
    private javax.swing.JButton btnOp5;
    private javax.swing.JButton btnOp7;
    private javax.swing.JButton btnOp8;
    private javax.swing.JButton btnOp9;
    private javax.swing.JButton btn_Bolsa_1;
    private javax.swing.JButton btn_Bolsa_2;
    private javax.swing.JButton btn_Contr_1;
    private javax.swing.JButton btn_Contr_2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lblFadiga;
    private javax.swing.JLabel lblFome;
    private javax.swing.JLabel lblHoras;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JLabel lblMsg2;
    private javax.swing.JLabel lblSede;
    private javax.swing.JLabel lblVida1;
    private javax.swing.JLabel lbl_Bolsa_1;
    private javax.swing.JLabel lbl_Bolsa_2;
    private javax.swing.JLabel lbl_Item_01;
    private javax.swing.JLabel lbl_Item_2;
    private javax.swing.JLabel lbl_Item_3;
    private javax.swing.JLabel lbl_Item_4;
    private javax.swing.JLabel lbl_Item_5;
    // End of variables declaration//GEN-END:variables
}
