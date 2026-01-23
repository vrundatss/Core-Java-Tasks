package com.tss.assign;

import com.tss.assign.model.Course;
import com.tss.assign.model.Student;
import com.tss.assign.service.CourseService;
import com.tss.assign.service.StudentService;

import java.util.Scanner;

public class StudentCourseManagement {
    static Scanner scanner = new Scanner(System.in);

    static final int MAX_STUDENTS = 10;
    static final int MAX_COURSES = 5;
    static final int MAX_MONTHS = 60;
    static final int MAX_FEES = 1000000;

    static Student[] students;
    static Course[] courses;

    static int studentCount = 0;
    static int courseCount = 0;

    public static void main(String[] args) {
        System.out.print("Enter number of Students (max " + MAX_STUDENTS +  " ): ");
        int numberOfStudents;
        while (true) {
            numberOfStudents = scanner.nextInt();
            if (numberOfStudents > 0 && numberOfStudents <= MAX_STUDENTS) {
                break;
            }
            System.out.print("Only 1– " + MAX_STUDENTS +" students allowed. \nEnter number of Students again: ");
        }

        System.out.print("Enter number of Courses (max " +MAX_COURSES + " ): ");
        int numberOfCourses;
        while (true) {
            numberOfCourses = scanner.nextInt();
            if (numberOfCourses > 0 && numberOfCourses <= MAX_COURSES) {
                break;
            }
            System.out.print("Only 1- " + MAX_COURSES + " Courses allowed. \nEnter number of Courses again: ");
        }

        students = new Student[numberOfStudents];

        courses = new Course[numberOfCourses];

        int choice;

        do {
            System.out.println("\n====== Student Management Menu ======");
            System.out.println("1. Add new Student");
            System.out.println("2. Add new Course");
            System.out.println("3. Register Course for a Student");
            System.out.println("4. Pay fees");
            System.out.println("5. View pending fees");
            System.out.println("6. Unenroll course for a Student");
//            System.out.println("6. Update Course");
            System.out.println("7. Display a Student");
            System.out.println("8. Display all Students");
            System.out.println("9. Display all Courses");
            System.out.println("10. Exit");

            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Enter a valid number (1–10): ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            boolean idAlreadyExists = true;

            switch (choice) {
                case 1:
                    addNewStudent();
                    break;

                case 2:
                    addNewCourse();
                    break;

                case 3:
                    registerCourseForStudent();
                    break;

                case 4:
                    payFees();
                    break;

                case 5:
                    viewPendingFees();
                    break;

                case 6:
                    unenrollCourseForStudent();
//                    updateCourse();
                    break;

                case 7:
                    displaySingleStudent();
                    break;

                case 8:
                    displayAllStudents();
                    break;

                case 9:
                    displayAllCourses();
                    break;

                case 10:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Enter valid choice (1–10).");
            }

        } while (choice != 10);
    }

