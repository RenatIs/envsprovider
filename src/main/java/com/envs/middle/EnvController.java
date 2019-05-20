package com.envs.middle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/env")
public class EnvController {
    private List<Environment> environmentList;

    @GetMapping
    public List<Environment> getEnvironmentList() {
        return findEnvironments();
    }

    private List<Environment> findEnvironments() {
        List<Environment> envs = new ArrayList();

        Random r = new Random();
        envs.add(new Environment("bet365", "bet365","pas.bet365", "oapi.bet365", 4805));
        envs.add(new Environment("marca", "marcaES", "pasas.com", "oapi.marxusix", 443));
        envs.forEach(environment -> environment.setUsers(
                Arrays.asList(new User(("user" + r.nextInt(100)), "pwd1"), new User(("user" + r.nextInt(100)), "pwd1"))));
        return envs;
    }

    @GetMapping("/{nameParam}")
    public Environment getEnvironmentList(@PathVariable("nameParam") String name) {
        List<Environment> allEnvs = findEnvironments();
        Optional<Environment> found = allEnvs.stream()
                .filter(env -> env.getName().equalsIgnoreCase(name))
                .findAny();
        return found.orElse(null);
    }
}
