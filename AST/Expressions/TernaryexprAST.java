
class TernaryexprAST extends ExprAST implements AST{
    ExprAST expr1;
    ExprAST true_expr;
    ExprAST false_expr;

    public TernaryexprAST(ExprAST e1, ExprAST e2, ExprAST e3){
        this.expr1 = e1;
        this.true_expr = e2;
        this.false_expr = e3;
        this.type = "";
    }


    public void accept(Visitor v){
        this.expr1.accept(v);
        this.true_expr.accept(v);
        this.false_expr.accept(v);
        v.visit(this);
    }

    public String toString(){
        return (""+String.format("(%s ? %s : %s)", expr1, true_expr, false_expr));
    }

    public String getType(Visitor e) throws TypeConflictException{
        if(this.expr1.getType(e).equals("int") || this.expr1.getType(e).equals("bool")){
            if(this.true_expr.getType(e).equals(this.false_expr.getType(e))){
                return "";
            }
            else if((this.true_expr.getType(e).equals("int") || this.true_expr.getType(e).equals("float"))
                && (this.false_expr.getType(e).equals("int") || this.false_expr.getType(e).equals("float")))
                return "";
        }
        throw new TypeConflictException(String.format("Error in ternary expression %s", this.toString()));
    }
}
