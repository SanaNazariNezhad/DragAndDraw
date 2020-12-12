package org.maktab.draganddraw;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

public class DragAndDrawActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context context) {
        return new Intent(context, DragAndDrawActivity.class);
    }

    @Override
    public Fragment createFragment() {
        return DragAndDrawFragment.newInstance();
    }
}