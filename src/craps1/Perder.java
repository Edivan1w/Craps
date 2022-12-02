package craps1;


import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Perder implements PrimeiraJogada{

	

	private static String mumeros = "2,3,12";

	public Boolean primeiraJogada(Integer numero) {
		return Stream
				 .of(mumeros.split(","))
				 .map(Integer::valueOf)
				 .collect(Collectors
						 .toList())
				 .contains(numero);
	}

}
