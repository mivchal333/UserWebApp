package webapp.service;


import webapp.model.User;
import webapp.model.enimeration.Role;
import webapp.repository.UserRepository;
import webapp.util.ValidateResult;
import webapp.util.ValidateResultType;

public class RegistrationService {

    private UserRepository userRepository;
    private static RegistrationService instance = null;

    public static RegistrationService getInstance() {
        if (instance == null) {
            instance = new RegistrationService();
        }
        return instance;
    }

    private RegistrationService() {
        this.userRepository = UserRepository.getInstance();
    }

    public ValidateResult validateUserData(String login, String password) {
        ValidateResult result = new ValidateResult("User added!:)", ValidateResultType.SUCCESS);
        if (userRepository.userExist(login)) {
            result.setValue("This login already exist");
            result.setType(ValidateResultType.ERROR);
        }
        return result;
    }

    public void registerUser(String login, String password) {
        User user = new User(login, password, Role.USER);
        userRepository.save(user);
    }

    public boolean checkUserExist(String login) {
        return userRepository.userExist(login);
    }

}
