package com.lyfebloc.app.viewmodel;

import android.content.Context;
import android.content.Intent;

import com.lyfebloc.app.C;
import com.lyfebloc.app.entity.Wallet;
import com.lyfebloc.app.entity.nftassets.NFTAsset;
import com.lyfebloc.app.entity.tokens.Token;
import com.lyfebloc.app.interact.FetchTransactionsInteract;
import com.lyfebloc.app.service.AssetDefinitionService;
import com.lyfebloc.app.service.OpenSeaService;
import com.lyfebloc.app.service.TokensService;
import com.lyfebloc.app.ui.Erc1155AssetListActivity;
import com.lyfebloc.app.ui.NFTAssetDetailActivity;

import java.math.BigInteger;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class NFTAssetsViewModel extends BaseViewModel {
    private final FetchTransactionsInteract fetchTransactionsInteract;
    private final AssetDefinitionService assetDefinitionService;
    private final TokensService tokensService;
    private final OpenSeaService openSeaService;

    @Inject
    public NFTAssetsViewModel(FetchTransactionsInteract fetchTransactionsInteract,
                              AssetDefinitionService assetDefinitionService,
                              TokensService tokensService,
                              OpenSeaService openSeaService)
    {
        this.fetchTransactionsInteract = fetchTransactionsInteract;
        this.assetDefinitionService = assetDefinitionService;
        this.tokensService = tokensService;
        this.openSeaService = openSeaService;
    }

    public AssetDefinitionService getAssetDefinitionService()
    {
        return assetDefinitionService;
    }

    public OpenSeaService getOpenseaService()
    {
        return openSeaService;
    }

    public TokensService getTokensService()
    {
        return tokensService;
    }

    public Intent showAssetListDetails(Context context, Wallet wallet, Token token, NFTAsset asset)
    {
        Intent intent = new Intent(context, Erc1155AssetListActivity.class);
        intent.putExtra(C.Key.WALLET, wallet);
        intent.putExtra(C.EXTRA_CHAIN_ID, token.tokenInfo.chainId);
        intent.putExtra(C.EXTRA_ADDRESS, token.getAddress());
        intent.putExtra(C.EXTRA_NFTASSET_LIST, asset);
        return intent;
    }

    public Intent showAssetDetails(Context context, Wallet wallet, Token token, BigInteger tokenId)
    {
        Intent intent = new Intent(context, NFTAssetDetailActivity.class);
        intent.putExtra(C.Key.WALLET, wallet);
        intent.putExtra(C.EXTRA_CHAIN_ID, token.tokenInfo.chainId);
        intent.putExtra(C.EXTRA_ADDRESS, token.getAddress());
        intent.putExtra(C.EXTRA_TOKEN_ID, tokenId.toString());
        return intent;
    }
}