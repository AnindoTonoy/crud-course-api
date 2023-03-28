package io.javabrains.springbootstarter.course;

import java.net.Authenticator.RequestorType;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getCourses(id);		
	}
	
	@GetMapping("/topics/{topicId}/courses/{id}")
	public Optional<Course> getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	//@RequestMapping(method = RequestMethod.POST, value="/topics")
	@PostMapping("/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addTopic(course);
	}
	
//	@RequestMapping(method = RequestMethod.PUT, value="/topics/{id}")
	@PutMapping("/topics/{topicId}/courses/{id}")
	public String updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
		return "Course updated!";
	}

//	@RequestMapping(method = RequestMethod.DELETE, value="/topics/{id}")
	@PostMapping("/topics/{topicId}/courses/delete/{id}")
	public String deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
		return "Topic deleted!";
	}

}
