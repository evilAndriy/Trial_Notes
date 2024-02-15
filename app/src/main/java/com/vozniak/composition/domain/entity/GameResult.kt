package com.vozniak.composition.domain.entity

class GameResult (
    val winner : Boolean,
    val countOfRightAnswers : Int,
    val countOfQuestions: Questions,
    val gameSettings: GameSettings
)