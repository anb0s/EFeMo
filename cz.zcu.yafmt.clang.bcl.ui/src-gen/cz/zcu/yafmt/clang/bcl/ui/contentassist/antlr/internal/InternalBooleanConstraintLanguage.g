/*
* generated by Xtext
*/
grammar InternalBooleanConstraintLanguage;

options {
	superClass=AbstractInternalContentAssistParser;
	
}

@lexer::header {
package cz.zcu.yafmt.clang.bcl.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package cz.zcu.yafmt.clang.bcl.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import cz.zcu.yafmt.clang.bcl.services.BooleanConstraintLanguageGrammarAccess;

}

@parser::members {
 
 	private BooleanConstraintLanguageGrammarAccess grammarAccess;
 	
    public void setGrammarAccess(BooleanConstraintLanguageGrammarAccess grammarAccess) {
    	this.grammarAccess = grammarAccess;
    }
    
    @Override
    protected Grammar getGrammar() {
    	return grammarAccess.getGrammar();
    }
    
    @Override
    protected String getValueForTokenName(String tokenName) {
    	return tokenName;
    }

}




// Entry rule entryRuleExpression
entryRuleExpression 
:
{ before(grammarAccess.getExpressionRule()); }
	 ruleExpression
{ after(grammarAccess.getExpressionRule()); } 
	 EOF 
;

// Rule Expression
ruleExpression
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getExpressionAccess().getContextualExpressionParserRuleCall()); }
	ruleContextualExpression
{ after(grammarAccess.getExpressionAccess().getContextualExpressionParserRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleContextualExpression
entryRuleContextualExpression 
:
{ before(grammarAccess.getContextualExpressionRule()); }
	 ruleContextualExpression
{ after(grammarAccess.getContextualExpressionRule()); } 
	 EOF 
;

// Rule ContextualExpression
ruleContextualExpression
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getContextualExpressionAccess().getAlternatives()); }
(rule__ContextualExpression__Alternatives)
{ after(grammarAccess.getContextualExpressionAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEquation
entryRuleEquation 
:
{ before(grammarAccess.getEquationRule()); }
	 ruleEquation
{ after(grammarAccess.getEquationRule()); } 
	 EOF 
;

// Rule Equation
ruleEquation
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getEquationAccess().getGroup()); }
(rule__Equation__Group__0)
{ after(grammarAccess.getEquationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleImplication
entryRuleImplication 
:
{ before(grammarAccess.getImplicationRule()); }
	 ruleImplication
{ after(grammarAccess.getImplicationRule()); } 
	 EOF 
;

// Rule Implication
ruleImplication
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getImplicationAccess().getGroup()); }
(rule__Implication__Group__0)
{ after(grammarAccess.getImplicationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleDisjunction
entryRuleDisjunction 
:
{ before(grammarAccess.getDisjunctionRule()); }
	 ruleDisjunction
{ after(grammarAccess.getDisjunctionRule()); } 
	 EOF 
;

// Rule Disjunction
ruleDisjunction
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getDisjunctionAccess().getGroup()); }
(rule__Disjunction__Group__0)
{ after(grammarAccess.getDisjunctionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleConjunction
entryRuleConjunction 
:
{ before(grammarAccess.getConjunctionRule()); }
	 ruleConjunction
{ after(grammarAccess.getConjunctionRule()); } 
	 EOF 
;

// Rule Conjunction
ruleConjunction
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getConjunctionAccess().getGroup()); }
(rule__Conjunction__Group__0)
{ after(grammarAccess.getConjunctionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNegation
entryRuleNegation 
:
{ before(grammarAccess.getNegationRule()); }
	 ruleNegation
{ after(grammarAccess.getNegationRule()); } 
	 EOF 
;

// Rule Negation
ruleNegation
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNegationAccess().getAlternatives()); }
(rule__Negation__Alternatives)
{ after(grammarAccess.getNegationAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePrimaryExpression
entryRulePrimaryExpression 
:
{ before(grammarAccess.getPrimaryExpressionRule()); }
	 rulePrimaryExpression
{ after(grammarAccess.getPrimaryExpressionRule()); } 
	 EOF 
;

// Rule PrimaryExpression
rulePrimaryExpression
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); }
(rule__PrimaryExpression__Alternatives)
{ after(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__ContextualExpression__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContextualExpressionAccess().getGroup_0()); }
(rule__ContextualExpression__Group_0__0)
{ after(grammarAccess.getContextualExpressionAccess().getGroup_0()); }
)

    |(
{ before(grammarAccess.getContextualExpressionAccess().getEquationParserRuleCall_1()); }
	ruleEquation
{ after(grammarAccess.getContextualExpressionAccess().getEquationParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Negation__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNegationAccess().getPrimaryExpressionParserRuleCall_0()); }
	rulePrimaryExpression
{ after(grammarAccess.getNegationAccess().getPrimaryExpressionParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getNegationAccess().getGroup_1()); }
(rule__Negation__Group_1__0)
{ after(grammarAccess.getNegationAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrimaryExpressionAccess().getGroup_0()); }
(rule__PrimaryExpression__Group_0__0)
{ after(grammarAccess.getPrimaryExpressionAccess().getGroup_0()); }
)

    |(
{ before(grammarAccess.getPrimaryExpressionAccess().getGroup_1()); }
(rule__PrimaryExpression__Group_1__0)
{ after(grammarAccess.getPrimaryExpressionAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}



rule__ContextualExpression__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContextualExpression__Group_0__0__Impl
	rule__ContextualExpression__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ContextualExpression__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContextualExpressionAccess().getContextKeyword_0_0()); }

	'context' 