    private static int readPositiveId() {
        while (true) {
            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                scanner.nextLine();
                if (num > 0) return num;
            } else {
                scanner.next();
            }
            System.out.print("Enter valid positive integer: ");
        }
    }

    private static double readValidDouble(double min, double max) {
        while (true) {
            if (scanner.hasNextDouble()) {
                double val = scanner.nextDouble();
                scanner.nextLine();
                if (val >= min && val <= max) return val;
            } else {
                scanner.next();
            }
            System.out.print("Enter valid amount (" + min + " - " + max + "): ");
        }
    }

    private static Student findStudentById(Student[] students, int studentCount) {
        System.out.print("Enter Student ID : ");
        int id = readPositiveId();
        for (int i = 0; i < studentCount; i++) {
            if (students[i] != null && students[i].getId() == id) {
                return students[i];
            }
        }
        System.out.println("No student found with ID " + id);
        return null;
    }

    private static Course findCourseById(Course[] courses , int courseCount) {
        System.out.print("Enter Course ID : ");
        int id = readPositiveId();
        for (int i = 0; i < courseCount; i++) {
            if (courses[i] != null && courses[i].getCourseId() == id) {
                return courses[i];
            }
        }
        System.out.println("No course found with ID " + id);
        return null;
    }

    private static void addNewStudent() {
        if (studentCount >= students.length) {
            System.out.println("Cannot add more Students. Limit reached.");
            return;
        }
        System.out.print("Enter Student Name : ");
        String name = scanner.nextLine();
        Student student = new Student(name );
        students[studentCount++] = student;
        System.out.println("Student added successfully with ID: " + student.getId());
    }

    private static void addNewCourse() {
        if (courseCount >= courses.length) {
            System.out.println("Cannot add more Courses. Limit reached.");
            return;
        }
        System.out.print("Enter Course Name : ");
        String name = scanner.nextLine();

        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCourseName().equalsIgnoreCase(name)) {
                System.out.println("Course already exists: " + name);
                return;
            }
        }

        System.out.print("Enter Course Duration in months : ");
        double duration = readValidDouble(0 , MAX_MONTHS);

        System.out.print("Enter Course fees : ");
        double totalFees = readValidDouble(0 , MAX_FEES);

        Course course = new Course(name , duration , totalFees );
        courses[courseCount++] = course;
        System.out.println("Course added successfully with ID: " + course.getCourseId());
    }

    private static void registerCourseForStudent() {
        if (studentCount == 0 || courseCount == 0) {
            System.out.println("Add both students and courses first!");
            return;
        }

        Student student = findStudentById(students , studentCount);
        if (student == null) return;

        displayAllCourses();

        Course selectedCourse = findCourseById(courses , courseCount);

        StudentService studentService = new StudentService(student);

        if (selectedCourse != null) {
            Course studentCourse = new Course(selectedCourse);
            studentService.registerCourse(studentCourse);
        } else {
            System.out.println("No course found with this ID ");
        }
    }

    private static void payFees(){
        Student student = findStudentById(students, studentCount);

        if (student == null)
            return;

        if (studentCount == 0) {
            System.out.println("No students added yet!");
            return;
        }
        if (student.getCourseCount() == 0) {
            System.out.println("No registered courses.");
            return;
        }

        System.out.println("Select course to pay fees for : ");

        for (int i =0; i < student.getCourseCount(); i++){
            Course c = student.getRegisteredCourses()[i];
            System.out.printf("%d. %s (Pending: %.2f)\n", i + 1, c.getCourseName(), c.getPendingFees());
        }

//        int choice = readValidInt(1, student.getCourseCount());
        int choice = 0;
        while (true) {
            choice = scanner.nextInt();
            if (choice > 0 && choice <= student.getCourseCount()) {
                break;
            }
            System.out.print("Enter Valid Choice. \nEnter choice again: ");
        }

        Course selected = student.getRegisteredCourses()[choice - 1];

        CourseService courseService = new CourseService(selected);

        if (selected.getPendingFees() == 0) {
            System.out.println("All fees already paid for " + selected.getCourseName());
            return;
        }

        System.out.print("Enter amount to pay for " + selected.getCourseName() + ": ");
        double amount = readValidDouble(0, selected.getPendingFees());
        courseService.payFees(amount);

    }

    private static void viewPendingFees() {
        Student student = findStudentById(students, studentCount);
        if (student == null)
            return;

        StudentService studentService = new StudentService(student);

        if (student.getCourseCount() == 0) {
            System.out.println("No courses registered.");
            return;
        }

        System.out.println("\nCourse-wise Pending Fees:");
        System.out.printf("%-10s %-20s %-15s\n", "Course ID", "Course Name", "Pending Fees");

        for (int i = 0; i < student.getCourseCount(); i++) {
            Course c = student.getRegisteredCourses()[i];
            System.out.printf("%-10d %-20s %-15.2f\n", c.getCourseId(), c.getCourseName(), c.getPendingFees());
        }
        System.out.println("Total Pending Fees: " + studentService.getPendingFees());
    }

