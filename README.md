# Miniproject

This is a Java-based miniproject for managing university courses and students.

## How to Use

This program provides a set of interfaces that can be used to manage university courses and students. Here are the main interfaces:

### ICourse

This interface represents a university course and provides methods for managing students enrolled in the course.

### IStudent

This interface represents a university student and provides methods for managing student information.

### IUniversityManagement

This interface represents the main university management system and provides methods for adding students and courses to the system, enrolling students in courses, and listing registered students and courses.

## Examples

Here are some examples of how to use the public methods of the program:

### Creating a Course

```java
ICourse course = new Course(100, "Java Programming", "John Smith");```

### Enrolling a Student

```java
IUniversityManagement management = new UniversityManagement();
IStudent student = new Student(12345, "Jane Doe", "jane.doe@example.com");
management.addStudentToSystem(student.getId(), student.getName(), student.getEmail());
management.addCourseToSystem(course.getCode(), course.getName(), course.getCoordinator());
management.enrollStudent(student.getId(), course.getCode());```

### Listing Registered Courses

```java
IUniversityManagement management = new UniversityManagement();
List<ICourse> courses = management.registeredCoursesList();
for (ICourse course : courses) {
    System.out.println(course.getName());
}```
