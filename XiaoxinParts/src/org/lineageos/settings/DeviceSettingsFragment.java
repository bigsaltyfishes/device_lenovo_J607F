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

package org.lineageos.settings;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Switch;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceFragment;
import androidx.preference.SwitchPreference;

import org.lineageos.settings.R;

import org.lineageos.settings.doze.DozeSettingsActivity;

import com.android.settingslib.widget.MainSwitchPreference;
import com.android.settingslib.widget.OnMainSwitchChangeListener;

public class DeviceSettingsFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener{
    private Preference mDozePreference;
    private Preference mDolbyAtmos;

    private final String DOZE = "doze";
    private final String DOLBY_ATMOS = "dolby_atmos";

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.device_settings);

        mDozePreference = findPreference(DOZE);
        mDozePreference.setOnPreferenceChangeListener(this);
        mDozePreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    Intent intent = new Intent(getContext(), DozeSettingsActivity.class);
                    startActivity(intent);
                    return true;                     
                }
            });

        mDolbyAtmos = findPreference(DOLBY_ATMOS);
        mDolbyAtmos.setOnPreferenceChangeListener(this);
        mDolbyAtmos.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    Intent intent = new Intent()
                        .setClassName("com.motorola.dolby.dolbyui",
                                "com.motorola.dolby.dolbyui.MotoMainActivity");
                    startActivity(intent);
                    return true;                     
                }
            });
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object value) {
        return true;
    }

}
