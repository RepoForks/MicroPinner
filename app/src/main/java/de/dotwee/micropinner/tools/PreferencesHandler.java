package de.dotwee.micropinner.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by lukas on 18.08.2015 - 16:11
 * for project MicroPinner.
 */
public class PreferencesHandler {
    public static final String PREF_FIRSTUSE = "pref_firstuse", PREF_SHOWNEWPIN = "pref_shownewpin", PREF_ENABLERESTORE = "pref_enablerestore";
    private final static String LOG_TAG = "PreferencesHandler";
    private static PreferencesHandler instance;
    private SharedPreferences preferences;

    private PreferencesHandler(Context context) {
        this.preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static synchronized PreferencesHandler getInstance(Context context) {
        if (instance == null)
            instance = new PreferencesHandler(context);

        return instance;
    }

    public boolean isRestoreEnabled() {
        return preferences.getBoolean(PREF_ENABLERESTORE, false);
    }

    public void setRestoreEnabled(boolean b) {
        preferences.edit().putBoolean(PREF_ENABLERESTORE, b).apply();
    }

    public boolean isShowNewPinEnabled() {
        return preferences.getBoolean(PREF_SHOWNEWPIN, true);
    }

    public void setShowNewPinEnabled(boolean b) {
        preferences.edit().putBoolean(PREF_SHOWNEWPIN, b).apply();
    }

    public boolean isFirstUse() {
        boolean ret = false;

        if (!preferences.contains(PREF_FIRSTUSE)) {
            preferences.edit().putBoolean(PREF_FIRSTUSE, true).apply();
            ret = true;
        }

        return ret;
    }
}