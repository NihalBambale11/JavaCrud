package TaskValidaton;

import java.util.Comparator;

import TaskCore.Task;

public class ComparatorDate implements Comparator<Task> {



	@Override
	public int compare(Task o1, Task o2) {
		return o1.getTaskDate().compareTo(o2.getTaskDate());
	}

}
