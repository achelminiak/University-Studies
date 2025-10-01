; Zmodyfikuj programik tak, aby rozpoznawał wielkie i małe litery. Wielkie litery mają kody ASCII 41h-5Ah, a małe 61h-7Ah. 
; Program powinien drukować informacje zwrotną, np. „wielka litera”, „mala litera”, „error”

org 100h

mov AH, 0Ah
mov DX, character
int 21h
mov BX, [character + 2]

cmp BL, 41h
jge firstCheck
jl error

exit:
mov AH, 00h
int 21h

firstCheck:
cmp BL, 5Ah
jle big
jg secondCheck 

secondCheck:
cmp BL, 61h
jge thirdCheck
jl error

thirdCheck:
cmp BL, 7Ah
jle small
jg error

small:
mov AH, 02h
mov DL, 0Ah
int 21h
mov AH, 09h
mov DX, smallLetter
int 21h
jmp exit

big:
mov AH, 02h
mov DL, 0Ah
int 21h
mov AH, 09h
mov DX, bigLetter
int 21h
jmp exit

error:
mov AH, 02h
mov DL, 0Ah
int 21h
mov AH, 09h
mov DX, errorSign
int 21h
jmp exit

character db 02h
dunno db "dunno$"
errorSign db "error$"
bigLetter db "wielka litera$"
smallLetter db "mala litera$"