package com.gymapp.gymapp.bo;

import com.gymapp.gymapp.Role;
import com.gymapp.gymapp.UserBO;
import com.gymapp.gymapp.entity.User;
import com.gymapp.gymapp.factory.UserFactory;
import com.gymapp.gymapp.input.UserAddInput;
import com.gymapp.gymapp.repository.UserRepository;
import com.gymapp.gymapp.validator.PasswordValidator;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;


@Service
@Transactional
public class UserBOImpl implements UserBO {

    private final UserRepository userRepository;
    private final UserFactory userFactory;
    private final PasswordEncoder passwordEncoder;
    private final PasswordValidator passwordValidator;

    public UserBOImpl(final UserRepository userRepository,
               final UserFactory userFactory,
               final PasswordEncoder passwordEncoder,
               final PasswordValidator passwordValidator) {
        this.userRepository = userRepository;
        this.userFactory = userFactory;
        this.passwordEncoder = passwordEncoder;
        this.passwordValidator = passwordValidator;
    }

    @Override
    public boolean grantRole(long id, Role role) {
        User user = userRepository.getOne(id);

        user.grant(role);

        return true;
    }

    @Override
    public boolean revokeRole(long id, Role role) {
        User user = userRepository.getOne(id);

        user.revoke(role);

        return false;
    }

    @Override
    public boolean changePassword(long userId, String password) {
        passwordValidator.validate(password);

        User user = userRepository.getOne(userId);
        user.updatePassword(passwordEncoder.encode(password));

        return true;
    }

    @Override
    public boolean isMatchingPassword(long userId, String password) {
        User user = userRepository.getOne(userId);
        return passwordEncoder.matches(password, user.getPassword());
    }

    @Override
    public User addUser(UserAddInput userAddInput) {
        User user = userFactory.create(userAddInput);

        user = userRepository.save(user);

        return user;
    }

    @Override
    public boolean deleteUser(long userId) {
        userRepository.deleteById(userId);
        return true;
    }

    @Override
    public boolean changeUsername(long userId, String newUsername) {
        User user = userRepository.getOne(userId);
        user.updateUsername(newUsername);
        return true;
    }

    @Override
    public Set<Role> getUserRoles(long userId) {
        User user = userRepository.getOne(userId);

        return user.getRoles();
    }
}
