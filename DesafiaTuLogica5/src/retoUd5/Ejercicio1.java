package retoUd5;

import java.io.*;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		//Paso A
		
		String nombreArchivo1,nombreArchivo2;
		
		do {
			System.out.println("Introduce el nombre del primer fichero: ");
			nombreArchivo1=pedirNombreFichero();
			System.out.println("Introduce el nombre del segundo fichero: ");
			nombreArchivo2=pedirNombreFichero();
		}while(nombreArchivo1.length()<3|| nombreArchivo2.length()<3);
		System.out.println("El nombre del primer archivo es válido.");
		System.out.println("El nombre del segundo archivo es válido.");
		
		//Paso B
		
		String directorioActual=System.getProperty("user.dir");
		System.out.println("Ruta del directorio actual: "+directorioActual);
		
		//Paso C

		String rutaCompletaFich1= directorioActual+File.separator+nombreArchivo1;
		String rutaCompletaFich2= directorioActual+File.separator+nombreArchivo2;
		
		if(!comprobarExiste(new File(rutaCompletaFich1))) {
			
			crearFichero(nombreArchivo1);
		}else {
			System.out.println("El fichero "+nombreArchivo1+" ya existe en la ruta actual.");
		}
		
		if(!comprobarExiste(new File(rutaCompletaFich2))) {
			
			crearFichero(nombreArchivo2);
		}else {
			System.out.println("El fichero "+nombreArchivo2+" ya existe en la ruta actual.");
		}
		
		//Paso E
		
		if(comprobarExiste(new File(rutaCompletaFich1))) {
			
			escribirEnFichero(nombreArchivo1);
		}
		
		//Paso F
		
		if(comprobarExiste(new File(rutaCompletaFich1))) {
			
			leerDeFichero(nombreArchivo1);
		}
		
		//Paso G
		
		if(comprobarExiste(new File(rutaCompletaFich1))) {
			
			mostrarPropiedadesFichero(nombreArchivo1);
		}else {
			
			System.out.println("El fichero "+ nombreArchivo1+" no existe.");
		}
		
		//Paso H
		
		duplicarFicheros(new File(rutaCompletaFich1),new File(rutaCompletaFich2));
		
		//Paso I
		
		borrarFichero(new File(rutaCompletaFich1));
		
		//Paso J 
		
		leerDeFichero(nombreArchivo2);
		
		//Paso K
		
		String rutaDirectorio=directorioActual+ File.separator+"dirEjer1";
		
		if(!comprobarExiste(new File(rutaDirectorio))) {
			
			crearDirectorio(rutaDirectorio);
		}else {
			
			System.out.println("El directorio 'dirEjer1' ya existe en la ruta actual.");
		}
		
		
	}

	public static boolean leerDeFichero(String nombre) {
		
		try(BufferedReader br=new BufferedReader(new FileReader(nombre))){
			
			String linea;
			
			while((linea=br.readLine())!=null) {
				
				System.out.println(linea);
			}
			return true;
		}catch(IOException e) {
			
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean escribirEnFichero(String nombre) {
		
		try(FileWriter file= new FileWriter(nombre)){
			
			for(int i =0;i<=10;i++) {
				
				file.write(String.valueOf(i)+"\n");
			}
			return true;
		}catch(IOException e) {
			
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean borrarFichero(File fichero) {
		
		if(fichero.delete()) {
			
			System.out.println("El fichero "+fichero.getName()+" ha sido borrado");
			return true;
		}else {
			
			System.out.println("El fichero "+fichero.getName()+" no pudo ser borrado");
			return false;
		}
	}
	
	public static boolean comprobarExiste(File fichero) {
		
		return fichero.exists();
	}
	
	public static void duplicarFicheros(File origen,File destino) {
		
		try(FileReader fr=new FileReader(origen);
			BufferedReader br=new BufferedReader(fr);
			FileWriter fw=new FileWriter(destino);
			BufferedWriter bw=new BufferedWriter(fw)){
			
			String linea;
			
			while((linea=br.readLine())!=null) {
				
				bw.write(linea+"\n");
			}
		}catch(IOException e) {
			
			e.printStackTrace();
		}
	}
	
	 public static String pedirNombreFichero() {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String nombre = "";
	        try {
	            nombre = br.readLine();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return nombre;
	   }

	 public static void crearFichero(String nombre) {
	        try {
	            File fichero = new File(nombre);
	            if (fichero.createNewFile()) {
	                System.out.println("El fichero " + nombre + " ha sido creado.");
	            } else {
	                System.out.println("El fichero " + nombre + " no pudo ser creado.");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	   }

	    public static boolean crearDirectorio(String rutaDirectorio) {
	        File directorio = new File(rutaDirectorio);
	        if (directorio.mkdirs()) {
	            System.out.println("El directorio 'dirEjer1' ha sido creado.");
	            return true;
	        } else {
	            System.out.println("El directorio 'dirEjer1' no pudo ser creado.");
	            return false;
	        }
	   }
	    
	    public static void mostrarPropiedadesFichero(String nombre) {
	        File fichero = new File(nombre);
	        System.out.println("Nombre del archivo: " + fichero.getName());
	        System.out.println("Ruta absoluta: " + fichero.getAbsolutePath());
	        System.out.println("Ruta del directorio padre: " + fichero.getParent());
	        System.out.println("Tamaño del fichero: " + fichero.length() + " bytes");
	        System.out.println("¿Es un fichero o un directorio?: " + (fichero.isFile() ? "Fichero" : "Directorio"));
	        System.out.println("Permiso de lectura: " + fichero.canRead());
	        System.out.println("Permiso de escritura: " + fichero.canWrite());
	        System.out.println("Permiso de ejecución: " + fichero.canExecute());
	        System.out.println("¿Está oculto?: " + fichero.isHidden());
	   }
}

