package com.lyfebloc.app.repository;

import com.lyfebloc.app.entity.coinbasepay.DestinationWallet;

import java.util.List;

public interface CoinbasePayRepositoryType {
    String getUri(DestinationWallet.Type type, String json, List<String> list);
}
