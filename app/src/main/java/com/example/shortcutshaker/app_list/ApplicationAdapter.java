package com.example.shortcutshaker.app_list;

import java.util.List;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shortcutshaker.R;

public class ApplicationAdapter extends ArrayAdapter<ApplicationInfo> {

    private List<ApplicationInfo> appsList = null;
    private Context context;
    private PackageManager packageManager;

    public ApplicationAdapter(Context context, int textViewResourceId,
                              List<ApplicationInfo> appsList) {

        super(context, textViewResourceId, appsList);

        this.context = context;

        this.appsList = appsList;

        packageManager = context.getPackageManager();
    }

    @Override
    public int getCount() {

        return ((null != appsList) ? appsList.size() : 0);
    }

    @Override
    public ApplicationInfo getItem(int position) {

        return ((null != appsList) ? appsList.get(position) : null);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if (null == view) {

            LayoutInflater layoutInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = layoutInflater.inflate(R.layout.app_sorter, null);
        }

        ApplicationInfo applicationInfo = appsList.get(position);

        if (null != applicationInfo) {

            TextView appName = view.findViewById(R.id.app_name);
            TextView packageName = view.findViewById(R.id.app_package);
            ImageView iconView = view.findViewById(R.id.app_icon);

            appName.setText(applicationInfo.loadLabel(packageManager));
            packageName.setText(applicationInfo.packageName);
            iconView.setImageDrawable(applicationInfo.loadIcon(packageManager));
        }

        return view;
    }
};