package lotes_testeador;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class GeneradorDeLotesDePrueba {
	
	public static void main(String[] args) throws FileNotFoundException, IOException  {
		
		System.out.println("Programa ejecutandose...");
		long ini = System.currentTimeMillis();
		
		String rutaIn = "Estructura de Carpetas\\Preparacion de la Prueba\\Lote de Prueba\\Entrada\\";
//		String fileName = "06_Fatiga_500000M_500000F_Intercalados_60CF_60CM_Todos_Llegan_Orden_de_anotacion.in";
		String fileName = "07_Fatiga_500000M_500000F_correlativo_por_sexo_y_edad_60CF_60CM_Todos_Llegan_Orden_de_anotacion.in";
		resolver(rutaIn + fileName);

		long fin = System.currentTimeMillis();

		System.out.println("Programa finalizado");
		System.out.println("Tiempo de ejecucion: " + (fin - ini) / 1000 + " seg.");
	}
	
	public static void resolver(String fileOut) throws IOException {
		PrintWriter salida = new PrintWriter(new FileWriter(fileOut)); 
		String[] sexo= {"F","M"};
		
		int cantidadA = 1000000,
			cf = 60,
			cm = 60,
			llegaron =  1000000;
		salida.println(cantidadA + " " + cf + " " + cm + " " + llegaron);

		// Ragos de edad categoría femenina
		int edadMinCateg = 10;
		for (int i = 0; i < cf; i++) {
			salida.println(edadMinCateg + " " + edadMinCateg++);
		}
		// Ragos de edad categoría masculina
		edadMinCateg = 10;
		for (int i = 0; i < cm; i++) {
			salida.println(edadMinCateg + " " + edadMinCateg++);
		}
		
//		// Anotacion corredores Intercalados   
//		//  06_Fatiga_500000M_500000F_Intercalados_60CF_60CM_Todos_Llegan_Orden_de_anotacion
//		int edad;
//		for (int i = 0; i < cantidadA; i++) {
//			edad = (i % 60) + edadMinCateg;
//			salida.println(edad + " " + sexo[edad%2]);
//		}
		
		// Anotacion corredores  Correlativo
		// 07_Fatiga_500000M_500000F_correlativo_por_sexo_y_edad_60CF_60CM_Todos_Llegan_Orden_de_anotacion
		edadMinCateg = 10;
		int edad = edadMinCateg;
		for (int i = 0; i < 60; i++) {
			for (int j = 0; j < ((cantidadA / 2) / 60); j++) {
			salida.println(edad + " " + sexo[0]);
			}
			edad++;
		}
		for (int i = 0; i < 20; i++) {
			salida.println(edad + " " + sexo[0]);
		}

		edad = edadMinCateg;
		for (int i = 0; i < 60; i++) {
			for (int j = 0; j < ((cantidadA / 2) / 60); j++) {
			salida.println(edad + " " + sexo[1]);
			}
			edad++;
		}
		for (int i = 0; i < 20; i++) {
			salida.println(edad + " " + sexo[1]);
		}
		
		
		// Llegada Orden_de_anotacion
		for (int i = 1; i <= llegaron; i++) {
			salida.println(i);
		}
		
		
		salida.close();
	}

}
