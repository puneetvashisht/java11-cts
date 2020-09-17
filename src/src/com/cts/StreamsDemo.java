package com.cts;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.htmlcleaner.HtmlCleaner;

public class StreamsDemo {
	
	static String doc1 = "<html><body>One of the most common uses of <i>streams</i> is to represent queries over data in collections</body></html>";
	static String doc2 = "<html><body>Information integration systems provide valuable services to users by integrating information from a number of autonomous, heterogeneous and distributed Web sources</body></html>";
	static String doc3 = "<html><body>Solr is the popular, blazing fast open source enterprise search platform from the Apache Lucene</body></html>";
	static String doc4 = "<html><body>Java 8 goes one more step ahead and has developed a streams API which lets us think about parallelism</body></html>";
	
	static List<String> documents = new ArrayList<>(Arrays.asList(doc1, doc2, doc3, doc4));
	
	private static void imperative() {
		System.out.println("Imperative: \n");
		
		for (String doc : documents) {
			// 1. check if the documents contains "stream"
			Predicate<String> filter = d -> d.contains("stream");
			
			if (filter.test(doc)) {		
				// 2. strip html tag <h1>
				Function<String, String> htmlCleaner = Indexer::stripHtmlTags;
				doc = htmlCleaner.apply(doc);				
//				3. Remove stopwords (is, of, the)
				Function<String, String> stopwordRemover = Indexer::removeStopwords;
				doc = stopwordRemover.apply(doc);
				
				System.out.println(doc);				
			}
		}
		
		documents.parallelStream()
		.filter(d -> d.contains("stream"))
		.map(Indexer::stripHtmlTags)
		.map(Indexer::removeStopwords)
		.forEach(System.out::println);
	}
	
	private static void declarative() {
		System.out.println("\n\nDeclarative: \n");
		/*
		// Stream pipeline (a common structure): 
		     (a) set-up stream source (~ tables in SQL world)
		     (b) 0 or more intermediate operations (~ WHERE clause) -- lazy 
		              & return Stream<T>, i.e., transforms a stream into another stream
		     (c) terminal operation (~ column names) -- eager 
		              & return NON-STREAM. Terminates (closes) a stream
		*/		
//		select count(*) from employees e where e.salary > ? 
		
//		for(Employee e : employees){
//			if(e.salary > ?){
//				count++
//			}
//		}
		
		documents.stream()
		.filter(d -> d.contains("stream"))
		.map(Indexer::stripHtmlTags)
		.map(Indexer::removeStopwords)
		.forEach(System.out::println);

//		Code Here --- 
			//.forEach(System.out::println);
	}	
		
	private static void print(Stream<String> stream) {
		stream.forEach(System.out::println);
		//stream.forEach(System.out::println);
	}

	public static void main(String[] args) {
		imperative();
		declarative();
	}		
}


