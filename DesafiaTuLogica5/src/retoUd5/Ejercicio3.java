package retoUd5;

import java.io.*;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		final String  rutaFichero="tres.dat";
		
		try {
			
			//Paso 1: Crear un objectOutStream para escribir en el archivo
			
			ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream(rutaFichero));
			
			//Paso 2: Solicitar números positivos al usuario
			
			escribirNumeros(outputStream);
			
			//Paso 3: Cerrar el ObjectOutputStream
			
			outputStream.close();
			
			//Paso 4: Abrir un ObjectInputStream para leer del archivo
			
			ObjectInputStream inputStream=new ObjectInputStream(new FileInputStream(rutaFichero));
			
			//Paso 5: Leer los números almacenados en el archivo
			
			leerNumeros(inputStream);
			
			//Paso 6: Cerrar el objectInputStream
			
			inputStream.close();		
			
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		

	}
	
	public static void escribirNumeros(ObjectOutputStream outputStream) throws IOException{
		
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Introduce números positivos(introduce un número negativo para terminar):");
		
		try {
			while(true) {
				
				int numero=Integer.parseInt(reader.readLine());
				
				if(numero<0) {
					
					break;
				}
				outputStream.writeInt(numero);
			}
		}catch(NumberFormatException e) {
			
			System.out.println("Error: Debes introducir un número entero.");
		}
	}
	
	public static void leerNumeros(ObjectInputStream inputStream) throws IOException{
		
		System.out.println("Números almacenados en el archivo: ");
		
		try {
			
			while(true) {
				
				int numero=inputStream.readInt();
				
				System.out.println(numero);
			}
		}catch(EOFException e) {
			
			//Se alcanza el final del archivo, no hay más números que leer
		}
	}

}
