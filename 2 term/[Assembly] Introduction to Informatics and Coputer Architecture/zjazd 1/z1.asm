org 100h ;

MOV AH, 02h ;
MOV DL, 'A' ;
INT 21h     ;

MOV AH, 02h ;
MOV DL, 'g' ;
INT 21h     ;

MOV AH, 00h ;
INT 21h     ;