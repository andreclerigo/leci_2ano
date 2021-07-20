package aula4;

import java.util.Vector;
import aula3.Estudante;

public class Disciplina {
    private String nome;
    private String areaCientifica;
    private int ects;
    private Professor profDisciplina;
    private Vector<Estudante> alunos = new Vector<Estudante>();

    public Disciplina(String nome, String areaCientifica, int ects, Professor profDisciplina){
        this.nome = nome;
        this.areaCientifica = areaCientifica;
        this.ects = ects;
        this.profDisciplina = profDisciplina;
    }

    public Estudante[] getAlunos() {
        return toArray(this.alunos);
    }

    public String getAreaCientifica() {
        return areaCientifica;
    }

    public int getEcts() {
        return ects;
    }

    public String getNome() {
        return nome;
    }

    public Professor getProfDisciplina() {
        return profDisciplina;
    }

    @Override
    public String toString() {
        return "\nDisciplina: " + getNome()
               +  "\nArea Cientifica: " + getAreaCientifica()
               +  "\nECTS: " + getEcts()
               +  "\nResponsável: " + getProfDisciplina()
               +  "\nAlunos: "      + getAlunos().length;
    }

    public boolean addAluno(Estudante est){
        if(alunos.contains(est)){
            return false;
        }
        else{
            return alunos.add(est);
        }
    }

    public boolean delAluno(int nMec){
        for(Estudante a : alunos){
            if(a.getNmec() == nMec){
                return alunos.remove(a);
            }
        }
        return false;
    }

    public boolean alunoInscrito(int nMec){
        for(Estudante a : alunos){
            if(a.getNmec() == nMec){
                return true;
            }
        }
        return false;
    }

    public int numAlunos(){
        return alunos.size();
    }

    private static Estudante[] toArray(Vector<Estudante> s) {
        return s.toArray(new Estudante[s.size()]);
    }

    public Estudante[] getAlunos(String tipo){
        Vector<Estudante> tipoEstudante = new Vector<>();
        for(Estudante a : alunos){
            if(a.getClass().getSimpleName().equals(tipo)){
                tipoEstudante.add(a);
            }
        }
        return toArray(tipoEstudante);
    }  
}