{ after(grammarAccess.getContextualExpressionAccess().getContextKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ContextualExpression__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContextualExpression__Group_0__1__Impl
	rule__ContextualExpression__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ContextualExpression__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContextualExpressionAccess().getContextualExpressionAction_0_1()); }
(

)
{ after(grammarAccess.getContextualExpressionAccess().getContextualExpressionAction_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ContextualExpression__Group_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContextualExpression__Group_0__2__Impl
	rule__ContextualExpression__Group_0__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ContextualExpression__Group_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContextualExpressionAccess().getContextIdAssignment_0_2()); }
(rule__ContextualExpression__ContextIdAssignment_0_2)
{ after(grammarAccess.getContextualExpressionAccess().getContextIdAssignment_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ContextualExpression__Group_0__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContextualExpression__Group_0__3__Impl
	rule__ContextualExpression__Group_0__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ContextualExpression__Group_0__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContextualExpressionAccess().getColonKeyword_0_3()); }

	':' 

{ after(grammarAccess.getContextualExpressionAccess().getColonKeyword_0_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ContextualExpression__Group_0__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContextualExpression__Group_0__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ContextualExpression__Group_0__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContextualExpressionAccess().getExpressionAssignment_0_4()); }
(rule__ContextualExpression__ExpressionAssignment_0_4)
{ after(grammarAccess.getContextualExpressionAccess().getExpressionAssignment_0_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__Equation__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Equation__Group__0__Impl
	rule__Equation__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Equation__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEquationAccess().getImplicationParserRuleCall_0()); }
	ruleImplication
{ after(grammarAccess.getEquationAccess().getImplicationParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Equation__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Equation__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Equation__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEquationAccess().getGroup_1()); }
(rule__Equation__Group_1__0)*
{ after(grammarAccess.getEquationAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Equation__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Equation__Group_1__0__Impl
	rule__Equation__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Equation__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEquationAccess().getEquationLeftPartAction_1_0()); }
(

)
{ after(grammarAccess.getEquationAccess().getEquationLeftPartAction_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Equation__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Equation__Group_1__1__Impl
	rule__Equation__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Equation__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEquationAccess().getEqualsKeyword_1_1()); }

	'equals' 

