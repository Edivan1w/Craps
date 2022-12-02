package craps1;

import java.util.Random;
import java.util.Scanner;

public class CrapsUtil {

	public  Boolean ganharOuPerderNaPrimeiraJogada(Ganhar ganhar, Perder perder, Integer resultado,
			Boolean system) {
		if (perder.primeiraJogada(resultado)) {
			System.out.println("Você é Craps, perdeu: " + resultado);
			system = false;
	
		}
		if (ganhar.primeiraJogada(resultado)) {
			System.out.println("Você é natural, ganhou: " + resultado);
			system = false;
		}
		return system;
	}

	public  Integer iniciarJogo(Random random, Scanner scanner) {
		System.out.println("Digite 1 para jogar os dados");
		Integer resultado = 0;

		if (scanner.nextInt() == 1) {
			resultado += random.nextInt(11) + 1;
		}else{ 
			throw new IllegalArgumentException("opção incorreta.");
		}
		return resultado;
	}

	public  void continuarjogandoCasoTenhaPontuado(Pontuar pontuar, Scanner scanner, Integer resultado) {
		System.out.println("Você pontuou : tirou => " + resultado);
		System.out.println("Agora você terá que jogar os dados até tirar " + resultado + "  novamente.");
		System.out.println("Cuidado se você tirar 7 irá perder.");
		Boolean continues = true;
		while (continues) {
			
			Integer geradorDeNumerosAleatorios = geradorDeNumerosAleatorios(scanner);
			continues = pontuar.executarProximaJogada(geradorDeNumerosAleatorios);
		}
	}

	public  Integer geradorDeNumerosAleatorios(Scanner scanner) {
		System.out.println("Digite 1 para jogar os dados e gerar outro numero");
		Integer nextInt = scanner.nextInt();
		if(nextInt.equals(1)) {
			return new Random().nextInt(11) + 1;
		}
		throw new IllegalArgumentException("opção incorreta.");
	}


}
