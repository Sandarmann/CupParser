class SimpleAssignAST extends SimplestateAST{
    public NameAST name;
    public ExprAST expr;

    public SimpleAssignAST(NameAST n, ExprAST e){
        this.name = n;
        this.expr = e;
    }


    public void accept(Visitor v){
        this.name.accept(v);
        this.expr.accept(v);
        v.visit(this);
    }

    public String toString(){
        return(""+ String.format("%s = %s;", this.name, this.expr));
    }

    public String toString(int indent){
        return(getBase(indent) + String.format("%s = %s;", this.name, this.expr));
    }

    public String getType(Visitor e) throws TypeConflictException{
        if(e.lookup(name.id.name).ifFinal){
            throw new TypeConflictException(String.format(
            "Final, cannot assign to variabl: %s", this.name.toString())
            );
        }
        if (!name.getType(e).equals(expr.getType(e))){
            throw new TypeConflictException(String.format(
            "Type %s, Name %s conflicts with type: %s expr: %s", this.name.getType(e), this.name.toString(), this.expr.getType(e), this.expr.toString())
            );
        }
        return "";
    }
    public Object getValue(Visitor v){
        if(this.expr.getValue(v) != null){
            v.updateEntry(this.name.id.name, this.expr.getValue(v));
        }
        return null;
    }
}
