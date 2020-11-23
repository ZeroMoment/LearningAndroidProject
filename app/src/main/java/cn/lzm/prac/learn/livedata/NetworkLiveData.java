package cn.lzm.prac.learn.livedata;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

public class NetworkLiveData extends LiveData<Network> {

    private final Context mConext;

    static NetworkLiveData mNetworkLivedata;

    public NetworkLiveData(Context mConext) {
        this.mConext = mConext.getApplicationContext();

        listenerNetwork();
    }

    private void listenerNetwork() {
        ConnectivityManager connectivityManager = (ConnectivityManager) mConext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            connectivityManager.registerDefaultNetworkCallback(new ConnectivityManager.NetworkCallback() {
                @Override
                public void onAvailable(@NonNull Network network) {
                    super.onAvailable(network);

                    Log.i("lzm", "onAvailable: "+network);
                    getInstance(mConext).postValue(network);
                }

                @Override
                public void onLost(@NonNull Network network) {
                    super.onLost(network);

                    Log.i("lzm", "onLost: "+network);
                    getInstance(mConext).postValue(network);
                }

                @Override
                public void onUnavailable() {
                    super.onUnavailable();

                    Log.i("lzm", "onUnavailable: ");
                }

                @Override
                public void onCapabilitiesChanged(@NonNull Network network, @NonNull NetworkCapabilities networkCapabilities) {
                    super.onCapabilitiesChanged(network, networkCapabilities);
                    Log.i("lzm", "onCapabilitiesChanged: "+network);
                    getInstance(mConext).postValue(network);
                }

                @Override
                public void onLinkPropertiesChanged(@NonNull Network network, @NonNull LinkProperties linkProperties) {
                    super.onLinkPropertiesChanged(network, linkProperties);
                    getInstance(mConext).postValue(network);
                    Log.i("lzm", "onLinkPropertiesChanged: "+network);
                }
            });
        }
    }

    public static NetworkLiveData getInstance(Context context) {
        if(mNetworkLivedata == null) {
            mNetworkLivedata = new NetworkLiveData(context);
        }
        return mNetworkLivedata;
    }

    @Override
    protected void onActive() {
        super.onActive();
        Log.d("lzm", "page---network livedata -onactive");
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        Log.d("lzm", "page------network livedata -onInactive----------");
    }
}
