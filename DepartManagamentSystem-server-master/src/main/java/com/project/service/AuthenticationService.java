package com.project.service;

import com.project.Dao.EmployeeRepo;
import com.project.Dto.EmployeeDto;
import com.project.model.Employee;

import com.project.payload.AuthenticationResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuthenticationService {

    @Autowired
    private  EmployeeRepo repository;
    @Autowired
    private  PasswordEncoder passwordEncoder;

    @Autowired
    private  JwtService jwtService;

//    private TokenRepository tokenRepository;

    @Autowired
    private  AuthenticationManager authenticationManager;

    @Autowired
    private ModelMapper modelMapper;



    public AuthenticationResponse  register(@Valid @NotBlank  Employee request) {

        // check if user already exist. if exist than authenticate the user
        if(repository.findByEmail(request.getEmail()).isPresent()) {
            return new AuthenticationResponse(null, "User already exist" , modelMapper.map(request , EmployeeDto.class));
        }

        Employee user = new Employee();
        user.setName(request.getName());
      //  user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setSalary(request.getSalary());
        user.setCity(request.getCity());
//        user.setGender(request.getGender());
        user.setDepartment(request.getDepartment());


        user.setRole(request.getRole());

        Employee save = repository.save(user);

        String jwt = jwtService.generateToken(save);

//        saveUserToken(jwt, save);

        return new AuthenticationResponse(jwt, "User registration was successful" , modelMapper.map(save , EmployeeDto.class) );

    }

    public AuthenticationResponse authenticate( @Valid @NotBlank Employee request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        Employee user = repository.findByEmail(request.getEmail()).orElseThrow();
        String jwt = jwtService.generateToken(user);

       // revokeAllTokenByUser(user);
//        saveUserToken(jwt, user);

        return new AuthenticationResponse(jwt, "User login was successful" , modelMapper.map(user , EmployeeDto.class));

    }




//    private void revokeAllTokenByUser(Employee user) {
//        List<Token> validTokens = tokenRepository.findAllTokensByEmployee( user.getId());
//        if(validTokens.isEmpty()) {
//            return;
//        }
//
//        validTokens.forEach(t-> {
//            t.setLoggedOut(true);
//        });
//
//        tokenRepository.saveAll(validTokens);
////   }
//    private void saveUserToken(String jwt, Employee user) {
//        Token token = new Token();
//        token.setToken(jwt);
//        token.setLoggedOut(false);
//       token.setEmployee(user);
//       tokenRepository.save(token);
//  }
}
