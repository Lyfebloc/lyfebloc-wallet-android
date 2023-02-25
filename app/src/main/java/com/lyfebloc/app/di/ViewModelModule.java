package com.lyfebloc.app.di;

import com.lyfebloc.app.interact.ChangeTokenEnableInteract;
import com.lyfebloc.app.interact.CreateTransactionInteract;
import com.lyfebloc.app.interact.DeleteWalletInteract;
import com.lyfebloc.app.interact.ExportWalletInteract;
import com.lyfebloc.app.interact.FetchTokensInteract;
import com.lyfebloc.app.interact.FetchTransactionsInteract;
import com.lyfebloc.app.interact.FetchWalletsInteract;
import com.lyfebloc.app.interact.FindDefaultNetworkInteract;
import com.lyfebloc.app.interact.GenericWalletInteract;
import com.lyfebloc.app.interact.ImportWalletInteract;
import com.lyfebloc.app.interact.MemPoolInteract;
import com.lyfebloc.app.interact.SetDefaultWalletInteract;
import com.lyfebloc.app.interact.SignatureGenerateInteract;
import com.lyfebloc.app.repository.CurrencyRepository;
import com.lyfebloc.app.repository.CurrencyRepositoryType;
import com.lyfebloc.app.repository.EthereumNetworkRepositoryType;
import com.lyfebloc.app.repository.LocaleRepository;
import com.lyfebloc.app.repository.LocaleRepositoryType;
import com.lyfebloc.app.repository.PreferenceRepositoryType;
import com.lyfebloc.app.repository.TokenRepositoryType;
import com.lyfebloc.app.repository.TransactionRepositoryType;
import com.lyfebloc.app.repository.WalletRepositoryType;
import com.lyfebloc.app.router.CoinbasePayRouter;
import com.lyfebloc.app.router.ExternalBrowserRouter;
import com.lyfebloc.app.router.HomeRouter;
import com.lyfebloc.app.router.ImportTokenRouter;
import com.lyfebloc.app.router.ImportWalletRouter;
import com.lyfebloc.app.router.ManageWalletsRouter;
import com.lyfebloc.app.router.MyAddressRouter;
import com.lyfebloc.app.router.RedeemSignatureDisplayRouter;
import com.lyfebloc.app.router.SellDetailRouter;
import com.lyfebloc.app.router.TokenDetailRouter;
import com.lyfebloc.app.router.TransferTicketDetailRouter;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ViewModelComponent;

@Module
@InstallIn(ViewModelComponent.class)
/** Module for providing dependencies to viewModels.
 * All bindings of modules from BuildersModule is shifted here as they were injected in activity for ViewModelFactory but not needed in Hilt
 * */
public class ViewModelModule {

    @Provides
    FetchWalletsInteract provideFetchWalletInteract(WalletRepositoryType walletRepository) {
        return new FetchWalletsInteract(walletRepository);
    }

    @Provides
    SetDefaultWalletInteract provideSetDefaultAccountInteract(WalletRepositoryType accountRepository) {
        return new SetDefaultWalletInteract(accountRepository);
    }

    @Provides
    ImportWalletRouter provideImportAccountRouter() {
        return new ImportWalletRouter();
    }

    @Provides
    HomeRouter provideHomeRouter() {
        return new HomeRouter();
    }

    @Provides
    FindDefaultNetworkInteract provideFindDefaultNetworkInteract(
            EthereumNetworkRepositoryType networkRepository) {
        return new FindDefaultNetworkInteract(networkRepository);
    }

    @Provides
    ImportWalletInteract provideImportWalletInteract(
            WalletRepositoryType walletRepository) {
        return new ImportWalletInteract(walletRepository);
    }

    @Provides
    ExternalBrowserRouter externalBrowserRouter() {
        return new ExternalBrowserRouter();
    }

    @Provides
    FetchTransactionsInteract provideFetchTransactionsInteract(TransactionRepositoryType transactionRepository,
                                                               TokenRepositoryType tokenRepositoryType) {
        return new FetchTransactionsInteract(transactionRepository, tokenRepositoryType);
    }

    @Provides
    CreateTransactionInteract provideCreateTransactionInteract(TransactionRepositoryType transactionRepository) {
        return new CreateTransactionInteract(transactionRepository);
    }

    @Provides
    MyAddressRouter provideMyAddressRouter() {
        return new MyAddressRouter();
    }

    @Provides
    CoinbasePayRouter provideCoinbasePayRouter() {
        return new CoinbasePayRouter();
    }

    @Provides
    FetchTokensInteract provideFetchTokensInteract(TokenRepositoryType tokenRepository) {
        return new FetchTokensInteract(tokenRepository);
    }

    @Provides
    SignatureGenerateInteract provideSignatureGenerateInteract(WalletRepositoryType walletRepository) {
        return new SignatureGenerateInteract(walletRepository);
    }

    @Provides
    MemPoolInteract provideMemPoolInteract(TokenRepositoryType tokenRepository) {
        return new MemPoolInteract(tokenRepository);
    }

    @Provides
    TransferTicketDetailRouter provideTransferTicketRouter() {
        return new TransferTicketDetailRouter();
    }

    @Provides
    LocaleRepositoryType provideLocaleRepository(PreferenceRepositoryType preferenceRepository) {
        return new LocaleRepository(preferenceRepository);
    }

    @Provides
    CurrencyRepositoryType provideCurrencyRepository(PreferenceRepositoryType preferenceRepository) {
        return new CurrencyRepository(preferenceRepository);
    }

    @Provides
    TokenDetailRouter provideErc20DetailRouterRouter() {
        return new TokenDetailRouter();
    }

    @Provides
    GenericWalletInteract provideGenericWalletInteract(WalletRepositoryType walletRepository) {
        return new GenericWalletInteract(walletRepository);
    }

    @Provides
    ChangeTokenEnableInteract provideChangeTokenEnableInteract(TokenRepositoryType tokenRepository) {
        return new ChangeTokenEnableInteract(tokenRepository);
    }

    @Provides
    ManageWalletsRouter provideManageWalletsRouter() {
        return new ManageWalletsRouter();
    }

    @Provides
    SellDetailRouter provideSellDetailRouter() {
        return new SellDetailRouter();
    }

    @Provides
    DeleteWalletInteract provideDeleteAccountInteract(
            WalletRepositoryType accountRepository) {
        return new DeleteWalletInteract(accountRepository);
    }

    @Provides
    ExportWalletInteract provideExportWalletInteract(
            WalletRepositoryType walletRepository) {
        return new ExportWalletInteract(walletRepository);
    }

    @Provides
    ImportTokenRouter provideImportTokenRouter() {
        return new ImportTokenRouter();
    }

    @Provides
    RedeemSignatureDisplayRouter provideRedeemSignatureDisplayRouter() {
        return new RedeemSignatureDisplayRouter();
    }
}
