package aula7;

public class Voo implements Comparable<Voo>{ 
    private final Hour start;
	private final Hour delay;
	private final String observacoes, name, origin;
	private final Companhia companie; 
	
	public Voo(Hour start, String name, Companhia companie, String origin) {
        if(start == null || origin == null || companie == null) 
            throw new NullPointerException();
		this.start = start;
		this.name = name;
		this.origin = origin;
		this.companie = companie;
		this.delay = null;
		this.observacoes = "";
	}
	
	public Voo(Hour start, String name, Companhia companie, String origin, Hour delay, String observacoes) {
        if(start == null || delay == null || origin == null || companie == null) 
            throw new NullPointerException();
		this.start = start;
		this.delay = delay;
		this.name = name;
		this.origin = origin;
		this.companie = companie;
		this.observacoes = observacoes;
    }
	
	public String getObservacoes() {
		return observacoes;
	}

    public Companhia getCompanie() {
        return companie;
    }

	public Hour getDelay() {
		return delay;
	}

	public Hour getStart() {
		return start;
	}

	public String getName() {
		return name;
	}

	public String getOrigin() {
		return origin;
	}

    @Override
    public int compareTo(Voo v) {
        return 0;
    }

	@Override
	public String toString() {
		//String retorno = "";
		return null;
	}
}
