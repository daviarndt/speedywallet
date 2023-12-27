package com.speedywallet.speedywallet.user;

import com.speedywallet.speedywallet.user.dto.RequestUserDTO;
import com.speedywallet.speedywallet.user.dto.ResponseUserDTO;
import com.speedywallet.speedywallet.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<ApiResponse<ResponseUserDTO>> saveUser(@RequestBody @Valid RequestUserDTO requestUserDTO) {
        ResponseUserDTO responseUserDTO = userService.saveUser(requestUserDTO);
        return new ResponseEntity<>(ApiResponse.success(responseUserDTO), HttpStatus.CREATED);
    }
}
