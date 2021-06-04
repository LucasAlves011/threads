
public class MyThread implements Runnable{
  
    private Impressora impressora;
    private String texto;

    public MyThread(Impressora impressoras, String texto) {
        this.impressora = impressoras;
        this.texto = texto; 
        Thread x = new Thread(this);
        x.start();
    }
    public Impressora getImpressora() {
        return impressora;
    }

    public void setImpressora(Impressora impressora) {
        this.impressora = impressora;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public void run() {        
       impressora.imprimir(texto);              
    }
}