/*
* generated by Xtext
*/
package cz.jpikl.yafmt.clang.scl.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import cz.jpikl.yafmt.clang.scl.services.SimpleConstraintLanguageGrammarAccess;

public class SimpleConstraintLanguageParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private SimpleConstraintLanguageGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected cz.jpikl.yafmt.clang.scl.parser.antlr.internal.InternalSimpleConstraintLanguageParser createParser(XtextTokenStream stream) {
		return new cz.jpikl.yafmt.clang.scl.parser.antlr.internal.InternalSimpleConstraintLanguageParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Expression";
	}
	
	public SimpleConstraintLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(SimpleConstraintLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
