package io.fracturelabs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootController {
	@GetMapping("/")
	public String safeGetHandler() {
		return "GET / is not vulnerable";
	}

	@PostMapping("/")
	public String safePostHandler() {
		return "POST / is not vulnerable";
	}

	@GetMapping("/vulnerable")
	public String vulnGetHandler(ExampleBean bean) {
		return "GET /vulnerable is vulnerable - check for a shell";
	}

	@PostMapping("/vulnerable")
	public String vulnPostHandler(ExampleBean bean) {
		return "POST /vulnerable is vulnerable - check for a shell";
	}
}
