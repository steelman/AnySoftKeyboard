package com.anysoftkeyboard.ui.settings.setup;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;

import com.anysoftkeyboard.RobolectricFragmentTestCase;
import com.menny.android.anysoftkeyboard.R;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
public class SetUpKeyboardWizardFragmentTest extends RobolectricFragmentTestCase<SetUpKeyboardWizardFragment> {

    @NonNull
    @Override
    protected SetUpKeyboardWizardFragment createFragment() {
        return new SetUpKeyboardWizardFragment();
    }

    @Test
    @Config(sdk = Build.VERSION_CODES.M)
    public void test() {
        SetUpKeyboardWizardFragment fragment = startFragment();
        ViewPager pager = (ViewPager) fragment.getView().findViewById(R.id.wizard_pages_pager);
        Assert.assertNotNull(pager);
        Assert.assertEquals(4, pager.getAdapter().getCount());
        Assert.assertTrue(((WizardPagesAdapter) pager.getAdapter()).getItem(2) instanceof WizardPermissionsFragment);
    }
}