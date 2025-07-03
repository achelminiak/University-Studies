#include <iostream>
using namespace::std;

int li1, li2;

int nwd(int liczba1, int liczba2){
    if (liczba1%liczba2 != 0) {
        li1 = liczba2;
        li2 = liczba1%liczba2;
        nwd(li1, li2);
    } else {return li2;}  
}

int main() {
    int liczba, liczba2;
    
    cout << "Podaj liczby do nwd" << endl;
    cout << "liczba: ";
    cin >> liczba;
    cout << endl << "liczba: ";
    cin >> liczba2;
    
    cout << nwd(liczba, liczba2);
    return 0;
}