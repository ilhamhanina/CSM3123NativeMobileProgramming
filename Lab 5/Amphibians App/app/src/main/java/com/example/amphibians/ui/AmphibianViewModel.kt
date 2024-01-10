
package com.example.amphibians.ui

import androidx.lifecycle.ViewModel
import com.example.amphibians.network.Amphibian

enum class AmphibianApiStatus {LOADING, ERROR, DONE}

class AmphibianViewModel : ViewModel() {

    // TODO: Create properties to represent MutableLiveData and LiveData for the API status

    // TODO: Create properties to represent MutableLiveData and LiveData for a list of amphibian objects

    // TODO: Create properties to represent MutableLiveData and LiveData for a single amphibian object.
    //  This will be used to display the details of an amphibian when a list item is clicked

    // TODO: Create a function that gets a list of amphibians from the api service and sets the
    //  status via a Coroutine

    fun onAmphibianClicked(amphibian: Amphibian) {
        // TODO: Set the amphibian object
    }
}
