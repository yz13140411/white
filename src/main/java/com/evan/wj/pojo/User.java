package com.evan.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@Table(name = "user")
@Entity
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;
  private String username;
  private String password;
  private String salt;
  private String name;
  private String phone;
  private String email;
  private boolean enabled;

  @Transient
  private List<String> roles;


}
