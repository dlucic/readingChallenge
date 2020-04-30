package hr.littlemouse.readingChallenge.data.enumeration;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

import static hr.littlemouse.readingChallenge.data.enumeration.UserPermission.USER_READ;
import static hr.littlemouse.readingChallenge.data.enumeration.UserPermission.USER_WRITE;

@AllArgsConstructor
@Getter
public enum UserRole {

    USER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(USER_READ, USER_WRITE));

    private final Set<UserPermission> permissions;
}