{ after(grammarAccess.getEquationAccess().getEqualsKeyword_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Equation__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Equation__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Equation__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEquationAccess().getRightPartAssignment_1_2()); }
(rule__Equation__RightPartAssignment_1_2)
{ after(grammarAccess.getEquationAccess().getRightPartAssignment_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__Implication__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Implication__Group__0__Impl
	rule__Implication__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Implication__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImplicationAccess().getDisjunctionParserRuleCall_0()); }
	ruleDisjunction
{ after(grammarAccess.getImplicationAccess().getDisjunctionParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Implication__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Implication__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Implication__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImplicationAccess().getGroup_1()); }
(rule__Implication__Group_1__0)*
{ after(grammarAccess.getImplicationAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Implication__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Implication__Group_1__0__Impl
	rule__Implication__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Implication__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImplicationAccess().getImplicationLeftPartAction_1_0()); }
(

)
{ after(grammarAccess.getImplicationAccess().getImplicationLeftPartAction_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Implication__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Implication__Group_1__1__Impl
	rule__Implication__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Implication__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImplicationAccess().getImpliesKeyword_1_1()); }

	'implies' 

{ after(grammarAccess.getImplicationAccess().getImpliesKeyword_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Implication__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Implication__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Implication__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImplicationAccess().getRightPartAssignment_1_2()); }
(rule__Implication__RightPartAssignment_1_2)
{ after(grammarAccess.getImplicationAccess().getRightPartAssignment_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__Disjunction__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Disjunction__Group__0__Impl
	rule__Disjunction__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Disjunction__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDisjunctionAccess().getConjunctionParserRuleCall_0()); }
	ruleConjunction
{ after(grammarAccess.getDisjunctionAccess().getConjunctionParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Disjunction__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Disjunction__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Disjunction__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDisjunctionAccess().getGroup_1()); }
(rule__Disjunction__Group_1__0)*
{ after(grammarAccess.getDisjunctionAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Disjunction__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Disjunction__Group_1__0__Impl
	rule__Disjunction__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Disjunction__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDisjunctionAccess().getDisjunctionLeftPartAction_1_0()); }
(

)
{ after(grammarAccess.getDisjunctionAccess().getDisjunctionLeftPartAction_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Disjunction__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Disjunction__Group_1__1__Impl
	rule__Disjunction__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Disjunction__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDisjunctionAccess().getOrKeyword_1_1()); }

	'or' 

{ after(grammarAccess.getDisjunctionAccess().getOrKeyword_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Disjunction__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Disjunction__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Disjunction__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDisjunctionAccess().getRightPartAssignment_1_2()); }
(rule__Disjunction__RightPartAssignment_1_2)
{ after(grammarAccess.getDisjunctionAccess().getRightPartAssignment_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__Conjunction__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Conjunction__Group__0__Impl
	rule__Conjunction__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Conjunction__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConjunctionAccess().getNegationParserRuleCall_0()); }
	ruleNegation
{ after(grammarAccess.getConjunctionAccess().getNegationParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Conjunction__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Conjunction__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Conjunction__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConjunctionAccess().getGroup_1()); }
(rule__Conjunction__Group_1__0)*
{ after(grammarAccess.getConjunctionAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Conjunction__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Conjunction__Group_1__0__Impl
	rule__Conjunction__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Conjunction__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConjunctionAccess().getConjunctionLeftPartAction_1_0()); }
(

)
{ after(grammarAccess.getConjunctionAccess().getConjunctionLeftPartAction_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Conjunction__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Conjunction__Group_1__1__Impl
	rule__Conjunction__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Conjunction__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConjunctionAccess().getAndKeyword_1_1()); }

	'and' 

