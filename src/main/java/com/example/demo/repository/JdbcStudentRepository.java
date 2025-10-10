package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.Student;

@Repository
public class JdbcStudentRepository implements StudentRepository {
	private JdbcTemplate repo;

	public JdbcStudentRepository(JdbcTemplate repo) {
		this.repo = repo;
	}

	@Override
	public List<Student> findAll() {
		String request = "select id,fname,email,semester,registration_status from Student";
		List<Student> student = repo.query(request, this::getStudent);
		return student;
	}

	@Override
	public Optional<Student> findById(String id) {
		String request = "select id,fname,email,semester,registration_status from Student where id=?";
		List<Student> student = repo.query(request, this::getStudent, id);
		return student.size() == 0 ? Optional.empty() : Optional.of(student.get(0));
	}

	@Override
	public void Save(Student student) {
		String request = "insert into Student (id,fname,email,semester,registration_status) values(?,?,?,?,?)";
		repo.update(request, student.getId(), student.getFname(), student.getEmail(), student.getSemester(),
				student.getRegistration_status());
	}

	public Student getStudent(ResultSet rc, int index) throws SQLException {
		return new Student(rc.getString("id"), rc.getString("fname"), rc.getString("email"), rc.getString("semester"),
				rc.getString("registration_status"));
	}

}
