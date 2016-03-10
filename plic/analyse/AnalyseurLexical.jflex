package plic.analyse ;

import java_cup.runtime.*;
import plic.exceptions.AnalyseLexicaleException;
      
%%
   
%class AnalyseurLexical
%public

%line
%column
    
%type Symbol
%eofval{
        return symbol(CodesLexicaux.EOF) ;
%eofval}

%cup

%{
  private Symbol symbol(int type) {
	return new Symbol(type, yyline, yycolumn) ;
  }

  private Symbol symbol(int type, Object value) {
	return new Symbol(type, yyline, yycolumn, value) ;
  }
%}

idf = [a-zA-Z][a-zA-Z0-9]*
csteE = [0-9]+
csteB = "vrai" | "faux"
statut = "publique" | "privee"
type = "entier" | "bool"
chaine = \"([^[\"]]|([\"]{2}))*\"

finDeLigne = \r|\n
espace = {finDeLigne}  | [ \t\f]

commentaireSlashSlash = [/][/].*

%%

"classe"            { return symbol(CodesLexicaux.CLASS); }
"fin"        		{ return symbol(CodesLexicaux.FIN); }
"="                 { return symbol(CodesLexicaux.EGALE); }
"ecrire"            { return symbol(CodesLexicaux.ECRIR); }
"si"				{ return symbol(CodesLexicaux.SI); }
"alors"				{ return symbol(CodesLexicaux.ALORS); }
"{"					{ return symbol(CodesLexicaux.ACCOLADEOUVERT); }
"sinon"				{ return symbol(CodesLexicaux.SINON); }
"}"					{ return symbol(CodesLexicaux.ACCOLADEFERMER); }
"fsi"				{ return symbol(CodesLexicaux.FINSI); }
"+"                	{ return symbol(CodesLexicaux.PLUS); }
"-"                	{ return symbol(CodesLexicaux.MOINS); }
"*"                	{ return symbol(CodesLexicaux.MULT); }
"/"                	{ return symbol(CodesLexicaux.DIV); }

"=="                { return symbol(CodesLexicaux.EGALEGAL); }
"!="                { return symbol(CodesLexicaux.DIFF); }
"<"                	{ return symbol(CodesLexicaux.INF); }
">"                	{ return symbol(CodesLexicaux.SUP); }

"et"                { return symbol(CodesLexicaux.ET); }
"ou"                { return symbol(CodesLexicaux.OU); }
"non"               { return symbol(CodesLexicaux.NON); }
{csteE}      	    { return symbol(CodesLexicaux.CONSTANTEINT, yytext()); }
{csteB}      	    { return symbol(CodesLexicaux.CONSTANTEBOOL, yytext()); }
{chaine}      	    { return symbol(CodesLexicaux.CONSTANTECHAINE, yytext()); }

"("                	{ return symbol(CodesLexicaux.PAROUV); }
")"                	{ return symbol(CodesLexicaux.PARFER); }
","                	{ return symbol(CodesLexicaux.VIRGULE); }
";"                	{ return symbol(CodesLexicaux.POINT_VIRGULE); }

{type}      	    { return symbol(CodesLexicaux.TYPE, yytext()); }
{statut}            { return symbol(CodesLexicaux.STATUT, yytext()); }
{idf}               { return symbol(CodesLexicaux.IDF, yytext()); }

{espace}            { }
{commentaireSlashSlash} 	{}

.                    { throw new AnalyseLexicaleException(yyline, yycolumn, yytext()) ; }
