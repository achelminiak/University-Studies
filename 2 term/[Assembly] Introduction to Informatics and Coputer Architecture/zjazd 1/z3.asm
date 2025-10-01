org 100h ;

MOV AH, 02h ;
MOV DH, 00h ;
MOV DL, 00h ;
INT 10h     ;

MOV AH, 02h ;
MOV DL, 'A' ;
INT 21h     ;

MOV AH, 00h ;
INT 21h     ;