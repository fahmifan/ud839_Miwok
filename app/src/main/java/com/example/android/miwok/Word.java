package com.example.android.miwok;

public class Word {
    /** Default translation for then word */
    private String mDefaultTranslation;

    /** Miwok translation for the word */
    private String mMiwokTranslation;

    /** Image resource eg: R.id.image */
    private int mImageResourceId = NO_IMAGE_PROVIDED ;

    /** Audio resource id */
    private int mAudioResourceId = NO_AUDIO_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;
    private static final int NO_AUDIO_PROVIDED = -1;

    public Word(String mDefaultTranslation, String mMiwokTranslation, int audioId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mAudioResourceId = audioId;
    }

    public Word(String mDefaultTranslation, String mMiwokTranslation, int imageId, int audioId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mImageResourceId = imageId;
        this.mAudioResourceId = audioId;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public int getmAudioResourceId() {
        return mAudioResourceId;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    /** This will return true if the image is provided */
    public boolean hasImage() {
        return this.mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /** This will return true if the audio is provided */
    public boolean hasAudio() {
        return this.mAudioResourceId != NO_AUDIO_PROVIDED;
    }
}
