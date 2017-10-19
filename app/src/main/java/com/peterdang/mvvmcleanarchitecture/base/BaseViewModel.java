package com.peterdang.mvvmcleanarchitecture.base;

import android.os.Bundle;

/**
 * Interface with a contract that needs to be fulfilled by view model classes.
 */
public interface BaseViewModel {
    /**
     * Invoked when view is initialized and is ready to display the data exposed by view model.
     * @param bundle additional to be passed to the viewmodel.
     */
    void onLoad(final Bundle bundle);

    void dispose();
}
