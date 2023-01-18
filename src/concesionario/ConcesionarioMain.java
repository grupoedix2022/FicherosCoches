package concesionario;

import java.util.*;
import java.io.*;

public class ConcesionarioMain {
	public static final String nombreFichero = "coches.dat";
	public static final String csv = "concesionario.csv";
	
	public static void main(String[] args) {
		
		int id;
		Concesionario concesionario = new Concesionario();
		File fn = new File(nombreFichero);
		if (!fn.exists()) {
			try {
				fn.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Creado el archivo " + fn.getName());
			Coche c1 = new Coche("1111AAA", "Ford", "Sierra", "Azul");
			Coche c2 = new Coche("2222BBB", "Toyota", "Celica", "Blanco");
			Coche c3 = new Coche("3333CCC", "VolksWagen", "Santana", "Gris");
			concesionario.addCoche(c1);
			concesionario.addCoche(c2);
			concesionario.addCoche(c3);			
			try(FileOutputStream fos = new FileOutputStream(fn);
					ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(concesionario);
				System.out.println("Concesionario actualizado");
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 														
		}else {
			try (FileInputStream fis = new FileInputStream(fn);
					 ObjectInputStream ois = new ObjectInputStream(fis);) {
				concesionario = (Concesionario)ois.readObject();
				int ultimaPosicion = concesionario.getConcesionario().size()-1;
				Coche c = concesionario.getConcesionario().get(ultimaPosicion);
				concesionario.setId(c.getId());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block4
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
		
		try (Scanner scan = new Scanner(System.in)){
			String texto = "";
			boolean continuar = true;
			
			while (continuar) {
								
				System.out.println("1. Añadir nuevo coche.");
				System.out.println("2. Borrar coche por id.");
				System.out.println("3. Consulta coche por id.");
				System.out.println("4. Listado de coches.");
				System.out.println("5. Exportar archivo CSV.");
				System.out.println("0. Salir.");
				int instruction = Integer.parseInt(scan.nextLine());
				switch(instruction) {
				case 1:
					System.out.println("Introduzca matricula:");
					String matricula = scan.nextLine();
					System.out.println("Introduzca marca:");
					String marca = scan.nextLine();
					System.out.println("Introduzca modelo:");
					String modelo = scan.nextLine();
					System.out.println("Introduzca color:");
					String color = scan.nextLine();
					
					Coche coche = new Coche(matricula, marca, modelo,color);
					concesionario.addCoche(coche);
					try(FileOutputStream fos = new FileOutputStream(fn);
							ObjectOutputStream oos = new ObjectOutputStream(fos)){
						oos.writeObject(concesionario);
						System.out.println("Concesionario actualizado");
					}catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
										
					break;					
				case 2:
					System.out.println("Introduzca ID para borrar:");
					id = Integer.parseInt(scan.nextLine());
					concesionario.borrar(id);
					try(FileOutputStream fos = new FileOutputStream(fn);
							ObjectOutputStream oos = new ObjectOutputStream(fos)){
						oos.writeObject(concesionario);
						System.out.println("Concesionario actualizado");
					}catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					break;					
				case 3:
					System.out.println("Introduzca ID para consultar:");
					id = Integer.parseInt(scan.nextLine());
					System.out.println("Listando...");
					try (FileInputStream fis = new FileInputStream(fn);
							 ObjectInputStream ois = new ObjectInputStream(fis);) {
							
							concesionario = (Concesionario)ois.readObject();
														
							
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block4
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("El coche que busca es: ");
					System.out.println(concesionario.buscarID(id));		
					break;
				case 4:					
					System.out.println("Listando...");
					try (FileInputStream fis = new FileInputStream(fn);
							 ObjectInputStream ois = new ObjectInputStream(fis);) {
							
							concesionario = (Concesionario)ois.readObject();
							
							System.out.println("Objeto leido");
							System.out.println("Imprimiendo coches");
							
							for(Coche c : concesionario.getConcesionario()){
								System.out.println(c);
							}
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block4
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					break;
				case 5:	
					System.out.println("Exportando CSV...");
					
					try (FileInputStream fis = new FileInputStream(fn);
							 ObjectInputStream ois = new ObjectInputStream(fis);) {
							
							concesionario = (Concesionario)ois.readObject();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block4
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					
					File csvfile = new File(nombreFichero);
					if (!csvfile.exists()) {
						try {
							csvfile.createNewFile();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}						
					}
					
					try(FileWriter fw = new FileWriter(csv);
							BufferedWriter pw = new BufferedWriter(fw);) {
						pw.write("ID;MATRICULA;MARCA;MODELO;COLOR");
						pw.newLine();
						for (Coche c: concesionario.getConcesionario()) {
							pw.write(c.getId() + ";" +c.getMatricula() + ";" + c.getMarca() + ";"
									+ c.getModelo() +";" + c.getColor());							
							pw.newLine();
						}
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					break;
				case 0:
					continuar=false;
					break;
				default:
					System.out.println("No válido");
					break;
				}
			}
		}

	}

}
