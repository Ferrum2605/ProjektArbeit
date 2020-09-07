package klausurvorbereitung2;

import java.io.*;

public class Model {

    private static Model instance;
    private String playerNameOne;
    private String playerNameTwo;

    final String fieldsNotFilled = "Please fill in both fields.";
    final File file = new File("/Users/kevin/IdeaProjects/preparationp2/src/project1/users.txt");

    private Model() {

    }

    /*
     * Model-Bereich
     */
    
    public void setPlayerOneName(String playerNameOne) {
    	this.playerNameOne = playerNameOne;
    }
    
    public void setPlayerTwoName(String playerNameTwo) {
    	this.playerNameTwo = playerNameTwo;
    }
    
    public String getPlayerOneName() {
        return this.playerNameOne;
    }
    
    public String getPlayerTwoName() {
        return this.playerNameTwo;
    }

    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }
    

}
