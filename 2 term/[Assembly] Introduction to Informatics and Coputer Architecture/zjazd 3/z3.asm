; Napisz programik, który w pętli będzie przyjmował i od razu wypisywał przyjęte znaki, ale jeśli wprowadzony zostanie znak Q to się zakończy.

org 100h

input:
mov AH, 0Ah
mov DX, character
int 21h
mov BX, [character + 2]
mov AH, 02h
mov DL, 0Ah
int 21h

comparing:
cmp BL, 51h
jg input
jl input
je exit

exit:
mov AH, 00h
int 21h

character db 02h