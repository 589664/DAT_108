package Oppg_2;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class tester {
	
	public static void main(String[] args) {
		List<Ansatt> ansatte = Stream.of(
				new Ansatt("Andreas", "Petersen", Kjonn.MANN, "Feier", 100000),
				new Ansatt("Anine", "Petersen", Kjonn.KVINNE, "Utvikler", 120000),
				new Ansatt("Harald", "Augustus", Kjonn.MANN, "Lerer", 500000),
				new Ansatt("Vlada", "ThePutin", Kjonn.KVINNE, "Elektriker", 320000),
				new Ansatt("Geir", "Petersen", Kjonn.MANN, "Operator", 420000)
				).collect(Collectors.toList());
		
		
		Predicate<Ansatt> predikat = a -> true;
		
		Function<Ansatt, Integer> funk = a -> a.getAarslonn() + 1000;
		
		lonnsoppgjor(ansatte,funk,predikat);
		
		skrivUtAlle(ansatte);
	}
	
	
	private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> fun, Predicate<Ansatt> pre) {
		
		for (Ansatt ansatt : ansatte) {
			if (pre.test(ansatt)) {
				ansatt.setAarslonn(fun.apply(ansatt));
			}
		}
		
	}//lonnsoppgjor
	
	private static void skrivUtAlle(List<Ansatt> ansatte) {
		ansatte.forEach(System.out::println);
	}//skrivUtAlle
	
}
