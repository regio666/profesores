package profesores;

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		
		int opcion;
		int i=0;
		
		Profesor lista[]=new Profesor[3];
	
		lista[0]= new Profesor();
				
		System.out.print("Curso: ");
		String curso=sc.nextLine();
		lista[0].setCurso(curso);
	
		System.out.println("");
		
		System.out.print("Importe Horas Extra: ");
		double pagoPorHoraExtra=sc.nextDouble();
		lista[0].setPagoPorHoraExtra(pagoPorHoraExtra);
	
			
		do {
		
		System.out.print("SELECCIONE UNA OPCION");
		System.out.print("\n1. ALTA DE UN PROFESOR");
		System.out.print("\n2. BAJA DE UN PROFESOR");
		System.out.print("\n3. CONSULTA DE DATOS PERSONALES DE UN PROFESORES");
		System.out.print("\n4. INTRODUCIR HORAS EXTRAORDINARIAS DE UN MES");
		System.out.print("\n5. LISTADO DE PROFESORES");
		System.out.print("\n6. LISTADO DE NOMINAS DE UN MES");
		System.out.print("\n0. SALIR DEL PROGRAMA");
		System.out.print("\n");
		System.out.print("OPCION SELECCIONADA: ");
		opcion=sc.nextInt();
		
		switch(opcion) {
		
			case 1:
			System.out.println("");	
			i++;
			lista[i]=new Profesor();
			System.out.print("Profesor: ");
			String nombre=sc.nextLine();
			System.out.print("DNI: ");
			String dni=sc.nextLine();
			System.out.print("Sueldo Base: ");
			double sueldoBase=sc.nextDouble();
			System.out.print("tipoIRPF: ");
			double tipoIRPF=sc.nextDouble();
			
			lista[i].nuevoProfesor(curso, pagoPorHoraExtra, dni, nombre, sueldoBase, tipoIRPF);
			
			break;
			case 2:
			break;
			case 3:
			break;
			case 4:
			break;
			case 5:
			for(int j=0;j<lista.length;j++) {
				lista[j].imprimeProfesor(j);
			}
			break;
			case 6:
			break;
			
		}
		
		} while(opcion!=0);
		
		
	}
	
	//public void lista=AltaProfesor(lista, Profesor p) {
		
	

}
