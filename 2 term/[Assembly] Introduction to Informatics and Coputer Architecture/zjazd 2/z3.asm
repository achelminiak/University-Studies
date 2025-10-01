org 100h

MOV AH, 0Ah    ;
MOV DX, buffer ; 
INT 21h        ;

MOV AH, 02h ;
MOV DL, 0Ah ;
INT 21h     ;

MOV BX, [buffer + 1]             ;
MOV BH, 00h                      ;
MOV [buffer + 2 + bx], byte '$'  ;

MOV AH, 09h         ;
MOV DX, buffer + 2  ;
INT 21h             ;

MOV AH, 00h ;
INT 21h     ;

buffer db 15h
