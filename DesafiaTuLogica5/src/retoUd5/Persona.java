package retoUd5;

import java.io.*;

public class Persona implements Serializable{
	
	private static final long serialVersionUID=1L;// Identificador único de la clase
	
	//Atributos de la clase persona
	
	private String nombre,genero,ocupacion;
	private int edad;
	
	//Construtor clase Persona
	
	public Persona(String nombre,int edad,String genero,String ocupacion) {
		
		this.nombre=nombre;
		this.edad=edad;
		this.genero=genero;
		this.ocupacion=ocupacion;
	}
	
	//Métodos getter y setter
	
	//GETTER
	
	public String getNombre(){
		
		return nombre;
	}
	
	public int getEdad() {
		
		return edad;
	}
	
	public String getGenero() {
		
		return genero;
	}
	
	public String getOcupacion() {
		
		return ocupacion;
	}
	
	//SETTER

	public void setNombre(String nombre) {
		
		this.nombre=nombre;
	}
	
	public void setEdad(int edad) {
		
		this.edad=edad;
	}
	
	public void setGenero(String genero) {
		
		this.genero=genero;
	}
	
	public void setOcupacion(String ocupacion) {
		
		this.ocupacion=ocupacion;
	}
	
	//Método toString() para imprimir información de la persona
	
	public String toString() {
		
		return"El nombre de esta persona es "+nombre+" tiene "+edad+" años, su genero es "+genero+" y su ocupación es "
				+ocupacion+".";
	}
}
