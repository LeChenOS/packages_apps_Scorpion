/*
 * Copyright (C) 2018 Invictrix ROM
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

package com.nest.settings;

import android.os.Bundle;

import com.android.settings.R;

import com.nest.settings.preferences.Utils;
import com.nest.settings.ui.ScorpionSettingsFragment;

public class MainActivity extends ScorpionSettingsFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final String KEY_DEVICE_PART = "device_part";
        final String KEY_DEVICE_PART_PACKAGE_NAME = "org.omnirom.device";

        addPreferencesFromResource(R.xml.settings_main);

        // DeviceParts
        if (!Utils.isPackageInstalled(getActivity(), KEY_DEVICE_PART_PACKAGE_NAME)) {
            getPreferenceScreen().removePreference(findPreference(KEY_DEVICE_PART));
        }

    }

}
