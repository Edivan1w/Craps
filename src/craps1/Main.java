package craps1;


import java.util.Random;
import java.util.Scanner;

//jogo de Craps:
//Fa�a um programa que implemente um jogo de Craps. O jogador lan�a um par de dados, obtendo um valor entre 2 e 12.
//Regras:
//
//a) Se, na primeira jogada, voc� tirar 7 ou 11, voc� � um "Natural" e ganha;
//b) Se voc� tirar 2, 3 ou 12 na primeira jogada, isto � chamado de "Craps" e voc� perdeu;
//c) Se, na primeira jogada, voc� fez um 4, 5, 6, 8, 9 ou 10, este � seu "Ponto";
//d) Seu objetivo agora � continuar jogando os dados at� tirar este n�mero novamente;
//e) Voc� perde, no entanto, se tirar um 7 antes de tirar este Ponto novamente;
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
