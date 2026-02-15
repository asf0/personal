# Personal Project

## Description
The "Personal" project is a Java-based collection of algorithms and data structures, aimed at demonstrating fundamental computer science concepts. This repository includes implementations of various search algorithms, sorting algorithms, and data structures such as linked lists, hash maps, and trees, making it a valuable resource for learning and reference.

## Features
- Implementations of common search algorithms:
  - Linear Search
  - Binary Search
- Implementations of popular sorting algorithms:
  - Bubble Sort
  - Insertion Sort
  - Merge Sort
  - Quick Sort
  - Selection Sort
- Data structures:
  - ArrayList
  - Doubly Linked List
  - Circular Linked List
  - Hash Map
  - Linked Hash Map
  - Tree Map
- Performance analysis of sorting algorithms

## Technologies Used
- Java 8 or higher

## Prerequisites
To run this project locally, you will need:
- **Java Development Kit (JDK)**: Ensure that you have JDK 8 or higher installed. You can download it from [Oracle's official website](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html) or install it using a package manager for your OS.

## How to Run Locally

### Step 1: Clone the Repository
Open your terminal and run the following command to clone the repository:
```bash
git clone https://github.com/yourusername/personal.git
cd personal/Java/AMZ/src
```

### Step 2: Compile the Java Files
You will need to compile the Java files. Navigate to the respective directories for each algorithm or data structure and compile them. For example:
```bash
javac BinarySearch/Main.java
javac BubbleSort/Main.java
javac InsertionSort/Main.java
# Repeat for other Java files as necessary
```

### Step 3: Run the Java Programs
After compiling, you can run the Java programs. For instance, to run the Binary Search implementation, execute:
```bash
java BinarySearch.Main
```
Repeat this for other main classes found in their respective directories.

### Step 4: (Optional) Performance Tests
If you want to test the performance of sorting algorithms, navigate to their respective directories (e.g., `BubbleSort`) and run the performance test classes:
```bash
java BubbleSort.BubbleSortPerformance
```

## Project Structure
```
Java/
 └── AMZ/
     └── src/
         ├── BinarySearch/
         ├── BubbleSort/
         ├── DoublyLinkedList/
         ├── HashMap/
         ├── InsertionSort/
         ├── LinearSearch/
         ├── LinkedHashMap/
         ├── MergeSort/
         ├── QuickSort/
         ├── SelectionSort/
         ├── TreeMap/
         └── stacks/
```

- **BinarySearch**: Contains implementations of binary search algorithms.
- **BubbleSort, InsertionSort, MergeSort, QuickSort, SelectionSort**: Directories for various sorting algorithm implementations.
- **DoublyLinkedList, HashMap, LinkedHashMap, TreeMap**: Directories containing Java implementations of different data structures.
- **stacks**: Contains stack-related implementations.

## Configuration
Currently, there are no specific configuration files required for this project. All necessary configurations are handled within the Java files. However, ensure your Java environment is correctly set up, and feel free to modify any Java source files according to your needs.

## Conclusion
This project serves as an educational resource to understand and implement basic algorithms and data structures in Java. Feel free to contribute or modify the code for your learning purposes.