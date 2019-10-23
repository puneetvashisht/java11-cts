package com.cts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

import org.htmlcleaner.HtmlCleaner;

/**
 * Demonstrates:
 * 
 *  Function & Predicate (including Chaining & Compose)
 *  Bi-Function as an alternate to Predicate
 *    
 *  Consumer & Supplier
 *  Show API too (including primitive functional interfaces) !!
 *  
 *  Method References
 *  TODO: Constructor References
 *
 */
public class FunctionalInterfaceDemo {
	
	public static void main(String[] args) {
		
		String doc1 = "<html><body>One of the most common uses of <i>streams</i> is to represent queries over data in collections</body></html>";
		String doc2 = "<html><body>Information integration systems provide valuable services to users by integrating information from a number of autonomous, heterogeneous and distributed Web sources</body></html>";
		String doc3 = "<html><body>Solr is the popular, blazing fast open source enterprise search platform from the Apache Lucene</body></html>";
		String doc4 = "<html><body>Java 8 goes one more step ahead and has developed a streams API which lets us think about parallelism</body></html>";
		
		List<String> documents = new ArrayList<>(Arrays.asList(doc1, doc2, doc3, doc4));
		

		
		for(String doc : documents){
//			1. Filter documents with word  "streams"
			boolean isTargetDoc  = filter(doc, d -> d.contains("stream"));
			if(isTargetDoc){
//				2. Strip Html Tags			
//				doc = transform(doc, d -> Indexer.stripHtmlTags(d));
				Function<String, String> htmlCleaner = d -> Indexer.stripHtmlTags(d);
				doc  = transform(doc, htmlCleaner);
				
//				3. Remove Stop Words ("of", "the", "a", "is", "to", "in", "and")
//				doc = transform(doc, d-> Indexer.removeStopwords(d));
				Function<String, String> stopWordRemover = d -> Indexer.removeStopwords(d);
				doc  = transform(doc, stopWordRemover);
				
				System.out.println(doc);
			}
		}


		
	}	
	
	static boolean filter(String doc, Predicate<String> filter) {
		return filter.test(doc);
	}
	
	/*static String transform(String doc, UnaryOperator<String> transformer) {
		return transformer.apply(doc);
	}*/
	static String transform(String doc, Function<String, String> transformer) {
		return transformer.apply(doc);
	}
	
}

class Indexer {
	
	private static List<String> stopWords = Arrays.asList("of", "the", "a", "is", "to", "in", "and");
	
	static String stripHtmlTags(String doc) {
		return new HtmlCleaner().clean(doc).getText().toString();
	}
	
	static String removeStopwords(String doc) {
		
		StringBuilder sb = new StringBuilder();
		for (String word : doc.split(" ")) {
			if (!stopWords.contains(word))
				sb.append(word).append(" ");
		}
		
		return sb.toString();
	}	
	
}

