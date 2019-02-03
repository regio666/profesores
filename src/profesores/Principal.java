package profesores;

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int opcion;
		int mes;
		
		ArrayList<Profesor> lista=new ArrayList<Profesor>();
				
		System.out.print("Curso: ");
		String curso=sc.nextLine();
		Profesor.curso=curso;
	
		System.out.println("");
		
		System.out.print("Importe Horas Extra: ");
		double pagoPorHoraExtra=sc.nextDouble();
		Profesor.pagoPorHoraExtra=pagoPorHoraExtra;
	
			
		do {
		
		System.out.print("SELECCIONE UNA OPCION");
		System.out.print("\n1. ALTA DE UN PROFESOR");
		System.out.print("\n2. BAJA DE UN PROFESOR");
		System.out.print("\n3. CONSULTA DE DATOS PERSONALES DE UN PROFESOR");
		System.out.print("\n4. INTRODUCIR HORAS EXTRAORDINARIAS DE UN MES");
		System.out.print("\n5. LISTADO DE PROFESORES");
		System.out.print("\n6. LISTADO DE NOMINAS DE UN MES");
		System.out.print("\n0. SALIR DEL PROGRAMA");
		System.out.print("\n");
		System.out.print("OPCION SELECCIONADA: ");
		opcion=sc.nextInt();
		
		switch(opcion) {
		
			case 1:
				
			Profesor p=new Profesor();
			
			System.out.println("");
			String nulo=sc.nextLine();
					
			System.out.print("Profesor: ");
			String profesor=sc.nextLine();
					
			System.out.print("DNI: ");
			String dni=sc.nextLine();
					
			System.out.print("Sueldo Base: ");
			double sueldoBase=sc.nextDouble();
						
			System.out.print("tipoIRPF: ");
			double tipoIRPF=sc.nextDouble();
			System.out.println("");
			
			p.nuevoProfesor(curso, pagoPorHoraExtra, profesor, dni, sueldoBase, tipoIRPF);
			altaProfesor(lista, p);
			
			break;
			
			case 2:
				
			System.out.print("Introduzca el número de profesor: ");
			int eliminar=sc.nextInt();
			eliminar=eliminar-1;
			Principal.bajaProfesor(lista,eliminar);
			
			break;
			
			case 3:
			
			System.out.print("Introduzca el número de profesor: ");
			int indice=sc.nextInt();	
			
			System.out.println(lista.get(indice).imprimeProfesor());
				
			break;
			case 4:
			
			do {
			System.out.print("Horas extraordinarias realizadas por los profesores en el mes: ");
			mes=sc.nextInt();	
			} while(mes<1 || mes>12);
			
			mes=mes-1;
			for(int i=0;i<lista.size();i++) {
			System.out.println("Nombre profesor: "+lista.get(i).getNombre());
			System.out.print("Horas realizadas:");
			int horasExtra=sc.nextInt();	
			lista.get(i).setHorasExtra(mes, horasExtra);
			}
			
			break;
			case 5:
			for(int j=0;j<lista.size();j++) {
			
				System.out.println("");
				System.out.println("Número de profedor: "+(j+1));
				System.out.println(lista.get(j).imprimeProfesor());
			
			}
			break;
			
			case 6:
			
			do {
			System.out.print("Nominas del mes: ");
			mes=sc.nextInt();	
			} while(mes<1 || mes>12);
			
			for(int j=0;j<lista.size();j++) {
				
					System.out.println("Número de profedor: "+(j+1));
					System.out.println(lista.get(j).imprimirNominas(mes-1, j));
				
				
				}
				
			break;
			
		}
		
		} while(opcion!=0);
		
		
	}
	
	public static void altaProfesor(ArrayList<Profesor> lista,Profesor p) {
	
			lista.add(p);
		
	}
	
	public static void bajaProfesor(ArrayList<Profesor> lista,int eliminar) {
				
			lista.remove(eliminar);
			
	}
	

}
