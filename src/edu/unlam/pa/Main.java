package edu.unlam.pa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

import clase.Corredor;

public class Main extends Ejercicio{

	private File entrada;
	private File salida;
	
	public Main(File entrada, File salida) {
		super(entrada, salida);
		this.entrada = entrada;
		this.salida = salida;
	}
	
	@Override
	public void resolver() {
		
		int[][] v_cf;
		int[][] v_cm;
		Corredor[] v_corredor;
		int[] v_llegaron;
		
		
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(entrada);
			sc.useLocale(Locale.ENGLISH);
			
		int cantidadA = sc.nextInt(),
				cf = sc.nextInt(),
				cm = sc.nextInt(),
				llegaron = sc.nextInt();
			
			v_cf = new int [cf][5]; // 2 para Rango Edad, 3 para el podio
			v_cm = new int [cm][5]; // 2 para Rango Edad, 3 para el podio
			v_corredor = new Corredor[cantidadA];
			v_llegaron = new int[llegaron];
			
			for (int i = 0; i < v_cf.length; i++) {
				v_cf[i][0] = sc.nextInt();
				v_cf[i][1] = sc.nextInt();
			}

			for (int i = 0; i < v_cm.length; i++) {
				v_cm[i][0] = sc.nextInt();
				v_cm[i][1] = sc.nextInt();
			}
			
			for (int i = 0; i < v_corredor.length; i++) {
				v_corredor[i] = new Corredor(sc.nextInt(),sc.next());
			}
			
			for (int i = 0; i < v_llegaron.length; i++) {
				v_llegaron[i] = sc.nextInt();
			}
				
			PrintWriter salida = new PrintWriter(this.salida);
			
			for (int i = 0; i < v_llegaron.length; i++) {
				if((v_corredor[v_llegaron[i] - 1].getSexo()).equals("F")){
					for (int j = 0; j < v_cf.length; j++) {
						if(v_corredor[v_llegaron[i] - 1].getEdad() <= v_cf[j][1]) {
							if(v_cf[j][2] == 0) {
								v_cf[j][2] = v_llegaron[i];
								break;
							}
							if(v_cf[j][3] == 0) {
								v_cf[j][3] = v_llegaron[i];
								break;
							}
							if(v_cf[j][4] == 0) {
								v_cf[j][4] = v_llegaron[i];
								break;
							}
							break;
						}
					}
				}
				else{
					for (int j = 0; j < v_cm.length; j++) {
						if(v_corredor[v_llegaron[i] - 1].getEdad() <= v_cm[j][1]) {
							if(v_cm[j][2] == 0) {
								v_cm[j][2] = v_llegaron[i];
								break;
							}
							if(v_cm[j][3] == 0) {
								v_cm[j][3] = v_llegaron[i];
								break;
							}
							if(v_cm[j][4] == 0) {
								v_cm[j][4] = v_llegaron[i];
								break;
							}
							break;
						}
					}
				}
			}
			for (int i = 0; i < v_cf.length; i++) {
//				System.out.println((i + 1) + " " + v_cf[i][2] + " " + v_cf[i][3] + " " + v_cf[i][4]);
				salida.println((i + 1) + " " + v_cf[i][2] + " " + v_cf[i][3] + " " + v_cf[i][4]);
			}
			for (int i = 0; i < v_cm.length; i++) {
//				System.out.println((i +1) + " " + v_cm[i][2] + " " + v_cm[i][3] + " " + v_cm[i][4]);
				salida.println((i +1) + " " + v_cm[i][2] + " " + v_cm[i][3] + " " + v_cm[i][4]);
			}
			salida.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		String 	dirIn 	= "Estructura de Carpetas\\Preparacion de la Prueba\\Lote de Prueba\\Entrada\\",
				dirOut 	= "Estructura de Carpetas\\Ejecucion de Prueba\\Salida Obtenida_modelo_parcial\\";
		
		File[] v_files = new File(dirIn).listFiles();
		
		for (File fileIn : v_files) {
			System.out.println("Ejecutandose: " + fileIn.getName());
			long ini = System.currentTimeMillis();
			
			File fileOut = new File(dirOut + (fileIn.getName()).replace(".in", ".out"));
			Ejercicio ejercicio = new Main(fileIn, fileOut);
			ejercicio.resolver();
			
			long fin = System.currentTimeMillis();
			System.out.println("Finalizado. Tiempo de ejecucion " + (fin - ini) + " miliseg.\n");
		}
	}

}
