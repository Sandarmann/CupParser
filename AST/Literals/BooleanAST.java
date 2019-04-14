class BooleanAST extends ExpressionLiterals implements AST{
    boolean is;

    public BooleanAST(boolean b){
        this.is = b;
    }


    public void accept(Visitor v){
        v.visit(this);
    }

    public String toString(){
        if(this.is){
            return "true";
        } else {
            return "false";
        }
    }
}
