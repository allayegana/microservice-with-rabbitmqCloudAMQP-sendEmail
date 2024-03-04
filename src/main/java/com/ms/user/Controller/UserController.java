package com.ms.user.Controller;


import com.ms.user.Dtos.UserRecordDto;
import com.ms.user.Service.UserService;
import com.ms.user.models.UserModels;
import com.ms.user.producers.UserProducers;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/users")
    public ResponseEntity<UserModels> saveUsers(@RequestBody @Valid UserRecordDto userRecordDto) {
        var userModels = new UserModels();
        BeanUtils.copyProperties(userRecordDto, userModels);
        return ResponseEntity.status(HttpStatus.CREATED).body( userService.saveService(userModels));
    }

}
