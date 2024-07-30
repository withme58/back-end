package toy.withme58.api.qustion.converter;

import toy.withme58.api.common.annotation.Converter;
import toy.withme58.api.qustion.dto.QuestionsDto;
import toy.withme58.api.qustion.dto.response.MyQuestionResponse;
import toy.withme58.db.answer.AnswerEntity;
import toy.withme58.db.question.enums.QuestionStatus;

import java.util.List;

@Converter
public class QuestionConverter {

    public QuestionsDto questionsDto(String questionTitle, String senderName, AnswerEntity question) {
        return QuestionsDto.builder().questionName(questionTitle)
                .friendName(senderName).friendId(question.getSenderId()).answerId(question.getId())
                .build();
    }

    public MyQuestionResponse questionResponse(List<QuestionsDto> questions) {
        return MyQuestionResponse.builder()
                .question(questions).status(QuestionStatus.REGISTERED.getStatus()).build();
    }
}
