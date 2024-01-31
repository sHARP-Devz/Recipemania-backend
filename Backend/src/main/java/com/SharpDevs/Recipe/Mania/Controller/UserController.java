package com.SharpDevs.Recipe.Mania.Controller;

import com.SharpDevs.Recipe.Mania.Service.UserService;
import com.SharpDevs.Recipe.Mania.domain.DTO.UpdateUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService ;

    @PatchMapping(path = "/update-user/{id}")
    public ResponseEntity<UpdateUserDto> updateUser(@RequestBody UpdateUserDto userDto, @PathVariable Long id){
        return userService.updateUser(userDto,id);
    }
}
