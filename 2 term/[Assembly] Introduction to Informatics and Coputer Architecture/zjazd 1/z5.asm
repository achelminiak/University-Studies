org 100h ;

MOV AH, 02h ;
MOV DH, 12 ;
MOV DL, 39 ;
INT 10h     ;

MOV AH, 02h ;
MOV DL, 'C' ;
INT 21h     ;


MOV AH, 00h ;
INT 21h     ;