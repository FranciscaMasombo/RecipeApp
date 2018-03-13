package ie.fran.recipeapp;

public class Recipes {
private String rName, rIn, instruction;
public Recipes(){}
public Recipes(String rName,String rIn,String instruction){
      this.rName = rName;
        this.instruction = instruction;
        this.rIn = rIn;

}

public String getrName(){
    return rName;
}

    public String getInstruction() {
        return instruction;
    }

    public String getrIn() {
        return rIn;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public void setrIn(String rIn) {
        this.rIn = rIn;
    }
}
