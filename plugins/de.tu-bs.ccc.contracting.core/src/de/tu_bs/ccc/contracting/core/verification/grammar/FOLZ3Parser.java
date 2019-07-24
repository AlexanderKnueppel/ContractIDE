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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, TYPE=8, TRUE=9, 
		FALSE=10, CODEWORD=11, NULL=12, QUANTIFER=13, OPERATOR=14, COMPONENT=15, 
		STRING=16, IDENTIFIER=17, NUMBER=18, LPAREN=19, NOT=20, RPAREN=21, POWER=22, 
		EQUAL=23, ADD=24, MINUS=25, MULTI=26, DIVISION=27, CHARACTER=28, CONJ=29, 
		DISJ=30, IMPL=31, BICOND=32, GREATER=33, SMALLER=34, SMALLEREQ=35, GREATEREQ=36, 
		WHITESPACE=37;
	public static final int
		RULE_condition = 0, RULE_formula = 1, RULE_quantifier = 2, RULE_operatorformula = 3, 
		RULE_connectiveformula = 4, RULE_tupelformula = 5, RULE_compareformula = 6, 
		RULE_tupel = 7, RULE_summformula = 8, RULE_faktorformula = 9, RULE_powerformula = 10, 
		RULE_notterm = 11, RULE_term = 12, RULE_array = 13, RULE_compproperty = 14, 
		RULE_portproperty = 15, RULE_port = 16, RULE_functioncall = 17, RULE_compoperator = 18, 
		RULE_multoperator = 19, RULE_addoperator = 20, RULE_connectoperator = 21, 
		RULE_pred_constant = 22;
	public static final String[] ruleNames = {
		"condition", "formula", "quantifier", "operatorformula", "connectiveformula", 
		"tupelformula", "compareformula", "tupel", "summformula", "faktorformula", 
		"powerformula", "notterm", "term", "array", "compproperty", "portproperty", 
		"port", "functioncall", "compoperator", "multoperator", "addoperator", 
		"connectoperator", "pred_constant"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\"'", "';'", "','", "'.'", "'['", "']'", "'_'", null, "'\\true'", 
		"'\\false'", "'.$'", "'\\null'", null, null, null, null, null, null, "'('", 
		"'!'", "')'", "'^'", "'=='", "'+'", "'-'", "'*'", "'/'", null, "'&&'", 
		"'||'", "'=>'", "'<>'", "'>'", "'<'", "'<='", "'>='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "TYPE", "TRUE", "FALSE", 
		"CODEWORD", "NULL", "QUANTIFER", "OPERATOR", "COMPONENT", "STRING", "IDENTIFIER", 
		"NUMBER", "LPAREN", "NOT", "RPAREN", "POWER", "EQUAL", "ADD", "MINUS", 
		"MULTI", "DIVISION", "CHARACTER", "CONJ", "DISJ", "IMPL", "BICOND", "GREATER", 
		"SMALLER", "SMALLEREQ", "GREATEREQ", "WHITESPACE"
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
			setState(46);
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
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TupelformulaContext tupelformula() {
			return getRuleContext(TupelformulaContext.class,0);
		}
		public ConnectiveformulaContext connectiveformula() {
			return getRuleContext(ConnectiveformulaContext.class,0);
		}
		public QuantifierContext quantifier() {
			return getRuleContext(QuantifierContext.class,0);
		}
		public OperatorformulaContext operatorformula() {
			return getRuleContext(OperatorformulaContext.class,0);
		}
		public Pred_constantContext pred_constant() {
			return getRuleContext(Pred_constantContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(FOLZ3Parser.LPAREN, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(FOLZ3Parser.RPAREN, 0); }
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
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				match(T__0);
				setState(49);
				formula();
				setState(50);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				tupelformula();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(53);
				connectiveformula();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(54);
				quantifier();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(55);
				operatorformula();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(56);
				pred_constant();
				setState(57);
				match(LPAREN);
				setState(58);
				term();
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(59);
					match(T__1);
					setState(60);
					term();
					}
					}
					setState(65);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(66);
				match(RPAREN);
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

	public static class QuantifierContext extends ParserRuleContext {
		public TerminalNode QUANTIFER() { return getToken(FOLZ3Parser.QUANTIFER, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(FOLZ3Parser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(FOLZ3Parser.IDENTIFIER, i);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public List<TerminalNode> TYPE() { return getTokens(FOLZ3Parser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(FOLZ3Parser.TYPE, i);
		}
		public QuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLZ3Visitor ) return ((FOLZ3Visitor<? extends T>)visitor).visitQuantifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantifierContext quantifier() throws RecognitionException {
		QuantifierContext _localctx = new QuantifierContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_quantifier);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(QUANTIFER);
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(71);
				match(TYPE);
				}
			}

			setState(74);
			match(IDENTIFIER);
			setState(82);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(75);
					match(T__1);
					setState(77);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==TYPE) {
						{
						setState(76);
						match(TYPE);
						}
					}

					setState(79);
					match(IDENTIFIER);
					}
					} 
				}
				setState(84);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(85);
				match(T__1);
				setState(86);
				formula();
				}
				break;
			}
			setState(89);
			match(T__1);
			setState(90);
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

	public static class OperatorformulaContext extends ParserRuleContext {
		public TerminalNode OPERATOR() { return getToken(FOLZ3Parser.OPERATOR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(FOLZ3Parser.IDENTIFIER, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode TYPE() { return getToken(FOLZ3Parser.TYPE, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public OperatorformulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorformula; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLZ3Visitor ) return ((FOLZ3Visitor<? extends T>)visitor).visitOperatorformula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorformulaContext operatorformula() throws RecognitionException {
		OperatorformulaContext _localctx = new OperatorformulaContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_operatorformula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(OPERATOR);
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(93);
				match(TYPE);
				}
			}

			setState(96);
			match(IDENTIFIER);
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(97);
				match(T__1);
				setState(98);
				term();
				setState(99);
				match(T__1);
				setState(100);
				term();
				}
				break;
			}
			setState(104);
			match(T__1);
			setState(105);
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
		enterRule(_localctx, 8, RULE_connectiveformula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(107);
			compareformula();
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONJ) | (1L << DISJ) | (1L << IMPL) | (1L << BICOND))) != 0)) {
				{
				{
				setState(108);
				connectoperator();
				setState(109);
				compareformula();
				}
				}
				setState(115);
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

	public static class TupelformulaContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(FOLZ3Parser.EQUAL, 0); }
		public List<TupelContext> tupel() {
			return getRuleContexts(TupelContext.class);
		}
		public TupelContext tupel(int i) {
			return getRuleContext(TupelContext.class,i);
		}
		public List<FunctioncallContext> functioncall() {
			return getRuleContexts(FunctioncallContext.class);
		}
		public FunctioncallContext functioncall(int i) {
			return getRuleContext(FunctioncallContext.class,i);
		}
		public TupelformulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupelformula; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLZ3Visitor ) return ((FOLZ3Visitor<? extends T>)visitor).visitTupelformula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupelformulaContext tupelformula() throws RecognitionException {
		TupelformulaContext _localctx = new TupelformulaContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tupelformula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				setState(116);
				tupel();
				}
				break;
			case IDENTIFIER:
				{
				setState(117);
				functioncall();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(120);
			match(EQUAL);
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				setState(121);
				tupel();
				}
				break;
			case IDENTIFIER:
				{
				setState(122);
				functioncall();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		enterRule(_localctx, 12, RULE_compareformula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(125);
			summformula();
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL) | (1L << GREATER) | (1L << SMALLER) | (1L << SMALLEREQ) | (1L << GREATEREQ))) != 0)) {
				{
				{
				setState(126);
				compoperator();
				setState(127);
				summformula();
				}
				}
				setState(133);
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

	public static class TupelContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(FOLZ3Parser.LPAREN, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(FOLZ3Parser.RPAREN, 0); }
		public TupelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupel; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLZ3Visitor ) return ((FOLZ3Visitor<? extends T>)visitor).visitTupel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupelContext tupel() throws RecognitionException {
		TupelContext _localctx = new TupelContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_tupel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(LPAREN);
			setState(135);
			term();
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(136);
				match(T__2);
				setState(137);
				term();
				}
				}
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(143);
			match(RPAREN);
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
		enterRule(_localctx, 16, RULE_summformula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(145);
			faktorformula();
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==MINUS) {
				{
				{
				setState(146);
				addoperator();
				setState(147);
				faktorformula();
				}
				}
				setState(153);
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
		enterRule(_localctx, 18, RULE_faktorformula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(154);
			powerformula();
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULTI || _la==DIVISION) {
				{
				{
				setState(155);
				multoperator();
				setState(156);
				powerformula();
				}
				}
				setState(162);
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
		enterRule(_localctx, 20, RULE_powerformula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(163);
			notterm();
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==POWER) {
				{
				{
				setState(164);
				match(POWER);
				setState(165);
				notterm();
				}
				}
				setState(170);
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
		enterRule(_localctx, 22, RULE_notterm);
		try {
			setState(174);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case COMPONENT:
			case STRING:
			case IDENTIFIER:
			case NUMBER:
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				term();
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(172);
				match(NOT);
				setState(173);
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
		public ComppropertyContext compproperty() {
			return getRuleContext(ComppropertyContext.class,0);
		}
		public PortpropertyContext portproperty() {
			return getRuleContext(PortpropertyContext.class,0);
		}
		public PortContext port() {
			return getRuleContext(PortContext.class,0);
		}
		public FunctioncallContext functioncall() {
			return getRuleContext(FunctioncallContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(FOLZ3Parser.IDENTIFIER, 0); }
		public TerminalNode NUMBER() { return getToken(FOLZ3Parser.NUMBER, 0); }
		public TerminalNode LPAREN() { return getToken(FOLZ3Parser.LPAREN, 0); }
		public TerminalNode MINUS() { return getToken(FOLZ3Parser.MINUS, 0); }
		public TerminalNode RPAREN() { return getToken(FOLZ3Parser.RPAREN, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode TRUE() { return getToken(FOLZ3Parser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(FOLZ3Parser.FALSE, 0); }
		public TerminalNode STRING() { return getToken(FOLZ3Parser.STRING, 0); }
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
		enterRule(_localctx, 24, RULE_term);
		try {
			setState(199);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				compproperty();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				portproperty();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(178);
				port();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(179);
				functioncall();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(180);
				array();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(181);
				match(IDENTIFIER);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(182);
				match(NUMBER);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				{
				setState(183);
				match(LPAREN);
				setState(184);
				match(MINUS);
				{
				setState(185);
				term();
				}
				setState(186);
				match(RPAREN);
				}
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(188);
				match(TRUE);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(189);
				match(FALSE);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(190);
				match(STRING);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				{
				setState(191);
				match(LPAREN);
				setState(192);
				term();
				setState(193);
				match(RPAREN);
				}
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				{
				setState(195);
				match(LPAREN);
				setState(196);
				formula();
				setState(197);
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

	public static class ArrayContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(FOLZ3Parser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(FOLZ3Parser.IDENTIFIER, i);
		}
		public TerminalNode COMPONENT() { return getToken(FOLZ3Parser.COMPONENT, 0); }
		public TerminalNode CODEWORD() { return getToken(FOLZ3Parser.CODEWORD, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLZ3Visitor ) return ((FOLZ3Visitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_array);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				{
				setState(201);
				match(COMPONENT);
				setState(202);
				match(CODEWORD);
				}
				}
				break;
			case 2:
				{
				setState(207);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(203);
						match(IDENTIFIER);
						setState(204);
						match(T__3);
						}
						} 
					}
					setState(209);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				}
				}
				break;
			}
			setState(212);
			match(IDENTIFIER);
			setState(220); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(213);
				match(T__4);
				setState(216);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(214);
					term();
					}
					break;
				case 2:
					{
					setState(215);
					formula();
					}
					break;
				}
				setState(218);
				match(T__5);
				}
				}
				setState(222); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
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

	public static class ComppropertyContext extends ParserRuleContext {
		public TerminalNode COMPONENT() { return getToken(FOLZ3Parser.COMPONENT, 0); }
		public TerminalNode CODEWORD() { return getToken(FOLZ3Parser.CODEWORD, 0); }
		public TerminalNode IDENTIFIER() { return getToken(FOLZ3Parser.IDENTIFIER, 0); }
		public ComppropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compproperty; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLZ3Visitor ) return ((FOLZ3Visitor<? extends T>)visitor).visitCompproperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComppropertyContext compproperty() throws RecognitionException {
		ComppropertyContext _localctx = new ComppropertyContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_compproperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(COMPONENT);
			setState(225);
			match(CODEWORD);
			setState(226);
			match(IDENTIFIER);
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

	public static class PortpropertyContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(FOLZ3Parser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(FOLZ3Parser.IDENTIFIER, i);
		}
		public TerminalNode CODEWORD() { return getToken(FOLZ3Parser.CODEWORD, 0); }
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public PortpropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_portproperty; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLZ3Visitor ) return ((FOLZ3Visitor<? extends T>)visitor).visitPortproperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PortpropertyContext portproperty() throws RecognitionException {
		PortpropertyContext _localctx = new PortpropertyContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_portproperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(IDENTIFIER);
			setState(229);
			match(CODEWORD);
			setState(232);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(230);
				match(IDENTIFIER);
				}
				break;
			case 2:
				{
				setState(231);
				array();
				}
				break;
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

	public static class PortContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(FOLZ3Parser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(FOLZ3Parser.IDENTIFIER, i);
		}
		public PortContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_port; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLZ3Visitor ) return ((FOLZ3Visitor<? extends T>)visitor).visitPort(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PortContext port() throws RecognitionException {
		PortContext _localctx = new PortContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_port);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(IDENTIFIER);
			setState(237); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(235);
				match(T__3);
				setState(236);
				match(IDENTIFIER);
				}
				}
				setState(239); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__3 );
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

	public static class FunctioncallContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(FOLZ3Parser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(FOLZ3Parser.IDENTIFIER, i);
		}
		public TerminalNode LPAREN() { return getToken(FOLZ3Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(FOLZ3Parser.RPAREN, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public FunctioncallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functioncall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLZ3Visitor ) return ((FOLZ3Visitor<? extends T>)visitor).visitFunctioncall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctioncallContext functioncall() throws RecognitionException {
		FunctioncallContext _localctx = new FunctioncallContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_functioncall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(IDENTIFIER);
			setState(242);
			match(T__3);
			setState(243);
			match(IDENTIFIER);
			setState(244);
			match(LPAREN);
			setState(247);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(245);
				term();
				}
				break;
			case 2:
				{
				setState(246);
				formula();
				}
				break;
			}
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(249);
				match(T__2);
				setState(252);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(250);
					term();
					}
					break;
				case 2:
					{
					setState(251);
					formula();
					}
					break;
				}
				}
				}
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(259);
			match(RPAREN);
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
		enterRule(_localctx, 36, RULE_compoperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
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
		enterRule(_localctx, 38, RULE_multoperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
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
		enterRule(_localctx, 40, RULE_addoperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
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
		enterRule(_localctx, 42, RULE_connectoperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
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
		enterRule(_localctx, 44, RULE_pred_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(T__6);
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CHARACTER) {
				{
				{
				setState(270);
				match(CHARACTER);
				}
				}
				setState(275);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\'\u0117\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3@\n\3\f\3\16\3C"+
		"\13\3\3\3\3\3\5\3G\n\3\3\4\3\4\5\4K\n\4\3\4\3\4\3\4\5\4P\n\4\3\4\7\4S"+
		"\n\4\f\4\16\4V\13\4\3\4\3\4\5\4Z\n\4\3\4\3\4\3\4\3\5\3\5\5\5a\n\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\5\5i\n\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6r\n\6\f\6"+
		"\16\6u\13\6\3\7\3\7\5\7y\n\7\3\7\3\7\3\7\5\7~\n\7\3\b\3\b\3\b\3\b\7\b"+
		"\u0084\n\b\f\b\16\b\u0087\13\b\3\t\3\t\3\t\3\t\7\t\u008d\n\t\f\t\16\t"+
		"\u0090\13\t\3\t\3\t\3\n\3\n\3\n\3\n\7\n\u0098\n\n\f\n\16\n\u009b\13\n"+
		"\3\13\3\13\3\13\3\13\7\13\u00a1\n\13\f\13\16\13\u00a4\13\13\3\f\3\f\3"+
		"\f\7\f\u00a9\n\f\f\f\16\f\u00ac\13\f\3\r\3\r\3\r\5\r\u00b1\n\r\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00ca\n\16\3\17\3\17\3\17"+
		"\3\17\7\17\u00d0\n\17\f\17\16\17\u00d3\13\17\5\17\u00d5\n\17\3\17\3\17"+
		"\3\17\3\17\5\17\u00db\n\17\3\17\3\17\6\17\u00df\n\17\r\17\16\17\u00e0"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\5\21\u00eb\n\21\3\22\3\22\3\22"+
		"\6\22\u00f0\n\22\r\22\16\22\u00f1\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00fa"+
		"\n\23\3\23\3\23\3\23\5\23\u00ff\n\23\7\23\u0101\n\23\f\23\16\23\u0104"+
		"\13\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\7\30"+
		"\u0112\n\30\f\30\16\30\u0115\13\30\3\30\2\2\31\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\2\6\4\2\31\31#&\3\2\34\35\3\2\32\33\3\2\37\""+
		"\2\u012b\2\60\3\2\2\2\4F\3\2\2\2\6H\3\2\2\2\b^\3\2\2\2\nm\3\2\2\2\fx\3"+
		"\2\2\2\16\177\3\2\2\2\20\u0088\3\2\2\2\22\u0093\3\2\2\2\24\u009c\3\2\2"+
		"\2\26\u00a5\3\2\2\2\30\u00b0\3\2\2\2\32\u00c9\3\2\2\2\34\u00d4\3\2\2\2"+
		"\36\u00e2\3\2\2\2 \u00e6\3\2\2\2\"\u00ec\3\2\2\2$\u00f3\3\2\2\2&\u0107"+
		"\3\2\2\2(\u0109\3\2\2\2*\u010b\3\2\2\2,\u010d\3\2\2\2.\u010f\3\2\2\2\60"+
		"\61\5\4\3\2\61\3\3\2\2\2\62\63\7\3\2\2\63\64\5\4\3\2\64\65\7\3\2\2\65"+
		"G\3\2\2\2\66G\5\f\7\2\67G\5\n\6\28G\5\6\4\29G\5\b\5\2:;\5.\30\2;<\7\25"+
		"\2\2<A\5\32\16\2=>\7\4\2\2>@\5\32\16\2?=\3\2\2\2@C\3\2\2\2A?\3\2\2\2A"+
		"B\3\2\2\2BD\3\2\2\2CA\3\2\2\2DE\7\27\2\2EG\3\2\2\2F\62\3\2\2\2F\66\3\2"+
		"\2\2F\67\3\2\2\2F8\3\2\2\2F9\3\2\2\2F:\3\2\2\2G\5\3\2\2\2HJ\7\17\2\2I"+
		"K\7\n\2\2JI\3\2\2\2JK\3\2\2\2KL\3\2\2\2LT\7\23\2\2MO\7\4\2\2NP\7\n\2\2"+
		"ON\3\2\2\2OP\3\2\2\2PQ\3\2\2\2QS\7\23\2\2RM\3\2\2\2SV\3\2\2\2TR\3\2\2"+
		"\2TU\3\2\2\2UY\3\2\2\2VT\3\2\2\2WX\7\4\2\2XZ\5\4\3\2YW\3\2\2\2YZ\3\2\2"+
		"\2Z[\3\2\2\2[\\\7\4\2\2\\]\5\4\3\2]\7\3\2\2\2^`\7\20\2\2_a\7\n\2\2`_\3"+
		"\2\2\2`a\3\2\2\2ab\3\2\2\2bh\7\23\2\2cd\7\4\2\2de\5\32\16\2ef\7\4\2\2"+
		"fg\5\32\16\2gi\3\2\2\2hc\3\2\2\2hi\3\2\2\2ij\3\2\2\2jk\7\4\2\2kl\5\4\3"+
		"\2l\t\3\2\2\2ms\5\16\b\2no\5,\27\2op\5\16\b\2pr\3\2\2\2qn\3\2\2\2ru\3"+
		"\2\2\2sq\3\2\2\2st\3\2\2\2t\13\3\2\2\2us\3\2\2\2vy\5\20\t\2wy\5$\23\2"+
		"xv\3\2\2\2xw\3\2\2\2yz\3\2\2\2z}\7\31\2\2{~\5\20\t\2|~\5$\23\2}{\3\2\2"+
		"\2}|\3\2\2\2~\r\3\2\2\2\177\u0085\5\22\n\2\u0080\u0081\5&\24\2\u0081\u0082"+
		"\5\22\n\2\u0082\u0084\3\2\2\2\u0083\u0080\3\2\2\2\u0084\u0087\3\2\2\2"+
		"\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\17\3\2\2\2\u0087\u0085"+
		"\3\2\2\2\u0088\u0089\7\25\2\2\u0089\u008e\5\32\16\2\u008a\u008b\7\5\2"+
		"\2\u008b\u008d\5\32\16\2\u008c\u008a\3\2\2\2\u008d\u0090\3\2\2\2\u008e"+
		"\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u008e\3\2"+
		"\2\2\u0091\u0092\7\27\2\2\u0092\21\3\2\2\2\u0093\u0099\5\24\13\2\u0094"+
		"\u0095\5*\26\2\u0095\u0096\5\24\13\2\u0096\u0098\3\2\2\2\u0097\u0094\3"+
		"\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\23\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u00a2\5\26\f\2\u009d\u009e\5(\25"+
		"\2\u009e\u009f\5\26\f\2\u009f\u00a1\3\2\2\2\u00a0\u009d\3\2\2\2\u00a1"+
		"\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\25\3\2\2"+
		"\2\u00a4\u00a2\3\2\2\2\u00a5\u00aa\5\30\r\2\u00a6\u00a7\7\30\2\2\u00a7"+
		"\u00a9\5\30\r\2\u00a8\u00a6\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3"+
		"\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\27\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad"+
		"\u00b1\5\32\16\2\u00ae\u00af\7\26\2\2\u00af\u00b1\5\32\16\2\u00b0\u00ad"+
		"\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\31\3\2\2\2\u00b2\u00ca\5\36\20\2\u00b3"+
		"\u00ca\5 \21\2\u00b4\u00ca\5\"\22\2\u00b5\u00ca\5$\23\2\u00b6\u00ca\5"+
		"\34\17\2\u00b7\u00ca\7\23\2\2\u00b8\u00ca\7\24\2\2\u00b9\u00ba\7\25\2"+
		"\2\u00ba\u00bb\7\33\2\2\u00bb\u00bc\5\32\16\2\u00bc\u00bd\7\27\2\2\u00bd"+
		"\u00ca\3\2\2\2\u00be\u00ca\7\13\2\2\u00bf\u00ca\7\f\2\2\u00c0\u00ca\7"+
		"\22\2\2\u00c1\u00c2\7\25\2\2\u00c2\u00c3\5\32\16\2\u00c3\u00c4\7\27\2"+
		"\2\u00c4\u00ca\3\2\2\2\u00c5\u00c6\7\25\2\2\u00c6\u00c7\5\4\3\2\u00c7"+
		"\u00c8\7\27\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00b2\3\2\2\2\u00c9\u00b3\3"+
		"\2\2\2\u00c9\u00b4\3\2\2\2\u00c9\u00b5\3\2\2\2\u00c9\u00b6\3\2\2\2\u00c9"+
		"\u00b7\3\2\2\2\u00c9\u00b8\3\2\2\2\u00c9\u00b9\3\2\2\2\u00c9\u00be\3\2"+
		"\2\2\u00c9\u00bf\3\2\2\2\u00c9\u00c0\3\2\2\2\u00c9\u00c1\3\2\2\2\u00c9"+
		"\u00c5\3\2\2\2\u00ca\33\3\2\2\2\u00cb\u00cc\7\21\2\2\u00cc\u00d5\7\r\2"+
		"\2\u00cd\u00ce\7\23\2\2\u00ce\u00d0\7\6\2\2\u00cf\u00cd\3\2\2\2\u00d0"+
		"\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d5\3\2"+
		"\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00cb\3\2\2\2\u00d4\u00d1\3\2\2\2\u00d4"+
		"\u00d5\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00de\7\23\2\2\u00d7\u00da\7"+
		"\7\2\2\u00d8\u00db\5\32\16\2\u00d9\u00db\5\4\3\2\u00da\u00d8\3\2\2\2\u00da"+
		"\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\7\b\2\2\u00dd\u00df\3\2"+
		"\2\2\u00de\u00d7\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0"+
		"\u00e1\3\2\2\2\u00e1\35\3\2\2\2\u00e2\u00e3\7\21\2\2\u00e3\u00e4\7\r\2"+
		"\2\u00e4\u00e5\7\23\2\2\u00e5\37\3\2\2\2\u00e6\u00e7\7\23\2\2\u00e7\u00ea"+
		"\7\r\2\2\u00e8\u00eb\7\23\2\2\u00e9\u00eb\5\34\17\2\u00ea\u00e8\3\2\2"+
		"\2\u00ea\u00e9\3\2\2\2\u00eb!\3\2\2\2\u00ec\u00ef\7\23\2\2\u00ed\u00ee"+
		"\7\6\2\2\u00ee\u00f0\7\23\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f1\3\2\2\2"+
		"\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2#\3\2\2\2\u00f3\u00f4\7"+
		"\23\2\2\u00f4\u00f5\7\6\2\2\u00f5\u00f6\7\23\2\2\u00f6\u00f9\7\25\2\2"+
		"\u00f7\u00fa\5\32\16\2\u00f8\u00fa\5\4\3\2\u00f9\u00f7\3\2\2\2\u00f9\u00f8"+
		"\3\2\2\2\u00fa\u0102\3\2\2\2\u00fb\u00fe\7\5\2\2\u00fc\u00ff\5\32\16\2"+
		"\u00fd\u00ff\5\4\3\2\u00fe\u00fc\3\2\2\2\u00fe\u00fd\3\2\2\2\u00ff\u0101"+
		"\3\2\2\2\u0100\u00fb\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102"+
		"\u0103\3\2\2\2\u0103\u0105\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u0106\7\27"+
		"\2\2\u0106%\3\2\2\2\u0107\u0108\t\2\2\2\u0108\'\3\2\2\2\u0109\u010a\t"+
		"\3\2\2\u010a)\3\2\2\2\u010b\u010c\t\4\2\2\u010c+\3\2\2\2\u010d\u010e\t"+
		"\5\2\2\u010e-\3\2\2\2\u010f\u0113\7\t\2\2\u0110\u0112\7\36\2\2\u0111\u0110"+
		"\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114"+
		"/\3\2\2\2\u0115\u0113\3\2\2\2\36AFJOTY`hsx}\u0085\u008e\u0099\u00a2\u00aa"+
		"\u00b0\u00c9\u00d1\u00d4\u00da\u00e0\u00ea\u00f1\u00f9\u00fe\u0102\u0113";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}