package com.example.JdbcDemo.repository;

import com.example.JdbcDemo.model.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class StudentRepository {

   private JdbcTemplate jdbcTemplate;

   public StudentRepository(JdbcTemplate jdbcTemplate){
       this.jdbcTemplate = jdbcTemplate;
   }

//   private StudentRowMapper studentRowMapper = new StudentRowMapper();

   private RowMapper<Student> rowMapper =
           new BeanPropertyRowMapper<>(Student.class);


//    String url="jdbc:mysql://localhost:3306/curd_springboot";
//    String username = "root";
//    String password = "7276&;;fzad";



//    public void createStudent(Student student) {
//        String sql = """
//                         INSERT INTO student(name, email, age)
//                         VALUES(?, ?, ?)
//                         """;
//        try (
//                Connection connection = DriverManager.getConnection(url, username, password);
//
//                PreparedStatement preparedStatement =
//                        connection.prepareStatement(sql);
//        ) {
//
//            preparedStatement.setString(1, student.getName());
//            preparedStatement.setString(2, student.getEmail());
//            preparedStatement.setInt(3, student.getAge());
//
//            int rowAffected = preparedStatement.executeUpdate();
//
//            if(rowAffected == 1) {
//                System.out.println("Create Student successful");
//            }
//            else {
//                System.out.println("Create Student failed");
//            }
//        }
//        catch(SQLException e) {
//            System.out.println("Database connection failed");
//            e.printStackTrace();
//        }
//
//    }

    public void createStudent(Student student) {
        String sql = """
                         INSERT INTO student(name, email, age)
                         VALUES(?, ?, ?)
                         """;

        int rowAffected = jdbcTemplate.update(sql,
                student.getName(), student.getEmail(), student.getAge());

        if(rowAffected == 1) {
            System.out.println("Create Student successful");
        }
        else {
            System.out.println("Create Student failed");
        }
    }


//    public void updateStudent(Student student, Long id) {
//        String sql = """
//                     UPDATE student
//                     SET name = ?,
//                         email = ?,
//                         age = ?
//                     WHERE user_id = ?
//                     """;
//        try(
//                Connection connection = DriverManager.getConnection(url, username, password);
//                PreparedStatement preparedStatement =
//                        connection.prepareStatement(sql);
//        ) {
//
//            preparedStatement.setString(1, student.getName());
//            preparedStatement.setString(2, student.getEmail());
//            preparedStatement.setInt(3, student.getAge());
//            preparedStatement.setLong(4, id);
//
//            int rowAffected =  preparedStatement.executeUpdate();
//
//            if(rowAffected == 1) {
//                System.out.println("Update operation successful");
//            }
//            else {
//                System.out.println("Updation failed");
//            }
//        }
//        catch(SQLException e) {
//            System.out.println("Database connection failed");
//            e.printStackTrace();
//        }
//    }


    public void updateStudent(Student student, Long id) {
        String sql = """
                     UPDATE student
                     SET name = ?,
                         email = ?,
                         age = ?
                     WHERE id = ?
                     """;

            int rowAffected = jdbcTemplate.update(sql,
                    student.getName(), student.getEmail(), student.getAge(), id);

            if(rowAffected == 1) {
                System.out.println("Update operation successful");
            }
            else {
                System.out.println("Updation failed");
            }

    }


//    public void deleteStudent(Long id) {
//        String sql = """
//            DELETE from student WHERE id  = ?
//        """;
//
//        try(
//                Connection connection = DriverManager.getConnection(url, username, password);
//                PreparedStatement preparedStatement =
//                        connection.prepareStatement(sql);
//        ) {
//
//            preparedStatement.setLong(1, id);
//
//            int rowAffected = preparedStatement.executeUpdate();
//
//            if(rowAffected == 1) {
//                System.out.println("Delete operation successful");
//            }
//            else {
//                System.out.println("Deletion failed");
//            }
//        }
//        catch(SQLException e) {
//            System.out.println("Database connection failed");
//            e.printStackTrace();
//        }
//    }


    public void deleteStudent(Long id) {
        String sql = """
                    DELETE from student WHERE id  = ?
                """;

        int rowAffected = jdbcTemplate.update(sql, id);

        if (rowAffected == 1) {
            System.out.println("Delete operation successful");
        } else {
            System.out.println("Deletion failed");
        }

    }


    public Student getStudentById(Long id) {

        String sql = """
                SELECT id, name, email, age FROM student
                WHERE id  = ?
                """;

        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

//    public ArrayList<Student> getStudent() {
//
//        String sql = """
//                SELECT id , name, email, age FROM student
//                """;
//
//
//
//        ArrayList<Student> students = new ArrayList<>();
//
//        try(
//                Connection connection = DriverManager.getConnection(url, username, password);
//                PreparedStatement preparedStatement =
//                        connection.prepareStatement(sql);
//        ) {
//
//            try(ResultSet resultSet = preparedStatement.executeQuery()) {
//                List<Student> studentList = new ArrayList<>();
//
//                while(resultSet.next()) {
//                    Student student = mapRow(resultSet);
//                    studentList.add(student);
//                    System.out.println(student);
//                    students.add(student);
//                }
//            }
//            return students;
//        }
//        catch(SQLException e) {
//            System.out.println("Database connection failed");
//            e.printStackTrace();
//        }
//        return students;
//    }

    public List<Student> getStudent() {

        String sql = """
                SELECT id, name, email, age FROM student
                """;

        List<Student> students = jdbcTemplate.query(
                sql,rowMapper);

        return students;
    }


//    public void completeCRUD() {
//        try {
//            Connection connection = DriverManager.getConnection(url, username, password);
//            Statement statement = connection.createStatement();
//
//            String sql = "SELECT user_id , name, email, age " +
//                    "FROM student where id  = 7";
//
//            boolean result = statement.execute(sql);
//
//            if(result) {
//                ResultSet resultSet = statement.getResultSet();
//            }
//            else {
//                int rowAffected = statement.getUpdateCount();
//            }
//
//            connection.close();
//        }
//        catch(SQLException e) {
//            System.out.println("Database connection failed");
//            e.printStackTrace();
//        }
//    }



}
