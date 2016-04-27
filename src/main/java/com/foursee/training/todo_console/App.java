package com.foursee.training.todo_console;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	List<ToDoItem> items = createTodoList();    	    	
    	System.out.println( "Original list");
    	
    	display( items);
    	
    	//Use an anonymous inner class.
    	System.out.println( "\nSort by Date-Priority");
    	Collections.sort( items, new Comparator<ToDoItem>() {

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
    	display( items);
    	

    	//use a normal class that can be unit tested.
    	System.out.println( "\nSort by Priority-Date");
    	Collections.sort( items, new PriorityDateComparator());
    	display( items);    	
    }

	private static List<ToDoItem> createTodoList() {
		List< ToDoItem> items = new ArrayList<ToDoItem>();
    	items.add( new ToDoItem( Priority.LOW, LocalDate.of(2014,  4, 28), "Wash house"));    	
    	items.add( new ToDoItem( Priority.HIGH, LocalDate.of(2014,  4, 26), "Clean car"));
    	items.add( new ToDoItem( Priority.LOW, LocalDate.of(2014,  4, 27), "Clean house"));
    	items.add( new ToDoItem( Priority.MEDIUM, LocalDate.of(2014,  4, 28), "Wash dog"));    	
    	items.add( new ToDoItem( Priority.MEDIUM, LocalDate.of(2014,  4, 28), "Wash Myself"));
		return items;
	}

	private static void display(List<ToDoItem> items) {
		for( ToDoItem item: items){
			System.out.println( item);
		}
	}
}
