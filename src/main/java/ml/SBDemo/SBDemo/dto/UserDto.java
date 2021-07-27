package ml.SBDemo.SBDemo.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDto extends DtoBase {

    private Integer id;

    @NotBlank
    private String userName;

    @NotBlank(message = "Email cannot be empty!")
    @Email(message = "Incorrect email format!")
    private String email;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;
}
