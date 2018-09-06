// Generated from FOLZ3.g4 by ANTLR 4.4

	package contractmodelling.grammar;


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
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		STRING=1, VARIABLE=2, LPAREN=3, NOT=4, RPAREN=5, EQUAL=6, ADD=7, MINUS=8, 
		MULTI=9, DIVISION=10, CHARACTER=11, CONJ=12, DISJ=13, IMPL=14, BICOND=15, 
		GREATER=16, SMALLER=17, SMALLEREQ=18, GREATEREQ=19, TRUE=20, FALSE=21, 
		WHITESPACE=22;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'"
	};
	public static final String[] ruleNames = {
		"STRING", "VARIABLE", "LPAREN", "NOT", "RPAREN", "EQUAL", "ADD", "MINUS", 
		"MULTI", "DIVISION", "CHARACTER", "CONJ", "DISJ", "IMPL", "BICOND", "GREATER", 
		"SMALLER", "SMALLEREQ", "GREATEREQ", "TRUE", "FALSE", "WHITESPACE"
	};


	public FOLZ3Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FOLZ3.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\30w\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\6\2\62\n\2"+
		"\r\2\16\2\63\3\2\3\2\3\3\6\39\n\3\r\3\16\3:\3\4\3\4\3\5\3\5\3\6\3\6\3"+
		"\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\5\fN\n\f\3\r\3\r\3\16\3\16"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\27\6\27r\n\27\r\27\16\27s\3\27\3\27\2\2\30\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30\3\2\4\6\2\60\60\62;C\\c|\4\2\13\13\"\"y\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\3/\3\2\2\2\58\3\2\2\2\7"+
		"<\3\2\2\2\t>\3\2\2\2\13@\3\2\2\2\rB\3\2\2\2\17D\3\2\2\2\21F\3\2\2\2\23"+
		"H\3\2\2\2\25J\3\2\2\2\27M\3\2\2\2\31O\3\2\2\2\33Q\3\2\2\2\35S\3\2\2\2"+
		"\37V\3\2\2\2!Y\3\2\2\2#\\\3\2\2\2%_\3\2\2\2\'b\3\2\2\2)e\3\2\2\2+j\3\2"+
		"\2\2-q\3\2\2\2/\61\7$\2\2\60\62\5\27\f\2\61\60\3\2\2\2\62\63\3\2\2\2\63"+
		"\61\3\2\2\2\63\64\3\2\2\2\64\65\3\2\2\2\65\66\7$\2\2\66\4\3\2\2\2\679"+
		"\5\27\f\28\67\3\2\2\29:\3\2\2\2:8\3\2\2\2:;\3\2\2\2;\6\3\2\2\2<=\7*\2"+
		"\2=\b\3\2\2\2>?\7#\2\2?\n\3\2\2\2@A\7+\2\2A\f\3\2\2\2BC\7?\2\2C\16\3\2"+
		"\2\2DE\7-\2\2E\20\3\2\2\2FG\7/\2\2G\22\3\2\2\2HI\7,\2\2I\24\3\2\2\2JK"+
		"\7\61\2\2K\26\3\2\2\2LN\t\2\2\2ML\3\2\2\2N\30\3\2\2\2OP\7(\2\2P\32\3\2"+
		"\2\2QR\7~\2\2R\34\3\2\2\2ST\7/\2\2TU\7@\2\2U\36\3\2\2\2VW\7>\2\2WX\7@"+
		"\2\2X \3\2\2\2YZ\7@\2\2Z[\7@\2\2[\"\3\2\2\2\\]\7>\2\2]^\7>\2\2^$\3\2\2"+
		"\2_`\7>\2\2`a\7?\2\2a&\3\2\2\2bc\7@\2\2cd\7?\2\2d(\3\2\2\2ef\7V\2\2fg"+
		"\7T\2\2gh\7W\2\2hi\7G\2\2i*\3\2\2\2jk\7H\2\2kl\7C\2\2lm\7N\2\2mn\7U\2"+
		"\2no\7G\2\2o,\3\2\2\2pr\t\3\2\2qp\3\2\2\2rs\3\2\2\2sq\3\2\2\2st\3\2\2"+
		"\2tu\3\2\2\2uv\b\27\2\2v.\3\2\2\2\7\2\63:Ms\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}