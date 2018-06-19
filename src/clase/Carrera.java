package clase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Carrera {
	
	private int[][] v_cf;
	private int[][] v_cm;
	private Corredor[] v_corredor;
	private int[] v_llegaron;
	
	public void cargar(String fileIn) throws FileNotFoundException {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(new File(fileIn));
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

//		System.out.println(v_corredor.length);
//		System.out.println(v_cf.length);
//		System.out.println(v_cm.length);
//		System.out.println(v_llegaron.length);
	}
	
	public void resolver(String fileOut) throws FileNotFoundException {
		PrintWriter salida = new PrintWriter(new File(fileOut));
		
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
//			System.out.println((i + 1) + " " + v_cf[i][2] + " " + v_cf[i][3] + " " + v_cf[i][4]);
			salida.println((i + 1) + " " + v_cf[i][2] + " " + v_cf[i][3] + " " + v_cf[i][4]);
		}
		for (int i = 0; i < v_cm.length; i++) {
//			System.out.println((i +1) + " " + v_cm[i][2] + " " + v_cm[i][3] + " " + v_cm[i][4]);
			salida.println((i +1) + " " + v_cm[i][2] + " " + v_cm[i][3] + " " + v_cm[i][4]);
		}
		salida.close();
	}

}
