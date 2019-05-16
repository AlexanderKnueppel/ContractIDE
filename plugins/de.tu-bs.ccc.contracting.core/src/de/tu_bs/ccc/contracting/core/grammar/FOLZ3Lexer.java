// Generated from FOLZ3.g4 by ANTLR 4.7.1

	package de.tu_bs.ccc.contracting.core.grammar;


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
		T__0=1, T__1=2, FORALL=3, EXISTS=4, STRING=5, VARIABLE=6, LPAREN=7, NOT=8, 
		RPAREN=9, POWER=10, EQUAL=11, ADD=12, MINUS=13, MULTI=14, DIVISION=15, 
		CHARACTER=16, CONJ=17, DISJ=18, IMPL=19, BICOND=20, GREATER=21, SMALLER=22, 
		SMALLEREQ=23, GREATEREQ=24, TRUE=25, FALSE=26, WHITESPACE=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "FORALL", "EXISTS", "STRING", "VARIABLE", "LPAREN", "NOT", 
		"RPAREN", "POWER", "EQUAL", "ADD", "MINUS", "MULTI", "DIVISION", "CHARACTER", 
		"CONJ", "DISJ", "IMPL", "BICOND", "GREATER", "SMALLER", "SMALLEREQ", "GREATEREQ", 
		"TRUE", "FALSE", "WHITESPACE"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u0093\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\6\6N\n\6\r\6\16\6O\3\6"+
		"\3\6\3\7\6\7U\n\7\r\7\16\7V\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f"+
		"\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\5\21l\n\21\3\22\3\22\3\23"+
		"\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\34\6\34\u008e\n\34\r\34\16\34\u008f\3\34\3\34\2\2\35\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\35\3\2\4\6\2\60\60\62;"+
		"C\\c|\4\2\13\13\"\"\2\u0095\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\39\3\2\2\2\5;\3\2\2\2\7=\3\2\2\2\tD\3\2\2\2\13K\3\2\2\2\r"+
		"T\3\2\2\2\17X\3\2\2\2\21Z\3\2\2\2\23\\\3\2\2\2\25^\3\2\2\2\27`\3\2\2\2"+
		"\31b\3\2\2\2\33d\3\2\2\2\35f\3\2\2\2\37h\3\2\2\2!k\3\2\2\2#m\3\2\2\2%"+
		"o\3\2\2\2\'q\3\2\2\2)t\3\2\2\2+w\3\2\2\2-y\3\2\2\2/{\3\2\2\2\61~\3\2\2"+
		"\2\63\u0081\3\2\2\2\65\u0086\3\2\2\2\67\u008d\3\2\2\29:\7.\2\2:\4\3\2"+
		"\2\2;<\7a\2\2<\6\3\2\2\2=>\7H\2\2>?\7q\2\2?@\7t\2\2@A\7c\2\2AB\7n\2\2"+
		"BC\7n\2\2C\b\3\2\2\2DE\7G\2\2EF\7z\2\2FG\7k\2\2GH\7u\2\2HI\7v\2\2IJ\7"+
		"u\2\2J\n\3\2\2\2KM\7$\2\2LN\5!\21\2ML\3\2\2\2NO\3\2\2\2OM\3\2\2\2OP\3"+
		"\2\2\2PQ\3\2\2\2QR\7$\2\2R\f\3\2\2\2SU\5!\21\2TS\3\2\2\2UV\3\2\2\2VT\3"+
		"\2\2\2VW\3\2\2\2W\16\3\2\2\2XY\7*\2\2Y\20\3\2\2\2Z[\7#\2\2[\22\3\2\2\2"+
		"\\]\7+\2\2]\24\3\2\2\2^_\7`\2\2_\26\3\2\2\2`a\7?\2\2a\30\3\2\2\2bc\7-"+
		"\2\2c\32\3\2\2\2de\7/\2\2e\34\3\2\2\2fg\7,\2\2g\36\3\2\2\2hi\7\61\2\2"+
		"i \3\2\2\2jl\t\2\2\2kj\3\2\2\2l\"\3\2\2\2mn\7(\2\2n$\3\2\2\2op\7~\2\2"+
		"p&\3\2\2\2qr\7/\2\2rs\7@\2\2s(\3\2\2\2tu\7>\2\2uv\7@\2\2v*\3\2\2\2wx\7"+
		"@\2\2x,\3\2\2\2yz\7>\2\2z.\3\2\2\2{|\7>\2\2|}\7?\2\2}\60\3\2\2\2~\177"+
		"\7@\2\2\177\u0080\7?\2\2\u0080\62\3\2\2\2\u0081\u0082\7V\2\2\u0082\u0083"+
		"\7T\2\2\u0083\u0084\7W\2\2\u0084\u0085\7G\2\2\u0085\64\3\2\2\2\u0086\u0087"+
		"\7H\2\2\u0087\u0088\7C\2\2\u0088\u0089\7N\2\2\u0089\u008a\7U\2\2\u008a"+
		"\u008b\7G\2\2\u008b\66\3\2\2\2\u008c\u008e\t\3\2\2\u008d\u008c\3\2\2\2"+
		"\u008e\u008f\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091"+
		"\3\2\2\2\u0091\u0092\b\34\2\2\u00928\3\2\2\2\7\2OVk\u008f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}