package com.example.yourboard.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class SignupRequestDto {
    @Size(min = 4,max = 10,message ="아이디의 길이는 4자에서 10자 사이입니다")
    @Pattern(regexp = "[a-z0-9]*$",message = "아이디 형식이 일치하지 않습니다")
    private String username;

    @Size(min = 8,max = 15,message ="비밀번호의 길이는 8자에서 15자 사이입니다")
    @Pattern(regexp = "[a-zA-Z0-9`~!@#$%^&*()_=+|{};:,.<>/?]*$",message = "비밀번호 형식이 일치하지 않습니다")
    private String password;
    private boolean admin = false;
    private String adminToken = "";
}

//final을 붙이는 이유 주입하는 정보가 null이 아니라는 것을 알려주기 위해
// 처음 배울때는 최대한 본인이 게터, 세터를 쓰려고해야 이해할 수 있다.
//꿀팁 : 과제 요구사항 읽을때 > 내가 잘 모르는 개념이 뭘까? 그 개념 자체가 무엇인지. 파악.염두에 두면서 코드를 짤것.
//>    > 좀 멀리서 바라봐라. 너무 매몰되지 마라.
//exception에 대한 부분
//org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Invocation of init method failed; nested exception is org.hibernate.AnnotationException: mappedBy reference an unknown target entity property: com.example.yourboard.entity.User.user in com.example.yourboard.entity.User.users
//@Pattern(regexp = "^[a-zA-Z0-9]{8,15}$")