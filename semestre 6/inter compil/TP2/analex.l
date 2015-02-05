%{
#include<stdio.h>
#include<string.h>
#define IF	300
#define THEN	301
#define ELSE	302
#define THROW	303
#define ID	304
%}
%option noyywrap
chiffre		([0-9])

%%

if						{return IF;}
then						{return THEN;}
else						{return ELSE;}
throw						{return THROW;}
[1-9]{chiffre}*					{return DEC;}
0[0-7]*						{return OCT;}
0[xX][0-9a-fA-F]+				{return HEX;}
[a-zA-Z_][a-zA-Z_0-9]*				{return ID;}
([0-9]+\.[0-9]*|\.[0-9]+)([eEdD][+-]?[0-9]+)?	{return FLO;}
([ \t|\n|\r]"//"
.|\n						{return yytext[0];}

%%

main()
{
	int j;
	while(j=yylex())
	{
		printf("jeton=%i ; lexeme=%s\n", j, yytext);
	}
	return 0;
}
