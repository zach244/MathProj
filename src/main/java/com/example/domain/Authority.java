package com.example.domain;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by zach on 2/7/2017.
 */
public class Authority implements GrantedAuthority {

    private final String authority;

   public Authority(String authority)
   {
       this.authority = authority;
   }
   @Override
    public String getAuthority()
   {
       return authority;
   }
}
