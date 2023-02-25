package com.lyfebloc.app.repository;

import com.lyfebloc.app.entity.NetworkInfo;

public interface OnNetworkChangeListener {
	void onNetworkChanged(NetworkInfo networkInfo);
}
