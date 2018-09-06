// Generated from C:/Users/Markus/OneDrive/Bachelor-Arbeitwc/Project/ContractModelling/src/contractmodelling/grammar/FOLZ3.g4 by ANTLR 4.7

	package de.tu_bs.ccc.contracting.core.grammar;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FOLZ3Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		STRING=1, VARIABLE=2, LPAREN=3, NOT=4, RPAREN=5, EQUAL=6, ADD=7, MINUS=8, 
		MULTI=9, DIVISION=10, CHARACTER=11, CONJ=12, DISJ=13, IMPL=14, BICOND=15, 
		GREATER=16, SMALLER=17, SMALLEREQ=18, GREATEREQ=19, TRUE=20, FALSE=21, 
		WHITESPACE=22;
	public static final int
		RULE_condition = 0, RULE_notformula = 1, RULE_formula = 2, RULE_notterm = 3, 
		RULE_term = 4, RULE_operator = 5;
	public static final String[] ruleNames = {
		"condition", "notformula", "formula", "notterm", "term", "operator"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'('", "'!'", "')'", "'='", "'+'", "'-'", "'*'", "'/'", 
		null, "'&'", "'|'", "'->'", "'<>'", "'>>'", "'<<'", "'<='", "'>='", "'TRUE'", 
		"'FALSE'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "STRING", "VARIABLE", "LPAREN", "NOT", "RPAREN", "EQUAL", "ADD", 
		"MINUS", "MULTI", "DIVISION", "CHARACTER", "CONJ", "DISJ", "IMPL", "BICOND", 
		"GREATER", "SMALLER", "SMALLEREQ", "GREATEREQ", "TRUE", "FALSE", "WHITESPACE"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "FOLZ3.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FOLZ3Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ConditionContext extends ParserRuleContext {
		public NotformulaContext notformula() {
			return getRuleContext(NotformulaContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLZ3Listener ) ((FOLZ3Listener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLZ3Listener ) ((FOLZ3Listener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLZ3Visitor ) return ((FOLZ3Visitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			notformula();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotformulaContext extends ParserRuleContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode NOT() { return getToken(FOLZ3Parser.NOT, 0); }
		public NotformulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notformula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLZ3Listener ) ((FOLZ3Listener)listener).enterNotformula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLZ3Listener ) ((FOLZ3Listener)listener).exitNotformula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLZ3Visitor ) return ((FOLZ3Visitor<? extends T>)visitor).visitNotformula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotformulaContext notformula() throws RecognitionException {
		NotformulaContext _localctx = new NotformulaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_notformula);
		try {
			setState(17);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(14);
				formula();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(15);
				match(NOT);
				setState(16);
				formula();
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormulaContext extends ParserRuleContext {
		public List<NottermContext> notterm() {
			return getRuleContexts(NottermContext.class);
		}
		public NottermContext notterm(int i) {
			return getRuleContext(NottermContext.class,i);
		}
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(FOLZ3Parser.LPAREN, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(FOLZ3Parser.RPAREN, 0); }
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLZ3Listener ) ((FOLZ3Listener)listener).enterFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLZ3Listener ) ((FOLZ3Listener)listener).exitFormula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLZ3Visitor ) return ((FOLZ3Visitor<? extends T>)visitor).visitFormula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		FormulaContext _localctx = new FormulaContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_formula);
		try {
			setState(27);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(19);
				notterm();
				setState(20);
				operator();
				setState(21);
				notterm();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(23);
				match(LPAREN);
				setState(24);
				formula();
				setState(25);
				match(RPAREN);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NottermContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode NOT() { return getToken(FOLZ3Parser.NOT, 0); }
		public NottermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notterm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLZ3Listener ) ((FOLZ3Listener)listener).enterNotterm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLZ3Listener ) ((FOLZ3Listener)listener).exitNotterm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLZ3Visitor ) return ((FOLZ3Visitor<? extends T>)visitor).visitNotterm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NottermContext notterm() throws RecognitionException {
		NottermContext _localctx = new NottermContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_notterm);
		try {
			setState(32);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
			case VARIABLE:
			case LPAREN:
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				term();
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(30);
				match(NOT);
				setState(31);
				term();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public TerminalNode VARIABLE() { return getToken(FOLZ3Parser.VARIABLE, 0); }
		public TerminalNode LPAREN() { return getToken(FOLZ3Parser.LPAREN, 0); }
		public TerminalNode MINUS() { return getToken(FOLZ3Parser.MINUS, 0); }
		public TerminalNode RPAREN() { return getToken(FOLZ3Parser.RPAREN, 0); }
		public TerminalNode TRUE() { return getToken(FOLZ3Parser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(FOLZ3Parser.FALSE, 0); }
		public TerminalNode STRING() { return getToken(FOLZ3Parser.STRING, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public NotformulaContext notformula() {
			return getRuleContext(NotformulaContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLZ3Listener ) ((FOLZ3Listener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLZ3Listener ) ((FOLZ3Listener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLZ3Visitor ) return ((FOLZ3Visitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_term);
		try {
			setState(50);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				match(VARIABLE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(35);
				match(LPAREN);
				setState(36);
				match(MINUS);
				setState(37);
				match(VARIABLE);
				setState(38);
				match(RPAREN);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(39);
				match(TRUE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(40);
				match(FALSE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(41);
				match(STRING);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				{
				setState(42);
				match(LPAREN);
				setState(43);
				term();
				setState(44);
				match(RPAREN);
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				{
				setState(46);
				match(LPAREN);
				setState(47);
				notformula();
				setState(48);
				match(RPAREN);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorContext extends ParserRuleContext {
		public TerminalNode GREATER() { return getToken(FOLZ3Parser.GREATER, 0); }
		public TerminalNode SMALLER() { return getToken(FOLZ3Parser.SMALLER, 0); }
		public TerminalNode SMALLEREQ() { return getToken(FOLZ3Parser.SMALLEREQ, 0); }
		public TerminalNode GREATEREQ() { return getToken(FOLZ3Parser.GREATEREQ, 0); }
		public TerminalNode EQUAL() { return getToken(FOLZ3Parser.EQUAL, 0); }
		public TerminalNode CONJ() { return getToken(FOLZ3Parser.CONJ, 0); }
		public TerminalNode DISJ() { return getToken(FOLZ3Parser.DISJ, 0); }
		public TerminalNode IMPL() { return getToken(FOLZ3Parser.IMPL, 0); }
		public TerminalNode BICOND() { return getToken(FOLZ3Parser.BICOND, 0); }
		public TerminalNode MINUS() { return getToken(FOLZ3Parser.MINUS, 0); }
		public TerminalNode MULTI() { return getToken(FOLZ3Parser.MULTI, 0); }
		public TerminalNode DIVISION() { return getToken(FOLZ3Parser.DIVISION, 0); }
		public TerminalNode ADD() { return getToken(FOLZ3Parser.ADD, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLZ3Listener ) ((FOLZ3Listener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLZ3Listener ) ((FOLZ3Listener)listener).exitOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLZ3Visitor ) return ((FOLZ3Visitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL) | (1L << ADD) | (1L << MINUS) | (1L << MULTI) | (1L << DIVISION) | (1L << CONJ) | (1L << DISJ) | (1L << IMPL) | (1L << BICOND) | (1L << GREATER) | (1L << SMALLER) | (1L << SMALLEREQ) | (1L << GREATEREQ))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\309\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\3\3\3\3\3\5\3\24\n\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\36\n\4\3\5\3\5\3\5\5\5#\n\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\65\n\6\3\7"+
		"\3\7\3\7\2\2\b\2\4\6\b\n\f\2\3\4\2\b\f\16\25\2;\2\16\3\2\2\2\4\23\3\2"+
		"\2\2\6\35\3\2\2\2\b\"\3\2\2\2\n\64\3\2\2\2\f\66\3\2\2\2\16\17\5\4\3\2"+
		"\17\3\3\2\2\2\20\24\5\6\4\2\21\22\7\6\2\2\22\24\5\6\4\2\23\20\3\2\2\2"+
		"\23\21\3\2\2\2\24\5\3\2\2\2\25\26\5\b\5\2\26\27\5\f\7\2\27\30\5\b\5\2"+
		"\30\36\3\2\2\2\31\32\7\5\2\2\32\33\5\6\4\2\33\34\7\7\2\2\34\36\3\2\2\2"+
		"\35\25\3\2\2\2\35\31\3\2\2\2\36\7\3\2\2\2\37#\5\n\6\2 !\7\6\2\2!#\5\n"+
		"\6\2\"\37\3\2\2\2\" \3\2\2\2#\t\3\2\2\2$\65\7\4\2\2%&\7\5\2\2&\'\7\n\2"+
		"\2\'(\7\4\2\2(\65\7\7\2\2)\65\7\26\2\2*\65\7\27\2\2+\65\7\3\2\2,-\7\5"+
		"\2\2-.\5\n\6\2./\7\7\2\2/\65\3\2\2\2\60\61\7\5\2\2\61\62\5\4\3\2\62\63"+
		"\7\7\2\2\63\65\3\2\2\2\64$\3\2\2\2\64%\3\2\2\2\64)\3\2\2\2\64*\3\2\2\2"+
		"\64+\3\2\2\2\64,\3\2\2\2\64\60\3\2\2\2\65\13\3\2\2\2\66\67\t\2\2\2\67"+
		"\r\3\2\2\2\6\23\35\"\64";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}