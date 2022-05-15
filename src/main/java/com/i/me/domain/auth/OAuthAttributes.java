package com.i.me.domain.auth;

import com.i.me.domain.role.Role;
import com.i.me.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {

    private Map<String,Object> attributes;
    private String nameAttributeKey, name, email;

    @Builder
    public OAuthAttributes(Map<String,Object> attributes,
                           String nameAttributeKey,
                           String name,String email){
        this.attributes=attributes;
        this.nameAttributeKey=nameAttributeKey;
        this.name=name;
        this.email=email;
    }

    public static OAuthAttributes of(String userNameAttributeName, //String registrationId 구글만 하기에
                                     Map<String, Object> attributes) {
        return ofGoogle(userNameAttributeName, attributes);
    }          //of() : OAuth2User에서 반환하는 사용자 정보는 Map이기 때문에 값 하나하나를 변환해야만 한다.

    public static OAuthAttributes ofGoogle(String userNameAttributeName,
                                           Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    //user엔티티를 생성, 가입하는 시점. 글쓰기를 위해 USER권한을 부여하였다. OAuthAttributes 클래스 생성이 끝나면 같은 패키지 SessionUser 클래스를 생성한다.
    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .role(Role.USER)
                .build();
    }

}