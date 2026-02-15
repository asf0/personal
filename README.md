# Personal Project

## Description
This project is a Java-based implementation of various data structures and algorithms, including sorting algorithms, search algorithms, and different types of linked lists. It serves as an educational resource for understanding fundamental computer science concepts and their implementations in Java.

## Features
- Implementation of common sorting algorithms:
  - Bubble Sort
  - Insertion Sort
  - Merge Sort
  - Quick Sort
  - Selection Sort
- Implementation of search algorithms:
  - Linear Search
  - Binary Search
- Data structure implementations:
  - Doubly Linked List
  - Circular Linked List
  - HashMap
  - LinkedHashMap
  - TreeMap
- Performance evaluations for sorting algorithms
- Example usage and main classes for each algorithm and data structure

## Technologies Used
- **Programming Language**: Java
- **IDE Support**: Visual Studio Code (based on the presence of `.vscode` folder)

## Prerequisites
To run this project, ensure you have the following installed:
- **Java Development Kit (JDK)**: Version 8 or higher
- **Apache Maven** (optional, for project management)
- **IDE**: A Java-compatible IDE such as IntelliJ IDEA or Eclipse (optional)

## How to Run Locally

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/personal.git
   cd personal
   ```

2. **Set Up Your Development Environment**
   - Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
   - Configure the IDE to use the installed JDK.

3. **Compiling the Code**
   - Navigate to the directory with the code you want to run. For example, to run the BubbleSort:
   ```bash
   cd Java/AMZ/src/BubbleSort
   ```
   - Compile the Java files:
   ```bash
   javac Main.java BubbleSortPerformance.java
   ```

4. **Running the Application**
   - After compiling, you can run the main class:
   ```bash
   java Main
   ```

5. **Running Tests (if applicable)**
   - If you have written test cases, ensure you have a testing framework (like JUnit) set up.
   - Navigate to the test directory and run the tests using your IDE's built-in functionality or through the command line.

## Project Structure
The project is organized into the following directory structure:

```
Java/
├── AMZ/
│   ├── src/
│   │   ├── BinarySearch/         # Contains Binary Search implementation
│   │   ├── BubbleSort/           # Contains Bubble Sort implementation and performance evaluation
│   │   ├── DoublyLinkedList/     # Contains implementation of Doubly Linked List
│   │   ├── HashMap/              # Implementation of HashMap
│   │   ├── InsertionSort/        # Contains Insertion Sort implementation
│   │   ├── LinearSearch/         # Contains Linear Search implementation
│   │   ├── LinkedHashMap/        # Implementation of LinkedHashMap
│   │   ├── MergeSort/            # Contains Merge Sort implementation
│   │   ├── QuickSort/            # Contains Quick Sort implementation
│   │   ├── SelectionSort/        # Contains Selection Sort implementation
│   │   └── TreeMap/              # Implementation of TreeMap
│   └── stacks/                   # Stack implementations
└── DSA/
    ├── arrayList/                # Array List implementation
    ├── arrayexercises/           # Array exercises
    └── circularLinkedList/       # Circular Linked List implementation
```

## Configuration
No specific configuration files are present in this project. Ensure your Java environment is correctly configured, and follow the prerequisite instructions for a smooth setup. You may also customize the settings in your IDE as needed.

---

For any issues or contributions, please feel free to submit a pull request or open an issue in the repository!