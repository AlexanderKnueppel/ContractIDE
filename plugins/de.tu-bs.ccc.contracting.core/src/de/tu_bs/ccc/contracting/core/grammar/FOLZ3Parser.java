// Generated from FOLZ3.g4 by ANTLR 4.7.1

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
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, FORALL=3, EXISTS=4, STRING=5, VARIABLE=6, LPAREN=7, NOT=8, 
		RPAREN=9, POWER=10, EQUAL=11, ADD=12, MINUS=13, MULTI=14, DIVISION=15, 
		CHARACTER=16, CONJ=17, DISJ=18, IMPL=19, BICOND=20, GREATER=21, SMALLER=22, 
		SMALLEREQ=23, GREATEREQ=24, TRUE=25, FALSE=26, WHITESPACE=27;
	public static final int
		RULE_condition = 0, RULE_formula = 1, RULE_connectiveformula = 2, RULE_compareformula = 3, 
		RULE_summformula = 4, RULE_faktorformula = 5, RULE_powerformula = 6, RULE_notterm = 7, 
		RULE_term = 8, RULE_compoperator = 9, RULE_multoperator = 10, RULE_addoperator = 11, 
		RULE_connectoperator = 12, RULE_pred_constant = 13;
	public static final String[] ruleNames = {
		"condition", "formula", "connectiveformula", "compareformula", "summformula", 
		"faktorformula", "powerformula", "notterm", "term", "compoperator", "multoperator", 
		"addoperator", "connectoperator", "pred_constant"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'_'", "'Forall'", "'Exists'", null, null, "'('", "'!'", 
		"')'", "'^'", "'='", "'+'", "'-'", "'*'", "'/'", null, "'&'", "'|'", "'->'", 
		"'<>'", "'>'", "'<'", "'<='", "'>='", "'TRUE'", "'FALSE'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "FORALL", "EXISTS", "STRING", "VARIABLE", "LPAREN", 
		"NOT", "RPAREN", "POWER", "EQUAL", "ADD", "MINUS", "MULTI", "DIVISION", 
		"CHARACTER", "CONJ", "DISJ", "IMPL", "BICOND", "GREATER", "SMALLER", "SMALLEREQ", 
		"GREATEREQ", "TRUE", "FALSE", "WHITESPACE"
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
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
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
			setState(28);
			formula();
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
		public ConnectiveformulaContext connectiveformula() {
			return getRuleContext(ConnectiveformulaContext.class,0);
		}
		public TerminalNode FORALL() { return getToken(FOLZ3Parser.FORALL, 0); }
		public TerminalNode LPAREN() { return getToken(FOLZ3Parser.LPAREN, 0); }
		public TerminalNode VARIABLE() { return getToken(FOLZ3Parser.VARIABLE, 0); }
		public TerminalNode RPAREN() { return getToken(FOLZ3Parser.RPAREN, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode EXISTS() { return getToken(FOLZ3Parser.EXISTS, 0); }
		public Pred_constantContext pred_constant() {
			return getRuleContext(Pred_constantContext.class,0);
		}
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLZ3Visitor ) return ((FOLZ3Visitor<? extends T>)visitor).visitFormula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		FormulaContext _localctx = new FormulaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_formula);
		int _la;
		try {
			setState(53);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
			case VARIABLE:
			case LPAREN:
			case NOT:
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				connectiveformula();
				}
				break;
			case FORALL:
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				match(FORALL);
				setState(32);
				match(LPAREN);
				setState(33);
				match(VARIABLE);
				setState(34);
				match(RPAREN);
				setState(35);
				formula();
				}
				break;
			case EXISTS:
				enterOuterAlt(_localctx, 3);
				{
				setState(36);
				match(EXISTS);
				setState(37);
				match(LPAREN);
				setState(38);
				match(VARIABLE);
				setState(39);
				match(RPAREN);
				setState(40);
				formula();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 4);
				{
				setState(41);
				pred_constant();
				setState(42);
				match(LPAREN);
				setState(43);
				term();
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(44);
					match(T__0);
					setState(45);
					term();
					}
					}
					setState(50);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(51);
				match(RPAREN);
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

	public static class ConnectiveformulaContext extends ParserRuleContext {
		public List<CompareformulaContext> compareformula() {
			return getRuleContexts(CompareformulaContext.class);
		}
		public CompareformulaContext compareformula(int i) {
			return getRuleContext(CompareformulaContext.class,i);
		}
		public List<ConnectoperatorContext> connectoperator() {
			return getRuleContexts(ConnectoperatorContext.class);
		}
		public ConnectoperatorContext connectoperator(int i) {
			return getRuleContext(ConnectoperatorContext.class,i);
		}
		public ConnectiveformulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_connectiveformula; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLZ3Visitor ) return ((FOLZ3Visitor<? extends T>)visitor).visitConnectiveformula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConnectiveformulaContext connectiveformula() throws RecognitionException {
		ConnectiveformulaContext _localctx = new ConnectiveformulaContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_connectiveformula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(55);
			compareformula();
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONJ) | (1L << DISJ) | (1L << IMPL) | (1L << BICOND))) != 0)) {
				{
				{
				setState(56);
				connectoperator();
				setState(57);
				compareformula();
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class CompareformulaContext extends ParserRuleContext {
		public List<SummformulaContext> summformula() {
			return getRuleContexts(SummformulaContext.class);
		}
		public SummformulaContext summformula(int i) {
			return getRuleContext(SummformulaContext.class,i);
		}
		public List<CompoperatorContext> compoperator() {
			return getRuleContexts(CompoperatorContext.class);
		}
		public CompoperatorContext compoperator(int i) {
			return getRuleContext(CompoperatorContext.class,i);
		}
		public CompareformulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compareformula; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLZ3Visitor ) return ((FOLZ3Visitor<? extends T>)visitor).visitCompareformula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompareformulaContext compareformula() throws RecognitionException {
		CompareformulaContext _localctx = new CompareformulaContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_compareformula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(64);
			summformula();
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL) | (1L << GREATER) | (1L << SMALLER) | (1L << SMALLEREQ) | (1L << GREATEREQ))) != 0)) {
				{
				{
				setState(65);
				compoperator();
				setState(66);
				summformula();
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class SummformulaContext extends ParserRuleContext {
		public List<FaktorformulaContext> faktorformula() {
			return getRuleContexts(FaktorformulaContext.class);
		}
		public FaktorformulaContext faktorformula(int i) {
			return getRuleContext(FaktorformulaContext.class,i);
		}
		public List<AddoperatorContext> addoperator() {
			return getRuleContexts(AddoperatorContext.class);
		}
		public AddoperatorContext addoperator(int i) {
			return getRuleContext(AddoperatorContext.class,i);
		}
		public SummformulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_summformula; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLZ3Visitor ) return ((FOLZ3Visitor<? extends T>)visitor).visitSummformula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SummformulaContext summformula() throws RecognitionException {
		SummformulaContext _localctx = new SummformulaContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_summformula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(73);
			faktorformula();
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==MINUS) {
				{
				{
				setState(74);
				addoperator();
				setState(75);
				faktorformula();
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class FaktorformulaContext extends ParserRuleContext {
		public List<PowerformulaContext> powerformula() {
			return getRuleContexts(PowerformulaContext.class);
		}
		public PowerformulaContext powerformula(int i) {
			return getRuleContext(PowerformulaContext.class,i);
		}
		public List<MultoperatorContext> multoperator() {
			return getRuleContexts(MultoperatorContext.class);
		}
		public MultoperatorContext multoperator(int i) {
			return getRuleContext(MultoperatorContext.class,i);
		}
		public FaktorformulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_faktorformula; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLZ3Visitor ) return ((FOLZ3Visitor<? extends T>)visitor).visitFaktorformula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FaktorformulaContext faktorformula() throws RecognitionException {
		FaktorformulaContext _localctx = new FaktorformulaContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_faktorformula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(82);
			powerformula();
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULTI || _la==DIVISION) {
				{
				{
				setState(83);
				multoperator();
				setState(84);
				powerformula();
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class PowerformulaContext extends ParserRuleContext {
		public List<NottermContext> notterm() {
			return getRuleContexts(NottermContext.class);
		}
		public NottermContext notterm(int i) {
			return getRuleContext(NottermContext.class,i);
		}
		public List<TerminalNode> POWER() { return getTokens(FOLZ3Parser.POWER); }
		public TerminalNode POWER(int i) {
			return getToken(FOLZ3Parser.POWER, i);
		}
		public PowerformulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_powerformula; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLZ3Visitor ) return ((FOLZ3Visitor<? extends T>)visitor).visitPowerformula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PowerformulaContext powerformula() throws RecognitionException {
		PowerformulaContext _localctx = new PowerformulaContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_powerformula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(91);
			notterm();
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==POWER) {
				{
				{
				setState(92);
				match(POWER);
				setState(93);
				notterm();
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLZ3Visitor ) return ((FOLZ3Visitor<? extends T>)visitor).visitNotterm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NottermContext notterm() throws RecognitionException {
		NottermContext _localctx = new NottermContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_notterm);
		try {
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
			case VARIABLE:
			case LPAREN:
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				term();
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(100);
				match(NOT);
				setState(101);
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
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLZ3Visitor ) return ((FOLZ3Visitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_term);
		try {
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				match(VARIABLE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(105);
				match(LPAREN);
				setState(106);
				match(MINUS);
				setState(107);
				match(VARIABLE);
				setState(108);
				match(RPAREN);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(109);
				match(TRUE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(110);
				match(FALSE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(111);
				match(STRING);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				{
				setState(112);
				match(LPAREN);
				setState(113);
				term();
				setState(114);
				match(RPAREN);
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				{
				setState(116);
				match(LPAREN);
				setState(117);
				formula();
				setState(118);
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

	public static class CompoperatorContext extends ParserRuleContext {
		public TerminalNode GREATER() { return getToken(FOLZ3Parser.GREATER, 0); }
		public TerminalNode SMALLER() { return getToken(FOLZ3Parser.SMALLER, 0); }
		public TerminalNode SMALLEREQ() { return getToken(FOLZ3Parser.SMALLEREQ, 0); }
		public TerminalNode GREATEREQ() { return getToken(FOLZ3Parser.GREATEREQ, 0); }
		public TerminalNode EQUAL() { return getToken(FOLZ3Parser.EQUAL, 0); }
		public CompoperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoperator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLZ3Visitor ) return ((FOLZ3Visitor<? extends T>)visitor).visitCompoperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompoperatorContext compoperator() throws RecognitionException {
		CompoperatorContext _localctx = new CompoperatorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_compoperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL) | (1L << GREATER) | (1L << SMALLER) | (1L << SMALLEREQ) | (1L << GREATEREQ))) != 0)) ) {
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

	public static class MultoperatorContext extends ParserRuleContext {
		public TerminalNode MULTI() { return getToken(FOLZ3Parser.MULTI, 0); }
		public TerminalNode DIVISION() { return getToken(FOLZ3Parser.DIVISION, 0); }
		public MultoperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multoperator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLZ3Visitor ) return ((FOLZ3Visitor<? extends T>)visitor).visitMultoperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultoperatorContext multoperator() throws RecognitionException {
		MultoperatorContext _localctx = new MultoperatorContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_multoperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_la = _input.LA(1);
			if ( !(_la==MULTI || _la==DIVISION) ) {
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

	public static class AddoperatorContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(FOLZ3Parser.MINUS, 0); }
		public TerminalNode ADD() { return getToken(FOLZ3Parser.ADD, 0); }
		public AddoperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addoperator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLZ3Visitor ) return ((FOLZ3Visitor<? extends T>)visitor).visitAddoperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddoperatorContext addoperator() throws RecognitionException {
		AddoperatorContext _localctx = new AddoperatorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_addoperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			_la = _input.LA(1);
			if ( !(_la==ADD || _la==MINUS) ) {
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

	public static class ConnectoperatorContext extends ParserRuleContext {
		public TerminalNode CONJ() { return getToken(FOLZ3Parser.CONJ, 0); }
		public TerminalNode DISJ() { return getToken(FOLZ3Parser.DISJ, 0); }
		public TerminalNode IMPL() { return getToken(FOLZ3Parser.IMPL, 0); }
		public TerminalNode BICOND() { return getToken(FOLZ3Parser.BICOND, 0); }
		public ConnectoperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_connectoperator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLZ3Visitor ) return ((FOLZ3Visitor<? extends T>)visitor).visitConnectoperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConnectoperatorContext connectoperator() throws RecognitionException {
		ConnectoperatorContext _localctx = new ConnectoperatorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_connectoperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONJ) | (1L << DISJ) | (1L << IMPL) | (1L << BICOND))) != 0)) ) {
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

	public static class Pred_constantContext extends ParserRuleContext {
		public List<TerminalNode> CHARACTER() { return getTokens(FOLZ3Parser.CHARACTER); }
		public TerminalNode CHARACTER(int i) {
			return getToken(FOLZ3Parser.CHARACTER, i);
		}
		public Pred_constantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pred_constant; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLZ3Visitor ) return ((FOLZ3Visitor<? extends T>)visitor).visitPred_constant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pred_constantContext pred_constant() throws RecognitionException {
		Pred_constantContext _localctx = new Pred_constantContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pred_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(T__1);
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CHARACTER) {
				{
				{
				setState(131);
				match(CHARACTER);
				}
				}
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35\u008c\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\61\n\3\f\3\16\3\64\13"+
		"\3\3\3\3\3\5\38\n\3\3\4\3\4\3\4\3\4\7\4>\n\4\f\4\16\4A\13\4\3\5\3\5\3"+
		"\5\3\5\7\5G\n\5\f\5\16\5J\13\5\3\6\3\6\3\6\3\6\7\6P\n\6\f\6\16\6S\13\6"+
		"\3\7\3\7\3\7\3\7\7\7Y\n\7\f\7\16\7\\\13\7\3\b\3\b\3\b\7\ba\n\b\f\b\16"+
		"\bd\13\b\3\t\3\t\3\t\5\ti\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\5\n{\n\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\17\3\17\7\17\u0087\n\17\f\17\16\17\u008a\13\17\3\17\2\2\20\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\2\6\4\2\r\r\27\32\3\2\20\21\3\2\16\17\3\2"+
		"\23\26\2\u008e\2\36\3\2\2\2\4\67\3\2\2\2\69\3\2\2\2\bB\3\2\2\2\nK\3\2"+
		"\2\2\fT\3\2\2\2\16]\3\2\2\2\20h\3\2\2\2\22z\3\2\2\2\24|\3\2\2\2\26~\3"+
		"\2\2\2\30\u0080\3\2\2\2\32\u0082\3\2\2\2\34\u0084\3\2\2\2\36\37\5\4\3"+
		"\2\37\3\3\2\2\2 8\5\6\4\2!\"\7\5\2\2\"#\7\t\2\2#$\7\b\2\2$%\7\13\2\2%"+
		"8\5\4\3\2&\'\7\6\2\2\'(\7\t\2\2()\7\b\2\2)*\7\13\2\2*8\5\4\3\2+,\5\34"+
		"\17\2,-\7\t\2\2-\62\5\22\n\2./\7\3\2\2/\61\5\22\n\2\60.\3\2\2\2\61\64"+
		"\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\65\3\2\2\2\64\62\3\2\2\2\65\66"+
		"\7\13\2\2\668\3\2\2\2\67 \3\2\2\2\67!\3\2\2\2\67&\3\2\2\2\67+\3\2\2\2"+
		"8\5\3\2\2\29?\5\b\5\2:;\5\32\16\2;<\5\b\5\2<>\3\2\2\2=:\3\2\2\2>A\3\2"+
		"\2\2?=\3\2\2\2?@\3\2\2\2@\7\3\2\2\2A?\3\2\2\2BH\5\n\6\2CD\5\24\13\2DE"+
		"\5\n\6\2EG\3\2\2\2FC\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2I\t\3\2\2\2"+
		"JH\3\2\2\2KQ\5\f\7\2LM\5\30\r\2MN\5\f\7\2NP\3\2\2\2OL\3\2\2\2PS\3\2\2"+
		"\2QO\3\2\2\2QR\3\2\2\2R\13\3\2\2\2SQ\3\2\2\2TZ\5\16\b\2UV\5\26\f\2VW\5"+
		"\16\b\2WY\3\2\2\2XU\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\r\3\2\2\2"+
		"\\Z\3\2\2\2]b\5\20\t\2^_\7\f\2\2_a\5\20\t\2`^\3\2\2\2ad\3\2\2\2b`\3\2"+
		"\2\2bc\3\2\2\2c\17\3\2\2\2db\3\2\2\2ei\5\22\n\2fg\7\n\2\2gi\5\22\n\2h"+
		"e\3\2\2\2hf\3\2\2\2i\21\3\2\2\2j{\7\b\2\2kl\7\t\2\2lm\7\17\2\2mn\7\b\2"+
		"\2n{\7\13\2\2o{\7\33\2\2p{\7\34\2\2q{\7\7\2\2rs\7\t\2\2st\5\22\n\2tu\7"+
		"\13\2\2u{\3\2\2\2vw\7\t\2\2wx\5\4\3\2xy\7\13\2\2y{\3\2\2\2zj\3\2\2\2z"+
		"k\3\2\2\2zo\3\2\2\2zp\3\2\2\2zq\3\2\2\2zr\3\2\2\2zv\3\2\2\2{\23\3\2\2"+
		"\2|}\t\2\2\2}\25\3\2\2\2~\177\t\3\2\2\177\27\3\2\2\2\u0080\u0081\t\4\2"+
		"\2\u0081\31\3\2\2\2\u0082\u0083\t\5\2\2\u0083\33\3\2\2\2\u0084\u0088\7"+
		"\4\2\2\u0085\u0087\7\22\2\2\u0086\u0085\3\2\2\2\u0087\u008a\3\2\2\2\u0088"+
		"\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\35\3\2\2\2\u008a\u0088\3\2\2"+
		"\2\f\62\67?HQZbhz\u0088";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}