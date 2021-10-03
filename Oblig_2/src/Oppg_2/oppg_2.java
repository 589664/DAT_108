package Oppg_2;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class oppg_2 {
	
	public static void main(String[] args) {
		
		List<Ansatt> ansatte = Stream.of(
				new Ansatt("Andreas", "Petersen", Kjonn.MANN, "Feier", 100000),
				new Ansatt("Anine", "Petersen", Kjonn.KVINNE, "Utvikler", 120000),
				new Ansatt("Harald", "Augustus", Kjonn.MANN, "Lerer", 500000),
				new Ansatt("Vlada", "ThePutin", Kjonn.KVINNE, "Elektriker", 320000),
				new Ansatt("Geir", "Petersen", Kjonn.MANN, "Operator", 420000)
				).collect(Collectors.toList());
		
		Function<Ansatt, Integer> valhalla = p -> p.getAarslonn() + 1000;
		
//		ansatte.removeIf(p -> p.getAarslonn() > 100000);
		
		Function<Ansatt, Integer> valhalla1 = p -> (int) (p.getAarslonn() * 1.1);
		
		Function<Ansatt, Integer> valhalla2 = p -> {
			if(p.getAarslonn() <= 100000) {
				return p.getAarslonn() + 1000;
			}
			return p.getAarslonn();};
			
		Function<Ansatt, Integer> valhalla3 = p -> {
			if(p.getKjonn().equals(Kjonn.MANN)) {
				return (int) (p.getAarslonn() * 2);
			}
			return p.getAarslonn();
		};
			
		Function<Ansatt, Integer> valhalla4 = a -> a.getAarslonn() >= 500000 ? a.getAarslonn() + 1000 : a.getAarslonn();
		
		lonnsoppgjor(ansatte,valhalla4);
		
		skrivUtAlle(ansatte);

		
	}//main
	
	private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> fun) {
		
		ansatte.stream()
		.forEach(x -> x.setAarslonn(fun.apply(x)));
		
	}//lonnsoppgjor
	
	private static void skrivUtAlle(List<Ansatt> ansatte) {
		ansatte.forEach(System.out::println);
	}//skrivUtAlle
	
}//class
