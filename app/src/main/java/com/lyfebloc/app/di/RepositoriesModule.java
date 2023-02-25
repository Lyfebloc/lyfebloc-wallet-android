package com.lyfebloc.app.di;

import static com.lyfebloc.app.service.KeystoreAccountService.KEYSTORE_FOLDER;

import android.content.Context;

import com.lyfebloc.app.repository.CoinbasePayRepository;
import com.lyfebloc.app.repository.CoinbasePayRepositoryType;
import com.lyfebloc.app.repository.EthereumNetworkRepository;
import com.lyfebloc.app.repository.EthereumNetworkRepositoryType;
import com.lyfebloc.app.repository.OnRampRepository;
import com.lyfebloc.app.repository.OnRampRepositoryType;
import com.lyfebloc.app.repository.PreferenceRepositoryType;
import com.lyfebloc.app.repository.SharedPreferenceRepository;
import com.lyfebloc.app.repository.SwapRepository;
import com.lyfebloc.app.repository.SwapRepositoryType;
import com.lyfebloc.app.repository.TokenLocalSource;
import com.lyfebloc.app.repository.TokenRepository;
import com.lyfebloc.app.repository.TokenRepositoryType;
import com.lyfebloc.app.repository.TokensRealmSource;
import com.lyfebloc.app.repository.TransactionLocalSource;
import com.lyfebloc.app.repository.TransactionRepository;
import com.lyfebloc.app.repository.TransactionRepositoryType;
import com.lyfebloc.app.repository.TransactionsRealmCache;
import com.lyfebloc.app.repository.WalletDataRealmSource;
import com.lyfebloc.app.repository.WalletRepository;
import com.lyfebloc.app.repository.WalletRepositoryType;
import com.lyfebloc.app.service.AccountKeystoreService;
import com.lyfebloc.app.service.LyfeblocService;
import com.lyfebloc.app.service.AnalyticsService;
import com.lyfebloc.app.service.AnalyticsServiceType;
import com.lyfebloc.app.service.AssetDefinitionService;
import com.lyfebloc.app.service.GasService;
import com.lyfebloc.app.service.IPFSService;
import com.lyfebloc.app.service.IPFSServiceType;
import com.lyfebloc.app.service.KeyService;
import com.lyfebloc.app.service.KeystoreAccountService;
import com.lyfebloc.app.service.NotificationService;
import com.lyfebloc.app.service.OpenSeaService;
import com.lyfebloc.app.service.RealmManager;
import com.lyfebloc.app.service.SwapService;
import com.lyfebloc.app.service.TickerService;
import com.lyfebloc.app.service.TokensService;
import com.lyfebloc.app.service.TransactionsNetworkClient;
import com.lyfebloc.app.service.TransactionsNetworkClientType;
import com.lyfebloc.app.service.TransactionsService;
import com.google.gson.Gson;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;

@Module
@InstallIn(SingletonComponent.class)
public class RepositoriesModule
{
    @Singleton
    @Provides
    PreferenceRepositoryType providePreferenceRepository(@ApplicationContext Context context)
    {
        return new SharedPreferenceRepository(context);
    }

    @Singleton
    @Provides
    AccountKeystoreService provideAccountKeyStoreService(@ApplicationContext Context context, KeyService keyService)
    {
        File file = new File(context.getFilesDir(), KEYSTORE_FOLDER);
        return new KeystoreAccountService(file, context.getFilesDir(), keyService);
    }

    @Singleton
    @Provides
    TickerService provideTickerService(OkHttpClient httpClient, PreferenceRepositoryType sharedPrefs, TokenLocalSource localSource)
    {
        return new TickerService(httpClient, sharedPrefs, localSource);
    }

    @Singleton
    @Provides
    EthereumNetworkRepositoryType provideEthereumNetworkRepository(
            PreferenceRepositoryType preferenceRepository,
            @ApplicationContext Context context
    )
    {
        return new EthereumNetworkRepository(preferenceRepository, context);
    }

    @Singleton
    @Provides
    WalletRepositoryType provideWalletRepository(
            PreferenceRepositoryType preferenceRepositoryType,
            AccountKeystoreService accountKeystoreService,
            EthereumNetworkRepositoryType networkRepository,
            WalletDataRealmSource walletDataRealmSource,
            KeyService keyService)
    {
        return new WalletRepository(
                preferenceRepositoryType, accountKeystoreService, networkRepository, walletDataRealmSource, keyService);
    }

    @Singleton
    @Provides
    TransactionRepositoryType provideTransactionRepository(
            EthereumNetworkRepositoryType networkRepository,
            AccountKeystoreService accountKeystoreService,
            TransactionLocalSource inDiskCache,
            TransactionsService transactionsService)
    {
        return new TransactionRepository(
                networkRepository,
                accountKeystoreService,
                inDiskCache,
                transactionsService);
    }

