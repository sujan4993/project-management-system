/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.web.auth.configuration;

import com.sujan.web.auth.handler.LoginSuccessHandler;
import com.sujan.web.auth.service.AuthUserService;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author sujan
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private DataSource dataSource;
    @Autowired
    private LoginSuccessHandler loginSuccessHandler;
    @Autowired
    private AuthUserService userService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/register","/resources/**").permitAll()
                .antMatchers("/users/addNew").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().loginPage("/login")                
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(loginSuccessHandler)
                .permitAll()
                .and().logout().permitAll()
                .invalidateHttpSession(true);
                
                
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/webjars/**","/assets/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = getPasswordEncoder();
       
      /*  String userSql="select username,password,status "
                + " from tbl_users where username=?";
        String roleSql="select u.username,r.role_name from tbl_users u "
                + " join tbl_user_roles ur on ur.user_id=u.id "
                + " join tbl_roles r on r.id=ur.role_id "
                + " where u.username=? ";
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(userSql)
                .authoritiesByUsernameQuery(roleSql)
                .passwordEncoder(getPasswordEncoder()); */
      auth.authenticationProvider(getauthProvider());
    }

    public DaoAuthenticationProvider  getauthProvider(){
        DaoAuthenticationProvider
                provider =new DaoAuthenticationProvider();
        provider.setPasswordEncoder(getPasswordEncoder());
        provider.setUserDetailsService(userService);
        return provider;
    }
    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
