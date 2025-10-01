org 100h

MOV AH, 09h    ;
MOV DX, string ;
INT 21h        ;

MOV AH, 02h ;
MOV DL, 0Ah ;
INT 21h     ;

MOV [string + 3], byte '$' ;
MOV AH, 09h                ;
MOV DX, string             ;
INT 21h                    ;

MOV AH, 00h ;
INT 21h     ;


string db "chomik bartus$"