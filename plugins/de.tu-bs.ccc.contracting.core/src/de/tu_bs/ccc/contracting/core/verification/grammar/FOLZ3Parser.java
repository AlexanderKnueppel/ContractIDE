// Generated from FOLZ3.g4 by ANTLR 4.7.1

	package de.tu_bs.ccc.contracting.core.verification.grammar;


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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, CODEWORD=6, NULL=7, FORALL=8, 
		COMPONENT=9, EXISTS=10, STRING=11, VARIABLE=12, LPAREN=13, NOT=14, RPAREN=15, 
		POWER=16, EQUAL=17, ADD=18, MINUS=19, MULTI=20, DIVISION=21, CHARACTER=22, 
		CONJ=23, DISJ=24, IMPL=25, BICOND=26, GREATER=27, SMALLER=28, SMALLEREQ=29, 
		GREATEREQ=30, TRUE=31, FALSE=32, WHITESPACE=33;
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
		null, "','", "'['", "']'", "'.\\'", "'_'", "'.$'", "'\\null'", "'\\forall'", 
		null, "'\\exists'", null, null, "'('", "'!'", "')'", "'^'", "'=='", "'+'", 
		"'-'", "'*'", "'/'", null, "'&'", "'|'", "'->'", "'<>'", "'>'", "'<'", 
		"'<='", "'>='", "'\\true'", "'\\false'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "CODEWORD", "NULL", "FORALL", "COMPONENT", 
		"EXISTS", "STRING", "VARIABLE", "LPAREN", "NOT", "RPAREN", "POWER", "EQUAL", 
		"ADD", "MINUS", "MULTI", "DIVISION", "CHARACTER", "CONJ", "DISJ", "IMPL", 
		"BICOND", "GREATER", "SMALLER", "SMALLEREQ", "GREATEREQ", "TRUE", "FALSE", 
		"WHITESPACE"
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
		public List<TerminalNode> LPAREN() { return getTokens(FOLZ3Parser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(FOLZ3Parser.LPAREN, i);
		}
		public TerminalNode VARIABLE() { return getToken(FOLZ3Parser.VARIABLE, 0); }
		public List<TerminalNode> RPAREN() { return getTokens(FOLZ3Parser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(FOLZ3Parser.RPAREN, i);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
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
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CODEWORD:
			case COMPONENT:
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
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(34);
					match(T__0);
					setState(35);
					formula();
					}
				}

				setState(38);
				match(RPAREN);
				setState(39);
				match(LPAREN);
				setState(40);
				formula();
				setState(41);
				match(RPAREN);
				}
				break;
			case EXISTS:
				enterOuterAlt(_localctx, 3);
				{
				setState(43);
				match(EXISTS);
				setState(44);
				match(LPAREN);
				setState(45);
				match(VARIABLE);
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(46);
					match(T__0);
					setState(47);
					formula();
					}
				}

				setState(50);
				match(RPAREN);
				setState(51);
				match(LPAREN);
				setState(52);
				formula();
				setState(53);
				match(RPAREN);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 4);
				{
				setState(55);
				pred_constant();
				setState(56);
				match(LPAREN);
				setState(57);
				term();
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(58);
					match(T__0);
					setState(59);
					term();
					}
					}
					setState(64);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(65);
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
			setState(69);
			compareformula();
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONJ) | (1L << DISJ) | (1L << IMPL) | (1L << BICOND))) != 0)) {
				{
				{
				setState(70);
				connectoperator();
				setState(71);
				compareformula();
				}
				}
				setState(77);
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
			setState(78);
			summformula();
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL) | (1L << GREATER) | (1L << SMALLER) | (1L << SMALLEREQ) | (1L << GREATEREQ))) != 0)) {
				{
				{
				setState(79);
				compoperator();
				setState(80);
				summformula();
				}
				}
				setState(86);
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
			setState(87);
			faktorformula();
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==MINUS) {
				{
				{
				setState(88);
				addoperator();
				setState(89);
				faktorformula();
				}
				}
				setState(95);
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
			setState(96);
			powerformula();
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULTI || _la==DIVISION) {
				{
				{
				setState(97);
				multoperator();
				setState(98);
				powerformula();
				}
				}
				setState(104);
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
			setState(105);
			notterm();
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==POWER) {
				{
				{
				setState(106);
				match(POWER);
				setState(107);
				notterm();
				}
				}
				setState(112);
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
			setState(116);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CODEWORD:
			case COMPONENT:
			case STRING:
			case VARIABLE:
			case LPAREN:
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				term();
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(114);
				match(NOT);
				setState(115);
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
		public List<TerminalNode> VARIABLE() { return getTokens(FOLZ3Parser.VARIABLE); }
		public TerminalNode VARIABLE(int i) {
			return getToken(FOLZ3Parser.VARIABLE, i);
		}
		public TerminalNode COMPONENT() { return getToken(FOLZ3Parser.COMPONENT, 0); }
		public TerminalNode CODEWORD() { return getToken(FOLZ3Parser.CODEWORD, 0); }
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
		int _la;
		try {
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMPONENT) {
					{
					setState(118);
					match(COMPONENT);
					}
				}

				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CODEWORD) {
					{
					setState(121);
					match(CODEWORD);
					}
				}

				setState(124);
				match(VARIABLE);
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(125);
					match(T__1);
					setState(126);
					match(VARIABLE);
					setState(127);
					match(T__2);
					}
				}

				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(130);
					match(T__3);
					setState(131);
					match(VARIABLE);
					}
				}

				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(134);
				match(LPAREN);
				setState(135);
				match(MINUS);
				setState(136);
				match(VARIABLE);
				setState(137);
				match(RPAREN);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(138);
				match(TRUE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(139);
				match(FALSE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(140);
				match(STRING);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				{
				setState(141);
				match(LPAREN);
				setState(142);
				term();
				setState(143);
				match(RPAREN);
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				{
				setState(145);
				match(LPAREN);
				setState(146);
				formula();
				setState(147);
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
			setState(151);
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
			setState(153);
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
			setState(155);
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
			setState(157);
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
			setState(159);
			match(T__4);
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CHARACTER) {
				{
				{
				setState(160);
				match(CHARACTER);
				}
				}
				setState(165);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\u00a9\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\5\3\'\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\63\n\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3?\n\3\f\3\16\3B\13\3\3\3\3\3\5\3"+
		"F\n\3\3\4\3\4\3\4\3\4\7\4L\n\4\f\4\16\4O\13\4\3\5\3\5\3\5\3\5\7\5U\n\5"+
		"\f\5\16\5X\13\5\3\6\3\6\3\6\3\6\7\6^\n\6\f\6\16\6a\13\6\3\7\3\7\3\7\3"+
		"\7\7\7g\n\7\f\7\16\7j\13\7\3\b\3\b\3\b\7\bo\n\b\f\b\16\br\13\b\3\t\3\t"+
		"\3\t\5\tw\n\t\3\n\5\nz\n\n\3\n\5\n}\n\n\3\n\3\n\3\n\3\n\5\n\u0083\n\n"+
		"\3\n\3\n\5\n\u0087\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\5\n\u0098\n\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3"+
		"\17\7\17\u00a4\n\17\f\17\16\17\u00a7\13\17\3\17\2\2\20\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\2\6\4\2\23\23\35 \3\2\26\27\3\2\24\25\3\2\31\34"+
		"\2\u00b1\2\36\3\2\2\2\4E\3\2\2\2\6G\3\2\2\2\bP\3\2\2\2\nY\3\2\2\2\fb\3"+
		"\2\2\2\16k\3\2\2\2\20v\3\2\2\2\22\u0097\3\2\2\2\24\u0099\3\2\2\2\26\u009b"+
		"\3\2\2\2\30\u009d\3\2\2\2\32\u009f\3\2\2\2\34\u00a1\3\2\2\2\36\37\5\4"+
		"\3\2\37\3\3\2\2\2 F\5\6\4\2!\"\7\n\2\2\"#\7\17\2\2#&\7\16\2\2$%\7\3\2"+
		"\2%\'\5\4\3\2&$\3\2\2\2&\'\3\2\2\2\'(\3\2\2\2()\7\21\2\2)*\7\17\2\2*+"+
		"\5\4\3\2+,\7\21\2\2,F\3\2\2\2-.\7\f\2\2./\7\17\2\2/\62\7\16\2\2\60\61"+
		"\7\3\2\2\61\63\5\4\3\2\62\60\3\2\2\2\62\63\3\2\2\2\63\64\3\2\2\2\64\65"+
		"\7\21\2\2\65\66\7\17\2\2\66\67\5\4\3\2\678\7\21\2\28F\3\2\2\29:\5\34\17"+
		"\2:;\7\17\2\2;@\5\22\n\2<=\7\3\2\2=?\5\22\n\2><\3\2\2\2?B\3\2\2\2@>\3"+
		"\2\2\2@A\3\2\2\2AC\3\2\2\2B@\3\2\2\2CD\7\21\2\2DF\3\2\2\2E \3\2\2\2E!"+
		"\3\2\2\2E-\3\2\2\2E9\3\2\2\2F\5\3\2\2\2GM\5\b\5\2HI\5\32\16\2IJ\5\b\5"+
		"\2JL\3\2\2\2KH\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2N\7\3\2\2\2OM\3\2"+
		"\2\2PV\5\n\6\2QR\5\24\13\2RS\5\n\6\2SU\3\2\2\2TQ\3\2\2\2UX\3\2\2\2VT\3"+
		"\2\2\2VW\3\2\2\2W\t\3\2\2\2XV\3\2\2\2Y_\5\f\7\2Z[\5\30\r\2[\\\5\f\7\2"+
		"\\^\3\2\2\2]Z\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`\13\3\2\2\2a_\3\2"+
		"\2\2bh\5\16\b\2cd\5\26\f\2de\5\16\b\2eg\3\2\2\2fc\3\2\2\2gj\3\2\2\2hf"+
		"\3\2\2\2hi\3\2\2\2i\r\3\2\2\2jh\3\2\2\2kp\5\20\t\2lm\7\22\2\2mo\5\20\t"+
		"\2nl\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2q\17\3\2\2\2rp\3\2\2\2sw\5\22"+
		"\n\2tu\7\20\2\2uw\5\22\n\2vs\3\2\2\2vt\3\2\2\2w\21\3\2\2\2xz\7\13\2\2"+
		"yx\3\2\2\2yz\3\2\2\2z|\3\2\2\2{}\7\b\2\2|{\3\2\2\2|}\3\2\2\2}~\3\2\2\2"+
		"~\u0082\7\16\2\2\177\u0080\7\4\2\2\u0080\u0081\7\16\2\2\u0081\u0083\7"+
		"\5\2\2\u0082\177\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0086\3\2\2\2\u0084"+
		"\u0085\7\6\2\2\u0085\u0087\7\16\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3"+
		"\2\2\2\u0087\u0098\3\2\2\2\u0088\u0089\7\17\2\2\u0089\u008a\7\25\2\2\u008a"+
		"\u008b\7\16\2\2\u008b\u0098\7\21\2\2\u008c\u0098\7!\2\2\u008d\u0098\7"+
		"\"\2\2\u008e\u0098\7\r\2\2\u008f\u0090\7\17\2\2\u0090\u0091\5\22\n\2\u0091"+
		"\u0092\7\21\2\2\u0092\u0098\3\2\2\2\u0093\u0094\7\17\2\2\u0094\u0095\5"+
		"\4\3\2\u0095\u0096\7\21\2\2\u0096\u0098\3\2\2\2\u0097y\3\2\2\2\u0097\u0088"+
		"\3\2\2\2\u0097\u008c\3\2\2\2\u0097\u008d\3\2\2\2\u0097\u008e\3\2\2\2\u0097"+
		"\u008f\3\2\2\2\u0097\u0093\3\2\2\2\u0098\23\3\2\2\2\u0099\u009a\t\2\2"+
		"\2\u009a\25\3\2\2\2\u009b\u009c\t\3\2\2\u009c\27\3\2\2\2\u009d\u009e\t"+
		"\4\2\2\u009e\31\3\2\2\2\u009f\u00a0\t\5\2\2\u00a0\33\3\2\2\2\u00a1\u00a5"+
		"\7\7\2\2\u00a2\u00a4\7\30\2\2\u00a3\u00a2\3\2\2\2\u00a4\u00a7\3\2\2\2"+
		"\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\35\3\2\2\2\u00a7\u00a5"+
		"\3\2\2\2\22&\62@EMV_hpvy|\u0082\u0086\u0097\u00a5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}