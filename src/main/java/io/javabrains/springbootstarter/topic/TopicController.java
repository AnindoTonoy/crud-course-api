package io.javabrains.springbootstarter.topic;

import java.net.Authenticator.RequestorType;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getTopics();		
	}
	
	@RequestMapping("/topics/{id}")
	public Optional<Topic> getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	//@RequestMapping(method = RequestMethod.POST, value="/topics")
	@PostMapping("/addTopics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/topics/{id}")
	//@PostMapping("/addTopics")
	public String updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(topic, id);
		return "Topic updated!";
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/topics/{id}")
	//@PostMapping("/addTopics")
	public String deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
		return "Topic deleted!";
	}

}
