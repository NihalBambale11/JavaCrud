package TaskValidaton;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Collections;
import TaskException.StatusNotFoundException;
import TaskCore.Task;
import Task_Status.Status;

public class TaskValidationRules {
	public TaskValidationRules tvr = new TaskValidationRules();

	public static ArrayList<Task> populateList() {
		ArrayList<Task> list = new ArrayList<>();
		list.add(new Task("Running", "hijshjkdfd jkldflhijksjkhfdjkj ijdkjldlkjflk df", LocalDate.parse("2024-04-26"),
				Status.PENDING, true));
		list.add(new Task("eating", "hijshjkdfd jkaiudiks ioulikjdfdkjldlkjflk df", LocalDate.parse("2024-04-26"),
				Status.PENDING, true));
		list.add(new Task("Cleaning", "hijshjkdfd jkldflhijksjkhf d", LocalDate.parse("2023-03-21"), Status.PENDING,
				true));
		list.add(new Task("Studying", "hijshjkdfd s iujsiudi oiusd", LocalDate.parse("2024-01-02"), Status.PENDING,
				true));

		return list;
	}

	public static Task validateInputs(String taskName, String description, String taskDate, String status,
			boolean active) {

		status = "PENDING";
		active = true;

		return new Task(taskName, description, LocalDate.parse(taskDate), Status.PENDING, active);
	}

	public static Status validateStatus(String status) throws StatusNotFoundException {
		for (Status s : Status.values()) {
			if (s.name().equalsIgnoreCase(status)) {
				return s;
			}
		}
		throw new StatusNotFoundException("Please Assign Proper Status");
	}

	public static Task findById(ArrayList<Task> tasklist, int taskId) {
		Task t = new Task(taskId);
		int index = tasklist.indexOf(t);
		if (index == -1) {
			System.out.println("Error");
		}
		return tasklist.get(index);

	}

	// case 2
	public static void deleteTask(ArrayList<Task> tasklist, int id) {
		for (Task t : tasklist) {
			if (t.getTaskId() == id) {

				t.setActive(false);
				display(tasklist);
			}
		}
		tasklist.remove(id);
	}

	// case 3
	public static void updateTaskStatus(ArrayList<Task> TaskList, int taskId, String status)
			throws StatusNotFoundException {
		for (Task t : TaskList) {
			if (t.getTaskId() == taskId) {
				t.setStatus(TaskValidationRules.validateStatus(status));
				if (t.getStatus() == Status.COMPLETED) {
					t.setActive(false);
				} else if (t.getStatus() == Status.INPROGRESS) {
					t.setActive(true);
				} else {
					t.setActive(true);
				}
			}
		}
		throw new StatusNotFoundException("NOT Found");
	}

	// case 4
	public static void displayPendingWork(ArrayList<Task> TaskList) {
		for (Task t : TaskList) {
			if (t.isActive() && t.getStatus() == Status.PENDING) {
				display(TaskList);
			}
		}
	}

	// case 5
	public static void displayPendingWorkForToday(ArrayList<Task> TaskList) {
		for (Task t : TaskList) {
			if (t.isActive() && t.getStatus() == Status.PENDING && t.getTaskDate().equals(LocalDate.now())) {
				display(TaskList);

			}
		}
	}

	//case 6:

	public static void SortByDate(ArrayList<Task> TaskList) {
		Collections.sort(TaskList,new ComparatorDate());

	}

	

//case 7
	public static void display(ArrayList<Task> tasklist) {
		for (Task t : tasklist) {
			System.out.println(t);
		}
	}
}