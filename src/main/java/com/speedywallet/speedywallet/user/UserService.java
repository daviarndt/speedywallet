package com.speedywallet.speedywallet.user;

import com.speedywallet.speedywallet.user.dto.RequestUserDTO;
import com.speedywallet.speedywallet.user.dto.ResponseUserDTO;
import com.speedywallet.speedywallet.utils.exception.UserFoundByEmailOrDocumentException;
import com.speedywallet.speedywallet.utils.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseUserDTO saveUser(RequestUserDTO requestUserDTO) {
        boolean userFound = userAlreadyExistsWithEmailOrDocument(requestUserDTO.email(), requestUserDTO.document());
        if (userFound) {
            throw new UserFoundByEmailOrDocumentException("User already exists by the given email/document");
        }
        return new ResponseUserDTO(
                userRepository.save(new UserModel(requestUserDTO))
        );
    }

    public boolean userAlreadyExistsWithEmailOrDocument(String email, String document) {
        if (userRepository.findByEmail(email).isPresent() || userRepository.findByDocument(document).isPresent()) {
            return true;
        }
        return false;
    }

    public UserModel getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found by the given ID"));
    }
}
