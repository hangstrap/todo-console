package com.foursee.training.todo_console;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class PriorityDateComparatorTest {

	PriorityDateComparator underTest = new PriorityDateComparator();
	
	@Test
	public void selfShouldBeEquals() {
		
		ToDoItem item = new ToDoItem( Priority.HIGH, LocalDate.of(2016, 4, 26), "self");
		assertEquals( 0, underTest.compare( item, item));
	}

	@Test
	public void ItemsWithHigherPriorityShouldBeLessThan() {
		
		LocalDate date = LocalDate.of(2016, 4, 26);
		ToDoItem item = new ToDoItem( Priority.HIGH, date, "self");
		assertTrue( underTest.compare( item, new ToDoItem( Priority.MEDIUM, date, "self")) < 0);
		assertTrue( underTest.compare( item, new ToDoItem( Priority.LOW, date, "self")) < 0);
	}
	@Test
	public void ItemsWithLowerPriorityShouldBeGreaterThan() {
		
		LocalDate date = LocalDate.of(2016, 4, 26);
		ToDoItem item = new ToDoItem( Priority.LOW, date, "self");
		assertTrue( underTest.compare( item, new ToDoItem( Priority.MEDIUM, date, "self")) > 0);
		assertTrue( underTest.compare( item, new ToDoItem( Priority.HIGH, date, "self")) > 0);
	}
	@Test
	public void itemsWithEqualPriorityShouldThenUseDueDate(){
		
		ToDoItem item = new ToDoItem( Priority.LOW, LocalDate.of(2016, 4, 26), "self");
		ToDoItem itemBefore = new ToDoItem( Priority.LOW, LocalDate.of(2016, 4, 25), "self");
		ToDoItem itemAfter = new ToDoItem( Priority.LOW, LocalDate.of(2016, 4, 27), "self");
		
		assertTrue( underTest.compare( item, itemBefore) > 0);
		assertTrue( underTest.compare( item, itemAfter) < 0);
	}
	@Test
	public void itemsWithEqualPriorityAndDueDateShouldUseMessage(){
		
		LocalDate date = LocalDate.of(2016, 4, 26);
		ToDoItem item = new ToDoItem( Priority.LOW, date, "mmmm");
		ToDoItem itemBefore = new ToDoItem( Priority.LOW, date, "aaaa");
		ToDoItem itemAfter = new ToDoItem( Priority.LOW, date, "zzzz");
		
		assertTrue( underTest.compare( item, itemBefore) > 0);
		assertTrue( underTest.compare( item, itemAfter) < 0);
	}
	@Test
	public void itemsWithEqualPriorityAndDueDateShouldUseCaseSensitiveMessage(){
		
		LocalDate date = LocalDate.of(2016, 4, 26);
		ToDoItem item = new ToDoItem( Priority.LOW, date, "A");
		ToDoItem itemBefore = new ToDoItem( Priority.LOW, date, "a");		
		assertTrue( underTest.compare( item, itemBefore) < 0);
	}

}
