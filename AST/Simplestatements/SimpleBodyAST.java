class SimpleBodyAST extends SimplestateAST{
    FielddeclsAST fields;
    StatementlistAST stmtlist;
    OptionalsemiAST semi;

    public SimpleBodyAST(FielddeclsAST f, StatementlistAST s, OptionalsemiAST semi){
        this.fields = f;
        this.stmtlist = s;
        this.semi = semi;
    }


    public void accept(Visitor v){
        v.visit(this);
        this.fields.accept(v);
        this.stmtlist.accept(v);
        this.semi.accept(v);
        v.exitScope(); 
    }

    public String toString(int indent){
        return (getBase(indent-1) + "{\n"
                + String.format("%s", this.fields.toString(indent))
                + String.format("%s", this.stmtlist.toString(indent))
                + getBase(indent-1) + String.format("}%s", this.semi));
    }
}
