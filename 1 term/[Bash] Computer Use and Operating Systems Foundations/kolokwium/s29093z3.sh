#!/bin/bash

index=3
if [ $1 = "a" ];
then
	echo $(( $index + $2 ))
elif [ $1 = "s" ];
then
	echo $(( $2 - $index ))
elif [ $1 = "m" ];
then
	echo $(( $2 * $index ))
else
	echo zle parametry
fi 

cd ~
content='ls'
