package com.foursee.training.todo_console;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	List< ToDoItem> items = new ArrayList<ToDoItem>();
    	items.add( new ToDoItem( Priority.LOW, LocalDate.of(2014,  4, 28), "Wash house"));    	
    	items.add( new ToDoItem( Priority.HIGH, LocalDate.of(2014,  4, 26), "Clean car"));
    	items.add( new ToDoItem( Priority.LOW, LocalDate.of(2014,  4, 27), "Clean house"));
    	items.add( new ToDoItem( Priority.MEDIUM, LocalDate.of(2014,  4, 28), "Wash dog"));    	
    	items.add( new ToDoItem( Priority.MEDIUM, LocalDate.of(2014,  4, 28), "Wash Myself"));    	    	
    	
    	TreeSet< ToDoItem> byDatePriority = new TreeSet<ToDoItem>( new Comparator<ToDoItem>() {

			public int compare(ToDoItem o1, ToDoItem o2) {
				int result = o1.getDueBye().compareTo( o2.getDueBye());
				if( result ==0 ){
					result = o1.getPriority().compareTo( o2.getPriority());
				}
				if( result==0){
					result = o1.getMessage().compareTo( o2.getMessage());
				}
				return result;
			}
		});
    	
    	byDatePriority.addAll( items);
    	System.out.println( "Date Priority");
    	display( byDatePriority);
    	

    	TreeSet< ToDoItem> byPriorityDate = new TreeSet<ToDoItem>( new PriorityDateComparator());
    	
    	System.out.println( "Priority Date");
    	byPriorityDate.addAll( items);
    	display( byPriorityDate);
    	
    }

	private static void display(TreeSet<ToDoItem> items) {
		for( ToDoItem item: items){
			System.out.println( item);
		}
	}
}
