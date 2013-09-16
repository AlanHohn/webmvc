package org.anvard.webmvc.api;


public class Calculation {

    private String operation;
    private Integer left;
    private Integer right;
    private Integer result;
    
    public Calculation() {
    }
    
    public Calculation(String operation, Integer left, Integer right) {
        super();
        this.operation = operation;
        this.left = left;
        this.right = right;
    }

    public String getOperation() {
        return operation;
    }
    
    public void setOperation(String operation) {
        this.operation = operation;
    }
    
    public Integer getLeft() {
        return left;
    }
    
    public void setLeft(Integer left) {
        this.left = left;
    }
    
    public Integer getRight() {
        return right;
    }
    
    public void setRight(Integer right) {
        this.right = right;
    }
    
    public Integer getResult() {
        return result;
    }
    
    public void setResult(Integer result) {
        this.result = result;
    }
    
}
