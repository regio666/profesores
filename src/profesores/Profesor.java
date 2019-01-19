package profesores;

import java.util.Scanner;

public class Profesor {

	static String curso;
	static double pagoPorHoraExtra;
	private String dni;
	private String nombre;
	private double sueldoBase;
	private int[] horasExtra;
	private double tipoIRPF ;
		
	public Profesor() {
		Profesor.curso="";
		Profesor.pagoPorHoraExtra=0.0;
		this.nombre="";
		this.dni="";
		this.sueldoBase=0.0;
		this.horasExtra= new int[12];
		this.tipoIRPF=0.0;
		
	}
	
	public void nuevoProfesor(String curso, double pagoPorHoraExtra, String nombre,String dni,
			double sueldoBase,double tipoIRPF) {
		Profesor.curso=curso;
		Profesor.pagoPorHoraExtra=pagoPorHoraExtra;
		this.nombre=nombre;
		this.dni=dni;
		this.sueldoBase=sueldoBase;
		this.tipoIRPF=tipoIRPF;
		
		
	}
	
	public void setCurso(String curso) {
		Profesor.curso=curso;
	}
	
	public void setPagoPorHoraExtra(Double pagoPorHoraExtra) {
		Profesor.pagoPorHoraExtra=pagoPorHoraExtra;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public void setDni(String dni) {
		this.dni=dni;
	}
	
	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase=sueldoBase;
	}
	
	public void setHorasExtra(int mes, int horasExtra) {
		this.horasExtra[mes]=horasExtra;
	}
	
	public void setTipoIRPF(double tipoIRPF) {
		this.tipoIRPF=tipoIRPF;
	}
	
	public String getCurso() {
		return curso;
	}
	
	public double getPagoPorHoraExtra() {
		return pagoPorHoraExtra;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDni() {
		return dni;
	}
	
	public double getSueldoBase() {
		return sueldoBase;
	}
	
	public int getHorasExtra(int mes) {
		return horasExtra[mes];
	}
	
	public double getTipoIRPF() {
		return tipoIRPF;
	}
	
	public double calcularImporteHorasExtras(int mes) {
		
		return horasExtra[mes]*pagoPorHoraExtra;
	}
	
	public double calcularSueldoBruto(int mes) {
		double resultado=this.getSueldoBase()+this.calcularImporteHorasExtras(mes);
		return resultado;
	}
	
	public double calcularRetencionIrpf(int mes) {
		double resultado=this.tipoIRPF*this.calcularSueldoBruto(mes)/100;
		return resultado;
	}
	
	public double calcularSueldo(int mes) {
		double resultado=this.calcularSueldoBruto(mes)-this.calcularRetencionIrpf(mes);
		return resultado;
	}
	
	public String imprimeProfesor() {
		String resultado="";
		resultado=resultado+("Nombre: ");
	    resultado=resultado+(nombre);
	    resultado=resultado+("\nDNI: ");
	    resultado=resultado+(dni);
	    resultado=resultado+("\nSueldo Base: ");
	    resultado=resultado+(sueldoBase);
	    resultado=resultado+("\ntipo IRPF: ");
	    resultado=resultado+(tipoIRPF);
	    resultado=resultado+("\n");
	    return  resultado;
	    		
	}
	
	public void leerProfesores() {
		Scanner sc=new Scanner(System.in);
		System.out.print("Nombre: ");
		this.nombre=sc.nextLine();
		System.out.print("DNI: ");
		this.dni=sc.nextLine();
		System.out.print("Sueldo Base: ");
		this.sueldoBase=sc.nextDouble();
		System.out.print("tipoIRPF: ");
		this.tipoIRPF=sc.nextDouble();
	}
	
	public String imprimirNominas(int mes,int numero) {
		
		String resultado="";
		String [] meses={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto",
				"Septiembre","Octubre","Noviembre"};
		resultado=resultado+("\nNombre: "+this.nombre);
		resultado=resultado+("\nCurso: "+Profesor.curso);
		resultado=resultado+(" Nómina mes: "+meses[mes]);
		resultado=resultado+("\nDNI: "+this.dni);
		resultado=resultado+("\nSuelo Base: "+this.sueldoBase);
		resultado=resultado+("\nHoras Extras: "+this.getHorasExtra(mes));
		resultado=resultado+("\nTipo IRPF: "+this.getTipoIRPF());
		resultado=resultado+("\nSueldo Bruto: "+this.calcularSueldoBruto(mes));
		resultado=resultado+("\nRetención por IRPF: "+this.calcularRetencionIrpf(mes));
		resultado=resultado+("\nSueldo Neto: "+this.calcularSueldo(mes));
		resultado=resultado+("\n");
		return resultado;
		
	}
	
}