    @Singleton
    @Provides
    OnRampRepositoryType provideOnRampRepository(@ApplicationContext Context context)
    {
        return new OnRampRepository(context);
    }

    @Singleton
    @Provides
    SwapRepositoryType provideSwapRepository(@ApplicationContext Context context)
    {
        return new SwapRepository(context);
    }

    @Singleton
    @Provides
    CoinbasePayRepositoryType provideCoinbasePayRepository()
    {
        return new CoinbasePayRepository();
    }

    @Singleton
    @Provides
    TransactionLocalSource provideTransactionInDiskCache(RealmManager realmManager)
    {
        return new TransactionsRealmCache(realmManager);
    }

    @Singleton
    @Provides
    TransactionsNetworkClientType provideBlockExplorerClient(
            OkHttpClient httpClient,
            Gson gson,
            RealmManager realmManager)
    {
        return new TransactionsNetworkClient(httpClient, gson, realmManager);
    }

    @Singleton
    @Provides
    TokenRepositoryType provideTokenRepository(
            EthereumNetworkRepositoryType ethereumNetworkRepository,
            TokenLocalSource tokenLocalSource,
            OkHttpClient httpClient,
            @ApplicationContext Context context,
            TickerService tickerService)
    {
        return new TokenRepository(
                ethereumNetworkRepository,
                tokenLocalSource,
                httpClient,
                context,
                tickerService);
    }

    @Singleton
    @Provides
    TokenLocalSource provideRealmTokenSource(RealmManager realmManager, EthereumNetworkRepositoryType ethereumNetworkRepository)
    {
        return new TokensRealmSource(realmManager, ethereumNetworkRepository);
    }

    @Singleton
    @Provides
    WalletDataRealmSource provideRealmWalletDataSource(RealmManager realmManager)
    {
        return new WalletDataRealmSource(realmManager);
    }

    @Singleton
    @Provides
    TokensService provideTokensServices(EthereumNetworkRepositoryType ethereumNetworkRepository,
                                        TokenRepositoryType tokenRepository,
                                        TickerService tickerService,
                                        OpenSeaService openseaService,
                                        AnalyticsServiceType analyticsService)
    {
        return new TokensService(ethereumNetworkRepository, tokenRepository, tickerService, openseaService, analyticsService);
    }

    @Singleton
    @Provides
    IPFSServiceType provideIPFSService(OkHttpClient client)
    {
        return new IPFSService(client);
    }

    @Singleton
    @Provides
    TransactionsService provideTransactionsServices(TokensService tokensService,
                                                    EthereumNetworkRepositoryType ethereumNetworkRepositoryType,
                                                    TransactionsNetworkClientType transactionsNetworkClientType,
                                                    TransactionLocalSource transactionLocalSource)
    {
        return new TransactionsService(tokensService, ethereumNetworkRepositoryType, transactionsNetworkClientType, transactionLocalSource);
    }

    @Singleton
    @Provides
    GasService provideGasService(EthereumNetworkRepositoryType ethereumNetworkRepository, OkHttpClient client, RealmManager realmManager)
    {
        return new GasService(ethereumNetworkRepository, client, realmManager);
    }

    @Singleton
    @Provides
    OpenSeaService provideOpenseaService()
    {
        return new OpenSeaService();
    }

    @Singleton
    @Provides
    SwapService provideSwapService()
    {
        return new SwapService();
    }

    @Singleton
    @Provides
    LyfeblocService provideFeemasterService(OkHttpClient okHttpClient, TransactionRepositoryType transactionRepository, Gson gson)
    {
        return new LyfeblocService(okHttpClient, transactionRepository, gson);
    }

    @Singleton
    @Provides
    NotificationService provideNotificationService(@ApplicationContext Context ctx)
    {
        return new NotificationService(ctx);
    }

    @Singleton
    @Provides
    AssetDefinitionService providingAssetDefinitionServices(IPFSServiceType ipfsService, @ApplicationContext Context ctx, NotificationService notificationService, RealmManager realmManager,
                                                            TokensService tokensService, TokenLocalSource tls,
                                                            LyfeblocService alphaService)
    {
        return new AssetDefinitionService(ipfsService, ctx, notificationService, realmManager, tokensService, tls, alphaService);
    }

    @Singleton
    @Provides
    KeyService provideKeyService(@ApplicationContext Context ctx, AnalyticsServiceType analyticsService)
    {
        return new KeyService(ctx, analyticsService);
    }

    @Singleton
    @Provides
    AnalyticsServiceType provideAnalyticsService(@ApplicationContext Context ctx)
    {
        return new AnalyticsService(ctx);
    }
}
