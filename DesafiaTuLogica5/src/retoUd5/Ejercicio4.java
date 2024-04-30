package retoUd5;

import java.io.*;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		final String rutaFichero="persona.dat";
		
		try {
			
			//Escribir objetos Personas en el archivo
			
			escribirPersonas(rutaFichero);
			
			//Leer objetos Persona del archivo
			
			leerPersonas(rutaFichero);
			
		}catch(IOException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}

	}
	
	public static void escribirPersonas(String rutaFichero) throws IOException{
		
		//Crear objetos Persona
		
		Persona persona1=new Persona("Iván",32,"Masculino","Desarrollador");
		Persona persona2=new Persona("Ángela",32,"Femenino","Consultora");
		Persona persona3=new Persona("Marina",28,"Femenino","Gestión");
		
		//Escribir objetos personas en el archivo
		
		try(ObjectOutputStream outputStream= new ObjectOutputStream(new FileOutputStream(rutaFichero))){
			
			outputStream.writeObject(persona1);
			outputStream.writeObject(persona2);
			outputStream.writeObject(persona3);
		}
		
		System.out.println("Objetos Persona escritos en el archivo'"+rutaFichero+"'.");
		
	}
	
	public static void leerPersonas(String rutaFichero) throws IOException, ClassNotFoundException{
		
		//Leer objetos Personas en el archivo
		
		try(ObjectInputStream inputStream =new ObjectInputStream(new FileInputStream(rutaFichero))){
			
			System.out.println("Leyendo objetos Persona del archivo'"+rutaFichero+"':");
			
			try {
				
				while(true) {
					
					Persona persona=(Persona) inputStream.readObject();
					
					System.out.println(persona);
				}
				
			}catch(EOFException e) {
				
				//Se alcanzó el final del archivo
			}
		}
	}

}
