package concesionario;
import java.io.Serializable;
import java.util.*;


public class Concesionario implements Serializable {
	
	//Declaraci�n de atributos: id (statico) y Array que alojar� los coches.
	//Generamos id �nico que identifica la clase cuando la serializamos
	private static final long serialVersionUID = -3194480034592798021L;
	private static int id=1;
	private List<Coche> concesionario;
	
	//Constructor
	public Concesionario() {
		concesionario = new ArrayList<Coche>();		
	}
	
	//M�todo a�adir que chequear� si la matr�cula es repetida:
	public void addCoche(Coche coche) {		
		if (checkMatricula(coche.getMatricula())) {
			id++;
			coche.setId(id);
			concesionario.add(coche);				
		} else {
			System.out.println("Error: Matr�cula repetida");
		}
			
		
	}
	
	//M�todo borrar eliminar� el veh�culo del array
	public void borrar(int id) {
		Coche c;
		for (int i=0; i<concesionario.size(); i++) {
			c = concesionario.get(i);
			if (c.getId() == id) {				
				this.concesionario.remove(c);
			}
		}	
	}
	
	//M�todo buscar que buscar� el coche para imprimirlo
	public Coche buscarID (int id) {
		for (Coche c: this.concesionario) {
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
	}
	
	//M�todo auxiliar para comprobar la validez de la matr�cula
	public boolean checkMatricula (String matricula) {
		boolean check=true;
		for (Coche c: concesionario) {
			if(matricula.equals(c.getMatricula())){
				check = false;
			}
		}
		return check;
		
	}
	
	//Getters y Setters

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
