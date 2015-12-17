/*
 * Copyright (C) 2014-2015 Oleg Kan, @Simplaapliko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.simplaapliko.util.sample;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.simplaapliko.util.AppInfo;
import com.simplaapliko.util.Feedback;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {

    private TextView mAppVersion;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        mAppVersion = (TextView) rootView.findViewById(R.id.app_version);

        rootView.findViewById(R.id.get_version)
                .setOnClickListener(this);

        rootView.findViewById(R.id.get_version_name)
                .setOnClickListener(this);

        rootView.findViewById(R.id.get_version_code)
                .setOnClickListener(this);

        rootView.findViewById(R.id.send_feedback)
                .setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.get_version:
                mAppVersion.setText(AppInfo.getAppVersion(getContext()));
                break;
            case R.id.get_version_name:
                mAppVersion.setText(AppInfo.getAppVersionName(getContext()));
                break;
            case R.id.get_version_code:
                mAppVersion.setText(String.valueOf(AppInfo.getAppVersionCode(getContext())));
                break;
            case R.id.send_feedback:
                Feedback.sendFeedback(getContext(), "myEmail@mail.com", "Util");
                break;
        }
    }
}
