package klausurvorbereitung;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Model {

    private static Model instance;
    private String user;
    private String userPassword;

    final String loginSuccessful = "Login successful.";
    final String wrongPassword = "Wrong password.";
    final String userNotFound = "User not found.";
    final File file = new File("C:/Users/A002520/Documents/GitHub/exam-preparation-dev2/src/dev2/project1/users.txt");

    private Model() {

    }

    /*
     * Model-Bereich
     */
    private StringProperty userProperty = new SimpleStringProperty();

    public StringProperty getUserProperty() {
        return userProperty;
    }


    public String getUserName() {
        return this.user;
    }

    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    public String login(String userName, String password) {
        String message = "";
        try {
            boolean isLoggedIn = false;
            boolean userExists = false;
            Scanner s = new Scanner(file);
            while (s.hasNextLine() && !isLoggedIn) {
                String[] user = s.nextLine().split(";");
                if(user[0].equals(userName) && user[1].equals(password)) {
                    message = loginSuccessful;
                    isLoggedIn = true;
                    userExists = true;
                    System.out.println("Login successful.");
                } else if(user[0].equals(userName) && !user[1].equals(password)) {
                    userExists = true;
                    message = wrongPassword;
                }
            }
           if(!isLoggedIn && !userExists) {
                message = userNotFound;
                System.out.println("User not found");
           } else if(isLoggedIn && userExists) {
               this.user = userName;
               this.userPassword = password;
           }
           s.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        return message;
    }

    public void createUser(String userName, String password) throws IOException {
        try (FileWriter fw = new FileWriter(file, true); BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(userName+";"+password);
            bw.newLine();
        }
            //System.out.println(userName + " " + password);
            //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            //bufferedWriter.write(userName+";"+password);
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            System.out.println("IOException");
        }
    }

    public void deleteUser(String userName, String password) throws IOException {
        try {
            Scanner scanner = new Scanner(file);
            ArrayList<String> users = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String user = scanner.nextLine();
                users.add(user);
                System.out.println(user);
            }

            for(String user : users ) {
                System.out.println(user);
                if(user.equals(userName)) {
                    users.remove(user);
                }
            }



            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            for(int i = 0; i <= users.toArray().length; i++) {
                System.out.println(users.get(i));
                if(users.get(i).equals(userName+";"+password)) {
                    users.remove(i);
                }
            }

            for(String user : users) {
                System.out.println(user);
                bw.write(user);
                bw.newLine();
            }

        } catch (FileNotFoundException e) {

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}

