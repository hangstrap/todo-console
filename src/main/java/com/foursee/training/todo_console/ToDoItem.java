package com.foursee.training.todo_console;

import java.time.LocalDate;

/**
 * class is immutable
 */
public class ToDoItem {

	private final Priority priority;
	private final LocalDate dueBye;
	private final String message;
	
	public ToDoItem(Priority priority, LocalDate dueBye, String message) {
		super();
		this.priority = priority;
		this.dueBye = dueBye;
		this.message = message;
	}

	public Priority getPriority() {
		return priority;
	}

	public LocalDate getDueBye() {
		return dueBye;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dueBye == null) ? 0 : dueBye.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((priority == null) ? 0 : priority.hashCode());
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
		ToDoItem other = (ToDoItem) obj;
		if (dueBye == null) {
			if (other.dueBye != null)
				return false;
		} else if (!dueBye.equals(other.dueBye))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (priority != other.priority)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ToDoItem [priority=" + priority + ", dueBye=" + dueBye + ", message=" + message + "]";
	}
	
	
	
}
