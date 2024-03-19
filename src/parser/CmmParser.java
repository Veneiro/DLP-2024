// Generated from C:/Users/mateo/Documentos/Universidad/DLP/AST_DLP/src/parser/Cmm.g4 by ANTLR 4.13.1
package parser;

    import ast.*;
    import ast.expression.*;
    import ast.program.*;
    import ast.statement.*;
    import ast.type.*;
    import ast.errorhandler.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, INT_CONSTANT=37, REAL_CONSTANT=38, 
		REAL_CONSTANT_WITH_EXPONENT=39, CHAR_CONSTANT=40, ON_LINE_COMMENT=41, 
		MULTI_LINE_COMMENT=42, ID=43, WHITE_SPACES=44;
	public static final int
		RULE_program = 0, RULE_definitions = 1, RULE_expression = 2, RULE_expressions = 3, 
		RULE_statement = 4, RULE_block = 5, RULE_type = 6, RULE_built_in_type = 7, 
		RULE_main_func_def = 8, RULE_varDef = 9, RULE_ids = 10, RULE_funcDef = 11, 
		RULE_return_type = 12, RULE_params = 13, RULE_parameter = 14, RULE_body = 15, 
		RULE_struct = 16, RULE_record = 17, RULE_field = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "definitions", "expression", "expressions", "statement", "block", 
			"type", "built_in_type", "main_func_def", "varDef", "ids", "funcDef", 
			"return_type", "params", "parameter", "body", "struct", "record", "field"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'['", "']'", "'.'", "'-'", "'!'", "'*'", "'/'", 
			"'%'", "'+'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'&&'", "'||'", 
			"','", "'read'", "';'", "'write'", "'='", "'if'", "'else'", "'while'", 
			"'return'", "'{'", "'}'", "'int'", "'double'", "'char'", "'void'", "'main'", 
			"'struct'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "INT_CONSTANT", "REAL_CONSTANT", "REAL_CONSTANT_WITH_EXPONENT", 
			"CHAR_CONSTANT", "ON_LINE_COMMENT", "MULTI_LINE_COMMENT", "ID", "WHITE_SPACES"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "Cmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public DefinitionsContext d;
		public Main_func_defContext def_main;
		public DefinitionsContext definitions() {
			return getRuleContext(DefinitionsContext.class,0);
		}
		public Main_func_defContext main_func_def() {
			return getRuleContext(Main_func_defContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			((ProgramContext)_localctx).d = definitions();
			setState(39);
			((ProgramContext)_localctx).def_main = main_func_def();
			 ((ProgramContext)_localctx).ast =  new Program(0,0,((ProgramContext)_localctx).d.ast, ((ProgramContext)_localctx).def_main.ast); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class DefinitionsContext extends ParserRuleContext {
		public List<Definition> ast = new ArrayList<>();
		public VarDefContext def_var;
		public FuncDefContext def_func;
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public DefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitions; }
	}

	public final DefinitionsContext definitions() throws RecognitionException {
		DefinitionsContext _localctx = new DefinitionsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definitions);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(48);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						setState(42);
						((DefinitionsContext)_localctx).def_var = varDef();
						 _localctx.ast.addAll(((DefinitionsContext)_localctx).def_var.ast); 
						}
						break;
					case 2:
						{
						setState(45);
						((DefinitionsContext)_localctx).def_func = funcDef();
						 _localctx.ast.add(((DefinitionsContext)_localctx).def_func.ast); 
						}
						break;
					}
					} 
				}
				setState(52);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Expression ast;
		public ExpressionContext exp_list;
		public ExpressionContext exp_to_access;
		public ExpressionContext exp_left;
		public Token ID;
		public Token RC;
		public Token CC;
		public Token IC;
		public ExpressionContext e1;
		public Built_in_typeContext cast_type;
		public ExpressionContext exp_to_cast;
		public ExpressionContext exp_num;
		public ExpressionContext exp_not;
		public ExpressionsContext es;
		public Token OP;
		public ExpressionContext exp_right;
		public ExpressionContext exp_index;
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(CmmParser.REAL_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(CmmParser.CHAR_CONSTANT, 0); }
		public TerminalNode INT_CONSTANT() { return getToken(CmmParser.INT_CONSTANT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Built_in_typeContext built_in_type() {
			return getRuleContext(Built_in_typeContext.class,0);
		}
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(54);
				((ExpressionContext)_localctx).ID = match(ID);
				 ((ExpressionContext)_localctx).ast =  new Variable(((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine()+1, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)); 
				}
				break;
			case 2:
				{
				setState(56);
				((ExpressionContext)_localctx).RC = match(REAL_CONSTANT);
				((ExpressionContext)_localctx).ast =  new RealLiteral(((ExpressionContext)_localctx).RC.getLine(), ((ExpressionContext)_localctx).RC.getCharPositionInLine()+1, LexerHelper.lexemeToReal((((ExpressionContext)_localctx).RC!=null?((ExpressionContext)_localctx).RC.getText():null)));
				}
				break;
			case 3:
				{
				setState(58);
				((ExpressionContext)_localctx).CC = match(CHAR_CONSTANT);
				((ExpressionContext)_localctx).ast =  new CharLiteral(((ExpressionContext)_localctx).CC.getLine(), ((ExpressionContext)_localctx).CC.getCharPositionInLine()+1, LexerHelper.lexemeToChar((((ExpressionContext)_localctx).CC!=null?((ExpressionContext)_localctx).CC.getText():null)));
				}
				break;
			case 4:
				{
				setState(60);
				((ExpressionContext)_localctx).IC = match(INT_CONSTANT);
				((ExpressionContext)_localctx).ast =  new IntLiteral(((ExpressionContext)_localctx).IC.getLine(), ((ExpressionContext)_localctx).IC.getCharPositionInLine()+1, LexerHelper.lexemeToInt((((ExpressionContext)_localctx).IC!=null?((ExpressionContext)_localctx).IC.getText():null)));
				}
				break;
			case 5:
				{
				setState(62);
				match(T__0);
				setState(63);
				((ExpressionContext)_localctx).e1 = expression(0);
				setState(64);
				match(T__1);
				((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).e1.ast;
				}
				break;
			case 6:
				{
				setState(67);
				match(T__0);
				setState(68);
				((ExpressionContext)_localctx).cast_type = built_in_type();
				setState(69);
				match(T__1);
				setState(70);
				((ExpressionContext)_localctx).exp_to_cast = expression(8);
				((ExpressionContext)_localctx).ast =  new Cast(((ExpressionContext)_localctx).exp_to_cast.ast.getLine(), ((ExpressionContext)_localctx).exp_to_cast.ast.getColumn(), ((ExpressionContext)_localctx).cast_type.ast, ((ExpressionContext)_localctx).exp_to_cast.ast);
				}
				break;
			case 7:
				{
				setState(73);
				match(T__5);
				setState(74);
				((ExpressionContext)_localctx).exp_num = expression(7);
				((ExpressionContext)_localctx).ast =  new UnaryMinus(((ExpressionContext)_localctx).exp_num.ast.getLine(), ((ExpressionContext)_localctx).exp_num.ast.getColumn(), ((ExpressionContext)_localctx).exp_num.ast);
				}
				break;
			case 8:
				{
				setState(77);
				match(T__6);
				setState(78);
				((ExpressionContext)_localctx).exp_not = expression(6);
				((ExpressionContext)_localctx).ast =  new UnaryNot(((ExpressionContext)_localctx).exp_not.ast.getLine(), ((ExpressionContext)_localctx).exp_not.ast.getColumn(), ((ExpressionContext)_localctx).exp_not.ast);
				}
				break;
			case 9:
				{
				setState(81);
				((ExpressionContext)_localctx).ID = match(ID);
				setState(82);
				match(T__0);
				setState(83);
				((ExpressionContext)_localctx).es = expressions();
				setState(84);
				match(T__1);
				((ExpressionContext)_localctx).ast =  new FuncInvocation(((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine()+1, new Variable(((ExpressionContext)_localctx).ID.getLine(),
				                ((ExpressionContext)_localctx).ID.getCharPositionInLine()+1, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)), ((ExpressionContext)_localctx).es.ast);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(121);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(119);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp_left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(89);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(90);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1792L) != 0)) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(91);
						((ExpressionContext)_localctx).exp_right = expression(6);
						 ((ExpressionContext)_localctx).ast =  Arithmetic.arithmeticFactory(((ExpressionContext)_localctx).exp_left.ast.getLine(), ((ExpressionContext)_localctx).exp_left.ast.getColumn(),
						                          ((ExpressionContext)_localctx).exp_left.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).exp_right.ast); 
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp_left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(94);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(95);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__5 || _la==T__10) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(96);
						((ExpressionContext)_localctx).exp_right = expression(5);
						 ((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).exp_left.ast.getLine(), ((ExpressionContext)_localctx).exp_left.ast.getColumn(),
						                          ((ExpressionContext)_localctx).exp_left.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).exp_right.ast); 
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp_left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(99);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(100);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 258048L) != 0)) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(101);
						((ExpressionContext)_localctx).exp_right = expression(4);
						 ((ExpressionContext)_localctx).ast =  new Logical(((ExpressionContext)_localctx).exp_left.ast.getLine(), ((ExpressionContext)_localctx).exp_left.ast.getColumn(),
						                          ((ExpressionContext)_localctx).exp_left.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).exp_right.ast); 
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp_left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(104);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(105);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__17 || _la==T__18) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(106);
						((ExpressionContext)_localctx).exp_right = expression(3);
						 ((ExpressionContext)_localctx).ast =  new Logical(((ExpressionContext)_localctx).exp_left.ast.getLine(), ((ExpressionContext)_localctx).exp_left.ast.getColumn(),
						                          ((ExpressionContext)_localctx).exp_left.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).exp_right.ast); 
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp_list = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(109);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(110);
						match(T__2);
						setState(111);
						((ExpressionContext)_localctx).exp_index = expression(0);
						setState(112);
						match(T__3);
						((ExpressionContext)_localctx).ast =  new Indexing(((ExpressionContext)_localctx).exp_list.ast.getLine(), ((ExpressionContext)_localctx).exp_list.ast.getColumn(), ((ExpressionContext)_localctx).exp_list.ast, ((ExpressionContext)_localctx).exp_index.ast);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp_to_access = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(115);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(116);
						match(T__4);
						setState(117);
						((ExpressionContext)_localctx).ID = match(ID);
						((ExpressionContext)_localctx).ast =  new FieldAccess(((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine()+1, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null), ((ExpressionContext)_localctx).exp_to_access.ast);
						}
						break;
					}
					} 
				}
				setState(123);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionsContext extends ParserRuleContext {
		public List<Expression> ast = new ArrayList<>();
		public ExpressionContext e1;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expressions);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 10307921510594L) != 0)) {
				{
				setState(130);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(124);
						((ExpressionsContext)_localctx).e1 = expression(0);
						 _localctx.ast.add(((ExpressionsContext)_localctx).e1.ast); 
						setState(126);
						match(T__19);
						}
						} 
					}
					setState(132);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
				setState(133);
				((ExpressionsContext)_localctx).e2 = expression(0);
				 _localctx.ast.add(((ExpressionsContext)_localctx).e2.ast); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public Statement ast;
		public List<Statement> else_statements = new ArrayList<>();;
		public Token r;
		public ExpressionContext toRead;
		public Token w;
		public ExpressionsContext es_to_write;
		public ExpressionContext assignTo;
		public ExpressionContext toAssign;
		public Token ID;
		public ExpressionsContext es;
		public Token i;
		public ExpressionContext exp;
		public BlockContext if_stmts;
		public BlockContext else_stmts;
		public Token wh;
		public ExpressionContext e1;
		public BlockContext while_block;
		public ExpressionContext exp_to_return;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(195);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				((StatementContext)_localctx).r = match(T__20);
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 10307921510594L) != 0)) {
					{
					setState(144);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(139);
							((StatementContext)_localctx).toRead = expression(0);
							setState(140);
							match(T__19);
							}
							} 
						}
						setState(146);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
					}
					setState(147);
					((StatementContext)_localctx).toRead = expression(0);
					}
				}

				setState(150);
				match(T__21);
				((StatementContext)_localctx).ast =  new Read(((StatementContext)_localctx).r.getLine(), ((StatementContext)_localctx).r.getCharPositionInLine()+1, ((StatementContext)_localctx).toRead.ast);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				((StatementContext)_localctx).w = match(T__22);
				setState(153);
				((StatementContext)_localctx).es_to_write = expressions();
				setState(154);
				match(T__21);
				((StatementContext)_localctx).ast =  new Write(((StatementContext)_localctx).w.getLine(), ((StatementContext)_localctx).w.getCharPositionInLine()+1, ((StatementContext)_localctx).es_to_write.ast);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(157);
				((StatementContext)_localctx).assignTo = expression(0);
				setState(158);
				match(T__23);
				setState(159);
				((StatementContext)_localctx).toAssign = expression(0);
				setState(160);
				match(T__21);
				((StatementContext)_localctx).ast =  new Assignment(((StatementContext)_localctx).assignTo.ast.getLine(), ((StatementContext)_localctx).assignTo.ast.getColumn(), ((StatementContext)_localctx).assignTo.ast, ((StatementContext)_localctx).toAssign.ast);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(163);
				((StatementContext)_localctx).ID = match(ID);
				setState(164);
				match(T__0);
				setState(165);
				((StatementContext)_localctx).es = expressions();
				setState(166);
				match(T__1);
				setState(167);
				match(T__21);

				              ((StatementContext)_localctx).ast =  new FunctionInvocation(
				              ((StatementContext)_localctx).ID.getLine(),
				              ((StatementContext)_localctx).ID.getCharPositionInLine() + 1,
				              new Variable(((StatementContext)_localctx).ID.getLine(),
				                              ((StatementContext)_localctx).ID.getCharPositionInLine()+1, (((StatementContext)_localctx).ID!=null?((StatementContext)_localctx).ID.getText():null)),
				              ((StatementContext)_localctx).es.ast
				            );
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(170);
				((StatementContext)_localctx).i = match(T__24);
				setState(171);
				match(T__0);
				setState(172);
				((StatementContext)_localctx).exp = expression(0);
				setState(173);
				match(T__1);
				setState(174);
				((StatementContext)_localctx).if_stmts = block();
				setState(179);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(175);
					match(T__25);
					setState(176);
					((StatementContext)_localctx).else_stmts = block();
					((StatementContext)getInvokingContext(4)).else_statements =  ((StatementContext)_localctx).else_stmts.ast;
					}
					break;
				}
				((StatementContext)_localctx).ast =  new IfElse(
				                ((StatementContext)_localctx).i.getLine(),
				                ((StatementContext)_localctx).i.getCharPositionInLine() + 1,
				                ((StatementContext)_localctx).if_stmts.ast,
				                ((StatementContext)getInvokingContext(4)).else_statements,
				                ((StatementContext)_localctx).exp.ast
				            );
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(183);
				((StatementContext)_localctx).wh = match(T__26);
				setState(184);
				match(T__0);
				setState(185);
				((StatementContext)_localctx).e1 = expression(0);
				setState(186);
				match(T__1);
				setState(187);
				((StatementContext)_localctx).while_block = block();
				((StatementContext)_localctx).ast =  new While(
				                ((StatementContext)_localctx).wh.getLine(),
				                ((StatementContext)_localctx).wh.getCharPositionInLine() + 1,
				                ((StatementContext)_localctx).while_block.ast,
				                ((StatementContext)_localctx).e1.ast
				            );
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(190);
				match(T__27);
				setState(191);
				((StatementContext)_localctx).exp_to_return = expression(0);
				setState(192);
				match(T__21);
				((StatementContext)_localctx).ast =  new Return(((StatementContext)_localctx).exp_to_return.ast.getLine(), ((StatementContext)_localctx).exp_to_return.ast.getColumn(), ((StatementContext)_localctx).exp_to_return.ast);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<>();
		public StatementContext st1;
		public StatementContext st2;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		int _la;
		try {
			setState(210);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__5:
			case T__6:
			case T__20:
			case T__22:
			case T__24:
			case T__26:
			case T__27:
			case INT_CONSTANT:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				((BlockContext)_localctx).st1 = statement();
				_localctx.ast.add(((BlockContext)_localctx).st1.ast);
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 2);
				{
				setState(200);
				match(T__28);
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 10308368203970L) != 0)) {
					{
					{
					setState(201);
					((BlockContext)_localctx).st2 = statement();
					_localctx.ast.add(((BlockContext)_localctx).st2.ast);
					}
					}
					setState(208);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(209);
				match(T__29);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public TypeContext array_type;
		public Built_in_typeContext built_in_type;
		public StructContext s;
		public Token IC;
		public Built_in_typeContext built_in_type() {
			return getRuleContext(Built_in_typeContext.class,0);
		}
		public StructContext struct() {
			return getRuleContext(StructContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(CmmParser.INT_CONSTANT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
			case T__31:
			case T__32:
				{
				setState(213);
				((TypeContext)_localctx).built_in_type = built_in_type();
				((TypeContext)_localctx).ast =  ((TypeContext)_localctx).built_in_type.ast;
				}
				break;
			case T__35:
				{
				setState(216);
				((TypeContext)_localctx).s = struct();
				((TypeContext)_localctx).ast =  ((TypeContext)_localctx).s.ast;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(228);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					_localctx.array_type = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(221);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(222);
					match(T__2);
					setState(223);
					((TypeContext)_localctx).IC = match(INT_CONSTANT);
					setState(224);
					match(T__3);
					((TypeContext)_localctx).ast =  ArrayType.createArray(((TypeContext)_localctx).array_type.ast.getLine(), ((TypeContext)_localctx).array_type.ast.getColumn(),
					                          LexerHelper.lexemeToInt((((TypeContext)_localctx).IC!=null?((TypeContext)_localctx).IC.getText():null)), ((TypeContext)_localctx).array_type.ast);
					}
					} 
				}
				setState(230);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Built_in_typeContext extends ParserRuleContext {
		public Type ast;
		public Token t1;
		public Built_in_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_built_in_type; }
	}

	public final Built_in_typeContext built_in_type() throws RecognitionException {
		Built_in_typeContext _localctx = new Built_in_typeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_built_in_type);
		try {
			setState(237);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				enterOuterAlt(_localctx, 1);
				{
				setState(231);
				((Built_in_typeContext)_localctx).t1 = match(T__30);
				 ((Built_in_typeContext)_localctx).ast =  new IntType(((Built_in_typeContext)_localctx).t1.getLine(), ((Built_in_typeContext)_localctx).t1.getCharPositionInLine()+1);
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				setState(233);
				((Built_in_typeContext)_localctx).t1 = match(T__31);
				((Built_in_typeContext)_localctx).ast =  new DoubleType(((Built_in_typeContext)_localctx).t1.getLine(), ((Built_in_typeContext)_localctx).t1.getCharPositionInLine()+1);
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 3);
				{
				setState(235);
				((Built_in_typeContext)_localctx).t1 = match(T__32);
				((Built_in_typeContext)_localctx).ast =  new CharType(((Built_in_typeContext)_localctx).t1.getLine(), ((Built_in_typeContext)_localctx).t1.getCharPositionInLine()+1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Main_func_defContext extends ParserRuleContext {
		public FuncDefinition ast;
		public Token main;
		public BodyContext body;
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CmmParser.EOF, 0); }
		public Main_func_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main_func_def; }
	}

	public final Main_func_defContext main_func_def() throws RecognitionException {
		Main_func_defContext _localctx = new Main_func_defContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_main_func_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(T__33);
			setState(240);
			((Main_func_defContext)_localctx).main = match(T__34);
			setState(241);
			match(T__0);
			setState(242);
			match(T__1);
			setState(243);
			match(T__28);
			setState(244);
			((Main_func_defContext)_localctx).body = body();
			setState(245);
			match(T__29);
			setState(246);
			match(EOF);
			((Main_func_defContext)_localctx).ast =  new FuncDefinition(((Main_func_defContext)_localctx).main.getLine(), ((Main_func_defContext)_localctx).main.getCharPositionInLine()+1, ((Main_func_defContext)_localctx).body.ast, "main", null);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarDefContext extends ParserRuleContext {
		public List<VarDefinition> ast = new ArrayList<>();
		public TypeContext t;
		public IdsContext i;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdsContext ids() {
			return getRuleContext(IdsContext.class,0);
		}
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_varDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			((VarDefContext)_localctx).t = type(0);
			setState(250);
			((VarDefContext)_localctx).i = ids();
			setState(251);
			match(T__21);
			for (String id: ((VarDefContext)_localctx).i.ast) {
			                _localctx.ast.add(new VarDefinition(((VarDefContext)_localctx).t.ast.getLine(), ((VarDefContext)_localctx).t.ast.getColumn(), id, ((VarDefContext)_localctx).t.ast));
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

	@SuppressWarnings("CheckReturnValue")
	public static class IdsContext extends ParserRuleContext {
		public List<String> ast = new ArrayList<>();
		public Token i1;
		public Token i2;
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public IdsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ids; }
	}

	public final IdsContext ids() throws RecognitionException {
		IdsContext _localctx = new IdsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ids);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(254);
					((IdsContext)_localctx).i1 = match(ID);
					 _localctx.ast.add((((IdsContext)_localctx).i1!=null?((IdsContext)_localctx).i1.getText():null)); 
					setState(256);
					match(T__19);
					}
					} 
				}
				setState(261);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			setState(262);
			((IdsContext)_localctx).i2 = match(ID);
			 _localctx.ast.add((((IdsContext)_localctx).i2!=null?((IdsContext)_localctx).i2.getText():null)); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class FuncDefContext extends ParserRuleContext {
		public FuncDefinition ast;
		public Return_typeContext t;
		public Token ID;
		public ParamsContext params;
		public BodyContext b;
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_funcDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			((FuncDefContext)_localctx).t = return_type();
			setState(266);
			((FuncDefContext)_localctx).ID = match(ID);
			setState(267);
			match(T__0);
			setState(268);
			((FuncDefContext)_localctx).params = params();
			setState(269);
			match(T__1);
			setState(270);
			match(T__28);
			setState(271);
			((FuncDefContext)_localctx).b = body();
			setState(272);
			match(T__29);

			            FunctionType ft = new FunctionType(((FuncDefContext)_localctx).ID.getLine(), ((FuncDefContext)_localctx).ID.getCharPositionInLine() + 1, ((FuncDefContext)_localctx).params.ast, ((FuncDefContext)_localctx).t.ast);
			            ((FuncDefContext)_localctx).ast =  new FuncDefinition( ((FuncDefContext)_localctx).ID.getLine(), ((FuncDefContext)_localctx).ID.getCharPositionInLine() + 1, ((FuncDefContext)_localctx).b.ast, (((FuncDefContext)_localctx).ID!=null?((FuncDefContext)_localctx).ID.getText():null), ft );
			        
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

	@SuppressWarnings("CheckReturnValue")
	public static class Return_typeContext extends ParserRuleContext {
		public Type ast;
		public Built_in_typeContext built_in_type;
		public Built_in_typeContext built_in_type() {
			return getRuleContext(Built_in_typeContext.class,0);
		}
		public Return_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_type; }
	}

	public final Return_typeContext return_type() throws RecognitionException {
		Return_typeContext _localctx = new Return_typeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_return_type);
		try {
			setState(280);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
			case T__31:
			case T__32:
				enterOuterAlt(_localctx, 1);
				{
				setState(275);
				((Return_typeContext)_localctx).built_in_type = built_in_type();
				 ((Return_typeContext)_localctx).ast =  ((Return_typeContext)_localctx).built_in_type.ast; 
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 2);
				{
				setState(278);
				match(T__33);
				 ((Return_typeContext)_localctx).ast =  null; 
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParamsContext extends ParserRuleContext {
		public List<VarDefinition> ast = new ArrayList<>();
		public ParameterContext parameter;
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_params);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 15032385536L) != 0)) {
				{
				setState(288);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(282);
						((ParamsContext)_localctx).parameter = parameter();
						_localctx.ast.add(((ParamsContext)_localctx).parameter.ast);
						setState(284);
						match(T__19);
						}
						} 
					}
					setState(290);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				}
				setState(291);
				((ParamsContext)_localctx).parameter = parameter();
				_localctx.ast.add(((ParamsContext)_localctx).parameter.ast);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterContext extends ParserRuleContext {
		public VarDefinition ast;
		public Built_in_typeContext built_in_type;
		public Token ID;
		public Built_in_typeContext built_in_type() {
			return getRuleContext(Built_in_typeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			((ParameterContext)_localctx).built_in_type = built_in_type();
			setState(297);
			((ParameterContext)_localctx).ID = match(ID);
			((ParameterContext)_localctx).ast =  new VarDefinition(
			            ((ParameterContext)_localctx).ID.getLine(),
			            ((ParameterContext)_localctx).ID.getCharPositionInLine() + 1,
			            (((ParameterContext)_localctx).ID!=null?((ParameterContext)_localctx).ID.getText():null),
			            ((ParameterContext)_localctx).built_in_type.ast
			        );
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

	@SuppressWarnings("CheckReturnValue")
	public static class BodyContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<>();
		public VarDefContext varDef;
		public StatementContext st2;
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 83751862272L) != 0)) {
				{
				{
				setState(300);
				((BodyContext)_localctx).varDef = varDef();
				_localctx.ast.addAll(((BodyContext)_localctx).varDef.ast);
				}
				}
				setState(307);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 10308368203970L) != 0)) {
				{
				{
				setState(308);
				((BodyContext)_localctx).st2 = statement();
				_localctx.ast.add(((BodyContext)_localctx).st2.ast);
				}
				}
				setState(315);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StructContext extends ParserRuleContext {
		public StructType ast;
		public Token s;
		public RecordContext r;
		public RecordContext record() {
			return getRuleContext(RecordContext.class,0);
		}
		public StructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct; }
	}

	public final StructContext struct() throws RecognitionException {
		StructContext _localctx = new StructContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_struct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			((StructContext)_localctx).s = match(T__35);
			setState(317);
			match(T__28);
			setState(318);
			((StructContext)_localctx).r = record();
			setState(319);
			match(T__29);
			 ((StructContext)_localctx).ast =  new StructType(((StructContext)_localctx).s.getLine(), ((StructContext)_localctx).s.getCharPositionInLine()+1, ((StructContext)_localctx).r.ast);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RecordContext extends ParserRuleContext {
		public List<Field> ast = new ArrayList<>();
		public FieldContext field;
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public RecordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_record; }
	}

	public final RecordContext record() throws RecognitionException {
		RecordContext _localctx = new RecordContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_record);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 83751862272L) != 0)) {
				{
				{
				setState(322);
				((RecordContext)_localctx).field = field();
				 _localctx.ast.addAll(((RecordContext)_localctx).field.ast); 
				}
				}
				setState(329);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FieldContext extends ParserRuleContext {
		public List<Field> ast = new ArrayList<>();
		public TypeContext t;
		public IdsContext i;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdsContext ids() {
			return getRuleContext(IdsContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			((FieldContext)_localctx).t = type(0);
			setState(331);
			((FieldContext)_localctx).i = ids();
			setState(332);
			match(T__21);

			            for (String id: ((FieldContext)_localctx).i.ast) {
			                Field f = new Field(((FieldContext)_localctx).t.ast.getLine(), ((FieldContext)_localctx).t.ast.getColumn(), id, ((FieldContext)_localctx).t.ast);
			                if(_localctx.ast.contains(f)){
			                    ErrorType error = new ErrorType(((FieldContext)_localctx).t.ast.getLine(), ((FieldContext)_localctx).t.ast.getColumn(), "Struct must not have duplicated fields");
			                    ErrorHandler.getInstance().addError(error);
			                } else {
			                    _localctx.ast.add(f);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 6:
			return type_sempred((TypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001,\u0150\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u00011\b\u0001"+
		"\n\u0001\f\u00014\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002X\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0005\u0002x\b\u0002\n\u0002\f\u0002{\t\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003\u0081\b\u0003"+
		"\n\u0003\f\u0003\u0084\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003\u0089\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005"+
		"\u0004\u008f\b\u0004\n\u0004\f\u0004\u0092\t\u0004\u0001\u0004\u0003\u0004"+
		"\u0095\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004\u00b4\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00c4\b\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0005\u0005\u00cd\b\u0005\n\u0005\f\u0005\u00d0\t\u0005\u0001"+
		"\u0005\u0003\u0005\u00d3\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00dc\b\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00e3"+
		"\b\u0006\n\u0006\f\u0006\u00e6\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00ee\b\u0007\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0005"+
		"\n\u0102\b\n\n\n\f\n\u0105\t\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0003\f\u0119\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u011f\b\r\n"+
		"\r\f\r\u0122\t\r\u0001\r\u0001\r\u0001\r\u0003\r\u0127\b\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0005\u000f\u0130\b\u000f\n\u000f\f\u000f\u0133\t\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0005\u000f\u0138\b\u000f\n\u000f\f\u000f\u013b\t\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u0146\b\u0011\n\u0011"+
		"\f\u0011\u0149\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0000\u0002\u0004\f\u0013\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$\u0000"+
		"\u0004\u0001\u0000\b\n\u0002\u0000\u0006\u0006\u000b\u000b\u0001\u0000"+
		"\f\u0011\u0001\u0000\u0012\u0013\u0164\u0000&\u0001\u0000\u0000\u0000"+
		"\u00022\u0001\u0000\u0000\u0000\u0004W\u0001\u0000\u0000\u0000\u0006\u0088"+
		"\u0001\u0000\u0000\u0000\b\u00c3\u0001\u0000\u0000\u0000\n\u00d2\u0001"+
		"\u0000\u0000\u0000\f\u00db\u0001\u0000\u0000\u0000\u000e\u00ed\u0001\u0000"+
		"\u0000\u0000\u0010\u00ef\u0001\u0000\u0000\u0000\u0012\u00f9\u0001\u0000"+
		"\u0000\u0000\u0014\u0103\u0001\u0000\u0000\u0000\u0016\u0109\u0001\u0000"+
		"\u0000\u0000\u0018\u0118\u0001\u0000\u0000\u0000\u001a\u0126\u0001\u0000"+
		"\u0000\u0000\u001c\u0128\u0001\u0000\u0000\u0000\u001e\u0131\u0001\u0000"+
		"\u0000\u0000 \u013c\u0001\u0000\u0000\u0000\"\u0147\u0001\u0000\u0000"+
		"\u0000$\u014a\u0001\u0000\u0000\u0000&\'\u0003\u0002\u0001\u0000\'(\u0003"+
		"\u0010\b\u0000()\u0006\u0000\uffff\uffff\u0000)\u0001\u0001\u0000\u0000"+
		"\u0000*+\u0003\u0012\t\u0000+,\u0006\u0001\uffff\uffff\u0000,1\u0001\u0000"+
		"\u0000\u0000-.\u0003\u0016\u000b\u0000./\u0006\u0001\uffff\uffff\u0000"+
		"/1\u0001\u0000\u0000\u00000*\u0001\u0000\u0000\u00000-\u0001\u0000\u0000"+
		"\u000014\u0001\u0000\u0000\u000020\u0001\u0000\u0000\u000023\u0001\u0000"+
		"\u0000\u00003\u0003\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u0000"+
		"56\u0006\u0002\uffff\uffff\u000067\u0005+\u0000\u00007X\u0006\u0002\uffff"+
		"\uffff\u000089\u0005&\u0000\u00009X\u0006\u0002\uffff\uffff\u0000:;\u0005"+
		"(\u0000\u0000;X\u0006\u0002\uffff\uffff\u0000<=\u0005%\u0000\u0000=X\u0006"+
		"\u0002\uffff\uffff\u0000>?\u0005\u0001\u0000\u0000?@\u0003\u0004\u0002"+
		"\u0000@A\u0005\u0002\u0000\u0000AB\u0006\u0002\uffff\uffff\u0000BX\u0001"+
		"\u0000\u0000\u0000CD\u0005\u0001\u0000\u0000DE\u0003\u000e\u0007\u0000"+
		"EF\u0005\u0002\u0000\u0000FG\u0003\u0004\u0002\bGH\u0006\u0002\uffff\uffff"+
		"\u0000HX\u0001\u0000\u0000\u0000IJ\u0005\u0006\u0000\u0000JK\u0003\u0004"+
		"\u0002\u0007KL\u0006\u0002\uffff\uffff\u0000LX\u0001\u0000\u0000\u0000"+
		"MN\u0005\u0007\u0000\u0000NO\u0003\u0004\u0002\u0006OP\u0006\u0002\uffff"+
		"\uffff\u0000PX\u0001\u0000\u0000\u0000QR\u0005+\u0000\u0000RS\u0005\u0001"+
		"\u0000\u0000ST\u0003\u0006\u0003\u0000TU\u0005\u0002\u0000\u0000UV\u0006"+
		"\u0002\uffff\uffff\u0000VX\u0001\u0000\u0000\u0000W5\u0001\u0000\u0000"+
		"\u0000W8\u0001\u0000\u0000\u0000W:\u0001\u0000\u0000\u0000W<\u0001\u0000"+
		"\u0000\u0000W>\u0001\u0000\u0000\u0000WC\u0001\u0000\u0000\u0000WI\u0001"+
		"\u0000\u0000\u0000WM\u0001\u0000\u0000\u0000WQ\u0001\u0000\u0000\u0000"+
		"Xy\u0001\u0000\u0000\u0000YZ\n\u0005\u0000\u0000Z[\u0007\u0000\u0000\u0000"+
		"[\\\u0003\u0004\u0002\u0006\\]\u0006\u0002\uffff\uffff\u0000]x\u0001\u0000"+
		"\u0000\u0000^_\n\u0004\u0000\u0000_`\u0007\u0001\u0000\u0000`a\u0003\u0004"+
		"\u0002\u0005ab\u0006\u0002\uffff\uffff\u0000bx\u0001\u0000\u0000\u0000"+
		"cd\n\u0003\u0000\u0000de\u0007\u0002\u0000\u0000ef\u0003\u0004\u0002\u0004"+
		"fg\u0006\u0002\uffff\uffff\u0000gx\u0001\u0000\u0000\u0000hi\n\u0002\u0000"+
		"\u0000ij\u0007\u0003\u0000\u0000jk\u0003\u0004\u0002\u0003kl\u0006\u0002"+
		"\uffff\uffff\u0000lx\u0001\u0000\u0000\u0000mn\n\n\u0000\u0000no\u0005"+
		"\u0003\u0000\u0000op\u0003\u0004\u0002\u0000pq\u0005\u0004\u0000\u0000"+
		"qr\u0006\u0002\uffff\uffff\u0000rx\u0001\u0000\u0000\u0000st\n\t\u0000"+
		"\u0000tu\u0005\u0005\u0000\u0000uv\u0005+\u0000\u0000vx\u0006\u0002\uffff"+
		"\uffff\u0000wY\u0001\u0000\u0000\u0000w^\u0001\u0000\u0000\u0000wc\u0001"+
		"\u0000\u0000\u0000wh\u0001\u0000\u0000\u0000wm\u0001\u0000\u0000\u0000"+
		"ws\u0001\u0000\u0000\u0000x{\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000"+
		"\u0000yz\u0001\u0000\u0000\u0000z\u0005\u0001\u0000\u0000\u0000{y\u0001"+
		"\u0000\u0000\u0000|}\u0003\u0004\u0002\u0000}~\u0006\u0003\uffff\uffff"+
		"\u0000~\u007f\u0005\u0014\u0000\u0000\u007f\u0081\u0001\u0000\u0000\u0000"+
		"\u0080|\u0001\u0000\u0000\u0000\u0081\u0084\u0001\u0000\u0000\u0000\u0082"+
		"\u0080\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083"+
		"\u0085\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0085"+
		"\u0086\u0003\u0004\u0002\u0000\u0086\u0087\u0006\u0003\uffff\uffff\u0000"+
		"\u0087\u0089\u0001\u0000\u0000\u0000\u0088\u0082\u0001\u0000\u0000\u0000"+
		"\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u0007\u0001\u0000\u0000\u0000"+
		"\u008a\u0094\u0005\u0015\u0000\u0000\u008b\u008c\u0003\u0004\u0002\u0000"+
		"\u008c\u008d\u0005\u0014\u0000\u0000\u008d\u008f\u0001\u0000\u0000\u0000"+
		"\u008e\u008b\u0001\u0000\u0000\u0000\u008f\u0092\u0001\u0000\u0000\u0000"+
		"\u0090\u008e\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000"+
		"\u0091\u0093\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000"+
		"\u0093\u0095\u0003\u0004\u0002\u0000\u0094\u0090\u0001\u0000\u0000\u0000"+
		"\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000"+
		"\u0096\u0097\u0005\u0016\u0000\u0000\u0097\u00c4\u0006\u0004\uffff\uffff"+
		"\u0000\u0098\u0099\u0005\u0017\u0000\u0000\u0099\u009a\u0003\u0006\u0003"+
		"\u0000\u009a\u009b\u0005\u0016\u0000\u0000\u009b\u009c\u0006\u0004\uffff"+
		"\uffff\u0000\u009c\u00c4\u0001\u0000\u0000\u0000\u009d\u009e\u0003\u0004"+
		"\u0002\u0000\u009e\u009f\u0005\u0018\u0000\u0000\u009f\u00a0\u0003\u0004"+
		"\u0002\u0000\u00a0\u00a1\u0005\u0016\u0000\u0000\u00a1\u00a2\u0006\u0004"+
		"\uffff\uffff\u0000\u00a2\u00c4\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005"+
		"+\u0000\u0000\u00a4\u00a5\u0005\u0001\u0000\u0000\u00a5\u00a6\u0003\u0006"+
		"\u0003\u0000\u00a6\u00a7\u0005\u0002\u0000\u0000\u00a7\u00a8\u0005\u0016"+
		"\u0000\u0000\u00a8\u00a9\u0006\u0004\uffff\uffff\u0000\u00a9\u00c4\u0001"+
		"\u0000\u0000\u0000\u00aa\u00ab\u0005\u0019\u0000\u0000\u00ab\u00ac\u0005"+
		"\u0001\u0000\u0000\u00ac\u00ad\u0003\u0004\u0002\u0000\u00ad\u00ae\u0005"+
		"\u0002\u0000\u0000\u00ae\u00b3\u0003\n\u0005\u0000\u00af\u00b0\u0005\u001a"+
		"\u0000\u0000\u00b0\u00b1\u0003\n\u0005\u0000\u00b1\u00b2\u0006\u0004\uffff"+
		"\uffff\u0000\u00b2\u00b4\u0001\u0000\u0000\u0000\u00b3\u00af\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000"+
		"\u0000\u0000\u00b5\u00b6\u0006\u0004\uffff\uffff\u0000\u00b6\u00c4\u0001"+
		"\u0000\u0000\u0000\u00b7\u00b8\u0005\u001b\u0000\u0000\u00b8\u00b9\u0005"+
		"\u0001\u0000\u0000\u00b9\u00ba\u0003\u0004\u0002\u0000\u00ba\u00bb\u0005"+
		"\u0002\u0000\u0000\u00bb\u00bc\u0003\n\u0005\u0000\u00bc\u00bd\u0006\u0004"+
		"\uffff\uffff\u0000\u00bd\u00c4\u0001\u0000\u0000\u0000\u00be\u00bf\u0005"+
		"\u001c\u0000\u0000\u00bf\u00c0\u0003\u0004\u0002\u0000\u00c0\u00c1\u0005"+
		"\u0016\u0000\u0000\u00c1\u00c2\u0006\u0004\uffff\uffff\u0000\u00c2\u00c4"+
		"\u0001\u0000\u0000\u0000\u00c3\u008a\u0001\u0000\u0000\u0000\u00c3\u0098"+
		"\u0001\u0000\u0000\u0000\u00c3\u009d\u0001\u0000\u0000\u0000\u00c3\u00a3"+
		"\u0001\u0000\u0000\u0000\u00c3\u00aa\u0001\u0000\u0000\u0000\u00c3\u00b7"+
		"\u0001\u0000\u0000\u0000\u00c3\u00be\u0001\u0000\u0000\u0000\u00c4\t\u0001"+
		"\u0000\u0000\u0000\u00c5\u00c6\u0003\b\u0004\u0000\u00c6\u00c7\u0006\u0005"+
		"\uffff\uffff\u0000\u00c7\u00d3\u0001\u0000\u0000\u0000\u00c8\u00ce\u0005"+
		"\u001d\u0000\u0000\u00c9\u00ca\u0003\b\u0004\u0000\u00ca\u00cb\u0006\u0005"+
		"\uffff\uffff\u0000\u00cb\u00cd\u0001\u0000\u0000\u0000\u00cc\u00c9\u0001"+
		"\u0000\u0000\u0000\u00cd\u00d0\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001"+
		"\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u00d1\u0001"+
		"\u0000\u0000\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d1\u00d3\u0005"+
		"\u001e\u0000\u0000\u00d2\u00c5\u0001\u0000\u0000\u0000\u00d2\u00c8\u0001"+
		"\u0000\u0000\u0000\u00d3\u000b\u0001\u0000\u0000\u0000\u00d4\u00d5\u0006"+
		"\u0006\uffff\uffff\u0000\u00d5\u00d6\u0003\u000e\u0007\u0000\u00d6\u00d7"+
		"\u0006\u0006\uffff\uffff\u0000\u00d7\u00dc\u0001\u0000\u0000\u0000\u00d8"+
		"\u00d9\u0003 \u0010\u0000\u00d9\u00da\u0006\u0006\uffff\uffff\u0000\u00da"+
		"\u00dc\u0001\u0000\u0000\u0000\u00db\u00d4\u0001\u0000\u0000\u0000\u00db"+
		"\u00d8\u0001\u0000\u0000\u0000\u00dc\u00e4\u0001\u0000\u0000\u0000\u00dd"+
		"\u00de\n\u0002\u0000\u0000\u00de\u00df\u0005\u0003\u0000\u0000\u00df\u00e0"+
		"\u0005%\u0000\u0000\u00e0\u00e1\u0005\u0004\u0000\u0000\u00e1\u00e3\u0006"+
		"\u0006\uffff\uffff\u0000\u00e2\u00dd\u0001\u0000\u0000\u0000\u00e3\u00e6"+
		"\u0001\u0000\u0000\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e4\u00e5"+
		"\u0001\u0000\u0000\u0000\u00e5\r\u0001\u0000\u0000\u0000\u00e6\u00e4\u0001"+
		"\u0000\u0000\u0000\u00e7\u00e8\u0005\u001f\u0000\u0000\u00e8\u00ee\u0006"+
		"\u0007\uffff\uffff\u0000\u00e9\u00ea\u0005 \u0000\u0000\u00ea\u00ee\u0006"+
		"\u0007\uffff\uffff\u0000\u00eb\u00ec\u0005!\u0000\u0000\u00ec\u00ee\u0006"+
		"\u0007\uffff\uffff\u0000\u00ed\u00e7\u0001\u0000\u0000\u0000\u00ed\u00e9"+
		"\u0001\u0000\u0000\u0000\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ee\u000f"+
		"\u0001\u0000\u0000\u0000\u00ef\u00f0\u0005\"\u0000\u0000\u00f0\u00f1\u0005"+
		"#\u0000\u0000\u00f1\u00f2\u0005\u0001\u0000\u0000\u00f2\u00f3\u0005\u0002"+
		"\u0000\u0000\u00f3\u00f4\u0005\u001d\u0000\u0000\u00f4\u00f5\u0003\u001e"+
		"\u000f\u0000\u00f5\u00f6\u0005\u001e\u0000\u0000\u00f6\u00f7\u0005\u0000"+
		"\u0000\u0001\u00f7\u00f8\u0006\b\uffff\uffff\u0000\u00f8\u0011\u0001\u0000"+
		"\u0000\u0000\u00f9\u00fa\u0003\f\u0006\u0000\u00fa\u00fb\u0003\u0014\n"+
		"\u0000\u00fb\u00fc\u0005\u0016\u0000\u0000\u00fc\u00fd\u0006\t\uffff\uffff"+
		"\u0000\u00fd\u0013\u0001\u0000\u0000\u0000\u00fe\u00ff\u0005+\u0000\u0000"+
		"\u00ff\u0100\u0006\n\uffff\uffff\u0000\u0100\u0102\u0005\u0014\u0000\u0000"+
		"\u0101\u00fe\u0001\u0000\u0000\u0000\u0102\u0105\u0001\u0000\u0000\u0000"+
		"\u0103\u0101\u0001\u0000\u0000\u0000\u0103\u0104\u0001\u0000\u0000\u0000"+
		"\u0104\u0106\u0001\u0000\u0000\u0000\u0105\u0103\u0001\u0000\u0000\u0000"+
		"\u0106\u0107\u0005+\u0000\u0000\u0107\u0108\u0006\n\uffff\uffff\u0000"+
		"\u0108\u0015\u0001\u0000\u0000\u0000\u0109\u010a\u0003\u0018\f\u0000\u010a"+
		"\u010b\u0005+\u0000\u0000\u010b\u010c\u0005\u0001\u0000\u0000\u010c\u010d"+
		"\u0003\u001a\r\u0000\u010d\u010e\u0005\u0002\u0000\u0000\u010e\u010f\u0005"+
		"\u001d\u0000\u0000\u010f\u0110\u0003\u001e\u000f\u0000\u0110\u0111\u0005"+
		"\u001e\u0000\u0000\u0111\u0112\u0006\u000b\uffff\uffff\u0000\u0112\u0017"+
		"\u0001\u0000\u0000\u0000\u0113\u0114\u0003\u000e\u0007\u0000\u0114\u0115"+
		"\u0006\f\uffff\uffff\u0000\u0115\u0119\u0001\u0000\u0000\u0000\u0116\u0117"+
		"\u0005\"\u0000\u0000\u0117\u0119\u0006\f\uffff\uffff\u0000\u0118\u0113"+
		"\u0001\u0000\u0000\u0000\u0118\u0116\u0001\u0000\u0000\u0000\u0119\u0019"+
		"\u0001\u0000\u0000\u0000\u011a\u011b\u0003\u001c\u000e\u0000\u011b\u011c"+
		"\u0006\r\uffff\uffff\u0000\u011c\u011d\u0005\u0014\u0000\u0000\u011d\u011f"+
		"\u0001\u0000\u0000\u0000\u011e\u011a\u0001\u0000\u0000\u0000\u011f\u0122"+
		"\u0001\u0000\u0000\u0000\u0120\u011e\u0001\u0000\u0000\u0000\u0120\u0121"+
		"\u0001\u0000\u0000\u0000\u0121\u0123\u0001\u0000\u0000\u0000\u0122\u0120"+
		"\u0001\u0000\u0000\u0000\u0123\u0124\u0003\u001c\u000e\u0000\u0124\u0125"+
		"\u0006\r\uffff\uffff\u0000\u0125\u0127\u0001\u0000\u0000\u0000\u0126\u0120"+
		"\u0001\u0000\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000\u0127\u001b"+
		"\u0001\u0000\u0000\u0000\u0128\u0129\u0003\u000e\u0007\u0000\u0129\u012a"+
		"\u0005+\u0000\u0000\u012a\u012b\u0006\u000e\uffff\uffff\u0000\u012b\u001d"+
		"\u0001\u0000\u0000\u0000\u012c\u012d\u0003\u0012\t\u0000\u012d\u012e\u0006"+
		"\u000f\uffff\uffff\u0000\u012e\u0130\u0001\u0000\u0000\u0000\u012f\u012c"+
		"\u0001\u0000\u0000\u0000\u0130\u0133\u0001\u0000\u0000\u0000\u0131\u012f"+
		"\u0001\u0000\u0000\u0000\u0131\u0132\u0001\u0000\u0000\u0000\u0132\u0139"+
		"\u0001\u0000\u0000\u0000\u0133\u0131\u0001\u0000\u0000\u0000\u0134\u0135"+
		"\u0003\b\u0004\u0000\u0135\u0136\u0006\u000f\uffff\uffff\u0000\u0136\u0138"+
		"\u0001\u0000\u0000\u0000\u0137\u0134\u0001\u0000\u0000\u0000\u0138\u013b"+
		"\u0001\u0000\u0000\u0000\u0139\u0137\u0001\u0000\u0000\u0000\u0139\u013a"+
		"\u0001\u0000\u0000\u0000\u013a\u001f\u0001\u0000\u0000\u0000\u013b\u0139"+
		"\u0001\u0000\u0000\u0000\u013c\u013d\u0005$\u0000\u0000\u013d\u013e\u0005"+
		"\u001d\u0000\u0000\u013e\u013f\u0003\"\u0011\u0000\u013f\u0140\u0005\u001e"+
		"\u0000\u0000\u0140\u0141\u0006\u0010\uffff\uffff\u0000\u0141!\u0001\u0000"+
		"\u0000\u0000\u0142\u0143\u0003$\u0012\u0000\u0143\u0144\u0006\u0011\uffff"+
		"\uffff\u0000\u0144\u0146\u0001\u0000\u0000\u0000\u0145\u0142\u0001\u0000"+
		"\u0000\u0000\u0146\u0149\u0001\u0000\u0000\u0000\u0147\u0145\u0001\u0000"+
		"\u0000\u0000\u0147\u0148\u0001\u0000\u0000\u0000\u0148#\u0001\u0000\u0000"+
		"\u0000\u0149\u0147\u0001\u0000\u0000\u0000\u014a\u014b\u0003\f\u0006\u0000"+
		"\u014b\u014c\u0003\u0014\n\u0000\u014c\u014d\u0005\u0016\u0000\u0000\u014d"+
		"\u014e\u0006\u0012\uffff\uffff\u0000\u014e%\u0001\u0000\u0000\u0000\u0017"+
		"02Wwy\u0082\u0088\u0090\u0094\u00b3\u00c3\u00ce\u00d2\u00db\u00e4\u00ed"+
		"\u0103\u0118\u0120\u0126\u0131\u0139\u0147";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}