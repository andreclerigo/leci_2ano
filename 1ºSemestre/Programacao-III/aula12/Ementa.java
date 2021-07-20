package aula12;

public class Ementa {
    String nome, local;
    Prato[] ementaDaSemana;

    public Ementa(String nome, String local) {
        this.nome = nome;
        this.local = local;
        ementaDaSemana = new Prato[7];
    }

    public void addPrato(Prato p, int index) {
        this.ementaDaSemana[index] = p;
    }

    @Override
    public String toString() {
        String s = "Ementa " + nome + " em " + local + ":\n";
        /**if (!(ementaDaSemana == null)) {
            for (Prato p : ementaDaSemana) {
                s += p.toString();
            }
        }
        **/
        s += this.ementaDaSemana[0].toString();
        return s;
    }
}
