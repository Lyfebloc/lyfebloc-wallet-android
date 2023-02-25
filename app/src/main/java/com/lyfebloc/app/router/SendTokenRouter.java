package com.lyfebloc.app.router;


import android.app.Activity;
import android.content.Intent;

import com.lyfebloc.app.C;
import com.lyfebloc.app.entity.QRResult;
import com.lyfebloc.app.entity.Wallet;
import com.lyfebloc.app.entity.tokens.Token;
import com.lyfebloc.app.ui.SendActivity;

public class SendTokenRouter {
    public void open(Activity context, String address, String symbol, int decimals, Wallet wallet, Token token, long chainId) {
        Intent intent = new Intent(context, SendActivity.class);
        intent.putExtra(C.EXTRA_CONTRACT_ADDRESS, address);
        intent.putExtra(C.EXTRA_ADDRESS, token.getAddress());
        intent.putExtra(C.EXTRA_NETWORKID, chainId);
        intent.putExtra(C.EXTRA_SYMBOL, symbol);
        intent.putExtra(C.EXTRA_DECIMALS, decimals);
        intent.putExtra(C.Key.WALLET, wallet);
        intent.putExtra(C.EXTRA_AMOUNT, (QRResult)null);
        intent.setFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        context.startActivityForResult(intent, C.COMPLETED_TRANSACTION);
    }
}
