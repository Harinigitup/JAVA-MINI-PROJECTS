# Java Mini Project - Student Management System

## Overview

This is a console-based student management system built as a Java mini project. It's a complete, functional application designed for educational institutions to manage student records efficiently.

Core Components:
Student.java - Model class representing student entities
StudentManagementSystem.java - Main business logic and operations
Main.java - Entry point with user interface
Compiled classes - Ready-to-run bytecode files

## Features
- Add new students with details (ID, Name, Age, Course, GPA)
- View all students in the system
- Search students by ID, Name, or Course
- Update existing student information
- Delete students from the system
- Display statistics (total students, average GPA, age range)

## Files Structure
```
├── Student.java              # Student model class
├── StudentManagementSystem.java  # Main application logic
├── Main.java                 # Entry point
└── README.md                 # This file
```

## How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command prompt/terminal

### Steps to Run
1. Open terminal/command prompt
2. Navigate to the project directory
3. Compile the Java files:
   ```
   javac *.java
   ```
4. Run the application:
   ```
   java Main
   ```

## Usage Guide
When you run the application, you'll see a menu with these options:
1. **Add Student**: Enter student details to add to the system
2. **View All Students**: Display all students currently in the system
3. **Search Student**: Find students by ID, name, or course
4. **Update Student**: Modify existing student information
5. **Delete Student**: Remove a student from the system
6. **Display Statistics**: Show system statistics
7. **Exit**: Close the application

## Key Concepts Demonstrated
- **Classes and Objects**: Student class with encapsulation
- **Collections**: ArrayList for storing student data
- **Input/Output**: Scanner for user interaction
- **Control Flow**: Switch statements and loops
- **Error Handling**: Input validation with try-catch
- **Methods**: Modular programming with separate functions

## Sample Usage
```
=== Student Management System ===

--- Main Menu ---
1. Add Student
2. View All Students
3. Search Student
4. Update Student
5. Delete Student
6. Display Statistics
7. Exit
Enter your choice: 1

--- Add New Student ---
Enter student name: John Doe
Enter student age: 20
Enter course name: Computer Science
Enter GPA (0.0 - 4.0): 3.5
Student added successfully!
```
