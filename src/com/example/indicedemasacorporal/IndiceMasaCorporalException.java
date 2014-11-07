package com.example.indicedemasacorporal;

public class IndiceMasaCorporalException extends Exception {

	boolean errorPeso = false;
	boolean errorAltura = false;

	/**
	 * 
	 */
	public IndiceMasaCorporalException(boolean errorPeso, boolean errorAltura) {
		super();
		// TODO Auto-generated constructor stub
		this.errorPeso = errorPeso;
		this.errorAltura = errorAltura;		
	}

	/**
	 * @return the errorPeso
	 */
	public boolean isErrorPeso() {
		return errorPeso;
	}

	/**
	 * @return the errorAltura
	 */
	public boolean isErrorAltura() {
		return errorAltura;
	}

	public String getMessage(){
		if(this.errorAltura && this.errorPeso) return  "Peso y altura introducidos incorrectamente.";
		if(this.errorPeso) return "Peso introducido incorrecto.";
		if(this.errorAltura) return "Altura introducida incorrecta.";
		return "Error no reconocido.";
	}

}