//    private static void updateCourse() {
//        if (courseCount == 0) {
//            System.out.println("No courses available to update.");
//            return;
//        }
//
//        System.out.println("\n------ Available Courses ------");
//        System.out.printf("%-10s %-20s %-15s %-10s\n", "Course ID", "Course Name", "Duration", "Total Fees");
//        System.out.println("-------------------------------------------------------------------------------");
//        for (int i = 0; i < courseCount; i++) {
//            courses[i].displayCourse();
//        }
//
//        Course selectedCourse = findCourseById(courses, courseCount);
//        if (selectedCourse == null) {
//            System.out.println("No course found with that ID.");
//            return;
//        }
//
//        System.out.println("\nEnter new details ==> ");
//
////        System.out.print("Enter new Course Name : ");
////        String newName = scanner.nextLine();
////        if (newName.trim().isEmpty()) {
//            String newName = selectedCourse.getCourseName();
////        }
//
//
//        System.out.print("Enter new Duration in months : ");
//        double newDuration = readValidDouble(0.1, 60);
//
//        System.out.print("Enter new course fees : ");
//        double newFees = readValidDouble(0 , 1000000);
////        double newFees = newDuration * 1000;
//
//        selectedCourse.updateCourse(newName, newDuration, newFees);
//
//        for (int i = 0; i < studentCount; i++) {
//            Student s = students[i];
//            if (s != null) {
//                s.updateRegisteredCourse(selectedCourse);
//            }
//        }
//
//        System.out.println("\nCourse updated successfully!");
//        System.out.printf("%-10s %-20s %-15s %-10.2f\n",
//                selectedCourse.getCourseId(),
//                selectedCourse.getCourseName(),
//                selectedCourse.getDuration(),
//                selectedCourse.getTotalFees());
//    }

    private static void unenrollCourseForStudent() {
        if (studentCount == 0 || courseCount == 0) {
            System.out.println("Add both students and courses first!");
            return;
        }

        Student student = findStudentById(students , studentCount);
        if (student == null) return;

        if (student.getCourseCount() == 0) {
            System.out.println("Student has not registered for any courses yet.\nRegister for any course first.");
            return;
        }

        System.out.println("\nRegistered Courses for " + student.getName() + ":");
        Course[] registered = student.getRegisteredCourses();


        System.out.printf("%-10s %-20s %-15s %-10s\n", "Course ID", "Course Name", "Duration", "Total Fees");
        System.out.println("-------------------------------------------------------------");
        for (int i = 0; i < student.getCourseCount(); i++) {
            CourseService courseService = new CourseService(registered[i]);

            courseService.displayCourse();
        }

//        Course selectedUnenrollCourse = findCourseById(courses , courseCount);

        System.out.print("\nEnter course number to unenroll (1-" + student.getCourseCount() + "): ");
        int choice = 0;
        while (true) {
            choice = scanner.nextInt();
            if (choice > 0 && choice <= student.getCourseCount()) {
                break;
            }
            System.out.print("Enter Valid Choice. \nEnter choice again: ");
        }

//        int choice = readChoice(1, student.getCourseCount());

        Course selectedUnenrollCourse = student.getRegisteredCourses()[choice - 1];


        StudentService studentService = new StudentService(student);

        if (selectedUnenrollCourse == null) {
//            studentService.registerCourse(selectedUnenrollCourse);
            System.out.println("No course found with this ID ");
        }
//        else {
//            System.out.println("No course found with this ID ");
//        }

        boolean isRemoved = studentService.unenrollCourse(selectedUnenrollCourse);

        if(isRemoved){
            System.out.println("Course Successfully Unenrolled.");
        }else {
            System.out.println("No course found with this ID for this student.");
        }

    }

    private static void displaySingleStudent(){
        if (studentCount == 0) {
            System.out.println("No students to display.");
            return;
        }
        Student student = findStudentById(students, studentCount);

        StudentService studentService = new StudentService(student);

        if (student != null)
        {
            System.out.printf("%-8s %-20s %-30s %-15s %-15s\n",
                    "ID", "Name", "Registered Courses", "Fees Paid", "Total Fees");
            System.out.println("--------------------------------------------------------------------------");
            studentService.displayAllDetails();
        }
    }

    private static void displayAllStudents() {
        if (studentCount == 0) {
            System.out.println("No students to display.");
            return;
        }

        System.out.println("\n===================== Student Details =====================");
        System.out.printf("%-8s %-20s %-30s %-15s %-15s\n",
                "ID", "Name", "Registered Courses", "Fees Paid", "Total Fees");
        System.out.println("---------------------------------------------------------------------------------");

        for (int i = 0; i < studentCount; i++) {
            if (students[i] != null) {
                Student student = students[i];
                StudentService studentService = new StudentService(student);
                studentService.displayAllDetails();
            }
        }
        System.out.println("====================================================================================");
    }


    private static void displayAllCourses(){
        System.out.println("\n------ Available Courses ------");
        System.out.printf("%-10s %-20s %-15s %-10s\n", "Course ID", "Course Name", "Duration", "Total Fees");
        System.out.println("-------------------------------------------------------------------------------");
        for (int i = 0; i < courseCount; i++) {
            CourseService courseService = new CourseService(courses[i]);
            courseService.displayCourse();
        }

    }

}
