package ml.SBDemo.SBDemo.model;


import lombok.*;
import ml.SBDemo.SBDemo.utils.Specifications;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@DynamicInsert
public class User extends ModelBase<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "userName", nullable = false, unique = true)
    private String userName;

    @Basic
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Basic
    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Basic
    @Column(name = "lastName", nullable = false)
    private String lastName;


    @Override
    public Specification<User> getSpecification() {
        Specification<User> spec = super.getSpecification();
        if (StringUtils.isNotBlank(userName)) {
            spec = spec.and(Specifications.specLike("userName", "%" + userName + "%"));
        }
        if (StringUtils.isNotBlank(email)) {
            spec = spec.and(Specifications.specLike("email", "%" + email + "%"));
        }
        if (StringUtils.isNotBlank(firstName)) {
            spec = spec.and(Specifications.specLike("firstName", "%" + firstName + "%"));
        }
        if (StringUtils.isNotBlank(lastName)) {
            spec = spec.and(Specifications.specLike("lastName", "%" + lastName + "%"));
        }
        return spec;
    }
}
