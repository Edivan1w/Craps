package craps1;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pontuar  implements PrimeiraJogada{



	private static String mumeros = "4,5,6,8,9,10";
	private Integer guardador;
	
	public  Boolean primeiraJogada(Integer numero) {
		guardador = numero;
		return Stream.of(mumeros.split(","))
				.map(Integer::valueOf)
				.collect(Collectors.toList()).contains(numero);
	}
	
   public Boolean executarProximaJogada(Integer numero) {
        if(guardador.equals(numero)) {
        	System.out.println("Voc� ganhou. tirou " + numero);
        	return false;
        }else if(numero.equals(7)) {
        	System.out.println("Voc� perdeu: tirou => " + numero);
        	return false;
        }else {
        System.out.println("Voc� tirou " + numero);
        return true;
        }
	}
   
   

}