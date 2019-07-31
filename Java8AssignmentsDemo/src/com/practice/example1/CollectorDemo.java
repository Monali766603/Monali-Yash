package com.practice.example1;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorDemo {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(10, 20, 30, 11, 20, 33, 4, 44, 55, 20);

		// collect the result of a Stream into Set
		Set<Integer> streamSet=  numbers.stream().collect(Collectors.toSet());
		System.out.println("Result of stream into set is:"+streamSet);
		//streamSet.forEach(num-> System.out.print(num+" "));

		// collect the result of a Stream into list
		System.out.println(" ");
		List<Integer> streamList= numbers.stream().collect(Collectors.toList());
		System.out.println("Result of stream into List is:"+streamList);
		
		// create Map from the elements of Stream (first remove the duplicates)
		Map<Integer,Integer> streamMap= numbers.stream().distinct().collect(Collectors.toMap(k1->k1,v1->v1));
		System.out.println();
		System.out.println("Map created by removing duplicate elements of stream is:"+streamMap);
		
		// find summary statistics from a Stream of numbers
		IntSummaryStatistics statistics= numbers.stream().mapToInt(num-> num).summaryStatistics();
		System.out.println();
		System.out.println("Summary Statistics of numbers is:"+statistics);
		
		// partition the result of Stream in two parts i.e., odd and even
		Map<Boolean,List<Integer>> streamPartition= numbers.stream().collect(Collectors.partitioningBy(num-> (num%2==0)));
		System.out.println();
		System.out.println("Result of stream partitioned into two parts is:"+streamPartition);
		
		
		// create comma separated string from numbers
		String commaSeparatedString= numbers.stream().map(num-> num.toString()).collect(Collectors.joining(","));
		System.out.println();
		System.out.println("Comma Separated string by numbers is:"+commaSeparatedString);

	}

}
