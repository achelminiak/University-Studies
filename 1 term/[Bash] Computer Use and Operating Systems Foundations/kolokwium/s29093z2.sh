#!/bin/bash

if [ $# -ne 2 ];
then
	echo podaj 2 liczby naturalne
fi

liczba1=$1
liczba2=$2

if [ $liczba2 -lt $liczba1 ];
then 
	echo pierwsza liczba musi być większa od drugiej
elif [ $liczba1 -le 20 ] || [ $liczba2 -le 20 ]
then
	echo obie liczby muszą być większe niż 20
else
for ((i=$liczba1+1; i<$liczba2; i++))
	do
		echo $i
	done
fi
