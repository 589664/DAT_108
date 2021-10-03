package Oppg_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class oppg_1 {
	
	public static void main(String[] args) {
		
		 List<String> list = Arrays.asList("10", "1", "20", "110", "21", "12");
		 
//		 1A:
//		 Bruke generell metode...
		 Collections.sort(list, vedAaSammenligne(Integer::valueOf));
		 System.out.println(list);
		
//		 Ved hjelp av Comparator...
		 Collections.sort(list, Comparator.comparing(p -> Integer.parseInt(p)));
		 System.out.println(list);
		 
//		 1B:
		 System.out.println(beregn(12, 13, (a,b) -> a + b));
		 System.out.println(beregn(-5, 3, (a,b) -> Integer.max(a, b)));
		 System.out.println(beregn(12, 13, (a,b) -> Math.abs(a - b)));
		 
		 
//		 det same med streams:
		 List<Integer> sort = list.stream()
		 .mapToInt(x -> Integer.valueOf(x))
		 .sorted()
		 .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		 
		 System.out.println(sort);
		 
		 
	}//main
	
	static <T, U extends Comparable<U>> Comparator<T> vedAaSammenligne(Function<T, U> function) {
		return (a,b) -> function.apply(a).compareTo(function.apply(b));
	}//vedAaSammenligne
	
	public static int beregn(int a, int b, BiFunction<Integer, Integer, Integer> function) {
		return function.apply(a,b);
	}//beregn
}


