package com.lyfebloc.app;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSubstring;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.lyfebloc.app.assertions.Should.shouldSee;
import static com.lyfebloc.app.steps.Steps.createNewWallet;
import static com.lyfebloc.app.steps.Steps.getWalletAddress;
import static com.lyfebloc.app.steps.Steps.gotoWalletPage;
import static com.lyfebloc.app.steps.Steps.input;
import static com.lyfebloc.app.steps.Steps.watchWalletWithENS;
import static com.lyfebloc.app.util.Helper.click;

import com.lyfebloc.app.util.Helper;

import org.junit.Test;

public class WalletNameTest extends BaseE2ETest
{
    @Test
    public void should_show_custom_name_instead_of_address()
    {
        createNewWallet();
        String address = getWalletAddress();

        gotoWalletPage();
        shouldSeeFormattedAddress(address);

        renameWalletTo("TestWallet");
        shouldSee("TestWallet");

        renameWalletTo("");
        shouldSeeFormattedAddress(address);
    }

    @Test
    public void should_show_custom_name_instead_of_ENS_name()
    {
        watchWalletWithENS("vitalik.eth");
        // Should see ENS name instead of address
        shouldSee("vitalik.eth");

        renameWalletTo("Vitalik");
        gotoWalletPage();
        shouldSee("Vitalik");

        renameWalletTo("");
        gotoWalletPage();
        shouldSee("vitalik.eth");
    }

    private void renameWalletTo(String name)
    {
        click(withId(R.id.action_my_wallet));
        click(withSubstring("Rename this Wallet"));
        onView(withId(R.id.edit_text)).perform(replaceText(name));
        input(R.id.input_name, name);
        click(withText("Save Name"));
        Helper.wait(2);
    }

    private void shouldSeeFormattedAddress(String address)
    {
        shouldSee(address.substring(0, 6) + "..." + address.substring(address.length() - 4)); // 0xabcd...wxyz
    }
}
