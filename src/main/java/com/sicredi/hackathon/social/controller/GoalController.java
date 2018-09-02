package com.sicredi.hackathon.social.controller;

import com.sicredi.hackathon.social.dto.request.AddValueGoalRequest;
import com.sicredi.hackathon.social.dto.request.EditGoalRequest;
import com.sicredi.hackathon.social.dto.request.RegisterGoalsRequest;
import com.sicredi.hackathon.social.dto.response.AddValueGoalResponse;
import com.sicredi.hackathon.social.entity.GoalEntity;
import com.sicredi.hackathon.social.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goals")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @PostMapping
    public ResponseEntity registerGoal(@RequestHeader(value = "Authorization", required = false) final String username, @RequestBody final RegisterGoalsRequest request) {
        return goalService.register(username, request);
    }

    @PutMapping
    public ResponseEntity editGoal(@RequestHeader(value = "Authorization", required = false) final String username, @RequestBody final EditGoalRequest request) {
        return goalService.edit(username, request);
    }

    @GetMapping("/{id}")
    public GoalEntity findGoal(@RequestHeader(value = "Authorization", required = false) final String username, @PathVariable("id") final Long id) {
        return goalService.find(username, id);
    }

    @DeleteMapping("/{id}")
    public GoalEntity deleteGoal(@RequestHeader(value = "Authorization", required = false) final String username, @PathVariable("id") final Long id) {
        return goalService.delete(username, id);
    }

    @PostMapping("/value")
    public AddValueGoalResponse addValue(@RequestHeader(value = "Authorization", required = false) final String username, @RequestBody final AddValueGoalRequest request) {
        return goalService.addValue(username, request);
    }
}
