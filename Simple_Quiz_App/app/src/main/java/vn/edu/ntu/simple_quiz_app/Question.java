package com.example.simple_quiz_app;

public class Question {


    public String questions[] = {
            "Con nào là con vật ăn cỏ?",
            "Ai là người đẹp trai nhất vũ trụ?",
            "Bạn có thấy tôi đẹp trai không?"
    };

    public String choices[][] = {
            {"Báo", "Cọp", "Sư Tử", "Bò"},
            {"Hiệu", "Hiệu", "Hiệu", "Hiệu"},
            {"Có", "Có", "Có", "Có"}
    };

    public String correctAnswer[] = {
            "Bò",
            "Hiệu",
            "Có"
    };

    public String getQuestion(int a){
        String question = questions[a];
        return question;
    }

    public String getchoice1(int a){
        String choice = choices[a][0];
        return choice;
    }

    public String getchoice2(int a){
        String choice = choices[a][1];
        return choice;
    }

    public String getchoice3(int a){
        String choice = choices[a][2];
        return choice;
    }

    public String getchoice4(int a){
        String choice = choices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = correctAnswer[a];
        return answer;
    }
}
