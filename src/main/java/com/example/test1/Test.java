package com.example.test1;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public  class Test{

    public static void readFile() throws IOException, ClassNotFoundException, SQLException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/decagon/IdeaProjects/Test1/src/main/java/file/Teachers.csv"));
        bufferedReader.readLine();
        String line;
        while((line = bufferedReader.readLine()) != null){
            String[] x = line.split(",");
            System.out.println(Arrays.toString(x));
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/facebook", "root", "Okafor.com");
            System.out.println(Arrays.toString(x));
            String teacher_id = x[0];
            String email = x[1];
            String first_name = x[2];
            String last_name = x[3];
            String grade_level = x[4];
            PreparedStatement preparedStatement = connection.prepareStatement("insert into mysql.teacher (teacher_id, email, first_name, last_name, grade_level) values(?,?,?,?,?)");
            preparedStatement.setString(1,teacher_id );
            preparedStatement.setString(2,email );
            preparedStatement.setString(3,first_name );
            preparedStatement.setString(4,last_name );
            preparedStatement.setString(5,grade_level );
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();

        }

    }

    public static void main(String... args) throws SQLException, ClassNotFoundException, IOException {

        readFile();

    }





}
