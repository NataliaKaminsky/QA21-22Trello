package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    private String email;
    private String password;
}