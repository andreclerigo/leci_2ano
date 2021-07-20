// Generated from GeometricsAux.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GeometricsAuxLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, HTMLColor=38, 
		Number=39, ID=40, NEWLINE=41, WS=42, COMMENT=43;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "T__35", "T__36", "Hex", "HTMLColor", "Number", "ID", 
			"NEWLINE", "WS", "COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'geometrics:'", "'database'", "'point'", "'is'", "'{'", "'}'", 
			"'+'", "'-'", "'*'", "'/'", "'%'", "'('", "')'", "'line'", "'circle'", 
			"'rectangle'", "'square'", "'ellipse'", "'color'", "'thickness'", "'filled'", 
			"'yes'", "'no'", "'hidden'", "','", "'red'", "'blue'", "'green'", "'yellow'", 
			"'black'", "'white'", "'cyan'", "'orange'", "'purple'", "'pink'", "'brown'", 
			"'grey'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "HTMLColor", "Number", "ID", "NEWLINE", "WS", "COMMENT"
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


	public GeometricsAuxLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GeometricsAux.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2-\u014d\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3"+
		"\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3"+
		"%\3&\3&\3&\3&\3&\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3)\6)\u0128\n)\r)\16"+
		")\u0129\3*\3*\6*\u012e\n*\r*\16*\u012f\3+\5+\u0133\n+\3+\3+\5+\u0137\n"+
		"+\3,\6,\u013a\n,\r,\16,\u013b\3,\3,\3-\3-\3-\3-\7-\u0144\n-\f-\16-\u0147"+
		"\13-\3-\3-\3-\3-\3-\3\u0145\2.\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M\2O(Q)S*U+W,Y-\3\2\7\5"+
		"\2\62;CHch\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\4\2\13\13\"\"\2\u0151\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2"+
		"I\3\2\2\2\2K\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3"+
		"\2\2\2\2Y\3\2\2\2\3[\3\2\2\2\5g\3\2\2\2\7p\3\2\2\2\tv\3\2\2\2\13y\3\2"+
		"\2\2\r{\3\2\2\2\17}\3\2\2\2\21\177\3\2\2\2\23\u0081\3\2\2\2\25\u0083\3"+
		"\2\2\2\27\u0085\3\2\2\2\31\u0087\3\2\2\2\33\u0089\3\2\2\2\35\u008b\3\2"+
		"\2\2\37\u0090\3\2\2\2!\u0097\3\2\2\2#\u00a1\3\2\2\2%\u00a8\3\2\2\2\'\u00b0"+
		"\3\2\2\2)\u00b6\3\2\2\2+\u00c0\3\2\2\2-\u00c7\3\2\2\2/\u00cb\3\2\2\2\61"+
		"\u00ce\3\2\2\2\63\u00d5\3\2\2\2\65\u00d7\3\2\2\2\67\u00db\3\2\2\29\u00e0"+
		"\3\2\2\2;\u00e6\3\2\2\2=\u00ed\3\2\2\2?\u00f3\3\2\2\2A\u00f9\3\2\2\2C"+
		"\u00fe\3\2\2\2E\u0105\3\2\2\2G\u010c\3\2\2\2I\u0111\3\2\2\2K\u0117\3\2"+
		"\2\2M\u011c\3\2\2\2O\u011e\3\2\2\2Q\u0127\3\2\2\2S\u012b\3\2\2\2U\u0136"+
		"\3\2\2\2W\u0139\3\2\2\2Y\u013f\3\2\2\2[\\\7i\2\2\\]\7g\2\2]^\7q\2\2^_"+
		"\7o\2\2_`\7g\2\2`a\7v\2\2ab\7t\2\2bc\7k\2\2cd\7e\2\2de\7u\2\2ef\7<\2\2"+
		"f\4\3\2\2\2gh\7f\2\2hi\7c\2\2ij\7v\2\2jk\7c\2\2kl\7d\2\2lm\7c\2\2mn\7"+
		"u\2\2no\7g\2\2o\6\3\2\2\2pq\7r\2\2qr\7q\2\2rs\7k\2\2st\7p\2\2tu\7v\2\2"+
		"u\b\3\2\2\2vw\7k\2\2wx\7u\2\2x\n\3\2\2\2yz\7}\2\2z\f\3\2\2\2{|\7\177\2"+
		"\2|\16\3\2\2\2}~\7-\2\2~\20\3\2\2\2\177\u0080\7/\2\2\u0080\22\3\2\2\2"+
		"\u0081\u0082\7,\2\2\u0082\24\3\2\2\2\u0083\u0084\7\61\2\2\u0084\26\3\2"+
		"\2\2\u0085\u0086\7\'\2\2\u0086\30\3\2\2\2\u0087\u0088\7*\2\2\u0088\32"+
		"\3\2\2\2\u0089\u008a\7+\2\2\u008a\34\3\2\2\2\u008b\u008c\7n\2\2\u008c"+
		"\u008d\7k\2\2\u008d\u008e\7p\2\2\u008e\u008f\7g\2\2\u008f\36\3\2\2\2\u0090"+
		"\u0091\7e\2\2\u0091\u0092\7k\2\2\u0092\u0093\7t\2\2\u0093\u0094\7e\2\2"+
		"\u0094\u0095\7n\2\2\u0095\u0096\7g\2\2\u0096 \3\2\2\2\u0097\u0098\7t\2"+
		"\2\u0098\u0099\7g\2\2\u0099\u009a\7e\2\2\u009a\u009b\7v\2\2\u009b\u009c"+
		"\7c\2\2\u009c\u009d\7p\2\2\u009d\u009e\7i\2\2\u009e\u009f\7n\2\2\u009f"+
		"\u00a0\7g\2\2\u00a0\"\3\2\2\2\u00a1\u00a2\7u\2\2\u00a2\u00a3\7s\2\2\u00a3"+
		"\u00a4\7w\2\2\u00a4\u00a5\7c\2\2\u00a5\u00a6\7t\2\2\u00a6\u00a7\7g\2\2"+
		"\u00a7$\3\2\2\2\u00a8\u00a9\7g\2\2\u00a9\u00aa\7n\2\2\u00aa\u00ab\7n\2"+
		"\2\u00ab\u00ac\7k\2\2\u00ac\u00ad\7r\2\2\u00ad\u00ae\7u\2\2\u00ae\u00af"+
		"\7g\2\2\u00af&\3\2\2\2\u00b0\u00b1\7e\2\2\u00b1\u00b2\7q\2\2\u00b2\u00b3"+
		"\7n\2\2\u00b3\u00b4\7q\2\2\u00b4\u00b5\7t\2\2\u00b5(\3\2\2\2\u00b6\u00b7"+
		"\7v\2\2\u00b7\u00b8\7j\2\2\u00b8\u00b9\7k\2\2\u00b9\u00ba\7e\2\2\u00ba"+
		"\u00bb\7m\2\2\u00bb\u00bc\7p\2\2\u00bc\u00bd\7g\2\2\u00bd\u00be\7u\2\2"+
		"\u00be\u00bf\7u\2\2\u00bf*\3\2\2\2\u00c0\u00c1\7h\2\2\u00c1\u00c2\7k\2"+
		"\2\u00c2\u00c3\7n\2\2\u00c3\u00c4\7n\2\2\u00c4\u00c5\7g\2\2\u00c5\u00c6"+
		"\7f\2\2\u00c6,\3\2\2\2\u00c7\u00c8\7{\2\2\u00c8\u00c9\7g\2\2\u00c9\u00ca"+
		"\7u\2\2\u00ca.\3\2\2\2\u00cb\u00cc\7p\2\2\u00cc\u00cd\7q\2\2\u00cd\60"+
		"\3\2\2\2\u00ce\u00cf\7j\2\2\u00cf\u00d0\7k\2\2\u00d0\u00d1\7f\2\2\u00d1"+
		"\u00d2\7f\2\2\u00d2\u00d3\7g\2\2\u00d3\u00d4\7p\2\2\u00d4\62\3\2\2\2\u00d5"+
		"\u00d6\7.\2\2\u00d6\64\3\2\2\2\u00d7\u00d8\7t\2\2\u00d8\u00d9\7g\2\2\u00d9"+
		"\u00da\7f\2\2\u00da\66\3\2\2\2\u00db\u00dc\7d\2\2\u00dc\u00dd\7n\2\2\u00dd"+
		"\u00de\7w\2\2\u00de\u00df\7g\2\2\u00df8\3\2\2\2\u00e0\u00e1\7i\2\2\u00e1"+
		"\u00e2\7t\2\2\u00e2\u00e3\7g\2\2\u00e3\u00e4\7g\2\2\u00e4\u00e5\7p\2\2"+
		"\u00e5:\3\2\2\2\u00e6\u00e7\7{\2\2\u00e7\u00e8\7g\2\2\u00e8\u00e9\7n\2"+
		"\2\u00e9\u00ea\7n\2\2\u00ea\u00eb\7q\2\2\u00eb\u00ec\7y\2\2\u00ec<\3\2"+
		"\2\2\u00ed\u00ee\7d\2\2\u00ee\u00ef\7n\2\2\u00ef\u00f0\7c\2\2\u00f0\u00f1"+
		"\7e\2\2\u00f1\u00f2\7m\2\2\u00f2>\3\2\2\2\u00f3\u00f4\7y\2\2\u00f4\u00f5"+
		"\7j\2\2\u00f5\u00f6\7k\2\2\u00f6\u00f7\7v\2\2\u00f7\u00f8\7g\2\2\u00f8"+
		"@\3\2\2\2\u00f9\u00fa\7e\2\2\u00fa\u00fb\7{\2\2\u00fb\u00fc\7c\2\2\u00fc"+
		"\u00fd\7p\2\2\u00fdB\3\2\2\2\u00fe\u00ff\7q\2\2\u00ff\u0100\7t\2\2\u0100"+
		"\u0101\7c\2\2\u0101\u0102\7p\2\2\u0102\u0103\7i\2\2\u0103\u0104\7g\2\2"+
		"\u0104D\3\2\2\2\u0105\u0106\7r\2\2\u0106\u0107\7w\2\2\u0107\u0108\7t\2"+
		"\2\u0108\u0109\7r\2\2\u0109\u010a\7n\2\2\u010a\u010b\7g\2\2\u010bF\3\2"+
		"\2\2\u010c\u010d\7r\2\2\u010d\u010e\7k\2\2\u010e\u010f\7p\2\2\u010f\u0110"+
		"\7m\2\2\u0110H\3\2\2\2\u0111\u0112\7d\2\2\u0112\u0113\7t\2\2\u0113\u0114"+
		"\7q\2\2\u0114\u0115\7y\2\2\u0115\u0116\7p\2\2\u0116J\3\2\2\2\u0117\u0118"+
		"\7i\2\2\u0118\u0119\7t\2\2\u0119\u011a\7g\2\2\u011a\u011b\7{\2\2\u011b"+
		"L\3\2\2\2\u011c\u011d\t\2\2\2\u011dN\3\2\2\2\u011e\u011f\7%\2\2\u011f"+
		"\u0120\5M\'\2\u0120\u0121\5M\'\2\u0121\u0122\5M\'\2\u0122\u0123\5M\'\2"+
		"\u0123\u0124\5M\'\2\u0124\u0125\5M\'\2\u0125P\3\2\2\2\u0126\u0128\t\3"+
		"\2\2\u0127\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u0127\3\2\2\2\u0129"+
		"\u012a\3\2\2\2\u012aR\3\2\2\2\u012b\u012d\t\4\2\2\u012c\u012e\t\5\2\2"+
		"\u012d\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u012d\3\2\2\2\u012f\u0130"+
		"\3\2\2\2\u0130T\3\2\2\2\u0131\u0133\7\17\2\2\u0132\u0131\3\2\2\2\u0132"+
		"\u0133\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0137\7\f\2\2\u0135\u0137\7\2"+
		"\2\3\u0136\u0132\3\2\2\2\u0136\u0135\3\2\2\2\u0137V\3\2\2\2\u0138\u013a"+
		"\t\6\2\2\u0139\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u0139\3\2\2\2\u013b"+
		"\u013c\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013e\b,\2\2\u013eX\3\2\2\2\u013f"+
		"\u0140\7\61\2\2\u0140\u0141\7,\2\2\u0141\u0145\3\2\2\2\u0142\u0144\13"+
		"\2\2\2\u0143\u0142\3\2\2\2\u0144\u0147\3\2\2\2\u0145\u0146\3\2\2\2\u0145"+
		"\u0143\3\2\2\2\u0146\u0148\3\2\2\2\u0147\u0145\3\2\2\2\u0148\u0149\7,"+
		"\2\2\u0149\u014a\7\61\2\2\u014a\u014b\3\2\2\2\u014b\u014c\b-\2\2\u014c"+
		"Z\3\2\2\2\t\2\u0129\u012f\u0132\u0136\u013b\u0145\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}