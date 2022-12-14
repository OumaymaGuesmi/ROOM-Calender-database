package com.example.roomdatabaseproject;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "word_table")
public class Word {
    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "word")
    private String mWord;

    @NotNull
    @ColumnInfo(name = "word2")
    private String mWord2;

    @NotNull
    @ColumnInfo(name = "word3")
    private String mWord3;

    public Word(@NotNull String mWord, @NotNull String mWord2, @NotNull String mWord3) {
        this.mWord = mWord;
        this.mWord2 = mWord2;
        this.mWord3 = mWord3;
    }

    public String getWord() {
        return this.mWord;
    }

    public String getWord2() {
        return mWord2;
    }

    public void setWord(@NotNull String mWord) {
        this.mWord = mWord;
    }

    public void setWord2(String mWord2) {
        this.mWord2 = mWord2;
    }

    @NotNull
    public String getWord3() {
        return mWord3;
    }

    public void setWord3(@NotNull String mWord3) {
        this.mWord3 = mWord3;
    }
}
