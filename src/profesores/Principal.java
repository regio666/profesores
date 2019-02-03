package profesores;

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int opcion;
		int mes;
		
		Profesor lista[]=new Profesor[0];
				
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
			lista=Principal.altaProfesor(lista, p);
			
			break;
			
			case 2:
				
			System.out.print("Introduzca el número de profesor: ");
			int eliminar=sc.nextInt();
			eliminar=eliminar-1;
			lista=Principal.bajaProfesor(lista,eliminar);
			
			break;
			
			case 3:
			
			System.out.print("Introduzca el número de profesor: ");
			int indice=sc.nextInt();	
			
			System.out.println(lista[indice-1].imprimeProfesor());
				
			break;
			case 4:
			
			do {
			System.out.print("Horas extraordinarias realizadas por los profesores en el mes: ");
			mes=sc.nextInt();	
			} while(mes<1 || mes>12);
			
			mes=mes-1;
			for(int i=0;i<lista.length;i++) {
			System.out.println("Nombre profesor: "+lista[i].getNombre());
			System.out.print("Horas realizadas:");
			int horasExtra=sc.nextInt();	
			lista[i].setHorasExtra(mes, horasExtra);
			}
			
			break;
			case 5:
			for(int j=0;j<lista.length;j++) {
			try {
				System.out.println("");
				System.out.println("Número de profedor: "+(j+1));
				System.out.println(lista[j].imprimeProfesor());
			} catch(NullPointerException e)
			{ }
			}
			break;
			
			case 6:
			
			do {
			System.out.print("Nominas del mes: ");
			mes=sc.nextInt();	
			} while(mes<1 || mes>12);
			
			for(int j=0;j<lista.length;j++) {
				try {
					System.out.println("Número de profedor: "+(j+1));
					System.out.println(lista[j].imprimirNominas(mes-1, j));
				} catch(NullPointerException e)
				{ }
				}
				
			break;
			
		}
		
		} while(opcion!=0);
		
		
	}
	
	public static Profesor[] altaProfesor(Profesor lista[],Profesor p) {
	
		Profesor[] listaNueva=new Profesor[lista.length+1];
		int i;
		for(i=0;i<lista.length;i++) {
			listaNueva[i]=lista[i];
		}
		listaNueva[i]=p;
		return listaNueva;
	}
	
	public static Profesor[] bajaProfesor(Profesor lista[],int eliminar) {
				
		boolean elementoEliminado;
		
		Profesor[] listaNueva=new Profesor[lista.length-1];
		int i;
		int j;
		for(i=0;i<lista.length-1;i++) {
			if(i==eliminar) {
				listaNueva[i]=null;
			} else {
				listaNueva[i]=lista[i];
			}
			
			}			
		 
		return listaNueva;
	}
	

}
