/*
 * Copyright (C) 2018 Scorpion
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

package com.nest.settings.ui;

import com.android.internal.logging.nano.MetricsProto;

import android.support.v7.preference.PreferenceCategory;
import android.support.v7.preference.PreferenceScreen;
import com.nest.settings.preferences.Utils;

import android.os.Bundle;
import com.android.settings.R;

import com.android.settings.SettingsPreferenceFragment;

public class NotificationsSettings extends SettingsPreferenceFragment {

    private static final String INCALL_VIB_OPTIONS = "incall_vib_options";

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        addPreferencesFromResource(R.xml.settings_notifications);

        PreferenceScreen prefScreen = getPreferenceScreen();
        PreferenceCategory incallVibCategory = (PreferenceCategory) findPreference(INCALL_VIB_OPTIONS);
        if (!Utils.isVoiceCapable(getActivity())) {
            prefScreen.removePreference(incallVibCategory);
        }
    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.SCORPION;
    }
}
