package com.mcsoft.android.preferencies_demo;

import android.os.Bundle;
import android.preference.PreferenceCategory;
import android.preference.SwitchPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceScreen;
import android.support.v7.preference.SwitchPreferenceCompat;

/**
 * Created by Mario on 01.02.2018.
 */

public class PrefFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {

        addPreferencesFromResource(R.xml.pref_settings);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        Preference settingsSwitch = preferenceScreen.findPreference(getString(R.string.pref_switch_one_key));
        setCheckBoxVisibility((SwitchPreferenceCompat) settingsSwitch);
        settingsSwitch.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                setCheckBoxVisibility((SwitchPreferenceCompat) preference);
                return true;
            }
        });
    }


    private void setCheckBoxVisibility(SwitchPreferenceCompat preference) {
        boolean isChecked = preference.isChecked();
        Preference checkbox1 = findPreference(getString(R.string.pref_checkbox_one_key));
        Preference checkbox2 = findPreference(getString(R.string.pref_checkbox_two_key));
        Preference category = findPreference(getString(R.string.pref_category_one_key));
        checkbox1.setVisible(isChecked);
        checkbox2.setVisible(isChecked);
        category.setVisible(isChecked);
    }
}
