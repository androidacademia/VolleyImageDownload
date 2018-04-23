package volleyimage.androidacademia.com.volleyimagedownload;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by girishkumarshakya on 22/04/18.
 */

public class NetworkConnection {

    public static boolean getConnection(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return  networkInfo!=null && networkInfo.isConnected();
    }
}
