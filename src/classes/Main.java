package classes;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.InputMismatchException;

import excecoes.EmailInvalidoException;
import excecoes.NumeroInvalidoException;
import excecoes.StringNumericaException;
import excecoes.NumeroPortasInvalidoException;

public class Main {
	
	public static void main(String[] args) throws NumeroPortasInvalidoException, NumeroInvalidoException, EmailInvalidoException, StringNumericaException {
		Scanner sc = new Scanner(System.in);
		String [] array_dominios = {"@gmail.com", "@hotmail.com", "@outlook.com", "@yahoo.com", "@icloud.com"};
		ClasseControle cd = new ClasseControle();
		OtherMethods om = new OtherMethods();
		
		int opcao = 1;
		while (opcao > 0 && opcao < 14) {
			System.out.println("------------------------------------\n"
					+ "1 -> Cadastrar Cliente\n"
					+ "2 -> Cadastrar Cliente Especial\n"
					+ "3 -> Cadastrar um Carro\n"
					+ "4 -> Listar Clientes\n"
					+ "5 -> Listar Carros\n"
					+ "6 -> Listar Carros vendidos (Recibos True)\n"
					+ "7 -> Listar Notas de venda\n"
					+ "8 -> Vender Carro\n"
					+ "9 -> Atualizar dados de um Cliente\n"
					+ "10 -> Atualizar dados de um Carro\n"
					+ "11 -> Excluir Cliente\n"
					+ "12 -> Excluir Carro\n"
					+ "13 -> TESTE Verificacao de Dominio\n"
					+ "0 -> Sair\n"
					+ "------------------------------------\n");
			
			try {
				opcao = sc.nextInt(); sc.nextLine();
			} catch(InputMismatchException e) {
				System.out.println("Opcao Invalida\n"); sc.nextLine();
				continue;
			}
			switch(opcao) {
			case 1, 2:
				cd.cadastrarCliente(array_dominios, opcao);
				break;
			case 3:
				cd.cadastrarCarro();
				break;
			case 4, 5, 6, 7:
				cd.listarDados(opcao);
				break;
			case 8:
				cd.venderCarro();
				break;
			case 9, 10:
				cd.alterarDados(opcao, array_dominios);
				break;
			case 11, 12:
				cd.deletarDados(opcao);
				break;
			case 13:
				om.verificarEmail("DVD@icloud.com", array_dominios);
				break;
			default:
				System.out.println("Saiu do Sistema!");
			}
		}
	}
}