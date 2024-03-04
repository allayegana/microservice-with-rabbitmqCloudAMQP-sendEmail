package com.ms.user.Service;


import com.ms.user.Repository.UserRepository;
import com.ms.user.models.UserModels;
import com.ms.user.producers.UserProducers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {


    final UserRepository userRepository;
    final UserProducers userProducers;

    public UserService(UserRepository userRepository, UserProducers userProducers) {
        this.userRepository = userRepository;
        this.userProducers = userProducers;
    }


    @Transactional
    public UserModels saveService(UserModels userModels) {
        var userModel = userRepository.save(userModels);
        userProducers.publishMessageEmail(userModel);
        return userModel;
    }
}
