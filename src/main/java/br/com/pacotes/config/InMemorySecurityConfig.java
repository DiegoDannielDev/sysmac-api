//package br.com.pacotes.config;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//public class InMemorySecurityConfig extends WebSecurityConfigurerAdapter {
//    private static final Logger LOGGER = LoggerFactory.getLogger(InMemorySecurityConfig.class);
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
//        auth.inMemoryAuthentication()
//                .withUser("user").password("{noop}123").roles("USER")
//                .and()
//                .withUser("admin").password("{noop}123").roles("ADMIN");
//
//    }
//}
