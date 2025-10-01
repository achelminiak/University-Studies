org 100h

MOV AH, 0Ah    ;
MOV DX, buffer ;
INT 21h        ;

MOV AH, 02h ;
MOV DL, 0Ah ;
INT 21h     ;

MOV DL, [buffer + 4] ;
INT 21h              ;

MOV AH, 00h ;
INT 21h     ;

buffer db 05h