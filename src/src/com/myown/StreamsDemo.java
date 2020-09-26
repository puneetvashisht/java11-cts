package com.myown;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.myown.StreamsDemo.Book;



public class StreamsDemo {
	static class Book implements Comparable<Book>{		
		private long isbn;
		private String title;	
		private double rating;
		private double price;
		private String source;
		
		public Book(long isbn, String title, double rating, double price, String source) {
			this.isbn = isbn;
			this.title = title;
			this.rating = rating;
			this.price = price;
			this.source = source;
		}
		
		public long getIsbn() {
			return isbn;
		}
		
		public String getTitle() {
			return title;
		}
		
		public double getRating() {
			return rating;
		}
		
		public double getPrice() {
			return price;
		}
		
		public String getSource() {
			return source;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (isbn ^ (isbn >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Book other = (Book) obj;
			if (isbn != other.isbn)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Book [isbn=" + isbn + ", title=" + title + ", rating=" + rating + ", price=" + price + ", source="
					+ source + "]";
		}

		@Override
		public int compareTo(Book o) {
			return this.title.compareTo(o.title);
		}
		
	}	
	
	/*
	// Stream pipeline (a common structure): 
	     (a) set-up stream source (~ tables in SQL world)
	     (b) 0 or more intermediate operations (~ WHERE clause) -- lazy 
	              & return Stream<T>, i.e., transforms a stream into another stream
	     (c) terminal operation (~ column names) -- eager 
	              & return NON-STREAM. Terminates (closes) a stream
	*/

	public static void main(String[] args) {
//		select count(*) from books b where b.rating > ? 
		List<Book> books = new ArrayList<>();
		
		books.addAll(DataExtractor.getFromAmazon("java"));
		books.addAll(DataExtractor.getFromBarnesAndNoble("java"));
		
		imperative(books);
		declarative(books);
		
		// Stream creation 
		Stream<List<Book>> bookStream = Stream.of(books);
		bookStream.forEach(System.out :: println);
		
		
		// from array
		Stream<Book> bookStream2 = Stream.of(arrayOfBooks);
		bookStream2.forEach(System.out :: println);
		
		// from arrays
		Stream<Book[]> bookStream3 = Stream.of(arrayOfBooks, arrayOfBooks1);
		bookStream2.forEach(System.out :: println);
		
		// HTML Stripper

	}
	
	public static void imperative(List<Book> books){
		int count = 0;
		for(Book b: books){
			if(b.rating > 4.8){
				count ++;
			}
		}
		System.out.println(count);
	}
	
	public static void declarative(List<Book> books){
		long count = books.stream()
		.filter(b -> b.rating>4.8)
		.count();
		System.out.println(count);
	}
	
	
	private static Book[] arrayOfBooks = {
			new Book(9780596009201L, "Java 1", 3.9, 20.0, "B&N"),
			new Book(9780596009202L, "Java 2", 4.1, 20.0, "B&N"),
			new Book(9780596009203L, "Java 3", 4.6, 20.0, "B&N")
		};
	private static Book[] arrayOfBooks1 = {
			new Book(9780596009201L, "Java 1", 3.9, 20.0, "B&N"),
			new Book(9780596009202L, "Java 2", 4.1, 20.0, "B&N"),
			new Book(9780596009203L, "Java 3", 4.6, 20.0, "B&N")
		};

}
