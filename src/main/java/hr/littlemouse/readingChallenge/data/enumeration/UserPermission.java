package hr.littlemouse.readingChallenge.data.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserPermission {

    USER_READ("user:read"),
    USER_WRITE("user:write");

    private final String permission;
}
