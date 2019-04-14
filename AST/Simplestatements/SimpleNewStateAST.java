class SimpleNewStateAST extends ClosedstateAST {

    StatementAST state;

    public SimpleNewStateAST(StatementAST s){
        this.state = s;
    }

    public void accept(Visitor v){
        this.state.accept(v);
        v.visit(this);
    }

    public String toString(int indent){
        return("" + String.format("%s", this.state));
    }
}
