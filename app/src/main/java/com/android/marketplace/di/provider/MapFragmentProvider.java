package com.android.marketplace.di.provider;


import android.content.Context;
import android.location.Geocoder;

import com.android.marketplace.data.repository.OrderRepository;
import com.android.marketplace.data.source.local.AppDataBase;
import com.android.marketplace.ui.map.MapFragmentView;
import com.android.marketplace.ui.map.MapPresenter;
import com.android.marketplace.ui.map.MapPresenterImps;
import com.google.android.gms.maps.model.LatLng;

import java.util.Locale;

import dagger.Module;
import dagger.Provides;

@Module
public class MapFragmentProvider {

    @Provides
    static MapPresenter provideMapPresenter(MapFragmentView mapFragmentView,
                                            OrderRepository orderRepository,
                                            LatLng latLng) {
        return new MapPresenterImps(mapFragmentView, orderRepository,latLng);
    }

    @Provides
    MapFragmentView provideMapFragmentView(com.android.marketplace.ui.map.MapFragment mapFragment) {
        return mapFragment;
    }

    @Provides
    OrderRepository provideOrderRepository(AppDataBase appDataBase) {
        return new OrderRepository(appDataBase);
    }

    @Provides
    Geocoder provideGeocoder(Context context){
        return new Geocoder(context,Locale.getDefault());
    }

    @Provides
    LatLng provideLatLng() { return new LatLng(35.745578, 51.375443);// Set default location
    }

}
