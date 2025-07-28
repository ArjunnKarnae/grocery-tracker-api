package com.grocerytracker.mapper;

import com.grocerytracker.dto.*;
import com.grocerytracker.entity.ProfileEntity;
import com.grocerytracker.entity.UserEntity;

public class AuthMapper {


   public static UserEntity mapAuthDtoToUserEntity(AuthRequestDTO authRequestDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(authRequestDTO.getUserName());
        userEntity.setAccountNonExpired(Boolean.TRUE);
        userEntity.setAccountNonLocked(Boolean.TRUE);
        userEntity.setCredentialsNonExpired(Boolean.TRUE);
        userEntity.setEnabled(Boolean.TRUE);

        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setEmail(authRequestDTO.getEmail());
        profileEntity.setFirstName(authRequestDTO.getFirstName());
        profileEntity.setLastName(authRequestDTO.getLastName());
        userEntity.setUserProfile(profileEntity);
        return userEntity;
    }
}
