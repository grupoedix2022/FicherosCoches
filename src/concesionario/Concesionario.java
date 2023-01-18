package concesionario;
import java.io.Serializable;
import java.util.*;

public class Concesionario implements Serializable {
	
	private static final long serialVersionUID = -3194480034592798021L;
	private static int id=1;
	private List<Coche> concesionario;
	
	public Concesionario() {
		concesionario = new ArrayList<Coche>();		
	}
	
	public void addCoche(Coche coche) {		
		if (checkMatricula(coche.getMatricula())) {
			id++;
			coche.setId(id);
			concesionario.add(coche);				
		} else {
			System.out.println("Error: Matrícula repetda");
		}
			
		
	}
	
	public void borrar(int id) {
		for (Coche c: this.concesionario) {
			if (c.getId() == id) {
				concesionario.remove(c);
			}
		}	
	}
	
	public Coche buscarID (int id) {
		for (Coche c: this.concesionario) {
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
	}
	
	public boolean checkMatricula (String matricula) {
		boolean check=true;
		for (Coche c: concesionario) {
			if(matricula.equals(c.getMatricula())){
				check = false;
			}
		}
		return check;
		
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Concesionario.id = id;
	}

	public List<Coche> getConcesionario() {
		return concesionario;
	}

	public void setConcesionario(List<Coche> concesionario) {
		this.concesionario = concesionario;
	}

}
