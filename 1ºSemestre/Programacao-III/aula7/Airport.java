package aula7;

import java.util.*;
import java.io.*;
import java.nio.file.*;
/** Falta implementar Comparables para ordenar
 *	Imprimir para os Ficheiros
 */

public class Airport {
    private List<Voo> voos = new ArrayList<>();
	private HashMap<String,Companhia> companhiaCampo = new HashMap<>();
	private final List<String> infoVoos;
	private final List<String> infoCompanhias;
	private List<String> table;
	private List<String> citys;
	private List<String> citysList;
	private HashMap<String, Integer> dictCitys;
	private HashMap<Companhia, Hour> delayPerCompany;
	
	public Airport(String voosFile, String companhiasFile) throws IOException {
		infoCompanhias = Files.readAllLines(Paths.get(companhiasFile));
		infoVoos = Files.readAllLines(Paths.get(voosFile));
		getCompanhias();
		setTable();
		setDelay();
		setCitys();
	}

	public List<Voo> getVoos() {
		return voos;
	}

	public List<String> getTable() {
		return table;
	}

	public HashMap<String, Integer> getCitys() {
		return dictCitys;
	}

	public List<String> getCitysList() {
		citysList = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : dictCitys.entrySet()) {
			citysList.add(entry.getKey() + "\t" + entry.getValue());
		}
		return citysList;
	}

	public HashMap<Companhia, Hour> getDelay() {
		return delayPerCompany;
	}

	public void getCompanhias() {
		for(int i = 1; i < infoCompanhias.size(); i++) {
			String[] line = infoCompanhias.get(i).split("\t");
			companhiaCampo.put(line[0], new Companhia(line[0],line[1]));
		}
	}

	public void printTable(List<String> table) {
		for (String s : table) {
            System.out.println(s);
		}
		System.out.println();
	}

	public void printDelay(HashMap<Companhia, Hour> delayPerCompany) {
		//Funcao print do Atraso Medio
		System.out.println("Companhia \t\tAtraso médio");
		for (Map.Entry<Companhia, Hour> entry : delayPerCompany.entrySet()) {
			double nbOfVisualTabs = entry.getKey().toString().length()/4.0;
			System.out.print(entry.getKey() + "\t");
			if (nbOfVisualTabs >= 1.0 && nbOfVisualTabs < 2.0) System.out.print("\t\t");
			if (nbOfVisualTabs >= 2.0 && nbOfVisualTabs < 4.0) System.out.print("\t");
			System.out.println(entry.getValue());
		}
		System.out.println();
	}

	public void printCitys(HashMap<String, Integer> dictCitys) {
		System.out.println("Origem\t\t\tVoos");
		for (String s : citys) {
			System.out.print(s + "\t");
			double nbOfVisualTabs = s.toString().length()/4.0;
			if (nbOfVisualTabs >= 1.0 && nbOfVisualTabs < 2.0) System.out.print("\t\t");
			if (nbOfVisualTabs >= 2.0 && nbOfVisualTabs < 4.0) System.out.print("\t");
			System.out.println(dictCitys.get(s));
		}
		System.out.println();
	}

	public HashMap<Companhia, Hour> setDelay() {
		delayPerCompany = new HashMap <>();
		HashMap<Companhia, Integer> delayPerCompanieMinutes = new HashMap <Companhia, Integer>();
		HashMap<Companhia, Integer> delayCompanieCounter = new HashMap <Companhia, Integer>();
		for (Voo v : voos) {
			if (v.getDelay() != null) {
				//Associar o numero de atrasos à companhia
				if(!delayCompanieCounter.containsKey(v.getCompanie())) {  //Verifica se ja existe counter
					delayCompanieCounter.put(v.getCompanie(), 1);
				}else {
					delayCompanieCounter.put(v.getCompanie(), delayCompanieCounter.get(v.getCompanie()) + 1);  //Incrementa o counter
				}

				//Associar o delay de todos os voos à companhia
				if(!delayPerCompanieMinutes.containsKey(v.getCompanie())) {
					delayPerCompanieMinutes.put(v.getCompanie(), v.getDelay().getTotalMinutes());
				}else {
					delayPerCompanieMinutes.put(v.getCompanie(), delayPerCompanieMinutes.get(v.getCompanie()) + v.getDelay().getTotalMinutes());
				}
			}
		}

		//Associar a Hora media de atraso à companhia
		for (Map.Entry<Companhia, Integer> entry : delayPerCompanieMinutes.entrySet()) {
			int minutes = entry.getValue() / delayCompanieCounter.get(entry.getKey());
			delayPerCompany.put(entry.getKey(), new Hour(minutes));
		}

		return delayPerCompany;
	}

	public List<String> setTable() {
		table = new ArrayList<>();
		//Funcao print do aeroporto
		table.add("Hora\tVoo\tCompanhia\t\tOrigem\t\t\tAtraso\tObservações");
		for(int i = 1; i < infoVoos.size(); i++) {
			String[] line = infoVoos.get(i).split("\t");
			Companhia company = companhiaCampo.get(line[1].substring(0,2));
			
			if(company == null) continue;
			Hour h1 = null;
			Hour h2 = null;
			String ad = "";
			for (String s : line) {
				ad = ad + s + "\t";
				//Igualar a coluna das companhias
				double nbOfVisualTabs = company.toString().length()/4.0;
				if(s.equals(line[1])) {
					ad += company;
					if (nbOfVisualTabs >= 1.0 && nbOfVisualTabs < 2.0) ad += "\t\t\t";
					if (nbOfVisualTabs >= 2.0 && nbOfVisualTabs < 4.0) ad += "\t\t";
					if (nbOfVisualTabs >= 4.0) ad += "\t"; 	
				}
			
				//Igualar a coluna da origem
				if(s.equals(line[2])) {
					nbOfVisualTabs = s.toString().length()/4.0;
					if (nbOfVisualTabs >= 1.0 && nbOfVisualTabs < 2.0) ad += "\t\t";
					if (nbOfVisualTabs >= 2.0 && nbOfVisualTabs < 4.0) ad += "\t";
				}

				h1 = new Hour(line[0]);
				h2 = null;
				if(line.length == 4 && s.equals(line[3]) && !s.equals("")) {
					ad += "Previsto: " + Hour.estimatedHour(line[0], line[3]);
					h2 = new Hour(line[3]);
				}
			}
			table.add(ad);

			if (h2 == null) {
				voos.add(new Voo(h1, line[1], company, line[2]));
			} else {
				voos.add(new Voo(h1, line[1], company, line[2], h2, "Previsto: " + Hour.estimatedHour(line[0], line[3])));
			}
		}
		return table;
	}

	public HashMap<String, Integer> setCitys() {
		citys = new ArrayList<>();
		dictCitys = new HashMap<>();

		for (Voo v : voos) {
			if(!citys.contains(v.getOrigin())) citys.add(v.getOrigin());  //Da as cidades
		}

		for (Voo v : voos) {
			if(dictCitys.containsKey(v.getOrigin())) {
				dictCitys.put(v.getOrigin(), dictCitys.get(v.getOrigin()) + 1);
			} else {
				dictCitys.put(v.getOrigin(), 1);   //Associa as cidades a um incrementador
			}
		}
		return dictCitys;	
	}
}