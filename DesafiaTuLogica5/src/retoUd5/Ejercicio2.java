package retoUd5;

import java.io.*;

public class Ejercicio2 {//Falla en el paso C

	public static void main(String[] args) {
		
		//Paso A: Mostrar directorio actual y crear directorio y ficheros
		
		try {
		
		String directorioActual=System.getProperty("user.dir");
		
		System.out.println("Directorio actual: "+directorioActual);
		
		String rutaDirectorio=directorioActual+File.separator+"dirEjer2";
		
		crearDirectorioYFicheros(rutaDirectorio);
		
		//Paso B: Abrir fichero "dos.txt" para excritura
		
		String rutaFicheroDos=rutaDirectorio+File.separator+"dos.txt";
		
		BufferedWriter writer=new BufferedWriter(new FileWriter(rutaFicheroDos));
		
		//Paso C: Pedir al usuario que introduzca nombres
		
		System.out.println("Introduce nombres de personas(escribe '-' para terminar): ");
		
		escribirNombres(writer);
		
		//Paso D: Cerrar ezcritura en fichero
		
		writer.close();
		
		//Paso E: Abrir fichero "dos.txt" para lectura y mostrar contenido
		
		leerFichero(rutaFicheroDos);
		
		}catch(IOException e){
			
			e.printStackTrace();
		}

	}

	public static void crearDirectorioYFicheros(String rutaDirectorio) throws IOException{
		
		File directorio=new File(rutaDirectorio);
		
		if(!directorio.exists()) {
			
			if(directorio.mkdirs()) {
				
				System.out.println("Directorio 'dirEjer2' creado correctamente.");
			}else {
				
				throw new IOException("Error al crear el directorio 'dirEjer2'");
			}
		}
		
		//Crear fichero "uno.txt"
		
		String rutaFicheroUno=rutaDirectorio+File.separator+"uno.txt";
		
		File ficheroUno=new File(rutaFicheroUno);
		
		if(ficheroUno.createNewFile()) {
			
			System.out.println("Fichero 'uno.txt' creado corectamente.");
		}else {
			
			System.out.println("El fichero 'uno.txt' ya existe.");
		}
		
		//Crar fichero "dos.txt"
		
		String rutaFicheroDos=rutaDirectorio+File.separator+"dos.txt";
		
		File ficheroDos=new File(rutaFicheroDos);
		
		if(ficheroDos.createNewFile()) {
			
			System.out.println("Fichero 'dos.txt' creado correctamente.");
		}else {
			
			System.out.println("EL fichero 'dos.txt, ya existe.");
		}
	
	}	
	
	public static void escribirNombres(BufferedWriter writer)throws IOException{
		
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		
		String nombre;
		
		while(true) {
			
			nombre=reader.readLine();
			
			if(nombre.equals("-")) {
				
				break;
			}
			writer.write(nombre);
			writer.newLine();
		}
		reader.close();
	}
	
	public static void leerFichero(String rutaFichero) throws IOException{
		
		BufferedReader reader=new BufferedReader(new FileReader(rutaFichero));
		
		String linea;
		
		System.out.println("Contenido del fichero 'dos.txt': ");
		
		while((linea=reader.readLine())!=null) {
			
			System.out.println(linea);
		}
		reader.close();
	}
}
