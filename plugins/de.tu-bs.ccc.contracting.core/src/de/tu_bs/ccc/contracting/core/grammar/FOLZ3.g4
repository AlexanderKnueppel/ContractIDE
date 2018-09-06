grammar FOLZ3;

@header {
	package contractmodelling.grammar;

}

condition
:
	
		notformula
	
;
notformula:
	formula |
	(NOT formula)
	;
formula
:
	(notterm operator notterm)|
	(LPAREN formula RPAREN)
;

notterm
:	term |
	(NOT term)
;

term
:	
	VARIABLE
	|(LPAREN MINUS VARIABLE RPAREN)
	| TRUE
	| FALSE
	| STRING
	| (LPAREN term RPAREN)
	| (LPAREN notformula RPAREN)
;

operator
:
	GREATER
	| SMALLER
	| SMALLEREQ
	| GREATEREQ
	| EQUAL
	| CONJ
	| DISJ
	| IMPL
	| BICOND
	| MINUS
	| MULTI
	| DIVISION
	| ADD
;


STRING
:	'"' CHARACTER+ '"'
;

VARIABLE
:	CHARACTER+
;



LPAREN
:	'('
;

NOT
:	'!'
;

RPAREN
:	')'
;

EQUAL
:	'='
;
ADD
:	'+'
;
MINUS
:	'-'
;
MULTI
:	'*'
;
DIVISION
:
	'/'
;



CHARACTER
:			 [0-9] | [A-Z]	| [a-z]	| '.'	
;

CONJ
:'&'
;

DISJ
:'|'
;

IMPL
:'->'
;

BICOND
:'<>'
;

GREATER
:'>>'
;

SMALLER
:'<<'
;

SMALLEREQ
:'<='
;

GREATEREQ
:'>='
;

TRUE
:'TRUE'
;

FALSE
:'FALSE'
;

WHITESPACE
:(
	' '|'\t'
	)+ -> skip
; 
