org 100h ;

MOV AH, 07h ;
INT 21h     ;

MOV AH, 02h ;
MOV DL, AL  ;
INT 21h     ;

MOV AH, 00h ;
INT 21h     ;