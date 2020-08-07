package com.example.geofencing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;

import java.util.List;

public class GeoFenceBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "GeoFenceBroadcastRec";

    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationHelper notificationHelper = new NotificationHelper(context);

        GeofencingEvent geofencingEvent = GeofencingEvent.fromIntent(intent);

        if (geofencingEvent.hasError()) {
            Log.d(TAG, "onReceive: Error receiving geoFence event...");
            return;
        }

        int transitionType = geofencingEvent.getGeofenceTransition();

        List<Geofence> geoFenceList = geofencingEvent.getTriggeringGeofences();
        for (Geofence geofence: geoFenceList) {
            Log.d(TAG, "onReceive: " + geofence.getRequestId());
        }

        switch (transitionType) {
            case Geofence.GEOFENCE_TRANSITION_ENTER:
                Toast.makeText(context, "GEO_FENCE TRANSITION ENTER", Toast.LENGTH_SHORT).show();
                notificationHelper.sendHighPriorityNotification("GEO_FENCE TRANSITION ENTER", "", MapsActivity.class);
                break;
            case Geofence.GEOFENCE_TRANSITION_DWELL:
                Toast.makeText(context, "GEO_FENCE TRANSITION DWELL", Toast.LENGTH_SHORT).show();
                notificationHelper.sendHighPriorityNotification("GEO_FENCE TRANSITION DWELL", "", MapsActivity.class);
                break;
            case Geofence.GEOFENCE_TRANSITION_EXIT:
                Toast.makeText(context, "GEO_FENCE TRANSITION EXIT", Toast.LENGTH_SHORT).show();
                notificationHelper.sendHighPriorityNotification("GEO_FENCE TRANSITION EXIT", "", MapsActivity.class);
                break;
        }
    }
}
