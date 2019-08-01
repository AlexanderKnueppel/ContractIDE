package de.tu_bs.ccc.contracting.grammar.verification;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class GrammarChecker {
	FOLZ3VisitorImpl visitor = new FOLZ3VisitorImpl();

	public FOLZ3VisitorImpl getVisitor() {
		return visitor;
	}

	public void setVisitor(FOLZ3VisitorImpl visitor) {
		this.visitor = visitor;
	}

	String error = new String();

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	

	public void parseString(String x) {
		String input = x;
		String returnString = null;

		FOLZ3Lexer lexer = new FOLZ3Lexer(CharStreams.fromString(input));
		lexer.removeErrorListeners();

		lexer.addErrorListener(new CustomErrorListener());
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		FOLZ3Parser parser = new FOLZ3Parser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(new CustomErrorListener());
		parser.getBuildParseTree();
		FOLZ3VisitorImpl xx = new FOLZ3VisitorImpl();
		String traverseResult = xx.visitCondition(parser.condition());

	}

}
