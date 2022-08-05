package unit;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

public class Lexer extends model.AbstractLexer {
	// TODO: do NOT redefine superclass fields
	
	//public Token TOKEN;
	//public char[] LEXEME;
	
	/*private enum TOKEN {
		LET_KEYWORD,	// regex /let/i
		EQUAL,			// regex /=/
		COMMA,			// regex /,/
		EVAL_KEYWORD,	// regex /eval/i
		QUESTION,		// regex /\?/
		DOUBLE_ARROW,	// regex /<->/
		ARROW,			// regex /->/
		VEE,			// regex /v/i
		CARET,			// regex /\^/
		APOSTROPHE,		// regex /'/
		OPEN_PAREN,		// regex /\(/
		CLOSE_PAREN,	// regex /\)/
		VARIABLE_NAME,	// regex /[a-z]+/i
		TRUE_LITERAL,	// regex /1/
		FALSE_LITERAL	// regex /0/
	}*/
	
	private char[] S;
	private int i;

	@Override
	public void initialize(char[] sentence) {
		//TODO: implement this method stub
		S = sentence;
		i = -1;
		//throw new UnsupportedOperationException();
	}

	@Override
	public void lex() {
		// TODO: implement this method stub
		//TOKEN = null;
		//LEXEME = null;
		
		if (S == null || i >= S.length)
			return;
		do {
			i++;
			if (i >= S.length)
				return;
		}while (S[i] == ' ');
		
		if (S[i] == 'l')
			TOKEN = Token.LET_KEYWORD;
			
		else if (S[i] == '=')
			TOKEN = Token.EQUAL;
		else if (S[i] == ',')
			TOKEN = Token.COMMA;
		else if (S[i] == 'e')
			TOKEN = Token.EVAL_KEYWORD;
		else if (S[i] == '?')
			TOKEN = Token.QUESTION;
		else if (S[i] == '<' && S[i] == '-' && S[i] == '>')
			TOKEN = Token.DOUBLE_ARROW;
		else if (S[i] == '-' && S[i] == '>')
			TOKEN = Token.ARROW;
		else if (S[i] == 'v')
			TOKEN = Token.VEE;
		else if (S[i] == '^')
			TOKEN = Token.CARET;
		else if (S[i] == '\'')
			TOKEN = Token.APOSTROPHE;
		else if (S[i] == '(')
			TOKEN = Token.OPEN_PAREN;
		else if (S[i] == ')')
			TOKEN = Token.CLOSE_PAREN;
		else if (S[i] >= 'a' && S[i] <= 'z') {
			//construct later /*S[i] >= 'a' && S[i] <= 'z'*/S[i] == 'a'-'z'
			int length = 1;
			while (i + length < S.length && S[i + length] >= 'a' && S[i + length] <= 'a')
				length++;
			TOKEN = Token.VARIABLE_NAME;
			LEXEME = new char[length];
			for (int j = 0; j < length; j++) {
				LEXEME[j] = S[i + j];
				i += length - 1;
			}
		}
		else if (S[i] == '1')
			TOKEN = Token.TRUE_LITERAL;
		else if (S[i] == '0')
			TOKEN = Token.FALSE_LITERAL;
		else throw new UnexpectedTokenException("Unexpected: " + S[i]);
		
		return;
	}
	
	
	/*
	private boolean accept(Token type) {
		if (TOKEN == type) {
			trace_flush("Accept: " + type);
			lex();
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean peek(Token type) {
		if (TOKEN == type) {
			trace_flush("Peek: " + type);
			return true;
		}
		else {
			return false;
		}
	}
	
	
	private boolean expect(Token type) {
		if (TOKEN == type) {
			trace_flush("Expect: " + type);
			lex();
			trace_lexed();
		}
		else throw new RuntimeException("Expected: " + type + ", Found: " + type );
	}*/
}
