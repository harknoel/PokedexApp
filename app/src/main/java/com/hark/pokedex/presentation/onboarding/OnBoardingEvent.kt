package com.hark.pokedex.presentation.onboarding

sealed class OnBoardingEvent {
    object SaveAppEntry: OnBoardingEvent()
}