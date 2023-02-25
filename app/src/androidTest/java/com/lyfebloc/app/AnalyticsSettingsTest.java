package com.lyfebloc.app;

import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.lyfebloc.app.assertions.Should.shouldSee;
import static com.lyfebloc.app.steps.Steps.createNewWallet;
import static com.lyfebloc.app.steps.Steps.gotoSettingsPage;
import static com.lyfebloc.app.steps.Steps.selectMenu;
import static com.lyfebloc.app.util.Helper.click;

import org.junit.Test;

public class AnalyticsSettingsTest extends BaseE2ETest
{
    @Test
    public void title_should_see_analytics_settings_page()
    {
        createNewWallet();
        gotoSettingsPage();
        selectMenu("Advanced");
        click(withText("Analytics"));
        shouldSee("Share Anonymous Data");
    }

    @Test
    public void title_should_see_crash_report_settings_page()
    {
        createNewWallet();
        gotoSettingsPage();
        selectMenu("Advanced");
        click(withText("Crash Reporting"));
        shouldSee("Share Anonymous Data");
    }
}
