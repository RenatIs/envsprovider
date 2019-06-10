package com.envs;


import com.envs.db.DBController;
import com.envs.db.DBHandler;
import com.envs.middle.Environment;
import com.envs.middle.User;
import com.envs.oapi.OAPIController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/env")
public class MainController {           //should be replaced to another package (does not belong to PAS)
    private List<Environment> environmentList;


    private DBController dbController;
    private OAPIController oapiController;

    @GetMapping
    public List<Environment> getEnvironmentList() {
        return findEnvironmentsForTest();
    }

    @GetMapping("/{nameParam}")
    public Environment getEnvironmentList(@PathVariable("nameParam") String name) {
        List<Environment> allEnvs = findEnvironmentsForTest();
        Optional<Environment> found = allEnvs.stream()
                .filter(env -> env.getName().equalsIgnoreCase(name))
                .findAny();
        return found.orElse(null);
    }

    @GetMapping("/verifyUsers")
    public void verifyThatUsersStillAvailable() {
        User user = new User("loh", "pidr");
        dbController.createUser(user);
        oapiController.verifyThatUserIsAvailable(user);
    }


    private List<Environment> findEnvironmentsByNames(List<String> environmentNames) {
        DBHandler dbHandler = new DBHandler("url to database");

        return IntStream.range(0, 3)
                .mapToObj(i -> dbHandler.getEnvironment())
                .collect(Collectors.toList());
    }

    private List<Environment> findEnvironmentsForTest() {
        List<Environment> envs = new ArrayList();

        Random r = new Random();
        envs.add(new Environment("bet365", "bet365", "pas.bet365", "oapi.bet365", 4805));
        envs.add(new Environment("marca", "marcaES", "pasas.com", "oapi.marxusix", 443));
        envs.forEach(environment -> environment.setUsers(
                Arrays.asList(new User(("user" + r.nextInt(100)), "pwd1"), new User(("user" + r.nextInt(100)), "pwd1"))));
        return envs;
    }


}
