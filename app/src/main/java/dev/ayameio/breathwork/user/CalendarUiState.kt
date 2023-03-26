package dev.ayameio.breathwork.user

import dev.ayameio.breathwork.data.SessionData

data class CalendarUiState (
    val selectedDate: Int,
    val sessionDataList: List<SessionData>
)