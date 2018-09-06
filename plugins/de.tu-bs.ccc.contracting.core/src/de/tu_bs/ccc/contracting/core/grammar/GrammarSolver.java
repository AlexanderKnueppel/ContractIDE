package de.tu_bs.ccc.contracting.core.grammar;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;


public class GrammarSolver {
	


	public static void main(String[] args) throws Exception {

		
		
		String input = "Memory=\"BLAAA\"";
		FOLZ3Lexer lexer = new FOLZ3Lexer(CharStreams.fromString(input));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		FOLZ3Parser parser = new FOLZ3Parser(tokens);
		parser.getBuildParseTree();
		FOLZ3VisitorImpl xx = new FOLZ3VisitorImpl();
		String traverseResult = xx.visitCondition(parser.condition());
		System.out.println(traverseResult);
		
		

	}
	public String parseString(String x) {
		String input = x;
		FOLZ3Lexer lexer = new FOLZ3Lexer(CharStreams.fromString(input));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		FOLZ3Parser parser = new FOLZ3Parser(tokens);
		parser.getBuildParseTree();
		FOLZ3VisitorImpl xx = new FOLZ3VisitorImpl();
		String traverseResult = xx.visitCondition(parser.condition());
		return traverseResult;
		
		
	}

}
