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
	
	public void setDni(String dni) {
		this.dni=dni;
	}
	
	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase=sueldoBase;
	}
	
	public void setHorasExtra(int[] horasExtra) {
		this.horasExtra=horasExtra;
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
	
	public String getDni() {
		return dni;
	}
	
	public double getSueldoBase() {
		return sueldoBase;
	}
	
	public int[] horasExtra() {
		return horasExtra;
	}
	
	public double tipoIRPF() {
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
	
	public void imprimirNominas(int mes,int numero) {
		
	}
	
}
