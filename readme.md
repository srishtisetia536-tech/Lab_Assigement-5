# Student Record Management System — Java (OOP + File Handling + Exceptions + Multithreading)

This is a Java-based **Student Record Management System** that supports CRUD operations with persistent storage.  
The project is built using **Object-Oriented Programming**, **Java Collections Framework**, **File I/O**, **Custom Exceptions**, and **Multithreading**.

---

## 📖 Features
✔ Add new students  
✔ Update student marks  
✔ Delete student records  
✔ Search by Roll Number  
✔ View all students  
✔ Sort students by marks (descending)  
✔ Save records to file  
✔ Load records from file at startup  
✔ Multithreaded loading simulation  
✔ Custom exceptions for invalid operations

---

## 🧠 Key Concepts Used

### 🔹 1. Abstraction
- **Person** → abstract base class with common fields

### 🔹 2. Inheritance
- **Student** extends `Person`
- Adds rollNo, course, marks, grade

### 🔹 3. Interfaces
- **RecordActions**
- Provides method signatures for CRUD

### 🔹 4. Collections
- `ArrayList<Student>` — manage student objects
- `HashMap<Integer, Student>` — fast lookup using rollNo

### 🔹 5. File Handling
- `BufferedReader` & `BufferedWriter`
- Persistent storage in `students.txt`

### 🔹 6. Multithreading
- `Loader` implements `Runnable`
- Simulates processing delay while adding records

### 🔹 7. Exception Handling
- Custom: `StudentNotFoundException`
- Validation for:
  - Duplicate roll numbers
  - Invalid marks
  - Empty fields

---

## 📁 Project Structure