{ after(grammarAccess.getConjunctionAccess().getAndKeyword_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Conjunction__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Conjunction__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Conjunction__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConjunctionAccess().getRightPartAssignment_1_2()); }
(rule__Conjunction__RightPartAssignment_1_2)
{ after(grammarAccess.getConjunctionAccess().getRightPartAssignment_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__Negation__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Negation__Group_1__0__Impl
	rule__Negation__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Negation__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNegationAccess().getNotKeyword_1_0()); }

	'not' 

{ after(grammarAccess.getNegationAccess().getNotKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Negation__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Negation__Group_1__1__Impl
	rule__Negation__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Negation__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNegationAccess().getNegationAction_1_1()); }
(

)
{ after(grammarAccess.getNegationAccess().getNegationAction_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Negation__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Negation__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Negation__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNegationAccess().getExpressionAssignment_1_2()); }
(rule__Negation__ExpressionAssignment_1_2)
{ after(grammarAccess.getNegationAccess().getExpressionAssignment_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__PrimaryExpression__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PrimaryExpression__Group_0__0__Impl
	rule__PrimaryExpression__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionAction_0_0()); }
(

)
{ after(grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionAction_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PrimaryExpression__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PrimaryExpression__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrimaryExpressionAccess().getFeatureIdAssignment_0_1()); }
(rule__PrimaryExpression__FeatureIdAssignment_0_1)
{ after(grammarAccess.getPrimaryExpressionAccess().getFeatureIdAssignment_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__PrimaryExpression__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PrimaryExpression__Group_1__0__Impl
	rule__PrimaryExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_1_0()); }

	'(' 

{ after(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PrimaryExpression__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PrimaryExpression__Group_1__1__Impl
	rule__PrimaryExpression__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_1_1()); }
	ruleExpression
{ after(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PrimaryExpression__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PrimaryExpression__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_1_2()); }

	')' 

{ after(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}









rule__ContextualExpression__ContextIdAssignment_0_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContextualExpressionAccess().getContextIdIDTerminalRuleCall_0_2_0()); }
	RULE_ID{ after(grammarAccess.getContextualExpressionAccess().getContextIdIDTerminalRuleCall_0_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ContextualExpression__ExpressionAssignment_0_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContextualExpressionAccess().getExpressionEquationParserRuleCall_0_4_0()); }
	ruleEquation{ after(grammarAccess.getContextualExpressionAccess().getExpressionEquationParserRuleCall_0_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Equation__RightPartAssignment_1_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEquationAccess().getRightPartImplicationParserRuleCall_1_2_0()); }
	ruleImplication{ after(grammarAccess.getEquationAccess().getRightPartImplicationParserRuleCall_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Implication__RightPartAssignment_1_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImplicationAccess().getRightPartDisjunctionParserRuleCall_1_2_0()); }
	ruleDisjunction{ after(grammarAccess.getImplicationAccess().getRightPartDisjunctionParserRuleCall_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Disjunction__RightPartAssignment_1_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDisjunctionAccess().getRightPartConjunctionParserRuleCall_1_2_0()); }
	ruleConjunction{ after(grammarAccess.getDisjunctionAccess().getRightPartConjunctionParserRuleCall_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Conjunction__RightPartAssignment_1_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConjunctionAccess().getRightPartNegationParserRuleCall_1_2_0()); }
	ruleNegation{ after(grammarAccess.getConjunctionAccess().getRightPartNegationParserRuleCall_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Negation__ExpressionAssignment_1_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNegationAccess().getExpressionPrimaryExpressionParserRuleCall_1_2_0()); }
	rulePrimaryExpression{ after(grammarAccess.getNegationAccess().getExpressionPrimaryExpressionParserRuleCall_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__FeatureIdAssignment_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrimaryExpressionAccess().getFeatureIdIDTerminalRuleCall_0_1_0()); }
	RULE_ID{ after(grammarAccess.getPrimaryExpressionAccess().getFeatureIdIDTerminalRuleCall_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


