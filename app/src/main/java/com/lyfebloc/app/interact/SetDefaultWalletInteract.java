package com.lyfebloc.app.interact;

import com.lyfebloc.app.repository.WalletRepositoryType;
import com.lyfebloc.app.entity.Wallet;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class SetDefaultWalletInteract {

	private final WalletRepositoryType accountRepository;

	public SetDefaultWalletInteract(WalletRepositoryType walletRepositoryType) {
		this.accountRepository = walletRepositoryType;
	}

	public Completable set(Wallet wallet) {
		return accountRepository
				.setDefaultWallet(wallet)
				.observeOn(AndroidSchedulers.mainThread());
	}
}
