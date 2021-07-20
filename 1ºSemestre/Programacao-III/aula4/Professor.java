package aula4;

import aula1.Data;
import aula3.Estudante;

public class Professor extends Estudante{
    private int nfunc;
    private static int nfuncGlobal = 0;
    private Data dataAdmissao;

    public Professor(String nome, int cc, Data dataNasc, Data iDataInsc,int nfunc,Data dataAdmissao){
        super(nome, cc, dataNasc);
        this.nfunc = nfuncGlobal++;
        this.dataAdmissao = dataAdmissao;
    }

    public Professor(String nome, int cc, aula1.Data data) {
        super(nome, cc, data);
        this.nfunc = nfuncGlobal++;
        this.dataAdmissao = new Data();
	}

	public Data getDataAdmissao() {
        return dataAdmissao;
    }

    public int getNfunc() {
        return nfunc;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
