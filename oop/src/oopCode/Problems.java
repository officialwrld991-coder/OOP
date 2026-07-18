package oopCode;

enum ProblemType {
    Financial,Spiritual,Educational,Business,Technical;
}

public class Problems {
    private String problemName;
    private ProblemType problemType;
    private boolean isSolved;

public Problems(String addedProblem, ProblemType addedProblemType, boolean isSolved){
    this.problemName = addedProblem;
    this.problemType = addedProblemType;
    this.isSolved = false;
}

public String getProblemName() {
    return problemName;
}
public ProblemType getProblemType() {
    return problemType;
}
public boolean isSolved() {
    return isSolved;
}
public void setSolved(boolean solved) {
    isSolved = solved;
}

}


