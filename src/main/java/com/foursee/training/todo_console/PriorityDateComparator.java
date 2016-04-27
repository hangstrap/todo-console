package com.foursee.training.todo_console;

import java.util.Comparator;

final class PriorityDateComparator implements Comparator<ToDoItem> {
	public int compare(ToDoItem o1, ToDoItem o2) {
		int result = o1.getPriority().compareTo( o2.getPriority());
		if( result ==0 ){
			result = o1.getDueBye().compareTo( o2.getDueBye());
		}
		if( result==0){
			result = o1.getMessage().compareTo( o2.getMessage());
		}
		return result;
	}
}