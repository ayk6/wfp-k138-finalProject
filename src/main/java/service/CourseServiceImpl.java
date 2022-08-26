package service;


import lombok.RequiredArgsConstructor;
import model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl {

    @Autowired
    final CourseRepository courseRepository;

    @Transactional (readOnly = true)
    public List<Course> findAll() {
        List<Course> courses = new ArrayList<>();
        Iterable<Course> courseIterable = courseRepository.findAll();
        courseIterable.iterator().forEachRemaining(courses::add);
        return courses;
    }

    @Transactional
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Transactional (readOnly = true)
    public Course findById(Long id) {
        return courseRepository.findById(id).get();
    }

    @Transactional
    public Course update(Course course) {
        return  courseRepository.save(course);
    }

    @Transactional
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    @Transactional
    public void deleteByName(String courseName) {courseRepository.deleteByName(courseName);
    }
}
