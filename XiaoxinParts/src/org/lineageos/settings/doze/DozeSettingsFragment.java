/*
 * Copyright (C) 2015 The CyanogenMod Project
 *               2017-2019 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.lineageos.settings.doze;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Switch;
import androidx.preference.Preference;
import androidx.preference.Preference.OnPreferenceChangeListener;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceFragment;
import androidx.preference.SwitchPreference;

import org.lineageos.settings.R;

import android.provider.Settings;

import com.android.settingslib.widget.MainSwitchPreference;
import com.android.settingslib.widget.OnMainSwitchChangeListener;

public class DozeSettingsFragment extends PreferenceFragment implements OnPreferenceChangeListener {

    private SwitchPreference mLidBehaviorPreference;
    private SwitchPreference mDoubleTapWakePreference;

    private final String LID_BEHAVIOR = "lid_behavior";
    private final String DOUBLE_TAP_WAKE = "double_tap_to_wake";

    private Handler mHandler = new Handler();

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.doze_settings);

        ContentResolver contentResolver = getContext().getContentResolver();

        mLidBehaviorPreference = findPreference(LID_BEHAVIOR);
        mLidBehaviorPreference.setOnPreferenceChangeListener(this);
        mLidBehaviorPreference.setChecked(Settings.Global.getInt(contentResolver, LID_BEHAVIOR, 1)!=0);

        mDoubleTapWakePreference = findPreference(DOUBLE_TAP_WAKE);
        mDoubleTapWakePreference.setOnPreferenceChangeListener(this);
        mDoubleTapWakePreference.setChecked(Settings.Secure.getInt(contentResolver, DOUBLE_TAP_WAKE, 1)!=0);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        ContentResolver contentResolver = getContext().getContentResolver();
        switch (preference.getKey()) {
            case LID_BEHAVIOR:
                Settings.Global.putInt(contentResolver, LID_BEHAVIOR, (boolean) newValue ? 1 : 0);
                mLidBehaviorPreference.setChecked(Settings.Global.getInt(contentResolver, LID_BEHAVIOR, 1)!=0);
                break;
            case DOUBLE_TAP_WAKE:
                Settings.Secure.putInt(contentResolver, DOUBLE_TAP_WAKE, (boolean) newValue ? 1 : 0);
                mDoubleTapWakePreference.setChecked(Settings.Secure.getInt(contentResolver, DOUBLE_TAP_WAKE, 1)!=0);
                break;
            default:
                break;
        }

        return true;
    }
    
}
