grammar FOLZ3;

@header {
	package de.tu_bs.ccc.contracting.core.grammar;

}

condition
:
	formula
;

formula
:
	connectiveformula
	| FORALL LPAREN VARIABLE RPAREN formula
	| EXISTS LPAREN VARIABLE RPAREN formula
	| pred_constant LPAREN term
	(
		',' term
	)* RPAREN
;

connectiveformula
:
	(
		compareformula (connectoperator compareformula)*
	)
;

compareformula
:
	(
		summformula
		(
			compoperator summformula
		)*
	)
;

summformula
:
	(
		faktorformula
		(
			addoperator faktorformula
		)*
	)
;

faktorformula
:
	(
		powerformula
		(
			multoperator powerformula
		)*
	)
;

powerformula
:
	(
		notterm
		( 
			POWER notterm
		)*
	)
;

notterm
:
	term
	|
	(
		NOT term
	)
;

term
:
	VARIABLE
	|
	(
		LPAREN MINUS VARIABLE RPAREN
	)
	| TRUE
	| FALSE
	| STRING
	|
	(
		LPAREN term RPAREN
	)
	|
	(
		LPAREN formula RPAREN
	)

;

compoperator
:
	GREATER
	| SMALLER
	| SMALLEREQ
	| GREATEREQ
	| EQUAL
;

multoperator
:
	MULTI
	| DIVISION
;

addoperator
:
	MINUS
	| ADD
;

connectoperator
:
	CONJ
	| DISJ
	| IMPL
	| BICOND
;

pred_constant
:
	'_' CHARACTER*
;
FORALL
:
	'Forall'
;

EXISTS
:
	'Exists'
;

STRING
:
	'"' CHARACTER+ '"'
;

VARIABLE
:
	CHARACTER+
;

LPAREN
:
	'('
;

NOT
:
	'!'
;


RPAREN
:
	')'
;

POWER
:
	'^'
;

EQUAL
:
	'='
;

ADD
:
	'+'
;

MINUS
:
	'-'
;

MULTI
:
	'*'
;

DIVISION
:
	'/'
;

CHARACTER
:
	[0-9]
	| [A-Z]
	| [a-z]
	| '.'
;

CONJ
:
	'&'
;

DISJ
:
	'|'
;

IMPL
:
	'->'
;

BICOND
:
	'<>'
;

GREATER
:
	'>'
;

SMALLER
:
	'<'
;

SMALLEREQ
:
	'<='
;

GREATEREQ
:
	'>='
;

TRUE
:
	'TRUE'
;

FALSE
:
	'FALSE'
;

WHITESPACE
:
	(
		' '
		| '\t'
	)+ -> skip
; 
