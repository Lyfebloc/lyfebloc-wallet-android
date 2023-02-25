package com.lyfebloc.app;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.lyfebloc.app.assertions.Should.shouldSee;
import static com.lyfebloc.app.steps.Steps.createNewWallet;
import static com.lyfebloc.app.util.Helper.click;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

public class CoinbasePayTest extends BaseE2ETest
{
    @Test
    public void should_see_coinbase_pay_window()
    {
        createNewWallet();
        click(withText("Buy ETH"));
        shouldSee("Buy with Coinbase Pay");
        click(withId(R.id.buy_with_coinbase_pay));
        shouldSee("Buy with Coinbase Pay");
    }
}
