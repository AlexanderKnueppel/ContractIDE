grammar FOLZ3;

@header {
	package de.tu_bs.ccc.contracting.core.verification.grammar;

}

condition
:
	formula
;

formula
:
	connectiveformula
	| FORALL LPAREN VARIABLE
	(
		',' formula
	)? RPAREN LPAREN formula RPAREN
	| EXISTS LPAREN VARIABLE
	(
		',' formula
	)? RPAREN LPAREN formula RPAREN
	| pred_constant LPAREN term
	(
		',' term
	)* RPAREN
;

connectiveformula
:
	(
		compareformula
		(
			connectoperator compareformula
		)*
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
	(
		COMPONENT? CODEWORD? VARIABLE
		(
			'[' VARIABLE ']'
		)?
		(
			'.\\' VARIABLE
		)?
	)
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

CODEWORD
:
	'.$'
;

NULL
:
	'\\null'
;

FORALL
:
	'\\forall'
;

COMPONENT
:
	'\\super'
	| '\\this'
;


EXISTS
:
	'\\exists'
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
	'=='
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
	'\\true'
;

FALSE
:
	'\\false'
;

WHITESPACE
:
	(
		' '
		| '\t'
	)+ -> skip
; 
