package com.portfoilo.fullstackbackend;

import javax.persistence.Id;
import javax.validation.constraints.*;

public class SignupForm {

    @Id
    private Integer id;

    @NotBlank(message = "メールアドレスを入力してください")
    @Email
    private String email;

    @NotBlank(message = "パスワードを入力する")
    @Pattern(regexp="^((?=.*[0-9])(?=.*[a-z]).{6,})$", message="パスワードは6文字以上の英数字で入力してください")
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
