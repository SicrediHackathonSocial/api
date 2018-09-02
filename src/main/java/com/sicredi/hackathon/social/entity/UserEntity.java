package com.sicredi.hackathon.social.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
@ToString
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 7366539098994678983L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 30, unique = true)
    private String username;

    @Column(nullable = false, length = 30)
    private String password;

    @JsonIgnore
    @ManyToMany(mappedBy = "contribuitors")
    private List<ProjectEntity> projects;

    @Column(nullable = true)
    private String picture;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "following",
            joinColumns = @JoinColumn(name = "id_followed"),
            inverseJoinColumns = @JoinColumn(name = "id_follower"))
    private List<UserEntity> followers = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "followers")
    private List<UserEntity> following = new ArrayList<>();


    public UserEntity(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

}
