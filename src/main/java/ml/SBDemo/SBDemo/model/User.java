package ml.SBDemo.SBDemo.model;


import lombok.*;
import org.dom4j.rule.Mode;
import org.hibernate.annotations.DynamicInsert;

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

}
