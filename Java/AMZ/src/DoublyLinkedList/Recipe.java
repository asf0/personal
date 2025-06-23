package DoublyLinkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class Recipe {
    public static void main(String[] args) {
//        LinkedList<String> recipeSteps = new LinkedList<>();
//        recipeSteps.add("Preheat the oven to 350F");
//        recipeSteps.add("Mix flour and sugar");
//        recipeSteps.add("Add eggs and milk.");
//        // adding step at the beginning
//        recipeSteps.addFirst("Gather all ingredients");
//        // addming step a the end
//        recipeSteps.addLast("Serve and Enjoy");
//        System.out.println("Recipe Steps: " + recipeSteps);
//        recipeSteps.add(2, "Whisk the eggs before adding");
//        System.out.println("Recipe Steps after adding in the middle: " + recipeSteps);
//        recipeSteps.removeFirst();
//        System.out.println("Recipe Steps after removing the first: " + recipeSteps);
//        recipeSteps.removeLast();
//        System.out.println("Recipe Steps after removing the last: " + recipeSteps);
//        recipeSteps.remove(1);
//        System.out.println("Recipe Steps after removing the last: " + recipeSteps);
//        ListIterator<String> recipeStepsIterator = recipeSteps.listIterator();
//        //Foward travesal
//        System.out.println("Traversing foward through the recipe: ");
//        while (recipeStepsIterator.hasNext()) {
//            System.out.println(recipeStepsIterator.next());
//        }
//
//        // backward traversal
//        System.out.println("\n Traversing backward through the recipe: ");
//        while (recipeStepsIterator.hasPrevious()) {
//            System.out.println(recipeStepsIterator.previous());
//        }
        LinkedList<String> tasks = new LinkedList<>();
        tasks.add("Reviews today's schedule");
        tasks.add("Check emails");
        tasks.add("Attend team meeting");
        tasks.add("Complete project report");
        System.out.println("Initial tasks");
        ListIterator<String> it = tasks.listIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        tasks.add(2, "Prepare presentation slides");
        System.out.println("\nTasks after adding in the middle");
        ListIterator<String> it2 = tasks.listIterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }
        System.out.println("\nTasks after removing the last task");
        tasks.removeLast();
        ListIterator<String> it3 = tasks.listIterator();
        while (it3.hasNext()) {
            System.out.println(it3.next());
        }
        System.out.println("\nFinal task list (foward)");
        ListIterator<String> it4 = tasks.listIterator();
        while (it4.hasNext()) {
            System.out.println(it4.next());
        }
        System.out.println("\nFinal task list (backward)");
        while (it4.hasPrevious()) {
            System.out.println(it4.previous());
        }
    }

}
