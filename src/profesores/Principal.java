package profesores;

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		
		int opcion;
	
		
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
				
			Profesor p=new Profesor();
			
			System.out.print("");
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
				
			System.out.print("Introduzca el n�mero de profesor: ");
			int eliminar=sc.nextInt();
			lista=Principal.bajaProfesor(lista,eliminar-1);
			
			break;
			
			case 3:
			
			System.out.print("Introduzca el n�mero de profesor: ");
			int indice=sc.nextInt();	
			
			System.out.println(lista[indice-1].imprimeProfesor());
				
			break;
			case 4:
			break;
			case 5:
			for(int j=0;j<lista.length;j++) {
			try {
				System.out.println("N�mero de profedor: "+(j+1));
				System.out.println(lista[j].imprimeProfesor());
			} catch(NullPointerException e)
			{ }
			}
			break;
			case 6:
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
		
		Profesor[] listaNueva=new Profesor[lista.length];
		int i;
		int j;
		for(i=0;i<lista.length;i++) {
			if(lista[i]==lista[eliminar]) {
			for(j=i;j<lista.length-1;j++) {
				listaNueva[i]=lista[j+1];
				}
				break;
			}
		
		}
		return listaNueva;
	}


}
