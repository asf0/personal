import java.util.ArrayList;
import java.util.Arrays;

/**
 * ArrayList is a class in Java that is used to store elements. 
 * It inherits AbstractList class and implements List interface.
 * The ArrayList class maintains the insertion order and is non-synchronized. 
 * The elements stored in the ArrayList class can be randomly accessed.
 * ArrayList is like an array, but there is no size limit. 
 * We can add or remove elements dynamically.
 * Arrays are type-safe, but ArrayList is not type-safe.
 * ArrayList are slower than arrays because they are dynamically sized.
 * 
 * Consider the following example:
 * ArrayList<String> list = new ArrayList<String>();
 * list.add("Java");
 * list.add("C++");
 * list.add("Python");
 * 
 * The above code creates an ArrayList of Strings and adds elements to it.
 * 
 * size() method: It is used to get the size of the ArrayList.
 * get() method: It is used to get the element of a specific index of the ArrayList.
 * set() method: It is used to set the value of an element at a specific index of the ArrayList.
 * add() method: It is used to add elements to the ArrayList.
 * remove() method: It is used to remove elements from the ArrayList.
 * clear() method: It is used to remove all the elements from the ArrayList.
 * isEmpty() method: It is used to check whether the ArrayList is empty or not.
 * contains() method: It is used to check whether the ArrayList contains a specific element or not.
 * indexOf() method: It is used to get the index of the first occurrence of an element in the ArrayList.
 * lastIndexOf() method: It is used to get the index of the last occurrence of an element in the ArrayList.
 * toArray() method: It is used to convert the ArrayList to an array.
 */
public class arrayList {
    public static void main(String[] args) {
        
        ArrayList<String> names = new ArrayList<String>(Arrays.asList("John", "David", "Mathew"));
        ArrayList<Integer> numbers = new ArrayList<Integer>(30);
        names.add("Peter");
        names.add("Sam");
        numbers.add(10);
        numbers.add(15);
        numbers.add(2, 20);
        // System.out.println(names);
        // System.out.println(numbers);
        // System.out.println(names.get(2));
        // System.out.println(numbers.size());
        // Iterating over an ArrayList
        // for (String name : names) {
        //     System.out.println(name);
        // }

        // for (int i = 0; i < names.size(); i++) {
        //     System.out.println(names.get(i));
        // }
        // Iterator<String> itr = names.iterator();
        // while (itr.hasNext()) {
        //     System.out.println(itr.next());
        // }

        // Searching for an element in the ArrayList
        for (String name : names) {
            if (name.equals("David")) {
                System.out.println("David is present in the list");
                break;
            }
        }
        // indexof
        System.out.println(names.indexOf("David"));
        // lastIndexOf
        System.out.println(names.lastIndexOf("David"));
        // contains
        System.out.println(names.contains("David"));
        // // isEmpty
        // System.out.println(names.isEmpty());
        // // clear
        // names.clear();
        // System.out.println(names.isEmpty());

        // remove
        names.remove(1);
        System.out.println(names);
        
        
    }

}
