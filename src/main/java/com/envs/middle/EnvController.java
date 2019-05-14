package com.envs.middle;

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
        return findEnvsironments();
    }

    private List<Environment> findEnvsironments() {
        List<Environment> envs = new ArrayList();
        envs.add(new Environment("bet365"));
        envs.add(new Environment("marca"));
        return envs;
    }
}
