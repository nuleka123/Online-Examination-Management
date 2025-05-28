package Services;

import Model.Exam;
import Utils.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExamService {
    private final Connection con = DBConnect.getConnection();

    public boolean createExam(Exam exam) {

        String sql = "INSERT INTO exams (examType, subject, semester, date, time, examHall, instructions) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, exam.getExamType());
            ps.setString(2, exam.getSubject());
            ps.setString(3, exam.getSemester());
            ps.setDate(4, exam.getDate());
            ps.setTime(5, exam.getTime());
            ps.setString(6, exam.getExamHall());
            ps.setString(7, exam.getInstructions());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateExam(Exam exam) {
        String sql = "UPDATE exams SET examType = ?, subject = ?, semester = ?, date = ?, time = ?, examHall = ?, instructions = ? WHERE examId = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, exam.getExamType());
            ps.setString(2, exam.getSubject());
            ps.setString(3, exam.getSemester());
            ps.setDate(4, exam.getDate());
            ps.setTime(5, exam.getTime());
            ps.setString(6, exam.getExamHall());
            ps.setString(7, exam.getInstructions());
            ps.setInt(8, exam.getExamId());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteExam(int examId) {
        String sql = "DELETE FROM exams WHERE examId = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, examId);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Exam> getAllExams() {
        ArrayList<Exam> exams = new ArrayList<>();
        String sql = "SELECT * FROM exams";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Exam exam = new Exam();
                exam.setExamId(rs.getInt("examId"));
                exam.setExamType(rs.getString("examType"));
                exam.setSubject(rs.getString("subject"));
                exam.setSemester(rs.getString("semester"));
                exam.setDate(rs.getDate("date"));
                exam.setTime(rs.getTime("time"));
                exam.setExamHall(rs.getString("examHall"));
                exam.setInstructions(rs.getString("instructions"));
                exams.add(exam);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exams;
    }

    public Exam getExamById(int examId) {
        String sql = "SELECT * FROM exams WHERE examId = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, examId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Exam exam = new Exam();
                exam.setExamId(rs.getInt("examId"));
                exam.setExamType(rs.getString("examType"));
                exam.setSubject(rs.getString("subject"));
                exam.setSemester(rs.getString("semester"));
                exam.setDate(rs.getDate("date"));
                exam.setTime(rs.getTime("time"));
                exam.setExamHall(rs.getString("examHall"));
                exam.setInstructions(rs.getString("instructions"));
                return exam;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
