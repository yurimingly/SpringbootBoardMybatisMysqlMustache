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
    }

    public static OAuthAttributes ofGoogle(String userNameAttributeName,
                                           Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .role(Role.GUEST)
                .build();
    }

}