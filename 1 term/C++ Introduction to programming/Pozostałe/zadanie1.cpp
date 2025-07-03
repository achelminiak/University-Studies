#include <iostream>

using namespace std;

int suma (int liczba)
{
int wynik=0;
do
{
wynik=wynik+liczba%10;
liczba=liczba/10;
}
while(liczba!=0);
return wynik;
}

int main ()
{
cout<<suma(148);
}  