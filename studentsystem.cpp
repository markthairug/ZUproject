#include <iostream>
#include<string>
using namespace std;
class Person
{
protected:
    string name;
public:
    Person(string n) {
        name = n;
    }
    // Pure virtual function (makes class abstract)
    virtual void displayDetails() = 0;
};
/*
   COURSE CLASS
*/
class Course
{
private:
    string courseName;

public:
    Course(string cname) {
        courseName = cname;
    }
    string getCourseName() {
        return courseName;
    }
};
/*
   STUDENT CLASS
   Inherits from Person (Inheritance)
*/
class Student : public Person /*inherits from class Person similar to extends keyword in java*/
{
private:
    int studentID;//int as shown in the example
    int marks;
    Course course;   // Composition (Student has a Course)
public:
    // Constructor
    Student(int id, string n, int m, string cname)
        : Person(n), course(cname) {
        studentID = id;
        marks = m;
    }
    // Getter methods (Encapsulation)
    int getStudentID()
    {
        return studentID;
    }
    int getMarks()
    {
        return marks;
    }
    void setMarks(int m)
    {
        marks = m;
    }
    // Method to calculate grade
    string calculateGrade()
    {
        if (marks >= 70)
            return "A";
        else if (marks >= 60)
            return "B";
        else if (marks >= 50)
            return "C";
        else
            return "Fail";
    }
    // Polymorphism (Overriding abstract method)
    void displayDetails() override
    {
        cout << "\n The Student Details are :" << endl;
        cout << "Student ID: " << studentID << endl;
        cout << "Name: " << name << endl;
        cout << "Course: " << course.getCourseName() << endl;
        cout << "Marks: " << marks << endl;
        cout << "Grade: " << calculateGrade() << endl;
    }
};

int main()
{
    int id, marks;
    string name, courseName;
    cout << "Enter Student ID: ";
    cin >> id;
    cin.ignore(); // clear buffer
    cout << "Enter Student Name: ";
    getline(cin, name);
    cout << "Enter Course Name: ";
    getline(cin, courseName);
    cout << "Enter Marks: ";
    cin >> marks;
    // Create student object
    Student student1(id, name, marks, courseName);
    // Display details
    student1.displayDetails();
    return 0;
}

