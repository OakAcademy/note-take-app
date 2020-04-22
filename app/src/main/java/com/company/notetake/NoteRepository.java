package com.company.notetake;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteRepository {

    private NoteDao noteDao;
    private LiveData<List<Note>> notes;

    public  NoteRepository(Application application)
    {
        NoteDatabase database = NoteDatabase.getInstance(application);
        noteDao = database.noteDao();
        notes = noteDao.getAllNotes();
    }

    public void insert(Note note)
    {
        new InsertNoteAsyncTask(noteDao).execute(note);
    }

    public void update(Note note)
    {
        new UpdateNoteAsyncTask(noteDao).execute(note);
    }

    public void delete(Note note)
    {
        new DeleteNoteAsyncTask(noteDao).execute(note);
    }

    public LiveData<List<Note>> getAllNotes()
    {
        return notes;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<Note, Void, Void>
    {
        private NoteDao noteDao;

        private InsertNoteAsyncTask(NoteDao noteDao)
        {
            this.noteDao = noteDao;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.Insert(notes[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<Note, Void, Void>
    {
        private NoteDao noteDao;

        private UpdateNoteAsyncTask(NoteDao noteDao)
        {
            this.noteDao = noteDao;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.Update(notes[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<Note, Void, Void>
    {
        private NoteDao noteDao;

        private DeleteNoteAsyncTask(NoteDao noteDao)
        {
            this.noteDao = noteDao;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.Delete(notes[0]);
            return null;
        }
    }
}
