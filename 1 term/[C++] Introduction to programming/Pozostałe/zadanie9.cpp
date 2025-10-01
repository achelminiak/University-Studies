#include <iostream>
#include <map>
#include <string>

using namespace::std;

struct Student {
    int index;
    string name;
    string lastName;
    int semester;
    string lectures[20];
    map<string, int> lectureMarks;
};

// struct Lecture {
//     string name;
//     int ects;
// };

void printStudentData (Student student){
    cout << student.name << endl;
    cout << student.lastName << endl;
    cout << "Indeks:" << endl;
    cout << student.index << endl;
    cout << "Obecny semestr:" << endl;
    cout << student.semester << endl;
    cout << "Oceny z poszczególnych przedmiotów:" << endl;
    for (const auto& pair : student.lectureMarks) {
        cout << "  " << pair.first << ": " << pair.second << endl;
    }
};

void passSemester (Student student){
    student.semester++;
    cout << "Student " << student.name << " " <<  student.lastName << " zostal przeniesiony na semestr " << student.semester << endl;
};

Student createStudent (){
    Student student;
    string name, lastName, lectures[20];
    int index, semester;
    cout << "Podaj imie studenta:" << endl;
    cin >> name;
    cout << "Podaj nazwisko studenta:" << endl;
    cin >> lastName;
    cout << "Podaj indeks studenta:" << endl;
    cin >> index;
    cout << "Podaj semestr studenta:" << endl;
    cin >> semester;
    student.name = name;
    student.lastName = lastName;
    student.index = index;
    student.semester = semester;
    return student;
};

int main() {
    Student studentsList[100];
    map<string, int> lectureMarks;
    // Pierwszy student
    studentsList[0].index = 1;
    studentsList[0].name = "Bartus";
    studentsList[0].lastName = "Chomikowski";
    studentsList[0].semester = 1;
    studentsList[0].lectures[0] = "Math";
    studentsList[0].lectures[1] = "Programowanie";
    studentsList[0].lectures[2] = "Angielski";
    lectureMarks["Math"] = 2;
    lectureMarks["Angielski"] = 4;
    studentsList[0].lectureMarks = lectureMarks;
    // Drugi student
    studentsList[1].index = 2;
    studentsList[1].name = "Asterix";
    studentsList[1].lastName = "Obeliksowy";
    studentsList[1].semester = 2;
    studentsList[1].lectures[0] = "Matematyka zaawansowana";
    studentsList[1].lectures[1] = "Programowanie zaawansowane";
    studentsList[1].lectures[2] = "Angielski 2";
    lectureMarks["Matematyka zaawansowana"] = 5;
    lectureMarks["Programowanie zaawansowane"] = 5;
    lectureMarks["Angielski 2"] = 3;
    studentsList[1].lectureMarks = lectureMarks;
    // Trzeci student
    studentsList[2].index = 3;
    studentsList[2].name = "Tomasz";
    studentsList[2].lastName = "Palinoga";
    studentsList[2].semester = 4;
    studentsList[2].lectures[0] = "Matematyka zaawansowana";
    studentsList[2].lectures[1] = "Programowanie zaawansowane";
    studentsList[2].lectures[2] = "Angielski 2";
    lectureMarks["Matematyka zaawansowana"] = 5;
    lectureMarks["Programowanie zaawansowane"] = 5;
    lectureMarks["Angielski 2"] = 3;
    studentsList[2].lectureMarks = lectureMarks;
    
    cout << "Witaj w dziekanacie" << endl << endl;
    
    int option, index, numOfStudents = 2, rankPoints;
    while (true) {
        cout << "Co chcesz zrobic?" << endl;
        cout << "1 - wyswietl informacje o danym studencie" << endl;
        cout << "2 - dodaj nowego studenta" << endl;
        cout << "3 - przenies studenta na kolejny semestr" << endl;
        cout << "4 - przygotuj liste rankingowa" << endl;
        cin >> option;
        
        switch (option) {
            case 1:
                cout << "Podaj indeks studenta:" << endl;
                cin >> index;
                printStudentData(studentsList[index]);
                break;
            case 2:
                studentsList[numOfStudents+1] = createStudent();
                numOfStudents++;
                break;
            case 3:
                cout << "Podaj indeks studenta" << endl;
                cin >> index;
                passSemester(studentsList[index]);
                break;
            case 4:
                cout << "Lista:" << endl;
                for (int i = 0; i<=numOfStudents; i++){
                    cout << studentsList[i].name << ":" << endl;
                    for (const auto& pair : studentsList[i].lectureMarks) {
                        cout << "  " << pair.first << ": " << pair.second << endl;
                        rankPoints += pair.second*5;
                    }
                    cout << "Punkty: " << rankPoints << endl;
                }
                break;
            default:
                break;
        }
        
    };
    return 0;
}