package clase;

import java.io.File;
import java.io.FileNotFoundException;
//import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		String 	rutaIn = "Estructura de Carpetas\\Preparacion de la Prueba\\Lote de Prueba\\Entrada\\",
				rutaOut = "Estructura de Carpetas\\Ejecucion de Prueba\\Salida Obtenida\\";
		
		Carrera carrera = new Carrera();

		File[] v_file = new File(rutaIn).listFiles();
		
		for (File fileName : v_file) {
			
			System.out.println("Ejectando: " + fileName.getName());
			long ini = System.currentTimeMillis();
			
			carrera.cargar(rutaIn + fileName.getName());
			carrera.resolver(rutaOut + fileName.getName().replace(".in", ".out"));
			
			long fin = System.currentTimeMillis();
			System.out.println("Programa finalizado");
			System.out.println("Tiempo de ejecucion: " + (fin - ini) + " miliseg.");
			System.out.println();
			
		}
		
//		String fileName = "01_Ejemplo_enunciado.in";
//		carrera.cargar(rutaIn + fileName);
//		carrera.resolver(rutaOut + fileName.replace("in", "out"));

//		List<String> l_files = new ArrayList<String>();	
//		filesNames(rutaIn,l_files);
//		for (String fileName : l_files) {
//			
//			System.out.println("Ejectando: " + fileName);
//			long ini = System.currentTimeMillis();
//			
//			carrera.cargar(rutaIn + fileName);
//			carrera.resolver(rutaOut + fileName.replace("in", "out"));
//			
//			long fin = System.currentTimeMillis();
//			System.out.println("Programa finalizado");
//			System.out.println("Tiempo de ejecucion: " + (fin - ini) / 1000 + " seg.");
//			System.out.println();
//			
//		}
		
	}
	
	public static void filesNames(String dir, List<String> l_files) {
		File[] v_file = new File(dir).listFiles();
		for (File file : v_file) {
			l_files.add(file.getName());
		}
	}

}
