package com.lyfebloc.app.entity;

import static com.lyfebloc.app.repository.EthereumNetworkBase.COVALENT;
import static com.lyfebloc.ethereum.EthereumNetworkBase.GOERLI_ID;

import android.net.Uri;
import android.text.TextUtils;

import androidx.annotation.Nullable;

import com.lyfebloc.app.entity.transactionAPI.TransferFetchType;
import com.lyfebloc.app.repository.EthereumNetworkRepository;
import com.lyfebloc.app.util.Utils;

public class NetworkInfo extends com.lyfebloc.ethereum.NetworkInfo
{
    private final String ETHERSCAN_API = ".etherscan.";
    private final String BLOCKSCOUT_API = "blockscout";
    private final String MATIC_API = "polygonscan";
    private final String OKX_API = "oklink";
    private final String PALM_API = "explorer.palm";

    public  String backupNodeUrl = null;
    public  String etherscanAPI = null; //This is used by the API call to fetch transactions

    public NetworkInfo(
            String name,
            String symbol,
            String rpcServerUrl,
            String etherscanUrl,
            long chainId,
            String backupNodeUrl,
            String etherscanAPI,
            boolean isCustom) {
        super(name, symbol, rpcServerUrl, etherscanUrl, chainId, isCustom);
        this.backupNodeUrl = backupNodeUrl;
        this.etherscanAPI = etherscanAPI;
    }

    public NetworkInfo(
            String name,
            String symbol,
            String rpcServerUrl,
            String etherscanUrl,
            long chainId,
            String backupNodeUrl,
            String etherscanAPI) {
        super(name, symbol, rpcServerUrl, etherscanUrl, chainId, false);
        this.backupNodeUrl = backupNodeUrl;
        this.etherscanAPI = etherscanAPI;
    }

    public String getShortName()
    {
        int index = this.name.indexOf(" (Test)");
        if (index > 0) return this.name.substring(0, index);
        else if (this.name.length() > 10) return this.symbol;
        else return this.name;
    }

    public TransferFetchType[] getTransferQueriesUsed()
    {
        if (etherscanAPI.contains(COVALENT) || TextUtils.isEmpty(etherscanAPI))
        {
            return new TransferFetchType[0];
        }
        else if (chainId == GOERLI_ID) //goerli doesn't yet implement erc1155 route TODO: test for when Etherscan Goerli implements ERC1155 tx:
        {                              // https://api-goerli.etherscan.io/api?module=account&action=token1155tx&address=0x0000000000000000000000000000000000000000
            return new TransferFetchType[]{TransferFetchType.ERC_20, TransferFetchType.ERC_721};
        }
        else if (etherscanAPI.contains(MATIC_API) || etherscanAPI.contains(ETHERSCAN_API) || etherscanAPI.contains(OKX_API))
        {
            return new TransferFetchType[]{TransferFetchType.ERC_20, TransferFetchType.ERC_721, TransferFetchType.ERC_1155};
        }
        else
        {
            return new TransferFetchType[]{TransferFetchType.ERC_20}; // assume it only supports tokenTx, eg Blockscout, Palm
        }
    }

    @Nullable
    public Uri getEtherscanUri(String transactionHash) {
        if (etherscanUrl != null)
        {
            return Uri.parse(etherscanUrl)
                    .buildUpon()
                    .appendEncodedPath(transactionHash)
                    .build();
        }
        else
        {
            return Uri.EMPTY;
        }
    }

    public Uri getEtherscanAddressUri(String value)
    {
        if (etherscanUrl != null)
        {
            String explorer = etherscanUrl;
            if (Utils.isAddressValid(value))
            {
                explorer = explorer.substring(0, explorer.lastIndexOf("tx/"));
                explorer += "address/";
            }
            else if (!Utils.isTransactionHash(value))
            {
                return Uri.EMPTY;
            }

            return Uri.parse(explorer)
                    .buildUpon()
                    .appendEncodedPath(value)
                    .build();
        }
        else
        {
            return Uri.EMPTY;
        }
    }

    public boolean hasRealValue()
    {
        return EthereumNetworkRepository.hasRealValue(this.chainId);
    }
}
