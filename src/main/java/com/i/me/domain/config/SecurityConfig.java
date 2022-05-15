package com.i.me.domain.config;

import com.i.me.domain.auth.CustomOAuth2UserService;
import com.i.me.domain.role.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //스프링 시큐리티 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() //h2-console 화면을 사용하기 위해 해당 옵션을 disable
                .and()
                .authorizeRequests()                //url 별 권한 관리를 설정하는 옵션의 시작점, authorizeRequests가 선언되어야만 antMatchers 옵션을 사용가능
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
                .antMatchers("/posts/**/**").hasRole(Role.USER.name()) //권한 관리 대상을 지정하는 옵션, "/"등 지정된 url들은 permitAll() 옵션을 통해 전체 열람 권한,
                .anyRequest().authenticated()       //설정된 값들 이외에 나머지 URL들을 나타내나 authenticated()을 추가하여 나머지 URL들은 모두 인증된 사용자만 허용
                .and()
                .logout()                           //로그아웃 기능에 대한 여러 설정의 진입점, 로그아웃 성공 시 "/" 주소로 이동
                .logoutSuccessUrl("/")
                .and()
                .oauth2Login()                      //OAuth 2 로그인 기능에 대한 여러 설정의 진입점
                .userInfoEndpoint()                 //OAuth 2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담당함
                .userService(customOAuth2UserService);//소셜 로그인 성공시 후속 조치를 진행할 UserService 인터페이스 구현체를 등록, 리소스 서버(즉, 소셜 서비스들)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시할 수 있다.
    }
}