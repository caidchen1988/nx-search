package com.nx.search.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 钱塘交易中心应用权限框架配置
 *
 * @author: caidchen
 * @create: 2017-04-12 14:02
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable(); // 关闭crsf() 防止post请求405

        http.authorizeRequests()
                .antMatchers("/login/**","/search/**", "/wx/**").anonymous()
                .anyRequest().authenticated();

        http.formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/") ;

        // 配置登出
        http.logout()
                .logoutSuccessUrl("/login")
                .permitAll();

        // 登录后记住用户，下次自动登录,数据库中必须存在名为persistent_logins的表
        http.rememberMe().tokenValiditySeconds(1209600) ;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //设置不拦截规则
        web.ignoring().antMatchers("/static/**");
    }

}