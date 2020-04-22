package com.company.notetake;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert
    void Insert(Note note);

    @Update
    void Update(Note note);

    @Delete
    void Delete(Note note);

    @Query("SELECT * FROM note_table ORDER BY id ASC")
    LiveData<List<Note>> getAllNotes();


}
