package io.fracturelabs;

public class ExampleBean {
	public String example;

    public ExampleBean() throws ClassNotFoundException {
        System.out.println("Instantiating a new ExampleBean");
    }

    public String getExample() {
        return this.example;
    }

    public void setExample(String example) {
        this.example = example;
    }
    
    public String toString() {
    	return "ExampleBean | example=" + this.example;
    }
}
