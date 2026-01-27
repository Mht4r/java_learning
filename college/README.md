# College Student Management System

A simple Java console application for  inserting students data (Name, age, Branch)  using MySQL database.



## Compilation

Compile the project using:

```bash
javac -d bin -cp "lib/*" src/com/college/model/*.java src/com/college/util/*.java src/com/college/dao/*.java src/com/college/*.java
```

## Running

Run the compiled application:

```bash
java -cp "bin;lib/*" com.college.Main
```

## Usage

When you run the application, it will prompt you for:

1. **Name** - Enter student's name
2. **Age** - Enter student's age (numeric)
3. **Branch** - Enter student's branch (e.g., CSE, IT, ECE)

After entering the details, the application will:
- Insert the new student record into the database
- Display all students currently in the database

## Dependencies

- **MySQL Connector/J 9.5.0** - JDBC driver for MySQL
- **dotenv-java 3.0.2** - Environment variable management

## Known Issues

- Scanner input bug: After entering age, the branch prompt may be skipped due to `nextInt()` not consuming the newline character

## License

This is a learning project for educational purposes.
