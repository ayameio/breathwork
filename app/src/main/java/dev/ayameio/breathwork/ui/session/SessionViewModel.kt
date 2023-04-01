package dev.ayameio.breathwork.ui.session

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class SessionViewModel : ViewModel() {
    private val sessionState = MutableStateFlow<SessionState>(SessionState(Phase.Breathing))
}