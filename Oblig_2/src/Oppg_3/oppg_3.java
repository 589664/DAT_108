package Oppg_3;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class oppg_3 {
	
	public static void main(String[] args) {
		
		List<Ansatt> ansatte = Stream.of(
				new Ansatt("Andreas", "Petersen", Kjonn.MANN, "Sjef Feier", 100000),
				new Ansatt("Anine", "Petersen", Kjonn.KVINNE, "Utvikler", 999999),
				new Ansatt("Harald", "Augustus", Kjonn.MANN, "Lerer", 999999),
				new Ansatt("Vlada", "ThePutin", Kjonn.KVINNE, "Elektriker", 320000),
				new Ansatt("Geir", "Petersen", Kjonn.MANN, "Operator", 850000)
				).collect(Collectors.toList());
		
		
		
		List<String> etterN = ansatte.stream()
				.map(x -> x.getEtternavn())
				.collect(Collectors.toList());
		
		etterN.forEach(System.out::println);
				
		System.out.println(
				ansatte.stream()
				.filter(x -> x.getKjonn().equals(Kjonn.KVINNE))
				.count()
				);
		
		System.out.println(
				ansatte.stream()
				.filter(x -> x.getKjonn().equals(Kjonn.KVINNE))
				.mapToInt(x -> x.getAarslonn())
				.average()
				.getAsDouble()
				);
		
		ansatte.stream()
		.filter(x -> x.getStilling().contains("Sjef"))
		.forEach(x -> x.setAarslonn((int)(x.getAarslonn() * 1.07)));
		
		skrivUtAlle(ansatte);
		
		System.out.println(
				ansatte.stream()
				.anyMatch(x -> x.getAarslonn() > 800000)
				);
		
		ansatte.stream()
		.forEach(System.out::println);
		
		Integer lavestlonn = ansatte.stream()
				.min(Comparator.comparing(Ansatt::getAarslonn))
				.map(Ansatt::getAarslonn).get()
				;
		
		List<Ansatt> lla = ansatte.stream()
				.filter(x -> x.getAarslonn() == lavestlonn)
				.collect(Collectors.toList());
		
		
		System.out.println("\nAnsatte med lavest lonn:\n");
		
		skrivUtAlle(lla);
		
		System.out.println(
				"\n" +
				IntStream.range(1, 1000)
				.filter(x -> x % 3 == 0 || x % 5 == 0)
				.sum()
				);
	}//main
	
	
	private static void skrivUtAlle(List<Ansatt> ansatte) {
		ansatte.forEach(System.out::println);
	}//skrivUtAlle
	
}//class
