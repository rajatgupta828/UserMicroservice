package com.rajat.user.services;

import com.rajat.user.entities.User;
import com.rajat.user.repository.UserRepository;
import com.rajat.user.valueobjects.Department;
import com.rajat.user.valueobjects.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser method of DepartmentService");
        return  userRepository.save(user);
    }

    public User getUserByID(int userID) {
        log.info("Inside getDepartmentbyId method of DepartmentService");
        return  userRepository.findByUserID(userID);
    }

    public ResponseTemplateVO getUserWithDepartment(int userID) {
        log.info("Into getUserWithDEpartment method of User Service");

        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserID(userID);
        // RestTemplate
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/" +
                user.getDepartmentID(), Department.class);
        if(department != null){
            log.info("Department Details : " + department.toString());
        }else{
            log.info("****** Department is null ******");
        }

        vo.setDepartment(department);
        vo.setUser(user);
        return vo;
    }
}
