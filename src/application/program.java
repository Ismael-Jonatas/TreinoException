package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.ProgramExceptions;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			
			System.out.print("Insira o número do quarto: ");
			int numero = sc.nextInt();
			
			System.out.print("\nInsira com a data de entrada: ");
			Date dt1 = sdf.parse(sc.next());
			
			System.out.print("Insira a data de saída: ");
			Date dt2 = sdf.parse(sc.next()); 
			
			Reservation reserva = new Reservation(numero, dt1, dt2);
			System.out.println(reserva);
			
			System.out.print("\nEntre com as novas datas de reserva: ");
			
			System.out.print("\nInsira com a data de entrada: ");
			dt1 = sdf.parse(sc.next());
			
			System.out.print("Insira a data de saída: ");
			dt2 = sdf.parse(sc.next());
			
			reserva.atualizar(dt1, dt2);
			System.out.println(reserva);
			
			
		}
		catch(ParseException e) {
			System.out.println("Formato da Data inválido");
			
		}

		catch(ProgramExceptions e) {
			System.out.println("Erro ao fazer reserva: " + e.getMessage());
			
		}
		
		catch(RuntimeException e) {
			System.out.println("!!!Erro inesperado!!!");
			
		}
		
		sc.close();
	}

}
