package lv.venta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Bean
    public UserDetailsManager createDemoUsers(){
        UserDetails details1 = User.builder()
        .username("laurelis")
        .password(encoder.encode("123"))
        .authorities("ADMIN")
        .build();

        UserDetails details2 = User.builder()
        .username("lauris1")
        .password(encoder.encode("123"))
        .authorities("USER")
        .build();

        UserDetails details3 = User.builder()
        .username("lauris2")
        .password(encoder.encode("123"))
        .authorities("USER")
        .build();

        return new InMemoryUserDetailsManager(details1, details2, details3);
    }


    @Bean
    public SecurityFilterChain configurePermissionToEndPoints(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(auth -> auth
        .requestMatchers("/").permitAll()
        .requestMatchers("/hello/**").permitAll()
        .requestMatchers("/product/test").hasAuthority("ADMIN")
        .requestMatchers("/product/crud/all").permitAll()
        .requestMatchers("/product/crud/one?id=**").permitAll()
        .requestMatchers("/product/crud/all/**").permitAll()
        .requestMatchers("/product/crud/insert").hasAuthority("ADMIN")
        .requestMatchers("/product/crud/update/**").hasAuthority("ADMIN")
        .requestMatchers("/product/crud/delete/**").hasAuthority("ADMIN")
        .requestMatchers("product/filder/**").hasAnyAuthority("USER", "ADMIN")
        );

        http.formLogin(auth -> auth.permitAll());

        return http.build();
    }
    
}
