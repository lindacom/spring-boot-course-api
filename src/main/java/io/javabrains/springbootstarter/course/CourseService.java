package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	

	/* private List<Topic> topics = new ArrayList<> (Arrays.asList(
				new Topic("spring", "Spring Framework", "Spring Framework Description "),
				new Topic("java", "Core Java", "Core Java Description"),
				new Topic("Javascript", "Javascript", "JavaScript Description")
	)); */
	
	
	public List <Course> getAllCourses() {
		// return courses;
		List<Course> courses = new ArrayList<>();
		courseRepository.findAll()
		.forEach(courses::add);
		return courses;
	}
	
	public Optional<Course> getCourse(String id) {
		// return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id);
	}
	
	public void addCourse(Course course) {
		// courses.add(course);
		courseRepository.save(course);
			}

	public void updateCourse(String id, Course course) {
	/*for(int i=0; i < courses.size(); i++) {
		course c=courses.get(i);
		if (t.getId().equals(id)) {
			courses.set(i,  course);
			return;
		}
	}*/
		courseRepository.save(course);
		
	}

	public void deleteCourse(String id) {
		// courses.removeIf(c -> c.getId().equals(id));
		courseRepository.deleteById(id);
	}
}
