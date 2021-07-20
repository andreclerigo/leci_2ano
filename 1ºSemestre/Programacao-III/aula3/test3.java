package aula3;
import aula1.Data;
public class test3 {
    
    public static void main(String[] args) {
        Ligeiros lig = new Ligeiros(50,120,4, 1200);
        Motociclo mot = new Motociclo(1000,60,2,200);
        PesadoMercadorias pesMerc = new PesadoMercadorias(100,140,3,4000);
        PesadoPassageiros pesPass = new PesadoPassageiros(150,120, 55, 3500);
        
        Condutor con = new Condutor("João", 123451523,new Data(22,6,2001),"A");
        Condutor con1 = new Condutor("André", 12341235,new Data(01,01,2001),"B");

        System.out.println(lig);
        System.out.println(mot);
        System.out.println(pesMerc);
        System.out.println(pesPass);
        System.out.println("\n--------Condutores:--------");
        System.out.println(con);
        System.out.println(con1);
    }
}
