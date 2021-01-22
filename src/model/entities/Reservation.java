package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.ProgramExceptions;

public class Reservation {
	
	private int numero;
	private Date dataEntrada;
	private Date dataSaida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
	
	
	public Reservation() {
		
	}

	
	public Reservation(int numero, Date dataEntrada, Date dataSaida) {

		if(!dataSaida.after(dataEntrada)) {
			throw new ProgramExceptions("\nA data de saída deve ser maior que a de entrada1!");
			
		}
		
		this.numero = numero;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public Date getDataEntrada() {
		return dataEntrada;
	}


	public Date getDataSaida() {
		return dataSaida;
	}

	public long duracao() {
		long diff = dataSaida.getTime() - dataEntrada.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void atualizar(Date entrada, Date saida) {

		Date now = new Date();
		if(entrada.before(now) || saida.before(now)) {
			throw new ProgramExceptions("\nA data para reservar deve ser uma data futura2!");
			
		}
		
		if (!saida.after(entrada)) {
			throw new ProgramExceptions("\nA data de sáida deve ser maior que a de entrada3!");
		}

		this.dataEntrada = entrada;
		this.dataSaida = saida;
		
	}
	
	@Override
	
	public String toString() {
		return "Reserva: Quarto " + numero
				+ ", Entrada: " + sdf.format(dataEntrada)
				+ ", Saída: " + sdf.format(dataSaida)
				+ ", " + duracao() + " noites";

	}
	
	
	
}
