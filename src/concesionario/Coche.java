package concesionario;
import java.io.Serializable;

public class Coche implements Serializable{
	
	//Declaración de atributos: id, matricula, marca, modelo y color
	//Generamos id único que identifica la clase cuando la serializamos
	private static final long serialVersionUID = -3941671490311809688L;
	
	private int id;
	private String matricula;
	private String marca;
	private String modelo;
	private String color;
	
	//Constructor
	public Coche(String matricula, String marca, String modelo, String color) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
	}

	//Getters y Setters
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}

	//ToString
	@Override
	public String toString() {
		return "Coches [id=" + id + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", color="
				+ color + "]";
	}
	
	
	
	

}
