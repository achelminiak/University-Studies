#!/bin/bash

echo "Gracze:" > polacy.txt
grep "Polska" gracze.txt | grep -E "2020|2021" >> polacy.txt
echo "Ilosc graczy:" >> polacy.txt
grep "Polska" gracze.txt | grep -E "2020|2021" | wc -l >> polacy.txt
