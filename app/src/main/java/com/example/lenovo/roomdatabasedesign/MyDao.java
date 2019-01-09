package com.example.lenovo.roomdatabasedesign;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

@Dao
public interface MyDao  {

    @Insert
    void addUser(User user);

}
