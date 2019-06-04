// Generated from FOLZ3.g4 by ANTLR 4.7.1

	package de.tu_bs.ccc.contracting.core.verification.grammar;


import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FOLZ3Lexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "CODEWORD", "NULL", "FORALL", 
		"COMPONENT", "EXISTS", "STRING", "VARIABLE", "LPAREN", "NOT", "RPAREN", 
		"POWER", "EQUAL", "ADD", "MINUS", "MULTI", "DIVISION", "CHARACTER", "CONJ", 
		"DISJ", "IMPL", "BICOND", "GREATER", "SMALLER", "SMALLEREQ", "GREATEREQ", 
		"TRUE", "FALSE", "WHITESPACE"
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


	public FOLZ3Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FOLZ3.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2#\u00c1\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nm\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\6\fy\n\f\r\f\16\fz\3\f\3\f\3\r\6\r\u0080\n\r\r\r\16\r"+
		"\u0081\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\3\25\3\25\3\26\3\26\3\27\5\27\u0098\n\27\3\30\3\30\3\31\3\31"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\37"+
		"\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3\"\6\"\u00bc\n\"\r"+
		"\"\16\"\u00bd\3\"\3\"\2\2#\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\359\36;\37= ?!A\"C#\3\2\4\6\2\60\60\62;C\\c|\4\2\13\13"+
		"\"\"\2\u00c4\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
		"\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\3E\3\2\2"+
		"\2\5G\3\2\2\2\7I\3\2\2\2\tK\3\2\2\2\13N\3\2\2\2\rP\3\2\2\2\17S\3\2\2\2"+
		"\21Y\3\2\2\2\23l\3\2\2\2\25n\3\2\2\2\27v\3\2\2\2\31\177\3\2\2\2\33\u0083"+
		"\3\2\2\2\35\u0085\3\2\2\2\37\u0087\3\2\2\2!\u0089\3\2\2\2#\u008b\3\2\2"+
		"\2%\u008e\3\2\2\2\'\u0090\3\2\2\2)\u0092\3\2\2\2+\u0094\3\2\2\2-\u0097"+
		"\3\2\2\2/\u0099\3\2\2\2\61\u009b\3\2\2\2\63\u009d\3\2\2\2\65\u00a0\3\2"+
		"\2\2\67\u00a3\3\2\2\29\u00a5\3\2\2\2;\u00a7\3\2\2\2=\u00aa\3\2\2\2?\u00ad"+
		"\3\2\2\2A\u00b3\3\2\2\2C\u00bb\3\2\2\2EF\7.\2\2F\4\3\2\2\2GH\7]\2\2H\6"+
		"\3\2\2\2IJ\7_\2\2J\b\3\2\2\2KL\7\60\2\2LM\7^\2\2M\n\3\2\2\2NO\7a\2\2O"+
		"\f\3\2\2\2PQ\7\60\2\2QR\7&\2\2R\16\3\2\2\2ST\7^\2\2TU\7p\2\2UV\7w\2\2"+
		"VW\7n\2\2WX\7n\2\2X\20\3\2\2\2YZ\7^\2\2Z[\7h\2\2[\\\7q\2\2\\]\7t\2\2]"+
		"^\7c\2\2^_\7n\2\2_`\7n\2\2`\22\3\2\2\2ab\7^\2\2bc\7u\2\2cd\7w\2\2de\7"+
		"r\2\2ef\7g\2\2fm\7t\2\2gh\7^\2\2hi\7v\2\2ij\7j\2\2jk\7k\2\2km\7u\2\2l"+
		"a\3\2\2\2lg\3\2\2\2m\24\3\2\2\2no\7^\2\2op\7g\2\2pq\7z\2\2qr\7k\2\2rs"+
		"\7u\2\2st\7v\2\2tu\7u\2\2u\26\3\2\2\2vx\7$\2\2wy\5-\27\2xw\3\2\2\2yz\3"+
		"\2\2\2zx\3\2\2\2z{\3\2\2\2{|\3\2\2\2|}\7$\2\2}\30\3\2\2\2~\u0080\5-\27"+
		"\2\177~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2"+
		"\2\2\u0082\32\3\2\2\2\u0083\u0084\7*\2\2\u0084\34\3\2\2\2\u0085\u0086"+
		"\7#\2\2\u0086\36\3\2\2\2\u0087\u0088\7+\2\2\u0088 \3\2\2\2\u0089\u008a"+
		"\7`\2\2\u008a\"\3\2\2\2\u008b\u008c\7?\2\2\u008c\u008d\7?\2\2\u008d$\3"+
		"\2\2\2\u008e\u008f\7-\2\2\u008f&\3\2\2\2\u0090\u0091\7/\2\2\u0091(\3\2"+
		"\2\2\u0092\u0093\7,\2\2\u0093*\3\2\2\2\u0094\u0095\7\61\2\2\u0095,\3\2"+
		"\2\2\u0096\u0098\t\2\2\2\u0097\u0096\3\2\2\2\u0098.\3\2\2\2\u0099\u009a"+
		"\7(\2\2\u009a\60\3\2\2\2\u009b\u009c\7~\2\2\u009c\62\3\2\2\2\u009d\u009e"+
		"\7/\2\2\u009e\u009f\7@\2\2\u009f\64\3\2\2\2\u00a0\u00a1\7>\2\2\u00a1\u00a2"+
		"\7@\2\2\u00a2\66\3\2\2\2\u00a3\u00a4\7@\2\2\u00a48\3\2\2\2\u00a5\u00a6"+
		"\7>\2\2\u00a6:\3\2\2\2\u00a7\u00a8\7>\2\2\u00a8\u00a9\7?\2\2\u00a9<\3"+
		"\2\2\2\u00aa\u00ab\7@\2\2\u00ab\u00ac\7?\2\2\u00ac>\3\2\2\2\u00ad\u00ae"+
		"\7^\2\2\u00ae\u00af\7v\2\2\u00af\u00b0\7t\2\2\u00b0\u00b1\7w\2\2\u00b1"+
		"\u00b2\7g\2\2\u00b2@\3\2\2\2\u00b3\u00b4\7^\2\2\u00b4\u00b5\7h\2\2\u00b5"+
		"\u00b6\7c\2\2\u00b6\u00b7\7n\2\2\u00b7\u00b8\7u\2\2\u00b8\u00b9\7g\2\2"+
		"\u00b9B\3\2\2\2\u00ba\u00bc\t\3\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bd\3"+
		"\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf"+
		"\u00c0\b\"\2\2\u00c0D\3\2\2\2\b\2lz\u0081\u0097\u00bd\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}