package core;

import java.util.ArrayList;
import java.util.List;

public class Module {
    private List<Lesson> lessonList = new ArrayList<>();
    private List<Quiz> quizList = new ArrayList<>();

    public Module(List<Lesson> lessonList, List<Quiz> quizList) {
        this.lessonList = lessonList;
        this.quizList = quizList;
    }

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    public List<Quiz> getQuizList() {
        return quizList;
    }

    public void setQuizList(List<Quiz> quizList) {
        this.quizList = quizList;
    }
}