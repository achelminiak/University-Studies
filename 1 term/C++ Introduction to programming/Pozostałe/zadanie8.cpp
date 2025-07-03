#include <iostream>
#include <cmath>

using namespace::std;

int main() {
    
    int x,y,x2,y2,x3,y3;
    cout << "Podaj x:" << endl;
    cin >> x;
    cout << "Podaj y:" << endl;
    cin >> y;
    
    cout << "Podaj x2:" << endl;
    cin >> x2;
    cout << "Podaj y2:" << endl;
    cin >> y2;
    
    cout << "Podaj x3:" << endl;
    cin >> x3;
    cout << "Podaj y3:" << endl;
    cin >> y3;
    
    cout << endl << "Wykres:" << endl;
    
    // Drukowanie osi Y oraz drukowanie * w odpowiednim miejscu
    for (int j = 10; j >= -10; j--){
        // Drukowanie osi Y i dodawanie odpowiedniej ilosci spacji aby liczby byly wyrownane
        if (j >= 0 && j < 10){
            cout << endl << " " << " "<< j;
        } else cout << endl << " " << j;
        // Jesli obecna wysokosc na osi Y rowna sie punktowi Y podanemu przez uzytkownika zacznij drukowac *
        if (j == y){
            // Petla drukujaca odpowiednia ilsoc spacji aby gwiazdka znalazla sie na swoim miejscu 
            for (int print = -9; print < x; print++){
                if (print < 0){
                    cout << " " << " " << " ";
                } else cout << " " << " ";
            }
            cout << " " << "*";
        }
        
        
        if (j == y2){
            if (y != y2 || y != y3){
                // Petla drukujaca odpowiednia ilsoc spacji aby gwiazdka znalazla sie na swoim miejscu 
                for (int print = -9; print < x2; print++){
                    if (print < 0){
                        cout << " " << " " << " ";
                    } else cout << " " << " ";
                }
            }
            cout << " " << "*";
        }
        
        if (j == y3){
            if (y != y2 || y != y3){
                // Petla drukujaca odpowiednia ilsoc spacji aby gwiazdka znalazla sie na swoim miejscu 
                for (int print = -9; print < x2; print++){
                    if (print < 0){
                        cout << " " << " " << " ";
                    } else cout << " " << " ";
                }
            }
            cout << " " << "*";
        }
        
    }
    // Drukowanie dolnej osi X
    for (int i = -9; i <= 10; i++){
        if (i > -9 && i < 10){
            cout << " "<< i;
        } else cout << i;
    }
    
    double dx = x2 - x;
    double dy = y2 - y;
    double point1_point2 = sqrt(dx * dx + dy * dy);
    cout << endl << "Odleglosc pomiedzy zadanymi punktami (x,y) a (x2,y2): "<< sqrt(dx * dx + dy * dy);
    
    dx = x3 - x;
    dy = y3 - y;
    double point1_point3 = sqrt(dx * dx + dy * dy);
    cout << endl << "Odleglosc pomiedzy zadanymi punktami (x,y) a (x3,y3): "<< sqrt(dx * dx + dy * dy);
    
    
    dx = x3 - x2;
    dy = y3 - y2;
    double point2_point3 = sqrt(dx * dx + dy * dy);
    cout << endl << "Odleglosc pomiedzy zadanymi punktami (x2,y2) a (x3,y3): "<< sqrt(dx * dx + dy * dy);
    
    if (point1_point2 > point1_point3 && point1_point2 > point2_point3) {
        cout << endl << "Najwieksza odleglosc jest pomiedzy punktami: (" << x << "," << y << ")" << "(" << x2 << "," << y2 << ")";
    }
    if (point1_point3 > point1_point2 && point1_point3 > point2_point3) {
        cout << endl << "Najwieksza odleglosc jest pomiedzy punktami: (" << x << "," << y << ")" << "(" << x3 << "," << y3 << ")";
    }
    if (point2_point3 > point1_point3 && point2_point3 > point1_point2) {
        cout << endl << "Najwieksza odleglosc jest pomiedzy punktami: (" << x2 << "," << y2 << ")" << "(" << x3 << "," << y3 << ")";
    }
    
    if ((y != y2 && y2 != y3) || (x != x2 && x2 != x3)) {
        cout << endl << "Tworza trojkat";
    } else cout << endl << "Nie tworza trojkata";
    

    return 0;
}