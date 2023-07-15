package com.flappybird.view; //user defined package (mechanism to encapsulate a group of classes, sub packages and interfaces)

import java.sql.*;//sql library imported




public class WriteToDb
{
    public void save(String Name, int highscore)
    {
        String url = "jdbc:mysql://localhost:3306/flappy";
        //database name = flappy
        //3306 is the default port, other port is 3307
        //we are connecting sql and intellij and storing in URL
        String userName = "root";
        String password = "admin";

        //connectivity is done using try-catch phrase
        try{
            Connection conn = DriverManager.getConnection(url, userName, password);
            //we give access to sql using driver manager
            //driverManager.getConnection is a method to create connection

            Statement smt = conn.createStatement();

            //This is the SQL query that inserts data to database table
            String query =
                    "INSERT INTO flappy.scores(name, score) VALUE(\"" + Name + "\", " + highscore + ")";
            //table name = score and database = flappy

            int status = smt.executeUpdate(query);//executing the update

            //checking if data is inserted or not
            if (status > 0) {
                System.out.println("data entered");
            } else {
                System.out.println("failure");
            }

            conn.close();
        } catch(SQLException e) //inbuilt SQL exception
        {
            e.printStackTrace();
        }
    }
}
