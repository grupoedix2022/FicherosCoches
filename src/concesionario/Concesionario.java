package concesionario;
import java.io.Serializable;
import java.util.*;


public class Concesionario implements Serializable {
	
	//Declaración de atributos: id (statico) y Array que alojará los coches.
	//Generamos id único que identifica la clase cuando la serializamos
	private static final long serialVersionUID = -3194480034592798021L;
	private static int id=1;
	private List<Coche> concesionario;
	
	//Constructor
	public Concesionario() {
		concesionario = new ArrayList<Coche>();		
	}
	
	//Método añadir que chequeará si la matrícula es repetida:
	public void addCoche(Coche coche) {		
		if (checkMatricula(coche.getMatricula())) {
			id++;
			coche.setId(id);
			concesionario.add(coche);				
		} else {
			System.out.println("Error: Matrícula repetida");
		}
			
		
	}
	
	//Método borrar eliminará el vehículo del array
	public void borrar(int id) {
		Coche c;
		for (int i=0; i<concesionario.size(); i++) {
			c = concesionario.get(i);
			if (c.getId() == id) {				
				this.concesionario.remove(c);
			}
		}	
	}
	
	//Método buscar que buscará el coche para imprimirlo
	public Coche buscarID (int id) {
		for (Coche c: this.concesionario) {
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
	}
	
	//Método auxiliar para comprobar la validez de la matrícula
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
