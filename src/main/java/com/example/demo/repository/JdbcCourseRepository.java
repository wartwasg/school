package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.Course;

@Repository
public class JdbcCourseRepository implements CourseRepository {
	private JdbcTemplate jdbcTemplate;

	public JdbcCourseRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Course> findAll() {
		String request = "select code,name,credits,time,semester from Course";
		List<Course> result = jdbcTemplate.query(request, this::getCourse);
		return result;
	}

	@Override
	public Optional<Course> findById(String code) {
		String request = "select code,name,credits,time,semester from Course where code=?";
		List<Course> result = jdbcTemplate.query(request, this::getCourse, code);
		return result.size() == 0 ? Optional.empty() : Optional.of(result.get(0));
	}

	@Override
	public Course save(Course course) {
		String request = "insert into Course (code,name,credits,time,semester) values (?,?,?,?,?)";
		jdbcTemplate.update(request, course.getCode(), course.getName(), course.getCredits(), course.getTime(),
				course.getSemester());
		return course;
	}

	public Course getCourse(ResultSet rc, int index) throws SQLException {
		return new Course(rc.getString("code"), rc.getString("name"), rc.getDouble("credits"), rc.getString("time"),
				rc.getString("semester"));
	}
}
