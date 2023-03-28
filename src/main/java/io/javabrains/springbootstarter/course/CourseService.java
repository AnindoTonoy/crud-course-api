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
	
//	private List<Course> topics = new ArrayList<>(Arrays.asList(
//			new Course("Spring", "Sping Framework", "Spring framework Description"),
//			new Course("Java", "Core Java Framework", "Core Java Description"),
//			new Course("JavaScript", "JavaScript", "JavaScript Description")
//			));
	
	public List<Course> getCourses(String topicId) {
		
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	public Optional<Course> getCourse(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id);
	}

	public void addTopic(Course Course) {		
		courseRepository.save(Course);
	}

	public void updateCourse(Course course) {
//		for (int i = 0 ; i < topics.size(); i++) {
//			Topic t = topics.get(i);
//			if (t.getId().equals(id)) {
//				topics.set(i, topic);
//				return;
//			}
//		}
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
//		topics.removeIf(t -> t.getId().equals(id));
		courseRepository.deleteById(id);
		
	}
}
