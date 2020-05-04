package hr.littlemouse.readingChallenge.data.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UserDTO {

    public static final String REGEX_EMAIL = "^[\\w-]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String EMAIL_MESSAGE = "Email should be valid, abc@abc.abc";
    public static final String PASSWORD_REGEX = "^[\\w]{4,}$";
    public static final String PASSWORD_MESSAGE = "Allowed A-Z, a-z, 0-9, _";


    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String username;

    @NotBlank
    @Pattern(regexp = PASSWORD_REGEX, message = PASSWORD_MESSAGE)
    private String password;

    @NotBlank
    private String repeatPassword;

    @NotBlank
    @Email(message = EMAIL_MESSAGE, regexp = REGEX_EMAIL)
    private String email;
}
