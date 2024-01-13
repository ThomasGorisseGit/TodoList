package fr.gorisse.todoApp.TodoListApp.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Email;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.V_Phone;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.converter.EmailConverter;
import fr.gorisse.todoApp.TodoListApp.entity.value_objects.converter.PhoneConverter;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.NonNullFields;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;


    private String lastName;
    private String firstName;
    private String username;
    private String password;

    private boolean isActived;
    @JsonIgnore
    private String activationCode;

    @Convert(converter = EmailConverter.class)
    private V_Email email;


    @Convert(converter = PhoneConverter.class)
    private V_Phone phone;


    @CreationTimestamp
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateCreation;

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return this.isActived;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return this.isActived;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return this.isActived;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return this.isActived;
    }
}
