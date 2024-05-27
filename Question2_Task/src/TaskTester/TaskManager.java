package TaskTester;

import static TaskValidaton.TaskValidationRules.deleteTask;
import static TaskValidaton.TaskValidationRules.display;
import static TaskValidaton.TaskValidationRules.displayPendingWork;
import static TaskValidaton.TaskValidationRules.displayPendingWorkForToday;
import static TaskValidaton.TaskValidationRules.populateList;
import static TaskValidaton.TaskValidationRules.updateTaskStatus;
import static TaskValidaton.TaskValidationRules.validateInputs;
import static TaskValidaton.TaskValidationRules.SortByDate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import TaskCore.Task;

public class TaskManager {
	public static void main(String[] args) {
		int choice;
		//ArrayList<Task> TaskList = new ArrayList<>();
		ArrayList<Task> TaskList = populateList();
		 String taskName;
		 String description;
		 String taskDate;
		 String status = "";
		 boolean active=true;
		try (Scanner scan = new Scanner(System.in)) {
			do {
				System.out.println("1. ADD NEW TASK" + "\n2. DELETE A TASK" + "\n3. UPDATE TASK STATUS "
			+ "\n4. DISPLAY ALL PENDING TASKS " + "\n5. DISPLAY ALL PENDING TASK FOR TODAY "+"\n6. DISPLAY ALL TASK SORTED BY TASKDATE "+"\n7.  DISPLAY ");
				System.out.println("Enter the Choice ");
				choice = scan.nextInt();
				
				switch(choice) {
				case 1:
						System.out.println("Enter the TaskName");
						taskName = scan.next();
						System.out.println("Enter the Description for the Task");
						description = scan.next();
						description = description  + scan.nextLine();
						System.out.println("Enter the taskDate");
						taskDate= scan.next();
						//System.out.println("Enter the Status of the Task ");
						//status = scan.nextInt();
						//System.out.println("Enter the Activeness of Task");
						//active = scan.nextBoolean();
						
						Task t = validateInputs(taskName,description,taskDate,status,active);
						TaskList.add(t);
						System.out.println("New TASK ADDED ");
						break;
				case 2:
					System.out.println("Delete A Task");
					System.out.println("Enter the ID");
					int taskId = scan.nextInt();
					deleteTask(TaskList,taskId);
					break;
					
				case 3:
					System.out.println("Enter the TaskId for Updation ");
					taskId = scan.nextInt();
					//Task t1 = findById(TaskList,taskId);
					System.out.println("Enter the Status ");
					String sta = scan.next();
					updateTaskStatus(TaskList,taskId,sta);
					break;
				case 4:
						displayPendingWork(TaskList);
						break;
				case 5:
					displayPendingWorkForToday(TaskList);
					break;
				case 6:
					SortByDate(TaskList);
					for(Task t4 : TaskList) {
						System.out.println(t4);
					}
					break;
				case 7:
					display(TaskList);
					break;
				}

			} while (choice != 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
