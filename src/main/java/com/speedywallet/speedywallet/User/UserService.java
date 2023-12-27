package com.speedywallet.speedywallet.User;

import com.speedywallet.speedywallet.User.DTO.RequestUserDTO;
import com.speedywallet.speedywallet.User.DTO.ResponseUserDTO;
import com.speedywallet.speedywallet.utils.exception.UserFoundByEmailOrDocumentException;
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
}
