package org.example.Repository;

import org.example.Model.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentRepository {

    String url = "jdbc:mysql://localhost:3306/curd_springboot";
    String username = "root";
    String password = "7276&;;fzad";


    public void createUser(Student student){

        String sql = """
                         INSERT INTO student(name, email, age)
                         VALUES(?, ?, ?)
                         """;

        try (
                Connection connection = DriverManager.getConnection(url, username, password);

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ){

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getAge());

            int result = preparedStatement.executeUpdate();

            if(result == 1){
                System.out.println("Create operation success");
            }else{
                System.out.println("Create operation failed");
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    public void updateUser(Student student, long id){

        String sql = """
                         UPDATE student 
                             set name = ?,
                                 email = ?,
                                 age = ?
                             where user_id = ?
                         """;

        try (
                Connection connection = DriverManager.getConnection(url, username, password);

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setLong(4, id);

            int result = preparedStatement.executeUpdate();

            if(result == 1){
                System.out.println("Update operation success");
            }else{
                System.out.println("Update operation failed");
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    public void deleteUser(long id){

        String sql = """
                         DELETE from student 
                             where user_id = ?
                         """;

        try (
                Connection connection = DriverManager.getConnection(url, username, password);

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){

            preparedStatement.setLong(1, id);

            int result = preparedStatement.executeUpdate();

            if(result == 1){
                System.out.println("Delete operation success");
            }else{
                System.out.println("Delete operation failed");
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    public void getUserById(long id){

        String sql = """
                         select * from student 
                             where user_id = ?
                         """;

        try (
                Connection connection = DriverManager.getConnection(url, username, password);

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){

            preparedStatement.setLong(1, id);

            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if(resultSet.next()) {
                    Student student = mapRow(resultSet);
                    System.out.println("User_id : "+student.getId());
                    System.out.println("Name : "+student.getName());
                    System.out.println("Email : "+student.getEmail());
                    System.out.println("Age : "+student.getAge());
                }
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void getStudents(){

        String sql = """
                         select * from student
                         """;

        try (
                Connection connection = DriverManager.getConnection(url, username, password);

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){



            try(ResultSet resultSet = preparedStatement.executeQuery()) {

                while(resultSet.next()){
                    Student student = mapRow(resultSet);
                    System.out.println("User_id : "+student.getId());
                    System.out.println("Name : "+student.getName());
                    System.out.println("Email : "+student.getEmail());
                    System.out.println("Age : "+student.getAge());
                    System.out.println();
                }

            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    public Student mapRow(ResultSet resultSet) throws SQLException{
        Student student = new Student();

        student.setId(resultSet.getLong("user_id"));
        student.setName(resultSet.getString("name"));
        student.setEmail(resultSet.getString("email"));
        student.setAge(resultSet.getInt("age"));

        return student;
    }


    //    public void deleteUser(){
//        try{
//            Connection connection = DriverManager.getConnection(url, username, password);
//
//            Statement statement = connection.createStatement();
//
//            String sql = "DELETE from student " +
//                    "where user_id = 1";
//
//            int result = statement.executeUpdate(sql);
//
//            if(result == 1){
//                System.out.println("Delete operation success");
//            }else{
//                System.out.println("Delete operation failed");
//            }
//
//            connection.close();
//        } catch (SQLException e) {
//            System.out.println("Database connection failed");
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }
//    public void updateUser(){
//        try{
//            Connection connection = DriverManager.getConnection(url, username, password);
//
//            Statement statement = connection.createStatement();
//
//            String sql = "UPDATE student set age = 30 " +
//                    "where user_id = 1";
//
//            int result = statement.executeUpdate(sql);
//
//            if(result == 1){
//                System.out.println("Update operation success");
//            }else{
//                System.out.println("Update operation failed");
//            }
//
//            connection.close();
//        } catch (SQLException e) {
//            System.out.println("Database connection failed");
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }

}
