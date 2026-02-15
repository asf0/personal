# Personal Project

## Description
This project is a collection of various data structures and algorithms implemented in Java. It includes a variety of search algorithms, sorting algorithms, as well as implementations of common data structures like linked lists and hash maps. The project serves as an educational resource to understand the fundamentals of computer science concepts.

## Features
- Implementations of common searching algorithms:
  - Linear Search
  - Binary Search
- Implementations of various sorting algorithms:
  - Bubble Sort
  - Insertion Sort
  - Selection Sort
  - Merge Sort
  - Quick Sort
- Data structures:
  - ArrayList
  - Doubly Linked List
  - Circular Linked List
  - HashMap
  - LinkedHashMap
  - TreeMap
- Performance testing for sorting algorithms
- Various example applications demonstrating the use of data structures and algorithms

## Technologies Used
- **Java**: The primary programming language used for implementation.

## Prerequisites
To run this project locally, you will need:
- Java Development Kit (JDK) version 8 or higher
- An Integrated Development Environment (IDE) such as IntelliJ IDEA, Eclipse, or Visual Studio Code

## How to Run Locally

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/personal.git
   cd personal
   ```

2. **Install Java**
   - Ensure you have JDK installed. You can download it from [Oracle's official website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or use a package manager like Homebrew on macOS:
     ```bash
     brew install openjdk
     ```

3. **Set Up Your IDE**
   - Open your IDE and import the cloned project.

4. **Building the Project**
   - If you're using an IDE, it will typically handle the build process automatically. Otherwise, you can compile the Java files using the command line:
     ```bash
     cd Java/AMZ/src
     javac **/*.java
     ```

5. **Run the Applications**
   - Navigate to the specific directory of the class you want to run, for example:
     ```bash
     cd BinarySearch
     java Main
     ```
   - Repeat for other algorithms or data structures as needed.

6. **Testing the Implementations**
   - Tests are not explicitly defined in this repository. You can add unit tests using JUnit or create main methods in your classes to test functionalities.

## Project Structure
```
Java/
├── AMZ/
│   ├── src/
│   │   ├── BinarySearch/
│   │   │   └── Main.java
│   │   ├── BubbleSort/
│   │   │   ├── BubbleSortPerformance.java
│   │   │   └── Main.java
│   │   ├── DoublyLinkedList/
│   │   │   └── Recipe.java
│   │   ├── HashMap/
│   │   │   └── hashMapIteration.java
│   │   ├── InsertionSort/
│   │   │   └── Main.java
│   │   ├── LinearSearch/
│   │   │   └── Main.java
│   │   ├── LinkedHashMap/
│   │   │   ├── Main.java
│   │   │   └── linkedHashMap.java
│   │   ├── MergeSort/
│   │   │   └── Main.java
│   │   ├── QuickSort/
│   │   ├── SelectionSort/
│   │   ├── TreeMap/
│   │   └── stacks/
└── DSA/
    ├── arrayList/
    ├── arrayexercises/
    ├── circularLinkedList/
```

## Configuration
No specific configuration files are found in this repository. Ensure your Java environment is correctly set up, and modify any paths if necessary while running the applications.

For further assistance, feel free to reach out or open an issue in the repository.