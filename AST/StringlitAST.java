/**
 * AST node for a number
 */ 
class StringlitAST implements AST {
    String s;

    public StringlitAST(String s) {
        this.s = s;
    }

    public String toString() {
        return(""+String.format("%s", this.s)); 
    }

}
