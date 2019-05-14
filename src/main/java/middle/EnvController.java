package middle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/env")
public class EnvController {
    private List<Environment> environmentList;

    @GetMapping("/")
    public List<Environment> getEnvironmentList() {
        return environmentList;
    }

    private List<Environment> findEnvsironments() {
        List<Environment> envs = new ArrayList();
        return envs;
    }
}
