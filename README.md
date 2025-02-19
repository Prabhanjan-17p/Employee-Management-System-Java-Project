# Employee Management System

## 📌 Project Overview
The **Employee Management System (EMS)** is a Java-based desktop application that allows organizations to efficiently manage employee details, including adding, updating, deleting, and viewing employee records. The project is built using **Java Core, Java Swing, and AWT** for the graphical user interface (GUI) and **MySQL** for database management.

---

## 🛠️ Technologies Used
- **Frontend (GUI):** Java Swing, AWT  
- **Backend (Logic & Processing):** Java Core  
- **Database:** MySQL  
- **JDBC (Java Database Connectivity):** For database interaction  

---

## 🎯 Features
✅ **Employee Registration** - Add new employees with details like name, age, designation, department, salary, and contact information.  
✅ **View Employee Records** - Display employee details in a table format using Swing components.  
✅ **Edit & Update Employee Details** - Modify existing employee details.  
✅ **Delete Employee Records** - Remove employees from the system.  
✅ **Search Functionality** - Search employees by name, department, or ID.  
✅ **Login System (Optional)** - Secure access with admin login credentials.  

---

## 🏗️ Project Structure
```
Employee-Management-System/
│── src/
│   ├── DBConnection.java      # Database connection setup
│   ├── EmployeeDAO.java       # Database operations (CRUD)
│   ├── EmployeeForm.java      # Java Swing-based UI
│── README.md                  # Project Documentation
│── EmployeeDB.sql             # Database Schema
│── assets/                    # Images and resources
```

---

## 🗄️ Database Schema (MySQL)
```sql
CREATE DATABASE EmployeeDB;
USE EmployeeDB;

CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    department VARCHAR(50),
    designation VARCHAR(50),
    salary DECIMAL(10,2),
    contact VARCHAR(15)
);
```

---

## 🚀 Getting Started
### 1️⃣ Clone the Repository
```sh
git clone https://github.com/your-username/employee-management-system.git
cd employee-management-system
```

### 2️⃣ Setup MySQL Database
- Install MySQL and create a database using the provided schema (**EmployeeDB.sql**).

### 3️⃣ Configure Database Connection
- Update **DBConnection.java** with your MySQL credentials:
```java
String url = "jdbc:mysql://localhost:3306/EmployeeDB";
String user = "root";
String password = "your_password";
```

### 4️⃣ Run the Application
- Compile and run the Java application:
```sh
javac EmployeeForm.java
java EmployeeForm
```

---

## 🔍 Code Snippets
### Connecting Java with MySQL (JDBC)
```java
import java.sql.*;

public class DBConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB", "root", "password");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
```

### Employee Form (Swing GUI)
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmployeeForm extends JFrame {
    JTextField nameField, ageField, deptField, desgField, salaryField, contactField;
    JButton submitButton;

    public EmployeeForm() {
        setTitle("Employee Management System");
        setSize(400, 400);
        setLayout(new GridLayout(7, 2));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);
        
        add(new JLabel("Age:"));
        ageField = new JTextField();
        add(ageField);
        
        add(new JLabel("Department:"));
        deptField = new JTextField();
        add(deptField);
        
        add(new JLabel("Designation:"));
        desgField = new JTextField();
        add(desgField);
        
        add(new JLabel("Salary:"));
        salaryField = new JTextField();
        add(salaryField);
        
        add(new JLabel("Contact:"));
        contactField = new JTextField();
        add(contactField);

        submitButton = new JButton("Add Employee");
        add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EmployeeDAO.addEmployee(nameField.getText(), Integer.parseInt(ageField.getText()),
                        deptField.getText(), desgField.getText(),
                        Double.parseDouble(salaryField.getText()), contactField.getText());
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new EmployeeForm();
    }
}
```

---

## 📌 Future Enhancements
- 🔒 Implement **login authentication** for security.
- 📜 Add **export to Excel/PDF** feature.
- 📊 Use **JTable for displaying employee data**.
- 📈 Include **reports & analytics** on employee performance.

---

## 🤝 Contributing
Contributions are welcome! If you’d like to improve this project:
1. Fork the repository.
2. Create a new branch.
3. Commit your changes.
4. Submit a pull request.

---

## 📄 License
This project is licensed under the **MIT License**.

---

## 📞 Contact
For any queries, feel free to connect with me on:
- **LinkedIn:** [Your LinkedIn Profile](https://www.linkedin.com/in/your-profile)
- **GitHub:** [Your GitHub Profile](https://github.com/your-username)

🚀 Happy Coding! 🎯
