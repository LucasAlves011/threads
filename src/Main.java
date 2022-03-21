
public class Main {    
    public static final int TEMPO = 3000;
    /** xd
     * @autor Lucas Matheus do Nascimento Alves 
     */
    
    public static void main(String[] args) throws Exception {
        /**
         * Vou simular 6 Threads disputando 2 impressoras.
         *  A lógica é a seguinte, cada Thread vai imprimir um linha de símbolos em um PAPEL e dormir 
         * por 3 segundos.
         * O resultado real esperado no PAPEL de uma impressora que nos estamos simulando  depois
         * que a primeira Thread executar por completo seria este: 
         * AAAAAAAAAAAAAAAAAAAA
         * AAAAAAAAAAAAAAAAAAAA
         * AAAAAAAAAAAAAAAAAAAA
         * AAAAAAAAAAAAAAAAAAAA
         * AAAAAAAAAAAAAAAAAAAA
         * 
         * Logo em seguida a Thread que esperava a impressora ficar disponível começa a sua impressão no papel
         * logo abaixdo de sua anterior e o resultado no PAPEL seria parecido com esse daqui:
         * 
         * AAAAAAAAAAAAAAAAAAAA
         * AAAAAAAAAAAAAAAAAAAA
         * AAAAAAAAAAAAAAAAAAAA
         * AAAAAAAAAAAAAAAAAAAA
         * AAAAAAAAAAAAAAAAAAAA 
         * BBBBBBBBBBBBBBBBBBBB
         * BBBBBBBBBBBBBBBBBBBB
         * BBBBBBBBBBBBBBBBBBBB
         * BBBBBBBBBBBBBBBBBBBB
         * BBBBBBBBBBBBBBBBBBBB
         * 
         * Lembrando que ela vai imprimir no mesmo PAPEL que a Thread anterior 
         * */ 

         /* 
            A Impressora é uma classe que tem um NOME e um método Imprimir(que é somente um system.out 
            simulando que ela está imprimindo em um papel)
         */
        Impressora vermelha = new Impressora("Vermelha");
        Impressora azul = new Impressora("  Azul  ");
        
        /*
            A Classe MyThread recebe como parâmetro uma impressora na qual vai fazer sua impressão e o seu texto
        */
        
        MyThread t0 = new MyThread(vermelha,"AAAAAAAAAAAAAAAAAAAA");
        MyThread t1 = new MyThread(vermelha,"BBBBBBBBBBBBBBBBBBBB");
        MyThread t2 = new MyThread(vermelha,"CCCCCCCCCCCCCCCCCCCC");

        MyThread t3 = new MyThread(azul,"DDDDDDDDDDDDDDDDDDDD");
        MyThread t4 = new MyThread(azul,"EEEEEEEEEEEEEEEEEEEE");
        MyThread t5 = new MyThread(azul,"FFFFFFFFFFFFFFFFFFFF");

        /**
         * Depois da execução no console vimos que não ficou certinho AAAAAA e logo abaixo BBBBBB, mas perceba
         * que temos duas Threads imprimindo em impressoras DIFERENTES e em papeis diferentes (PARALELISMO REAL):
         *  AAAAA na impressora Vermelha }                 
         *  BBBBB na impressora  Azul    }          (Vermelha)         (Azul)
         *  AAAAA na impressora Vermelha }            AAAAA             BBBBB
         *  BBBBB na impressora  Azul    }   ->       AAAAA             BBBBB
         *  AAAAA na impressora Vermelha }            AAAAA             BBBBB
         *  BBBBB na impressora  Azul    }
         * 
         * NUNCA UMA INTERFERIO NA IMPRESSÃO DA OUTRA !!
         */

    }  
}
