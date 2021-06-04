
public class Impressora {
   
    private String id;
    
    public Impressora(String id) {
       this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    /** 
     * No java, quem vai fazer o controle de Threads é a palavra reservada syncronized, ela não deixa o métodos imprimir 
     * ser execetudo simultâneamente por duas Threads, 
     * 
     * Sem ela uma Thread iria usar a impressora ao mesmo tempo que outra, teriamos algo parecido com isso no papel:
     * AAAAAAAAAAAAAAAAAAAA 
     * BBBBBBBBBBBBBBBBBBBB
     * AAAAAAAAAAAAAAAAAAAA         "OQUE SERIA UM ERRO GRAVE, O DOCUMENTO FICARIA ILEGÍVEL E ISSO TAMBÉM PODE
     * BBBBBBBBBBBBBBBBBBBB          PODE ACONTECER COM TODOS OS TIPOS DE DADOS QUE FOREM COMPARTILHADOS SEM 
     * BBBBBBBBBBBBBBBBBBBB          UMA REGRA DE ACESSO"
     * AAAAAAAAAAAAAAAAAAAA
     */

        /* 
            Teste de Webhook teste teste teste
            Qualquer coisa namoral coisa chata da porra teste de webhook
        */

    public synchronized void imprimir(String texto) {
        System.out.println("\t\t▶▶▶▶▶▶▶▶▶▶▶▶▶  " + Thread.currentThread().getName() + " começou a impressão na impressora " + id +"  ◀◀◀◀◀◀◀◀◀◀◀◀◀");       
        for (int i = 0; i < 5; i++) {
            System.out.println( Thread.currentThread().getName() + " / impressora " + id + ": " + texto);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
        System.out.println("\t\t'''''''''''''''' ✅ " +Thread.currentThread().getName() + " finalizou a impressão do documento."
                    + " Impressora " + id + " está livre ✅ ''''''''''''''''\n");
    }
}
