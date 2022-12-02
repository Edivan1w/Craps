package craps1;


import java.util.Random;
import java.util.Scanner;

//jogo de Craps:
//Faça um programa que implemente um jogo de Craps. O jogador lança um par de dados, obtendo um valor entre 2 e 12.
//Regras:
//
//a) Se, na primeira jogada, você tirar 7 ou 11, você é um "Natural" e ganha;
//b) Se você tirar 2, 3 ou 12 na primeira jogada, isto é chamado de "Craps" e você perdeu;
//c) Se, na primeira jogada, você fez um 4, 5, 6, 8, 9 ou 10, este é seu "Ponto";
//d) Seu objetivo agora é continuar jogando os dados até tirar este número novamente;
//e) Você perde, no entanto, se tirar um 7 antes de tirar este Ponto novamente;
public class Main {
	
	private static CrapsUtil crapsUtil;
	
	
	public Main(CrapsUtil crapsUtil) {
		Main.crapsUtil = crapsUtil;
	}

	public static void main(String[] args) {

		Pontuar pontuar = new Pontuar();
		Ganhar ganhar = new Ganhar();
		Perder perder = new Perder();

		Random random = new Random();
		Boolean system = true;
		Scanner scanner = new Scanner(System.in);
		Integer resultado = crapsUtil.iniciarJogo(random, scanner);

		while (system) {
			system = crapsUtil.ganharOuPerderNaPrimeiraJogada(ganhar, perder, resultado, system);

			if (pontuar.primeiraJogada(resultado)) {
				crapsUtil.continuarjogandoCasoTenhaPontuado(pontuar, scanner, resultado);
				system = false;
			}
		}

	}

}
