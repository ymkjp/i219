import java.util.regex.*;

public class SourceCode {
    private String sourceCode;

    public SourceCode(String sc) {
        sourceCode = sc;
    }

    private Token toToken(String s) {
        if (Pattern.matches("[0-9]+",s)) {
            return new Token(TokenName.NUM,
                             Integer.parseInt(s,10));
        } else {
            return new Token(TokenName.UNDEF,s);
        }
    }

    public TokenList scan() {
        TokenList tl = new TokenList();
        String str = "";
        Token t;
        Character c, c1;
        int idx = 0;

        while (idx < sourceCode.length()) {
            c = sourceCode.charAt(idx++);
            if (Character.isWhitespace(c)) {
                if (str.length() != 0) {
                    tl.add(toToken(str));
                    str = "";
                }
                continue;
            }
            switch (c) {
            case '(':
                if (str.length() != 0) {
                 tl.add(toToken(str));
                    str = "";
                }
                tl.add(new Token(TokenName.LPAR));
                break;
            case ')':
                if (str.length() != 0) {
                 tl.add(toToken(str));
                    str = "";
                }
                tl.add(new Token(TokenName.RPAR));
                break;
            case '*':
                if (str.length() != 0) {
                 tl.add(toToken(str));
                    str = "";
                }
                tl.add(new Token(TokenName.MUL));
                break;
            case '/':
                if (str.length() != 0) {
                 tl.add(toToken(str));
                    str = "";
                }
                tl.add(new Token(TokenName.QUO));
                break;
            case '%':
                if (str.length() != 0) {
                 tl.add(toToken(str));
                    str = "";
                }
                tl.add(new Token(TokenName.REM));
                break;
            case '+':
                if (str.length() != 0) {
                 tl.add(toToken(str));
                    str = "";
                }
                tl.add(new Token(TokenName.PLUS));
                break;
            case '-':
                if (str.length() != 0) {
                 tl.add(toToken(str));
                    str = "";
                }
                tl.add(new Token(TokenName.MINUS));
                break;
            default:
                str = str + c;
            }
        }
        if (str.length() != 0) {
            tl.add(toToken(str));
            str = "";
        }
        return tl;
    }

    public String toString() {
        return sourceCode;
    }
}